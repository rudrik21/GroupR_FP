package com.example.groupr_fp.models;

import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private char gender;
    private int age = -1;
    private int birthYear;
    private double monthlySalary;
    private int rate;
    private Vehicle vehicle;

    public static ArrayList<Employee> listEmployees = new ArrayList<>();

    public Employee(String name, char gender, int birthYear, double monthlySalary, int rate, Vehicle vehicle) {
        this.id = listEmployees.size() + 1;
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;
        this.vehicle = vehicle;

        if (rate < 10) {
            this.rate = 10;
        } else if (rate > 100) {
            this.rate = 100;
        } else {
            this.rate = rate;
        }

        this.age = (2019 - birthYear);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public int getRate() {
        return rate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public static ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }

    protected Double annualIncome() {
        return (monthlySalary * 12 * (rate / 100));
    }

    public static ArrayList<Employee> getFilteredEmployees(String search){
        ArrayList<Employee> list = new ArrayList<>();
        for(Employee e : listEmployees){
            if (e.name.startsWith(search)){
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return
                "name='" + name + "\n" +
                ", age=" + age + "\n" +
                ", birthYear=" + birthYear + "\n" +
                ", monthlySalary=" + monthlySalary + "\n" +
                ", rate=" + rate + "\n" +
                ", vehicle=" + vehicle + "\n";
    }
}
