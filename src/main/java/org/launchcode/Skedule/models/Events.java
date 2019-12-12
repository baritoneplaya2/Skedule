package org.launchcode.Skedule.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Events {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String startDate;

    @NotBlank
    private String startTime;

    @NotBlank
    private String endDate;

    @NotBlank
    private String endTime;

//    @NotBlank
//    private String location;
//
//    @NotBlank
//    private String group;
//
//    @NotBlank
//    private String reminder;

    @ManyToOne
    private Users users;

    public Events(String title, String startDate, String startTime, String endDate,String endTime) { //String location, String group, String reminder
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
//        this.location = location;
//        this.group = group;
//        this.reminder = reminder;
    }

    public Events() { }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    //    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getGroup() {
//        return group;
//    }
//
//    public void setGroup(String group) {
//        this.group = group;
//    }
//
//    public String getReminder() {
//        return reminder;
//    }
//
//    public void setReminder(String reminder) {
//        this.reminder = reminder;
//    }

}
