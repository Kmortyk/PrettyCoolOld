package com.example.user1.prettycool.Classes.Persons;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.user1.prettycool.R;

import java.util.HashMap;

/**
 * Created by user1 on 07.03.2016.
 */
public class HeroParameters extends Person {

    String NAME = "Barry";
    int POINTS;
    final int FINALMOVEPOINTS=1;
    int maxHP = 100;
    int expTimer = 2500;
    String[][]inventoryMas = new String[10][10];
    HashMap<String,Object> itemsHashMap;
    Bitmap bitmap;
    ///??????????????????




HeroParameters(){

        HP = 100;
        LVL = 0;
        EXP = 1000;
        ATTACK = 1;
        SHIELD = 0;
        SPEED = 100;
        POINTS = 1;
        MOVEPOINTS=1;
        String NAME = "Barry";
        imHeroNotMonstr = 1;
        drawableId = R.drawable.player_hero;
        ATTACKDISTANCE = 1;
        inventoryMas = new String[5][5];
        itemsHashMap = new HashMap<String,Object>();



    }

    public HashMap<String, Object> getItemsHashMap() {
        return itemsHashMap;
    }

    public void addItemsHashMap(String uniqueType,AllItems allItems) {
        itemsHashMap.put(uniqueType, allItems);
    }

    public String[][] getItemsMas() {
        return  inventoryMas;
    }

    public void addItemsMas(String uniqueType) {
        while(itemsHashMap.containsKey(uniqueType)){

                uniqueType+="O";

        }


            for (int i = 0; i < inventoryMas.length; i++) {
                for (int j = 0; j < inventoryMas.length; j++) {
                    if (!itemsHashMap.containsKey(inventoryMas[j][i])) {
                        inventoryMas[j][i] = uniqueType;
                        return;
                    }
                }
            }
    }

    public int getFINALMOVEPOINTS() {
        return FINALMOVEPOINTS;
    }

    public  int getMaxHP() {
        return maxHP;
    }


    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }


    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getPOINTS() {
        return POINTS;
    }

    public void setPOINTS(int POINTS) {
        this.POINTS = POINTS;
    }


    public void onHPgot(int hPgot){
        HP+=hPgot;
    if(HP>maxHP){
        HP=maxHP;
    }
    }

    public void onExpGot(int _EXP){

        while(_EXP-EXP>0){
            _EXP-=EXP;
            LVL+=1;
            expTimer = (int) expTimer*2+expTimer/2;
            EXP = expTimer;
            POINTS =(int) EXP/1000;
        }

           if(_EXP>0) {
               EXP -= _EXP;
               if (EXP <= 0) {
                   LVL += 1;
                   expTimer = (int) expTimer * 2 + expTimer / 2;
                   EXP = expTimer;
                   POINTS = (int) EXP / 1000;
               }
           }

    }

    public void onDamageHave(int Damage){
        HP-=Damage;
        if(HP<=0){
            isAlive = false;
        }
    }

    public void onDead(){
        NAME = "Dead Barry";

    }
    public void onPointUsed(String Param){
        if(POINTS>0){
            POINTS-=1;

            switch(Param){
                case "ATTACK":
                    ATTACK+=((int)(Math.random()*3+1));
                    break;
                case "SHIELD":
                    SHIELD+=1;
                    break;
                case "SPEED":
                    SPEED+=((int)(Math.random()*10+1));
                    break;
                case "maxHP":
                    maxHP+=((int)(Math.random()*10+1));
                    break;
            }
        }

    }
//    public void itemAtack(int attack,boolean used){
//        ATTACK+=attack;
//        used = true;
//    }
//    public void itemFIELD(int field,boolean used){
//        SHIELD +=field;
//        used = true;
//    }
//    public void itemSPEED(int speed,boolean used){
//        SPEED+=speed;
//        used = true;
//    }

}
