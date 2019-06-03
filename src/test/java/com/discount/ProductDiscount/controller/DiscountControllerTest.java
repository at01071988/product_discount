package com.discount.ProductDiscount.controller;

import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.services.DiscountService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DiscountController.class)
public class DiscountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DiscountService discountService;

    @Test
    public void addDiscount() throws Exception {

        Mockito.when(discountService.addDiscount(any()))
                .thenReturn(new Discount("5%"));

        MockHttpServletRequestBuilder request = post("/addDiscount")
                .contentType(MediaType.APPLICATION_JSON)
                .param("percentage", "5");

        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.discountPercentage", is("5%")));
     }


}

