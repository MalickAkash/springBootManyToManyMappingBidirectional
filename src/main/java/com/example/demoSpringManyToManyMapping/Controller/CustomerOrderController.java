package com.example.demoSpringManyToManyMapping.Controller;

import com.example.demoSpringManyToManyMapping.Entity.Customer;
import com.example.demoSpringManyToManyMapping.Entity.Product;
import com.example.demoSpringManyToManyMapping.Repository.CustomerRipository;
import com.example.demoSpringManyToManyMapping.Repository.ProductRepository;
import com.example.demoSpringManyToManyMapping.Service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/start")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/storeData")
    public Customer storeData(@RequestBody Customer customer){
        return customerOrderService.storeData(customer);
    }

    @GetMapping("/showAllOrders")
    public List<Customer> fetchAllData(){
        return customerOrderService.fetchAllData();
    }

    @GetMapping("/showSpecificOrder/{customerName}")
    public List<Customer> fetchSpecificData(@PathVariable String customerName){
        return customerOrderService.fetchSpecificData(customerName);
    }

    @GetMapping("/showSpecificPrice/{productPrice}")
    public List<Product> fetchSpecificOrderByPrice(@PathVariable Integer productPrice){
        return customerOrderService.fetchSpecificOrderByPrice(productPrice);
    }

}
