package com.discount.ProductDiscount.controller;

import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.model.Group;
import com.discount.ProductDiscount.services.DiscountService;
import com.discount.ProductDiscount.services.GroupService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
public class GroupControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GroupService groupService;


    @Test
    public void addDiscount() throws Exception {
        List<Group> groups =new ArrayList<>();
        groups.add(new Group("Employee",new Discount("30")));

        Mockito.when(groupService.getGroupList())
                .thenReturn(groups);

        MockHttpServletRequestBuilder request = get("/getGroupList")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].groupName", is("Employee")));
    }

    @Test
    public void addGroup() throws Exception {
        List<Group> groups =new ArrayList<>();
        groups.add(new Group("Employee",new Discount("30")));

        Mockito.when(groupService.addDiscount(any(),any()))
                .thenReturn(new Group("Employee",new Discount("5")));

        MockHttpServletRequestBuilder request = post("/addGroup")
                .contentType(MediaType.APPLICATION_JSON)
                .param("groupName", "Employee")
                .param("percentage", "5");


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.groupName", is("Employee")));
    }

    @Test
    public void getDiscountByGroup() throws Exception {

        Group group = new Group("Employee",new Discount("30"));
        Optional<Group> optionalGroup= Optional.of(group);
        Mockito.when(groupService.getDiscountByGroup(0))
                .thenReturn(optionalGroup);

        MockHttpServletRequestBuilder request = get("/getDiscountByGroup/0")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.groupName", is("Employee")));
    }


}
