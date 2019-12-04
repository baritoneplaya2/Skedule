package org.launchcode.Skedule.controllers;

import org.launchcode.Skedule.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersDao usersDao;

    @RequestMapping(value="register")
    public String index(Model model) {
        model.addAttribute("");
        model.addAttribute("users", usersDao.findAll());
        return "";
    }
}
