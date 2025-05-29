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

    public Bow(){}

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

    @PostConstruct
    public void onInit(){
        System.out.println("Bow is picked");
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("Bow is broken!");
    }
}
