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
@RequestMapping(value="")
public class UsersController {

    @Autowired
    private UsersDao usersDao;

//    welcome/index page
    @RequestMapping(value="")
    public String index() {
        return "/index";
    }

//    register page
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        model.addAttribute("title", "Register");
        return "/register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute @Valid Users users, Errors errors, String verify) {
        model.addAttribute(users);
        if (users != new Users()) {

        }
        boolean passwordsMatch = true;
        if (users.getPassword() == "{null}" || verify == "{null}"
                || !users.getPassword().equals(verify)) {
            passwordsMatch = false;
            users.setPassword("{null}");
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            usersDao.save(users);
            return "redirect:/calendar";
        }

        return "/register";

    }

    //    login page
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("title", "Login");
        model.addAttribute("users", usersDao.findById());
        return "/login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute @Valid Users users, Errors errors) {
        model.addAttribute(users);
        if (errors.hasErrors()) {
            return "/login";
        } else {
            return "redirect:/calendar";
        }
    }
}
