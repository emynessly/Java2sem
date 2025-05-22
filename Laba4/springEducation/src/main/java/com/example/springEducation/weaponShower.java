package com.example.springEducation;

public class weaponShower {
    private Weapon weapon;

    public weaponShower(Weapon weapon) {
        this.weapon = weapon;
    }
    public void show(){
        weapon.damage();
        weapon.inspection();
    }
}