package com.example.groupr_fp.models;

public class Programmer extends Employee {

    private int nbProjects;

    public Programmer(String name, char gender, int birthYear, double monthlySalary, int rate, Vehicle vehicle, int nbProjects) {
        super(name, gender, birthYear, monthlySalary, rate, vehicle);
        this.nbProjects = nbProjects;
    }

    @Override
    protected Double annualIncome() {
        return (super.annualIncome() + (200 * nbProjects));
    }

    public int getNbProjects() {
        return nbProjects;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", annualIncome=" + annualIncome() + "\n" +
                ", Projects=" + nbProjects + "\n";
    }
}
