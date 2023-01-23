package com.kgisl.spzomato.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.kgisl.spzomato.entity.Customer;







@Repository

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query("from customer where username=?1 and password=?2")
    public List<Customer> gotologin(String username, String password);



   

}