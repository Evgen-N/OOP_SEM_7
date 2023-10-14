package ru.geekbrains.lesson7.observer;

import java.util.List;

public interface Observer {

    void receiveOffer(String nameCompany, int salary, Vacancy vacancy);
    List<Vacancy>  getMyVacancy();

}
