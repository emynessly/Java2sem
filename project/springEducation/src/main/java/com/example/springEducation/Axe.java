package com.example.springEducation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Axe extends Weapon{
    public Axe(){
        effect = "bleeding";
    };

    public Axe(String name, float damage){
        this.name = name;
        this.damage = damage;
        this.effect = "bleeding";
    }

    @Override
    public float damage(){
        return damage;
    }
    @Override
    public float Effect(){
        return damage*1.5f;
    }

}
