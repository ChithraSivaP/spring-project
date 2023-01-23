package com.kgisl.spzomato.service;

import org.springframework.web.servlet.ModelAndView;

public interface UserService {

    ModelAndView login(String email, String password);
    
}
