package com.discount.ProductDiscount.repository;

import com.discount.ProductDiscount.model.Discount;
import com.discount.ProductDiscount.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Integer> {
}
