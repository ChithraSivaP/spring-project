package com.kgisl.spzomato.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    private int cusid;
    @OneToMany(cascade = CascadeType.ALL)  
@JoinColumn(name="cusid")  
  
private List<Order> answers; 

  
    private String username;

    private String password;

    private String email;
    
    public Customer() {

    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [cusid=" + cusid + ", username=" + username + ", password=" + password + ", email=" + email + "]";
    }

    public Object getCategory() {
        return null;
    }

   
}
