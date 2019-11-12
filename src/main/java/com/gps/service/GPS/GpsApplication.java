package com.gps.service.GPS;

import com.gps.service.GPS.models.Login;
import com.gps.service.GPS.repository.LoginRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpsApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(LoginRepository repository) {
        return (args) -> {
            // save a few login info
            Login login = new Login();
            login.setUsername("username");
            login.setPassword("password");
            repository.save(login);
        };
    }

}
