package com.discount.ProductDiscount.repository;

import com.discount.ProductDiscount.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT t FROM User t where t.userName  = :user_name")
    Optional<User> findByName(@Param("user_name")String userName);

}
