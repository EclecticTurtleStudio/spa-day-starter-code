package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){

        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        if (verify.equals(user.getPassword())) {
            model.addAttribute("welcome", "Welcome " + user.getUsername() + "!");
            return "user/index";
        } else {
            model.addAttribute("errorMessage","Password fields must match!");
            return "user/add";
        }
    }
}
