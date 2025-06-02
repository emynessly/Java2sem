package com.example.springEducation;

public abstract class Weapon {
    protected String name;
    protected float damage;
    protected String effect;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public float getDamage() {
        return damage;
    }
    public void setDamage(float damage) {
        this.damage = damage;
    }

    public String getEffect() {
        return effect;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }

    public float damage(){
        return 0;
    }
    public float Effect(){
        return 0;
    }
}