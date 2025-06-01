package com.example.springEducation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bow implements Weapon{
    @Value("${bow.arrows}")
    private int arrows;
    @Value("${bow.range}")
    private float range;
    @Value("${bow.damage}")
    private float damage;
    @Value("${bow.critdamage}")
    private float critdamage;

    public Bow(){}

    @Override
    public void damage() {
        if (arrows > 0) {
            System.out.println("Nice hit! " + damage + " dmg dealt.");
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

    public int getArrows() {
        return arrows;
    }
    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public float getRange() {
        return range;
    }
    public void setRange(float range) {
        this.range = range;
    }

    public float getDamage() {
        return damage;
    }
    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getCritdamage() {
        return critdamage;
    }
    public void setCritdamage(float critdamage) {
        this.critdamage = critdamage;
    }

    @PostConstruct
    public void onInit(){
        System.out.println("Bow is picked");
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("Bow is broken!");
    }
}
