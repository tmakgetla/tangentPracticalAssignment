package com.tangent.practicalassignment.domain.employees;

import com.tangent.practicalassignment.domain.employees.dto.Position;
import com.tangent.practicalassignment.domain.employees.dto.User;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class Employees {
    private User user;

    public User getUser() { return this.user; }

    public void setUser(User user) { this.user = user; }

    private Position position;

    public Position getPosition() { return this.position; }

    public void setPosition(Position position) { this.position = position; }

    private String phone_number;

    public String getPhoneNumber() { return this.phone_number; }

    public void setPhoneNumber(String phone_number) { this.phone_number = phone_number; }

    private String email;

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    private String github_user;

    public String getGithubUser() { return this.github_user; }

    public void setGithubUser(String github_user) { this.github_user = github_user; }

    private String birth_date;

    public String getBirthDate() { return this.birth_date; }

    public void setBirthDate(String birth_date) { this.birth_date = birth_date; }

    private String gender;

    public String getGender() { return this.gender; }

    public void setGender(String gender) { this.gender = gender; }

    private String race;

    public String getRace() { return this.race; }

    public void setRace(String race) { this.race = race; }

    private int years_worked;

    public int getYearsWorked() { return this.years_worked; }

    public void setYearsWorked(int years_worked) { this.years_worked = years_worked; }

    private int age;

    public int getAge() { return this.age; }

    public void setAge(int age) { this.age = age; }

    private int days_to_birthday;

    public int getDaysToBirthday() { return this.days_to_birthday; }

    public void setDaysToBirthday(int days_to_birthday) { this.days_to_birthday = days_to_birthday; }
}
