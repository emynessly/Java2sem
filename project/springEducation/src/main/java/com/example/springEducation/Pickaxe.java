package com.example.springEducation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Pickaxe extends Weapon{
    public Pickaxe(){
        effect = "slowed";
    };

    public Pickaxe(String name, float damage){
        this.name = name;
        this.damage = damage;
        this.effect = "slowed";
    }

    @Override
    public float damage(){
        return damage;
    }
    @Override
    public float Effect(){
        return damage*0.6f;
    }

}
