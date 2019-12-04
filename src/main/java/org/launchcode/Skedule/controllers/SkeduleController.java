package org.launchcode.Skedule.controllers;

import org.launchcode.Skedule.models.data.EventsDao;
import org.launchcode.Skedule.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SkeduleController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private EventsDao eventsDao;



    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String main() {

        return "register";
    }
}
