package com.kgisl.spzomato.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kgisl.spzomato.entity.Customer;
import com.kgisl.spzomato.entity.Order;
import com.kgisl.spzomato.entity.User;
import com.kgisl.spzomato.service.CustomerService;
import com.kgisl.spzomato.service.OrderService;
import com.kgisl.spzomato.service.UserService;

@Controller
@CrossOrigin

@RequestMapping("/zomato")
public class MainController {

    @Autowired
    private CustomerService customerservice;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    // @Autowired
    // private OrderRepository orderRepository;

    // {
    //     System.out.println("helo");
    // }



// ................................login customer...................................

    @PostMapping(value="/login", headers = "Accept=application/json")
    public ResponseEntity<?> gotologin(@RequestBody Customer customer,HttpServletRequest req) {
        System.out.println("came here");
        System.out.println(customer);
      System.out.println(customer.getUsername());
      System.out.println(customer.getPassword());

       ModelAndView kkk = customerservice.login(customer.getUsername(),customer.getPassword());
      //  Event theEvent = new Event();
        // theModel.addAttribute("loginpage", new User());
        System.out.println(kkk);
        return new ResponseEntity<>(kkk,HttpStatus.OK);
    }


// .........................................register customer.......................

    @PostMapping(value = "/signup", headers = "Accept=application/json")

    public ResponseEntity<?> signup(@RequestBody Customer customer, HttpServletRequest request) {

        System.out.println(customer.getEmail());
        ModelAndView sign = customerservice.signup(customer);

        return new ResponseEntity<>(sign, HttpStatus.OK);

    }

  
//...............................full order.........................
    @PostMapping(value = "/fullorder", headers = "Accept=application/json")
    public ResponseEntity<?> orderentry() {

     

        List<Order> sen = orderService.getAllUsers();

        System.out.println(sen);
        return new ResponseEntity<>(sen, HttpStatus.OK);

    }
// @ResponseBody
// @RequestMapping("/hlo")
// public List<Order> helos(){
//    List<Order> res = orderRepository.findAll();
     
// return res;
// }




//...................................orderentryform.......................................
    @PostMapping(value = "/orderentryform", headers = "Accept=application/json")

    public ResponseEntity<?> orderentry(@RequestBody Order order, HttpServletRequest request) {

     

        ModelAndView entry = orderService.orderentry(order);
        System.out.println(entry);

        return new ResponseEntity<>(entry, HttpStatus.OK);

    }

// .....................................login admin.........................
@PostMapping(value="/adlogin", headers = "Accept=application/json")
public ResponseEntity<?> gotoadlogin(@RequestBody User user,HttpServletRequest req) {
    System.out.println("came here");
    System.out.println(user);
  System.out.println(user.getEmail());
   ModelAndView ch = userService.login(user.getEmail(),user.getPassword());
  //  Event theEvent = new Event();
    // theModel.addAttribute("loginpage", new User());
    System.out.println(ch);
    return new ResponseEntity<>(ch,HttpStatus.OK);
}


// ..........................PARTICLUAR DATA SHOW.........................

@PostMapping(value = "/customerone", headers = "Accept=application/json")
public ResponseEntity<?> cusone(@RequestBody Customer customer,HttpServletRequest req) {
    System.out.println("CUSTOMER");
  System.out.println(customer.getUsername());

    List<Order> kkk = orderService.cusone(customer.getUsername());
  //  Event theEvent = new Event();
    // theModel.addAttribute("loginpage", new User());
    System.out.println(kkk);
    return new ResponseEntity<>(kkk,HttpStatus.CREATED);
}




// //.....................................cards..................................
@GetMapping(value ="/datewisecount", headers="Accept= application/json")
public ResponseEntity<?> datewise(){
System.out.println("helo cards");
           List<Order> sen = orderService.getUserDate();

        System.out.println(sen);

        return new ResponseEntity<>(sen, HttpStatus.OK);


}



}
