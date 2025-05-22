package com.example.springEducation;

import java.util.Date;

public class SmartBean {
    private String firstName;
    private String surname;
    private Date birthdate;

    public SmartBean(String firstName, String surname, Date birthdate) { // конструктор
        this.firstName = firstName;
        this.surname = surname;
        this.birthdate = birthdate;
    }
    public String getFirstName(){ // имя
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getSurname(){ // фамилия
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public Date getBirthdate(){ // дата рождения
        return birthdate;
    }
    public void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }

    @Override
    public String toString(){
        return "My name is " + firstName + " " + surname + ". I was born at " + birthdate;
    }
}
