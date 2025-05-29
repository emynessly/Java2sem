package com.example.springEducation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Axe implements Weapon{
    @Override
    public void damage(){
        System.out.println("-4.5 hp");
    }
    @Override
    public void inspection(){
        System.out.println("Shiny diamond axe!");
    }

    @PostConstruct
    public void onInit(){
        System.out.println("Axe is picked");
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("Axe is broken!");
    }
}
