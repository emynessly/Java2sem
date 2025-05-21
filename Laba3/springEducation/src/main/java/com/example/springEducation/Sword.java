package com.example.springEducation;

public class Sword implements Weapon{
    @Override
    public void damage(){
        System.out.println("-3.5 hp");
    }
    @Override
    public void inspection(){
        System.out.println("Looks cool, but an axe would be better.");
    }
}
