package com.amit.springtransactionabilitydemo.service;

import com.amit.springtransactionabilitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert(List<User> users) {
        System.out.println("Inserting into User table");
        for (User user : users) {
            jdbcTemplate.update("insert into user(Name, Dept, Salary) values (?, ? , ?)", preparedStatement -> {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getDept());
                preparedStatement.setLong(3, user.getSalary());
            });
        }
    }
    public List<User> getUsers() {
        System.out.println("Getting All Users");
        List<User> userList = jdbcTemplate.query("select name, dept, salary from user",
                (resultSet, i) -> new User(resultSet.getString("Name"),
                        resultSet.getString("Dept"), resultSet.getLong("Salary")));
        return userList;
    }

}
