package com.example.ComunicateFriends.controllers;

import com.example.ComunicateFriends.models.User;
import com.example.ComunicateFriends.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ControllerUser {
    @Autowired
    private UserRepository userRepository;
   /* @GetMapping("/login/{id}")
    public String login(@PathVariable(value = "id") long id, Model model){
        if (!userRepository.existsById(id)){
            return "redirect:/task";
        }
        Optional<User> task = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        task.ifPresent(res::add);
        model.addAttribute("user",res);
        return "redirect:/";
    }*/

    @GetMapping("/user")
    public String blogMain(Model model){
        Iterable<User> user = userRepository.findAll();
        model.addAttribute("user",user);
        return "user-main";
    }
}
