package com.example.springEducation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Sword implements Weapon{
    @Override
    public void damage(){
        System.out.println("-3.5 hp");
    }
    @Override
    public void inspection(){
        System.out.println("Looks cool, but an axe would be better.");
    }

    @PostConstruct
    public void onInit(){
        System.out.println("Sword is picked");
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("Sword is broken!");
    }
}
