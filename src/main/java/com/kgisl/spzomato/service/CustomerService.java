package com.kgisl.spzomato.service;

import org.springframework.web.servlet.ModelAndView;

import com.kgisl.spzomato.entity.Customer;

public interface CustomerService{
    public ModelAndView signup(Customer customer);


    public ModelAndView login(String username, String password);


}