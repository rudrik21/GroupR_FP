package com.example.groupr_fp.models;

public class Manager extends Employee {
    private int nbClients;
    private int nbTraverlDays;

    public Manager(String name, char gender, int birthYear, double monthlySalary, int rate, Vehicle vehicle, int nbClients, int nbTraverlDays) {
        super(name, gender, birthYear, monthlySalary, rate, vehicle);
        this.nbClients = nbClients;
        this.nbTraverlDays = nbTraverlDays;
    }

    @Override
    protected Double annualIncome() {
        return (super.annualIncome() + (500 * nbClients) + (100 * nbTraverlDays)) ;
    }

    public int getNbClients() {
        return nbClients;
    }

    public int getNbTraverlDays() {
        return nbTraverlDays;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", annualIncome=" + annualIncome() + "\n" +
                ", Clients=" + nbClients +
                ", Travel Days=" + nbTraverlDays + "\n";
    }
}
