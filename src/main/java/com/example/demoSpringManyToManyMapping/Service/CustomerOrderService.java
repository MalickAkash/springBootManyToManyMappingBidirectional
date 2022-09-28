package com.example.demoSpringManyToManyMapping.Service;

import com.example.demoSpringManyToManyMapping.Entity.Customer;
import com.example.demoSpringManyToManyMapping.Entity.Product;
import com.example.demoSpringManyToManyMapping.Repository.CustomerRipository;
import com.example.demoSpringManyToManyMapping.Repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CustomerOrderService {
    @Autowired
    private CustomerRipository customerRipository;
    @Autowired
    private ProductRepository productRepository;

    public CustomerOrderService(CustomerRipository customerRipository, ProductRepository productRepository) {
        this.customerRipository = customerRipository;
        this.productRepository = productRepository;
    }

    public Customer storeData(Customer customer) {
        return customerRipository.save(customer);
    }

    public List<Customer> fetchAllData() {
        return customerRipository.findAll();
    }

    public List<Customer> fetchSpecificData(String customerName) {
        return customerRipository.findByName(customerName);
    }


    public List<Product> fetchSpecificOrderByPrice(Integer productPrice) {
        return productRepository.findByproductPriceLessThan(productPrice);
    }
}
