package com.projectWebServices.project.config;

import com.projectWebServices.project.entities.User;
import com.projectWebServices.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98989777", "123456");
        User u2 = new User(null, "JHoao", "Joao@gmail.com", "9898978", "123776");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
