package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Company {

    private Random random = new Random();

    private String name;

    private int maxSalary;

    private Publisher jobAgency;

    private Vacancy vacancy;


    public Company(String name, Publisher jobAgency, int maxSalary, Vacancy vacancy) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
        this.vacancy = vacancy;
    }


    public void needEmployee(){
        int salary = random.nextInt(10000, maxSalary);
        jobAgency.sendOffer(name, salary, vacancy);
    }

}
