package com.example.springEducation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class weaponShower {
    private Weapon weapon;

    @Autowired
    public weaponShower(@Qualifier("bow") Weapon weapon)
    {
        this.weapon = weapon;
    }
    public void show(){
        weapon.damage();
        weapon.inspection();
    }
}