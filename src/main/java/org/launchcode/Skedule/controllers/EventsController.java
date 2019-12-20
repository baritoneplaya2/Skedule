package org.launchcode.Skedule.controllers;

import org.launchcode.Skedule.models.Events;
import org.launchcode.Skedule.models.data.EventsDao;
import org.launchcode.Skedule.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
    public String calendar(Model model, Events events) {
        model.addAttribute("title", "Calendar");
        model.addAttribute("events", eventsDao.findAll());
        int eventsId = events.getId();
        return "/calendar";
    }

    //    add event view
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(Model model) {
        Events events = new Events();
        model.addAttribute("events", events);
        model.addAttribute("title", "Event");
        return "/add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Events events, Errors errors) {
        model.addAttribute(events);
        if (!errors.hasErrors()) {
            eventsDao.save(events);
            int id = events.getId();
            return "redirect:/calendar";
        }
        return "/add";
    }

//    event view page
    @RequestMapping(value="/event")
    public String event(Model model, Events events, int id) {
        model.addAttribute("title", "Event");
//        model.addAttribute("event", event(id));
        return "/event";
    }

//    edit/add page
    @RequestMapping(value = "/edit/{eventsId}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("events", eventsDao.findById(id));
        return "/add";
}
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam int id, @RequestParam String eventsTitle, @RequestParam String eventsStartDate, @RequestParam String eventsStartTime, @RequestParam String eventsEndDate, @RequestParam String eventsEndTime) {
        Events events = (Events) eventsDao.findById(id);
        events.setTitle(eventsTitle);
        events.setStartDate(eventsStartDate);
        events.setStartTime(eventsStartTime);
        events.setEndDate(eventsEndDate);
        events.setEndTime(eventsEndTime);
        eventsDao.save(events);
        return "redirect:/calendar";
    }

}
