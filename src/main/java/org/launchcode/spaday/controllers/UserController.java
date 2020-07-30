package org.launchcode.spaday.controllers;



import org.launchcode.spaday.models.User;
import org.launchcode.spaday.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("userName", user.getUserName());
        UserData.add(user);
        if(user.getPassword().equals(verify)) {
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        }
        model.addAttribute("error", "Passwords do not match");
        return "user/add";
    }

    @GetMapping("detail")
    public String userPages(int userID, Model model) {
        User currentUser = UserData.getById(userID);
        model.addAttribute("user", currentUser);
        return "user/detail";
    }


}