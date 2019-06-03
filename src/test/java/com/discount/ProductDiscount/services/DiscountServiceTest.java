package com.discount.ProductDiscount.services;


import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.repository.DiscountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DiscountServiceTest {

    @Mock
    private DiscountRepository discountRepository;

    @Autowired
    private DiscountService discountService;

    @Test
    public void addDiscount() {
        Mockito.when(discountRepository.save(any())).thenReturn(new Discount("50"));
        Discount discount = discountService.addDiscount("50");
        assertEquals("50",discount.getDiscountPercentage());

    }
}
