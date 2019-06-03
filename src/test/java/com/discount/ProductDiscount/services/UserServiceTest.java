package com.discount.ProductDiscount.services;

import com.discount.ProductDiscount.model.*;
import com.discount.ProductDiscount.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RestService restService;

    UserModel userModel;
    User user;
    List<Group> groups;
    Group group;
    Optional<User> optional;

    @Before
    public void addData() {
        userModel = new UserModel();
        userModel.setUserName("XYZ");
        userModel.setBill("100");
        userModel.setGroupName("Employee");
        userModel.setType("non-grocery");

        user = new User("XYZ", "100", "Employee", 1);
        optional = Optional.of(user);

        group = new Group("Employee", new Discount("30"));
        groups = new ArrayList<>();
        groups.add(group);

    }

    @Test
    public void addUser() {
        Mockito.when(userRepository.findByName(any())).thenReturn(optional);
        String u = userService.addUser(userModel);
        assertEquals("XYZ is already present", u);

    }

    @Test
    public void getDiscountPercentage() {
        Mockito.when(userRepository.findByName(any())).thenReturn(optional);
        UserBaseModel u = userService.getDiscountPercentage("XYZ");
        assertEquals("30", u.getDiscountPercent());

    }
}
