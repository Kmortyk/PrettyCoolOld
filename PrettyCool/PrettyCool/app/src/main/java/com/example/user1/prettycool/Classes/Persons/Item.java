package com.example.user1.prettycool.Classes.Persons;

import com.example.user1.prettycool.Classes.Objects;

/**
 * Created by user1 on 18.03.2016.
 */
public class Item extends Objects{

        String name;
        String type;
        int usable;
        int caniwear;
        int wearing;
        int itemHP;
        int addHp;
    int addMaxHp;
    int addShield;
    int addSpeed;
    int addAttack;
    int addAttackDistance;

    public int getAddMaxHp() {
        return addMaxHp;
    }

    public void setAddMaxHp(int addMaxHp) {
        this.addMaxHp = addMaxHp;
    }

    public String getType() {
        return type;
    }

    public int getAddAttackDistance() { return addAttackDistance; }

    public int isWearing() {
        return wearing;
    }

    public void setWearing(int wearing) {
        this.wearing = wearing;
    }

    public int getAddAttack() {
        return addAttack;
    }

    public void setAddAtack(int addAtack) {
        this.addAttack = addAtack;
    }

    public int getAddHp() {
        return addHp;
    }

    public void setAddHp(int addHp) {
        this.addHp = addHp;
    }

    public int getAddShield() {
        return addShield;
    }

    public void setAddShield(int addShield) {
        this.addShield = addShield;
    }

    public int getAddSpeed() {
        return addSpeed;
    }

    public void setAddSpeed(int addSpeed) {
        this.addSpeed = addSpeed;
    }

    public int isCaniwear() {
        return caniwear;
    }

    public void setCaniwear(int caniwear) {
        this.caniwear = caniwear;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemHP() {
        return itemHP;
    }

    public void setItemHP(int itemHP) {
        this.itemHP = itemHP;
    }

    public int isUsable() {
        return usable;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }





    Item(){
//                boolean isininventory = false;
//                boolean usable = false;
//                boolean caniwear = false;
                int itemHP = 100;
                int addHp,addShield,addSpeed;

        }
}
