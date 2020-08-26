package com.example.user1.prettycool.Classes.Persons;


import com.example.user1.prettycool.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 07.03.2016.
 */
public class HeroParameters extends Person {

    String NAME = "Barry";
    int POINTS;
    final int FINALMOVEPOINTS=1;
    static final int maxHP = 100;
    String[][]inventoryMas = new String[10][10];
    HashMap<String,AllItems> itemsHashMap;




HeroParameters(){

        HP = 100;
        LVL = 0;
        EXP = 1000;
        ATTACK = 1;
        FIELD = 0;
        SPEED = 1;
        POINTS = 0;
        MOVEPOINTS=1;
        String NAME = "Barry";
        imHeroNotMonstr = 1;
        drawableId = R.drawable.player_hero;
        ATTACKDISTANCE = 2;
        inventoryMas = new String[10][10];
        itemsHashMap = new HashMap<String,AllItems>();


    }

    public HashMap<String, AllItems> getItemsHashMap() {
        return itemsHashMap;
    }

    public void addItemsHashMap(String uniqueType,AllItems allItems) {
        this.itemsHashMap.put(uniqueType,allItems);
    }

    public String[][] getItemsMas() {
        return  inventoryMas;
    }

    public void addItemsMas(String uniqueType) {
        for(int i=0;i<inventoryMas.length;i++){
            for(int j=0;j<inventoryMas.length;j++){
                if(inventoryMas[i][j]==null){
                    inventoryMas[i][j] = uniqueType;
                    break;
                }
            }
        }
    }

    public int getFINALMOVEPOINTS() {
        return FINALMOVEPOINTS;
    }

    public static int getMaxHP() {
        return maxHP;
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
    //public void onHPgot(int hPgot){
//        HP+=hPgot;
//    if(HP>maxHP){
//        HP=maxHP;
//    }
//    }
//
//    public void onExpGot(int _EXP){
//        EXP-=_EXP;
//        if(EXP<=0){
//            LVL+=1;
//            EXP = (int) EXP*2+EXP/2;
//            POINTS =(int) EXP/1000;
//        }
//    }
//
//    public void onDamageHave(int Damage){
//        HP-=Damage;
//        if(HP<=0){
//            isAlive = false;
//        }
//    }
//
//    public void onDead(){
//        NAME = "Dead Barry";
//
//    }
//    public int onPointUsed(int Param){
//        if(POINTS>0){
//            POINTS-=1;
//            Param+=((int)(Math.random()*10+1));
//        }
//        return Param;
//    }
//    public void itemAtack(int atack,boolean used){
//        ATACK+=atack;
//        used = true;
//    }
//    public void itemFIELD(int field,boolean used){
//        FIELD+=field;
//        used = true;
//    }
//    public void itemSPEED(int speed,boolean used){
//        SPEED+=speed;
//        used = true;
//    }

}
