package com.discount.ProductDiscount.controller;

import com.discount.ProductDiscount.model.User;
import com.discount.ProductDiscount.model.UserBaseModel;
import com.discount.ProductDiscount.model.UserModel;
import com.discount.ProductDiscount.services.UserService;
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

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void addUser() throws Exception {
        User user = new User("XYZ", "grocery", "200", 1);

        Mockito.when(userService.addUser(new UserModel())).thenReturn("XYZ is added");

        MockHttpServletRequestBuilder request = post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userName\":\"XYZ\",\"type\":\"grocery\",\"bill\":\"200\",\"groupName\":\"Customer Over Two-years\"}");

        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getDiscount() throws Exception {

        UserBaseModel userBaseModel = new UserBaseModel();
        userBaseModel.setDiscountedPrice(115);
        Mockito.when(userService.getDiscountPercentage("XYZ"))
                .thenReturn(userBaseModel);

        MockHttpServletRequestBuilder request = get("/getDiscount/XYZ")
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.discountedPrice", is(115)));
    }
}
