package com.tangent.practicalassignment.domain.employees.dto;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class User {
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String username;

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    private String email;

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    private String first_name;

    public String getFirstName() { return this.first_name; }

    public void setFirstName(String first_name) { this.first_name = first_name; }

    private String last_name;

    public String getLastName() { return this.last_name; }

    public void setLastName(String last_name) { this.last_name = last_name; }

    private boolean is_active;

    public boolean getIsActive() { return this.is_active; }

    public void setIsActive(boolean is_active) { this.is_active = is_active; }

    private boolean is_staff;

    public boolean getIsStaff() { return this.is_staff; }

    public void setIsStaff(boolean is_staff) { this.is_staff = is_staff; }
}
