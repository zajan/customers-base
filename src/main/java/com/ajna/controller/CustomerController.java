package com.ajna.controller;

import com.ajna.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ajna.service.CustomersService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Customer> customers = customersService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
