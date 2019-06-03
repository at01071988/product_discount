package com.discount.ProductDiscount.repository;

import com.discount.ProductDiscount.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
}
