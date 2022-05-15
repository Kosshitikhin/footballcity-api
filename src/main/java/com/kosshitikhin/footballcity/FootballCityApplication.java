package com.kosshitikhin.footballcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:application-dev.properties", ignoreResourceNotFound = true)
})
@EnableJpaAuditing
@EnableAsync
public class FootballCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballCityApplication.class, args);
    }

}
