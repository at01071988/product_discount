package com.discount.ProductDiscount.services;

import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    public Discount addDiscount(String percentage) {
        Discount discount = discountRepository.save(new Discount(percentage));
    return discount;
    }

}
