package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("username", user.getUserName());
        if(user.getPassword().equals(verify)) {
            return "/user/index";
        }
        model.addAttribute("email", user.getEmail());
        model.addAttribute("error", "Passwords do not match");
        return "/user/add";
    }
}