package com.kgisl.spzomato.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kgisl.spzomato.entity.User;
import com.kgisl.spzomato.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
 
    @Override
    @Transactional

    public ModelAndView login(String email, String password) {
        System.out.println("enter impl method");
            System.out.println(email);
            ModelAndView hhh=new ModelAndView();
          // List<User> df = userRepository.getlogin(username, password);
          List<User> df = userRepository.gotoadlogin(email, password);
            System.out.println(df);
            if((df != null) && (df.size() > 0)) {
                hhh.setViewName("adminwelcome.html");
                hhh.addObject(df.get(0));
            }
            else
            {
                hhh.setViewName("index.html");
            }
            return hhh; 
    }
    
}
