package com.example.springEducation;

public class Pickaxe implements Weapon{
    @Override
    public void damage(){
        System.out.println("-2 hp");
    }
    @Override
    public void inspection(){
        System.out.println("Definitely not for the fight..");
    }
}
