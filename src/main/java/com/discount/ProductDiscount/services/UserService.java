package com.discount.ProductDiscount.services;


import com.discount.ProductDiscount.model.*;
import com.discount.ProductDiscount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestService restService;


    public String addUser(UserModel userModel) {
        List<Group> groups = restService.getGroups();
        List<Group> newGroups = groups.stream().filter(g -> g.getGroupName().equals(userModel.getGroupName())).collect(Collectors.toList());
        Optional<User> user = userRepository.findByName(userModel.getUserName());
        if(user.isPresent() && user.get().getUserName().equals(userModel.getUserName())) {
            return user.get().getUserName() + " is already present";
        }else {
            User u = userRepository.save(new User(userModel.getUserName(),userModel.getType(),userModel.getBill(), newGroups.get(0).getId()));
            return u.getUserName() + " is added";
        }

    }


    public UserBaseModel getDiscountPercentage(String userName) {
        UserBaseModel userBaseModel = new UserBaseModel();
        int discounted_price = 0;
        Optional<User> u = userRepository.findByName(userName);
        Optional<Group> discountGroup = restService.getDiscountByUser(u.get().getGroup_id());

        if(u.get().getType().equals("non-grocery")) {
            discounted_price = (Integer.parseInt(u.get().getBill()) - ((Integer.parseInt(u.get().getBill()) * Integer.parseInt(discountGroup.get().getDiscount().getDiscountPercentage()) / 100)));
        }
        userBaseModel.setDiscountPercent(discountGroup.get().getDiscount().getDiscountPercentage());
        userBaseModel.setValue(u.get());
        userBaseModel.setDiscountedPrice(discounted_price);
        return userBaseModel;

    }


}
