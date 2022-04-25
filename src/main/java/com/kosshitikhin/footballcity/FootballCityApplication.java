package com.kosshitikhin.footballcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:application-dev.properties", ignoreResourceNotFound = true),
})
public class FootballCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballCityApplication.class, args);
    }

}
