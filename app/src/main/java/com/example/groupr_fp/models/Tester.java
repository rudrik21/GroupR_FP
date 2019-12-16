package com.example.groupr_fp.models;

public class Tester extends Employee {

    private int nbBugs;

    public Tester(String name, char gender, int birthYear, double monthlySalary, int rate, Vehicle vehicle, int nbBugs) {
        super(name, gender, birthYear, monthlySalary, rate, vehicle);
        this.nbBugs = nbBugs;
    }

    @Override
    protected Double annualIncome() {
        return (super.annualIncome() + (10 * nbBugs));
    }

    public int getNbBugs() {
        return nbBugs;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", annualIncome=" + annualIncome() + "\n" +
                ", Bugs=" + nbBugs + "\n" ;
    }

}
