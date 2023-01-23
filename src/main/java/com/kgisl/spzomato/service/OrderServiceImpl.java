package com.kgisl.spzomato.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kgisl.spzomato.entity.Order;
import com.kgisl.spzomato.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public List<Order> getAllUsers()  
    {     
    return orderRepository.findAll();   
   
    }

    @Override
    @Transactional
    public ModelAndView orderentry(Order order) {

        Order s = orderRepository.save(order);

        System.out.println(s);

        ModelAndView entry=new ModelAndView();

        entry.setViewName("confirm.html");

        return entry;
    }

    @Override
    @Transactional
    public List<Order> cusone(String username) {
        System.out.println("enter impl method");
        System.out.println(username);
        // ModelAndView hhh=new ModelAndView();
      // List<User> df = userRepository.getlogin(username, password);
      List<Order> df = orderRepository.cusone(username);
      System.out.println(df);
   
    
      return  df;
    }

    
    @Override
    @Transactional
    public List<Order> getUserDate() {
      return orderRepository.userdate();  
    }

   


   
    

   
    }

   
   

