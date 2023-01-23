package com.kgisl.spzomato.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.kgisl.spzomato.entity.Order;

public interface OrderService {
   

    List<Order> getAllUsers();

    ModelAndView orderentry(Order order);

    List<Order> cusone(String username);

    List<Order> getUserDate();






    
}
