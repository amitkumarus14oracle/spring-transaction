package com.amit.springtransactionabilitydemo.runner;

import com.amit.springtransactionabilitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.amit.springtransactionabilitydemo.service.UserService;

import java.util.Arrays;
import java.util.List;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserService service;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("system starting");
        User user1 = new User("amit", "comps", 1000l);
        User user2 = new User("anuj", "it", 1000l);
        User user3 = new User("sumit", "civil", 1000l);
        User user4 = new User("abhishek", "comps", 1000l);
        User user5 = new User("Nikhil", "mca", 1000l);
        try {
            List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
            service.insert(list);
        } catch (Exception e) {
            System.out.println("exception while inserting user list :"+e.getMessage());
        }
        System.out.println(service.getUsers());

    }
}
