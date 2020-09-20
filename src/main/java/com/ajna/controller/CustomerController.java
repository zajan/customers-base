package com.ajna.controller;

import com.ajna.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ajna.service.CustomersService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("")
    public String listCustomers(Model model){
        List<Customer> customers = customersService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/new")
    public String showAddForm(Model model){

        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "add-edit-customer";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model){

        Customer customer = customersService.getCustomer(id);
        model.addAttribute("customer", customer);

        return "add-edit-customer";
    }

    @PostMapping({"/{id}/edit", "/new"})
    public String saveCustomer(@ModelAttribute Customer customer){
        customersService.saveCustomer(customer);
        return "redirect:/customers/";
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable int id){
        customersService.deleteCustomer(id);
        return "redirect:/customers/";
    }
}
