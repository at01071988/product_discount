package com.discount.ProductDiscount.services;

import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.model.Group;
import com.discount.ProductDiscount.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public List<Group> getGroupList() {
        return groupRepository.findAll();
    }

    public Group addDiscount(String groupName, String percentage) {
        return groupRepository.save(new Group(groupName, new Discount(percentage)));
    }

    public Optional<Group> getDiscountByGroup(int groupId) {
        return groupRepository.findById(groupId);

    }

}
