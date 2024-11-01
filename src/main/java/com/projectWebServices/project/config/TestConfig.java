package com.projectWebServices.project.config;

import com.projectWebServices.project.entities.Order;
import com.projectWebServices.project.entities.User;
import com.projectWebServices.project.repositories.OrderRepository;
import com.projectWebServices.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98989777", "123456");
        User u2 = new User(null, "JHoao", "Joao@gmail.com", "9898978", "123776");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:07z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T19:00:07z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
