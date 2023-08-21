package com.example.CRUD.controller;

import ch.qos.logback.core.model.Model;
import com.example.CRUD.DAO.UserDAO;
import com.example.CRUD.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserDAO ud;
    @RequestMapping("index")
    public String index(Model m1){
        return "index";
    }

    @RequestMapping("click")
    public  String about(User user){
    ud.save(user);

        return "about";
    }

    @RequestMapping("getid")
    public ModelAndView getuser(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("display"); // Use the result display HTML page
        User data = ud.findById(id).orElse(null);
        if (data != null) {
            modelAndView.addObject("name", data.getName());
        } else {
            modelAndView.addObject("name", "Name not found for ID " + id);
        }
        return modelAndView;

    }


    @RequestMapping("deletuser")
    public ModelAndView deleteuser(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("display"); // Use the result display HTML page
        User data = ud.findById(id).orElse(null);
        String n1= data.getName();
        ud.deleteById(id);
        if (data != null) {
            modelAndView.addObject("name1", "this id was deleted   " +n1 );

        } else {
            modelAndView.addObject("name1"," delete failed");
        }

        return modelAndView;

    }







}
