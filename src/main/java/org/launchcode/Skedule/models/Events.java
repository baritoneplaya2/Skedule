package org.launchcode.Skedule.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Events {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size
    private String title;

    @NotBlank
    @Size
    private int date;

    @NotBlank
    @Size
    private int startTime;

    @NotBlank
    @Size(min=2)
    private int duration;

    @ManyToOne
    private Users users;



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
