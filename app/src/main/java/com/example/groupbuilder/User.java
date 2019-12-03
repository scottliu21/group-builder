package com.example.groupbuilder;

public class User {
    String name, email, year, major;
    String groupName;
    boolean inGroup;

    public User(){}

    public User(String name, String email, String year, String major, String groupName, boolean inGroup){
        this.name = name;
        this.email = email;
        this.year = year;
        this.major = major;
        this.groupName = groupName;
        this.inGroup = inGroup;
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

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setInGroup(boolean inGroup){
        this.inGroup = inGroup;
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

    public boolean getInGroup(){
        return inGroup;
    }
}
