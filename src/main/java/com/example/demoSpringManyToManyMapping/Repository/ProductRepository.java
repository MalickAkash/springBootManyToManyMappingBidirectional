package com.example.demoSpringManyToManyMapping.Repository;

import com.example.demoSpringManyToManyMapping.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value ="select * from product p where p.product_price= :n",
    nativeQuery = true
    )
    List<Product> findByproductPriceLessThan(@Param("n") Integer productPrice);
}
