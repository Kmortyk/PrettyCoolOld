package com.example.user1.prettycool.Classes.Persons;

import com.example.user1.prettycool.R;

/**
 * Created by user1 on 18.03.2016.
 */
public class AllItems extends Item{

     AllItems(String id){
         imHeroNotMonstr=-1;
         wearing = 0;
        switch(id){
            case "B":
                name = "Bag";
                type = "???";
                 caniwear = 0;
                 itemHP = 1000;
                 addHp = 20;
                        addShield = 0;
                        addSpeed = -1;
                        addAttack = 1;
                drawableId = R.drawable.item_littlebag;
                break;
            case "Bp":
                name = "Bad Pistol";
                type = "gun";
                caniwear = 1;
                itemHP = 1000;
                addMaxHp = 500;
                addShield = 0;
                addSpeed = -1;
                addAttack = 4;
                addAttackDistance = 5;
                drawableId = R.drawable.item_badpistol;
                break;
            case "Gp":
                name = "Good Pistol";
                type = "gun";
                caniwear = 1;
                itemHP = 10000;
                addMaxHp = 0;
                addShield = 0;
                addSpeed = 0;
                addAttack = 888;
                addAttackDistance = 999;
                drawableId = R.drawable.item_goodpistol;
                break;
            case "RedMan":
                name = "He's creator of that world!";
                type = "He's god";
                caniwear = 666;
                itemHP = 8;
                addMaxHp = 0;
                addShield = 0;
                addSpeed = 0;
                addAttack = 0;
                addAttackDistance = 0;
                drawableId = R.drawable.redman;
                break;
            case "Wp":
                name = "Worst Pistol";
                type = "gun";
                caniwear = 1;
                itemHP = 8;
                addMaxHp = 0;
                addShield = 0;
                addSpeed = 0;
                addAttack = 0;
                addAttackDistance = 0;
                drawableId = R.drawable.item_worstpistol;
                break;
            case "Wc":
                name = "Wood Clothe";
                type = "clothe";
                caniwear = 1;
                itemHP = 1000;
                addMaxHp = 0;
                addShield = 10;
                addSpeed = 1;
                addAttack = 0;
                addAttackDistance = 0;
                drawableId = R.drawable.item_woodclothe;
                break;
            case "Gc":
                name = "Wood Clothe";
                type = "clothe";
                caniwear = 1;
                itemHP = 1000;
                addMaxHp = 1000;
                addShield = 100;
                addSpeed = 10;
                addAttack = 0;
                addAttackDistance = 0;
                drawableId = R.drawable.item_goodclothe;
                break;


        }


    }
}
