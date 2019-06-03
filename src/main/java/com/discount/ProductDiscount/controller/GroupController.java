package com.discount.ProductDiscount.controller;


import com.discount.ProductDiscount.model.Group;
import com.discount.ProductDiscount.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("getGroupList")
    public List<Group> getGroupList() {
        return groupService.getGroupList();
    }

    @PostMapping("addGroup")
    public Group addGroup(@RequestParam String groupName, @RequestParam String percentage) {
        return groupService.addDiscount(groupName, percentage);
    }

    @GetMapping("getDiscountByGroup/{groupId}")
    public Optional<Group> getDiscountByGroup(@PathVariable("groupId") int groupId) {
        return groupService.getDiscountByGroup(groupId);

    }
}
