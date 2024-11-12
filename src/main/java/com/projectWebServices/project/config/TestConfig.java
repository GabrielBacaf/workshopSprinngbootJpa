package com.projectWebServices.project.config;

import com.projectWebServices.project.entities.*;
import com.projectWebServices.project.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98989777", "123456");
        User u2 = new User(null, "JHoao", "Joao@gmail.com", "9898978", "123776");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:07z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T19:00:07z"),OrderStatus.WAITING_PAYMENT,u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "books");
        Category cat3 = new Category(null, "Computers");


        Product p1 = new Product(null, "the Lord of Rings", "Lorem ipsum dolor sit amet, consectetur", 90.5,"");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus.Maecenas ante.", 2190.0,"");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0,"");
        Product p4 = new Product(null, "Pc Gamer", "Donec aliquet odio ac rhoncus cursus", 1200.0,"");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus", 100.9,"");

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        OrdemItem oi1 = new OrdemItem(o1,p1,2,p1.getPrice());
        OrdemItem oi2 = new OrdemItem(o1,p3,1,p4.getPrice());
        OrdemItem oi3 = new OrdemItem(o2,p3,2,p1.getPrice());
        OrdemItem oi4 = new OrdemItem(o3,p5,2,p5.getPrice());






        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        Payment paymentOne = new Payment(null, Instant.parse("2019-06-20T21:53:07z"), o1);
        o1.setPayment(paymentOne);

        orderRepository.save(o1);










    }
}
