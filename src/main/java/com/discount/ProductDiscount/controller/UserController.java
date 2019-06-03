package com.discount.ProductDiscount.controller;

import com.discount.ProductDiscount.model.UserBaseModel;
import com.discount.ProductDiscount.model.UserModel;
import com.discount.ProductDiscount.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("addUser")
    public String addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @GetMapping("getDiscount/{uname}")
    public UserBaseModel getDiscount(@PathVariable("uname") String uname){
        return userService.getDiscountPercentage(uname);
    }
}
