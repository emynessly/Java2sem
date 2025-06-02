package com.example.springEducation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Sword extends Weapon{
    public Sword(){
        effect = "Additional damage on several enemies";
    };

    public Sword(String name, float damage){
        this.name = name;
        this.damage = damage;
        this.effect = "Additional damage on several enemies";
    }

    @Override
    public float damage(){
        return damage;
    }
    @Override
    public float Effect(){
        return damage*1.2f;
    }

}
