package com.example.springEducation;

public class Bow implements Weapon{
    private int arrows;
    public Bow(int arrows){
        this.arrows = arrows;
    }
    @Override
    public void damage() {
        if (arrows > 0) {
            System.out.println("-5 hp");
            arrows--;
        } else {
            System.out.println("No more arrows.. Craft some more!");
        }
    }
    @Override
    public void inspection() {
        if (arrows > 0) {
            System.out.println("You got some arrows with you: " + arrows);
        } else {
            System.out.println("Yeah that's a powerful weapon, but it's nothing without arrows.");
        }
    }
}
