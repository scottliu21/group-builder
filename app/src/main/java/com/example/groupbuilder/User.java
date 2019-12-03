package com.example.groupbuilder;

public class User {
    public String name, email, year, major;

    public User(){}

    public User(String name, String email, String year, String major){
        this.name = name;
        this.email = email;
        this.year = year;
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }
}
