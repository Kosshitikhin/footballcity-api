package com.kosshitikhin.footballcity.auth;

import com.kosshitikhin.footballcity.auth.dto.JWTResponse;
import com.kosshitikhin.footballcity.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTTokenUtil {

    @Value("${jwt.validity-time.access-token}")
    private Long accessTokenValidityTime;
    @Value("${jwt.validity-time.refresh-token}")
    private Long refreshTokenValidityTime;
    @Value("${jwt.secret}")
    private String secret;

    //generate token for userDetailsImpl
    public JWTResponse generateToken(UserDetailsImpl userDetailsImpl) {
        return generateToken(userDetailsImpl.getUsername(), userDetailsImpl.getAuthorities());
    }

    public JWTResponse generateToken(User user) {
        return generateToken(user.getEmail(), user.getRoles());
    }

    private JWTResponse generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Map<String, Object> claims = new HashMap<>();
        Date accessTokenExpiresAt = new Date(System.currentTimeMillis() + accessTokenValidityTime);
        Date refreshTokenExpiresAt = new Date(System.currentTimeMillis() + refreshTokenValidityTime);
        String token = doGenerateToken(claims, username, accessTokenExpiresAt);
        String refreshToken = doGenerateToken(claims, username, refreshTokenExpiresAt);
        return new JWTResponse(token, accessTokenExpiresAt, refreshToken, refreshTokenExpiresAt, authorities);
    }

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        return !isTokenExpired(token) && !isCreatedBeforeLastPasswordReset(token, (UserDetailsImpl) userDetails);
    }

    //retrieve expiration date from jwt token
    private Date getCreatedDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    //retrieve expiration date from jwt token
    private Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * @param token
     * @param userDetails
     * @return true if token is expired
     */
    private Boolean isCreatedBeforeLastPasswordReset(String token, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        if (user != null && user.getLastPasswordResetTime() != null) {
            return getCreatedDateFromToken(token).before(user.getLastPasswordResetTime());
        } else {
            return false;
        }
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject, Date expireAt) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date()).setExpiration(expireAt)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
}