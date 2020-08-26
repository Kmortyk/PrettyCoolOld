package com.example.user1.prettycool.Classes.Persons;

import com.example.user1.prettycool.R;


/**
 * Created by user1 on 18.03.2016.
 */
public class MonstersParameters extends Person {

int previousHP;

    MonstersParameters(String monsterId){
        switch(monsterId){
            case "Zm":
                NAME = "Zombi-Man";
                HP = 5;
                previousHP = HP;
                ATTACK = 1;
                SHIELD = 0;
                SPEED = 1;
                EXP = 500;
                //SPRITE;
                MOVEPOINTS = 1;
                drawableId = R.drawable.monster_redneck;
                ATTACKDISTANCE=1;
                break;
            case "Gu":
                NAME = "Zombi-Man";
                HP = 8888;
                previousHP = HP;
                ATTACK = 50;
                SHIELD = 1000;
                SPEED = 1;
                EXP = 50000;
                //SPRITE;
                MOVEPOINTS = 1;
                drawableId = R.drawable.monster_guardian;
                ATTACKDISTANCE=5;
                break;
            case "Gn":
                NAME = "Zombi-Man";
                HP = 8888;
                previousHP = HP;
                ATTACK = 100;
                SHIELD = 0;
                SPEED = 2;
                EXP = 50000;
                //SPRITE;
                MOVEPOINTS = 2;
                drawableId = R.drawable.monster_general;
                ATTACKDISTANCE = 10;
                break;

        }
        imHeroNotMonstr = 0;
        }

//
//    public void onDamageGot(int Damage){
//        this.HP-=Damage;
//        if(this.HP<=0){
//            isAlive=false;
//        }
//    }



}