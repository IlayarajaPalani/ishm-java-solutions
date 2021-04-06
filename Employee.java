package com.ishm.codingchallenge.collections;

import java.util.List;

public class Employee {
    private String fName;
    private String lName;
    private List<String> Cities;
    private int age;

    public Employee(String fName, String lName, List<String> cities, int age) {
        this.fName = fName;
        this.lName = lName;
        Cities = cities;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public List<String> getCities() {
        return Cities;
    }

    public void setCities(List<String> cities) {
        Cities = cities;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
