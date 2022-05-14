package com.kosshitikhin.footballcity.auth;

import com.kosshitikhin.footballcity.user.User;
import com.kosshitikhin.footballcity.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class GeneralUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public GeneralUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmailOrUsername) throws UsernameNotFoundException {
        if (userEmailOrUsername.contains("##")) {
            return adminLogin(userEmailOrUsername);
        } else {
            return userLogin(userEmailOrUsername);
        }
    }

    protected UserDetails adminLogin(String phoneNumber) {
        String adminPhoneNumber = phoneNumber.split("##")[0];
        String userPhoneNumber = phoneNumber.split("##")[1];
        User adminUser = userRepository.findByEmail(adminPhoneNumber);
        if (adminUser != null && adminUser.getRoles().contains(User.Role.ADMIN)) {
            userLogin(userPhoneNumber);
        }
        throw new UsernameNotFoundException(phoneNumber);
    }

    protected UserDetails userLogin(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return new UserDetailsImpl(user, user.getRoles(), user.getPassHash());
        }
        throw new UsernameNotFoundException(email);
    }
}
