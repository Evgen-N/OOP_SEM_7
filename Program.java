package ru.geekbrains.lesson7.observer;


public class Program{

    /**
     *  TODO: Доработать приложение, которое разрабатывалось на семинаре, поработать с шаблоном проектирования Observer,
     *  добавить новый тип соискателя.
     *  Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *  Только после этого вы можете усложнить ваше приложение (при желании), например, добавить тип вакансии (enum),
     *  учитывать тип вакансии при отправке предложения соискателю.
     * @param args
     */
    public static void main(String[] args) {

        Publisher jobAgency = new JobAgency();
        Company google = new Company("Google", jobAgency, 120000, Vacancy.DATASCIENTIST);
        Company yandex = new Company("Yandex", jobAgency, 95000, Vacancy.AISPECIALIST);
        Company geekBrains = new Company("GeekBrains", jobAgency, 98000, Vacancy.PROGRAMMER);

        Student student1 = new Student("Студент #1");
        student1.setMyVacancies(Vacancy.PROGRAMMER);

        Bachelor bachelor1 = new Bachelor("Бакалавр #1");
        bachelor1.setMyVacancies(Vacancy.PROGRAMMER); 
        bachelor1.setMyVacancies(Vacancy.AISPECIALIST);
        
        Master master1 = new Master("Мастер #1");
        master1.setMyVacancies(Vacancy.PRODUCTMANAGER);
        master1.setMyVacancies(Vacancy.AISPECIALIST);

        Master master2 = new Master("Мастер #2");
        master2.setMyVacancies(Vacancy.PROGRAMMER);
        master2.setMyVacancies(Vacancy.AISPECIALIST);
        master2.setMyVacancies(Vacancy.DATASCIENTIST);


        jobAgency.registerObserver(student1);
        jobAgency.registerObserver(bachelor1);
        jobAgency.registerObserver(master1);
        jobAgency.registerObserver(master2);

        for (int i = 0; i < 2; i++){
            google.needEmployee();
            yandex.needEmployee();
            geekBrains.needEmployee();
        }

    }

}
