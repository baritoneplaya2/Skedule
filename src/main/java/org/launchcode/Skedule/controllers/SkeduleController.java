package org.launchcode.Skedule.controllers;

        import org.launchcode.Skedule.models.data.EventsDao;
        import org.launchcode.Skedule.models.data.UsersDao;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;

@Controller
public class SkeduleController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private EventsDao eventsDao;

}
