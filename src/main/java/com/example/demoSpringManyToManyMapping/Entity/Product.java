package com.example.demoSpringManyToManyMapping.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private Integer productQuantity;
    private String productName;
    private Integer productPrice;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "productList")
    @JsonBackReference //**its use when many to mny bidirectional mapping made on GetMapping

    private List<Customer> customerList;
}
