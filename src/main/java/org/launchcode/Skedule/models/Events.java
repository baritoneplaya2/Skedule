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
    private int startMonth;

    @NotBlank
    private int startDay;

    @NotBlank
    private int startYear;

    @NotBlank
    private int startHour;

    @NotBlank
    private int startMinutes;

    @NotBlank
    private String startampm;

    @NotBlank
    private int endMonth;

    @NotBlank
    private int endDay;

    @NotBlank
    private int endYear;

    @NotBlank
    private int endHour;

    @NotBlank
    private int endMinutes;

    @NotBlank
    private String endampm;

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

    public Events(String title, int startMonth, int startDay, int startYear, int startHour, int startMinutes, String startampm, int endMonth, int endDay, int endYear, int endHour, int endMinutes, String endampm) { //String location, String group, String reminder
        this.title = title;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startYear = startYear;
        this.startHour = startHour;
        this.startMinutes = startMinutes;
        this.startampm = startampm;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.endYear = endYear;
        this.endHour = endHour;
        this.endMinutes = endMinutes;
        this.endampm = endampm;
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

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinutes() {
        return startMinutes;
    }

    public void setStartMinutes(int startMinutes) {
        this.startMinutes = startMinutes;
    }

    public String getStartampm() {
        return startampm;
    }

    public void setStartampm(String startampm) {
        this.startampm = startampm;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinutes() {
        return endMinutes;
    }

    public void setEndMinutes(int endMinutes) {
        this.endMinutes = endMinutes;
    }

    public String getEndampm() {
        return endampm;
    }

    public void setEndampm(String endampm) {
        this.endampm = endampm;
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
