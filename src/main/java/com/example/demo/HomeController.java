package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String index(Model model){
        System.out.println("123---------------------------");
        model.addAttribute("name","world");
        return "home";
    }

    public String findById(Model model, @PathVariable(value = "id" ) int id) {
        User user = userDao.findById(id);
        model.addAttribute("name",user.getEmail());
        return "home";
    }
}
