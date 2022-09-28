package com.example.demoSpringManyToManyMapping.Repository;

import com.example.demoSpringManyToManyMapping.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRipository extends JpaRepository<Customer,Integer> {

    @Query(
            value = "select * from customer c where c.customer_name= :n",
            nativeQuery = true
    )
    List<Customer> findByName(@Param("n") String customerName);
}