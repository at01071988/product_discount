package com.discount.ProductDiscount.controller;

import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping("addDiscount")
    public Discount addDiscount(@RequestParam String percentage) {
        return discountService.addDiscount(percentage);
    }
}
