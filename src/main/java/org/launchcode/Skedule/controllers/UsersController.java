package org.launchcode.Skedule.controllers;

import org.launchcode.Skedule.models.Users;
import org.launchcode.Skedule.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersDao usersDao;

//    welcome/index page
    @RequestMapping(value="")
    public String index() {
        return "/index";
    }

//    register page
    @RequestMapping(value="register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("myuser", new Users());
        model.addAttribute("title", "Register");
        model.addAttribute("users", usersDao.findAll());
        return "/register";
    }

    @RequestMapping(value="register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute @Valid Users users, Errors errors) {
        model.addAttribute(users);
            if (errors.hasErrors()) {
                return "/register";
            } else {
                usersDao.save(users);
                return "redirect:/calendar";
            }
    }
}
