package com.example.user1.prettycool.Classes.Persons;

import com.example.user1.prettycool.R;

/**
 * Created by user1 on 18.03.2016.
 */
public class AllItems extends Item{

     AllItems(String id){
         imHeroNotMonstr=-1;
        switch(id){
            case "B":
                name = "Bag";
                 usable = false;
                 caniwear = false;
                 itemHP = 1000;
                 addHp = 0;
                        addShield = 0;
                        addSpeed = -1;
                        addAtack = 1;
                drawableId = R.drawable.item_littlebag;
                break;

        }

    }
}
