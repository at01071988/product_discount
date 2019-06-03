package com.discount.ProductDiscount.services;

import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.model.Group;
import com.discount.ProductDiscount.repository.GroupRepository;
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

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GroupServiceTest {

    @Mock
    private GroupRepository groupRepository;

    @Autowired
    private GroupService groupService;

    List<Group> groups;
    Optional<Group> optionalGroup;
    Group group;

    @Before
    public void addData(){
        group = new Group("Employee",new Discount("30"));
        groups =new ArrayList<>();
        groups.add(group);
        optionalGroup = Optional.of(group);
    }

    @Test
    public void getGroupList() {
        Mockito.when(groupRepository.findAll()).thenReturn(groups);
        List<Group> groupList  = groupService.getGroupList();
        assertEquals("Employee",groupList.get(0).getGroupName());

    }

    @Test
    public void addDiscount() {
        Mockito.when(groupRepository.save(any())).thenReturn(group);
        Group group1  = groupService.addDiscount("Employee","5");
        assertEquals("Employee",group1.getGroupName());
    }

    @Test
    public void getDiscountByGroup() {
        Mockito.when(groupRepository.findById(any())).thenReturn(optionalGroup);
        Optional<Group> group1  = groupService.getDiscountByGroup(4);
        assertEquals("Employee",group1.get().getGroupName());
    }
}
