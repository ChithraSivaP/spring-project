package com.kgisl.spzomato.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kgisl.spzomato.entity.Customer;
import com.kgisl.spzomato.repository.CustomerRepository;

@Service

public class CustomerServiceImpl  implements CustomerService {

    @Autowired
   CustomerRepository customerRepository;

    @Override
    @Transactional

    public ModelAndView signup(Customer customer) {

        Customer s = customerRepository.save(customer);

        System.out.println(s);

        ModelAndView sen=new ModelAndView();

        sen.setViewName("userwelcome.html");

        return sen;
    }

   

        @Override
        @Transactional
        public ModelAndView login(String username, String password) {
            System.out.println("enter impl method");
            System.out.println(username);
            ModelAndView hhh=new ModelAndView();
          // List<User> df = userRepository.getlogin(username, password);
          List<Customer> df = customerRepository.gotologin(username, password);
            System.out.println(df);
            if((df != null) && (df.size() > 0)) {
                hhh.setViewName("userwelcome.html");
                hhh.addObject(df.get(0));
            }
            else
            {
                hhh.setViewName("index.html");
            }
            return hhh; 
        }
    }

