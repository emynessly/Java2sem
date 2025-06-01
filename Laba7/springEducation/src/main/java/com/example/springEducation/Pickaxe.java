package com.example.springEducation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pickaxe implements Weapon{
    @Override
    public void damage(){
        System.out.println("-2 hp");
    }
    @Override
    public void inspection(){
        System.out.println("Definitely not for the fight..");
    }

    @PostConstruct
    public void onInit(){
        System.out.println("Pickaxe is picked");
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("Pickaxe is broken!");
    }
}
