package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Peoples implements Observer{

    private String name;
    private int salary;

    public Peoples(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    private List<Vacancy> myVacancies = new ArrayList<>();
    public void setMyVacancies(Vacancy v) {
        this.myVacancies.add(v);
    }

    @Override
    public List<Vacancy> getMyVacancy() {
        return this.myVacancies;
    }


    @Override
    public void receiveOffer(String nameCompany, int salary, Vacancy vacancy) {
        
            if (this.salary <= salary){
                System.out.printf("Специалист %s: Мне нужна эта работа! (компания: %s; заработная плата: %d; вакансия: %s)\n",
                        name, nameCompany, salary, vacancy);
                this.salary = salary;
            }
            else {
                System.out.printf("Специалист %s: Я найду работу получше! (компания: %s; заработная плата: %d; вакансия: %s)\n",
                        name, nameCompany, salary, vacancy);            
            }
    }

}
