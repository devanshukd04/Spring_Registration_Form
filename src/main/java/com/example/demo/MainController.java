package com.example.demo;

import com.example.demo.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/register")
    public String showForm(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()) {
            return "register_form";
        }
        repo.save(user);
        session.setAttribute("message","User Register Successfully..");
        System.out.println(user);
        return "register_success";
    }

}
