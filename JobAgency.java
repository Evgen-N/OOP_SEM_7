package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;
import java.util.List;

public class JobAgency implements Publisher {


    List<Observer> observers = new ArrayList<>();

    @Override
    public void sendOffer(String companyName, int salary, Vacancy vacancy) {
        for (Observer observer : observers){
            for (Vacancy myVacancy : observer.getMyVacancy()) {               
                //if (myVacancy.equals(vacancy)){
                    //System.out.printf(myVacancy.toString() + vacancy.toString() + "\n");
                    if (myVacancy == vacancy){
                    observer.receiveOffer(companyName, salary, vacancy);
                }
            }
        }
    }

    // @Override
    // public void sendOffer(String companyName, int salary, Vacancy vacancy) {
    //     for (Observer observer : observers){

    //     //    if (observer.getMyVacancy().equals(vacancy)) {
    //     //         observer.receiveOffer(companyName, salary, vacancy);
    //     //    }
    //     }
    // }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
