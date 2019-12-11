package org.launchcode.Skedule.controllers;

import org.launchcode.Skedule.models.Events;
import org.launchcode.Skedule.models.data.EventsDao;
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
@RequestMapping(value="calendar")
public class EventsController {

    @Autowired
    private EventsDao eventsDao;

    @Autowired
    private UsersDao usersDao;

    //    calendar view
    @RequestMapping(value="")
    public String calendar() {
        return "/calendar";
    }

    //    add event view
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(Model model) {
        Events events = new Events();
        model.addAttribute("events", events);
        model.addAttribute("title", "Event");
        return "add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Events events, Errors errors) {
        model.addAttribute(events);
        if (!errors.hasErrors()) {
            eventsDao.save(events);
            int id = events.getId();
            return "redirect:/calendar";
        }
        return "add";
    }
//
//    //    event view page
//    @RequestMapping(value="/event", method = RequestMethod.GET)
//    public String event(Model model) {
//        model.addAttribute("title", "Event");
//        return "/event";
//    }
//
//    @RequestMapping(value="/event", method = RequestMethod.POST)
//    public String event(Model model, @RequestParam String email, @RequestParam String password) {
//        if (email != "" && password != "") {
//            Users founduser = usersDao.findByEmail(email);
//            if (password.equals(founduser.getPassword())) {
//                return "redirect:/calendar";
//            }
//        }
//        return "/event";
//    }
//
//    //    calendar page
//    @RequestMapping(value="/calendar", method = RequestMethod.GET)
//    public String calendar(Model model) {
//        model.addAttribute("title", "Calendar");
//        return "/calendar";
//    }
}
