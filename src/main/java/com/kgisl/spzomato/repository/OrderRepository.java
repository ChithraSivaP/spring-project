package com.kgisl.spzomato.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgisl.spzomato.entity.Order;

@Repository

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM fullorder f JOIN customer c ON f.cusid=c.cusid  WHERE c.username=?1")
    public List<Order> cusone(String username);


    @Query(nativeQuery = true,value = "SELECT * FROM fullorder f WHERE f.date= '22/03/2022' GROUP BY f.res ORDER BY COUNT(f.id) DESC LIMIT 1")
    public List<Order> userdate();

  
   
    
}
