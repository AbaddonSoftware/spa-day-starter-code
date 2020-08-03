package org.launchcode.spaday.controllers;

import javax.validation.Valid;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return "user/add";
        }
        UserData.add(user);
        model.addAttribute("users", UserData.getAll());
        return "user/index";

        
        
    }

    @GetMapping("detail")
    public String userPages(int userID, Model model) {
        User user = UserData.getById(userID);
        model.addAttribute(user);
        return "user/detail";
    }


}