package com.example.demoSpringManyToManyMapping.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private Integer customerAge;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "customer_product",
    joinColumns = {
                @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "product_id",referencedColumnName = "productId")
                }
    )
    @JsonManagedReference //**its use when many to mny bidirectional mapping made on GetMapping
    private List<Product> productList;
}
