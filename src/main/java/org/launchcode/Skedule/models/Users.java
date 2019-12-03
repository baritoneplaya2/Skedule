package org.launchcode.Skedule.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    //private String for each user info: name, email, password & verifyPassword
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(min=2)
    private String name;

    @Email
    @Size(min=9, message = "Invalid email address")
    private String email;

    @NotBlank
    @Size(min=8, max=20, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Passwords do not match")
    private String verify;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Events> events = new ArrayList<>();

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Users() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verify != null
                && !password.equals(verify)) {
            verify = null;
        }
        //other password rules here in if statements, space, no nums, no char, one capital
    }

    public List<Events> getEvents() {
        return events;
    }
}
