package com.example.springEducation;

public class Axe implements Weapon{
    private boolean hit;
    public Axe(boolean hit){
        this.hit = hit;
    }
    @Override
    public void damage(){
        if (hit){
            System.out.println("-4.5 hp");
        } else {
            System.out.println("Miss!");
        }
    }
    @Override
    public void inspection(){
        System.out.println("Shiny diamond axe!");
    }
}
