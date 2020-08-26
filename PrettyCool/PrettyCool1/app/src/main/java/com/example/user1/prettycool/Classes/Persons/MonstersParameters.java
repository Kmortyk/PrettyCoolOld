package com.example.user1.prettycool.Classes.Persons;

import com.example.user1.prettycool.R;
import java.util.Map;


/**
 * Created by user1 on 18.03.2016.
 */
public class MonstersParameters extends Person {



    MonstersParameters(String monsterId){
        switch(monsterId){
            case "Zm":
                NAME = "Zombi-Man";
                HP = 5;
                ATACK =(int) Math.random()*5+1;
                FIELD = 0;
                SPEED = 1;
                //SPRITE;
                MOVEPOINTS = 1;
                drawableId = R.drawable.monster_redneck;
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