package com.example.springEducation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Bow extends Weapon{
    private int arrows;
    private float range;
    private float damage;

    public Bow(){
        effect = "headshot";
    }
    public Bow(String name, int arrows, float range, float damage){
        this.name = name;
        this.arrows = arrows;
        this.range = range;
        this.damage = damage;
        this.effect = "headshot";
    }

    @Override
    public float damage(){
        return damage;
    }
    @Override
    public float Effect(){
        return damage*1.5f;
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
}
