package com.example.user1.prettycool.Classes.ViewClasses;


import com.example.user1.prettycool.Classes.LevelMap.ItemMaps;
import com.example.user1.prettycool.Classes.LevelMap.MapLevels;
import com.example.user1.prettycool.Classes.Persons.AI;
import com.example.user1.prettycool.Classes.Persons.AllItems;
import com.example.user1.prettycool.Classes.Persons.GlobalInformation;
import com.example.user1.prettycool.Classes.Persons.HeroParameters;
import com.example.user1.prettycool.Classes.Persons.Moving;
import com.example.user1.prettycool.Classes.Persons.UniqueMas;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by user1 on 30.03.2016.
 */
public class Dynamics {

   ItemMaps itemMaps;
     MapLevels mapLevels;
    GlobalInformation globalInformation;
    String[][] dynamicsMap;
    String[][] staticMap;
    String isLevel,isLevelFinder;
    Moving moving;
    AI ai;
    UniqueMas uniqueMas;
    HashMap<String,Object> objects;
    int type,points,health;
    ValueByObject valueByObject;
    String heroState;
    int canvTimer=0;
    CoordMas coordMas,coordMasInv,coordMasParam;
    String[][] inventoryMas;
    HashMap<String,Object> inventoryHashMap;
    HashMap<String,String> heroWearingHashMap;
    int[] startheroXY;
    boolean isAlive;


   Dynamics() {
        itemMaps = new ItemMaps();
        mapLevels = new MapLevels();
        globalInformation = new GlobalInformation();
        isLevel = globalInformation.isLevel;

        dynamicsMap = itemMaps.ItemMaps(isLevel);
        staticMap = mapLevels.MapLevels(isLevel);
        moving = new Moving();
        ai = new AI();


       valueByObject = new ValueByObject();
       objects = new HashMap<String,Object>();
       heroWearingHashMap = new HashMap<String,String>();
       uniqueMas = new UniqueMas(dynamicsMap,objects,globalInformation);


       coordMas = new CoordMas(staticMap.length,staticMap.length);
       coordMasParam = new CoordMas(4,1);

       isAlive = true;
       startheroXY = new int[2];



    }



    public void firstRun(){
        for (int i = 0; i < dynamicsMap.length; i++) {
            for (int j = 0; j < dynamicsMap.length; j++) {
                if (objects.containsKey(dynamicsMap[i][j])&&valueByObject.getSomething(objects, dynamicsMap[i][j], "imHeroNotMonstr")>0) {

                    if(heroState==null) {

                        heroState = dynamicsMap[i][j];

                        startheroXY[0] = i;
                        startheroXY[1] = j;


                        inventoryMas = valueByObject.getItemsMas((HeroParameters)objects.get(heroState));
                        inventoryHashMap  = valueByObject.getItemsHashMap((HeroParameters) objects.get(heroState));
                        coordMasInv = new CoordMas(inventoryMas.length,inventoryMas.length);
                    }
                }
            }
        }
    }

    public void Moving(int X2,int Y2) {

            for (int i = 0; i < dynamicsMap.length; i++) {
                for (int j = 0; j < dynamicsMap.length; j++) {
//                    object =objects.get(dynamicsMap[i][j]).getClass();
//                    try {
//                        type = object.getField("imHeroNotMonstr").getInt(objects.get(dynamicsMap[i][j]));
//
////                        object.getField("imHeroNotMonstr").setInt(objects.get(dynamicsMap[i][j]),3);
//                    } catch (NoSuchFieldException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
                    if (objects.containsKey(dynamicsMap[i][j])) {
                        type = valueByObject.getSomething(objects, dynamicsMap[i][j], "imHeroNotMonstr");
                        points = valueByObject.getSomething(objects, dynamicsMap[i][j], "MOVEPOINTS")+1+
                                valueByObject.getSomething(objects, dynamicsMap[i][j], "SPEED")/10;
                        health = valueByObject.getSomething(objects, dynamicsMap[i][j], "HP");



                     if (type > 0) {

                         if(points>0) {
                         if (health > 0) {
                             moving.Moving(staticMap, dynamicsMap, i, j, X2, Y2, objects, globalInformation,startheroXY);
                             points -= 1;

//                             startheroX=moving.;
//                             startheroY=moving.;


                         } else {
                             points=0;
                             isAlive = false;
                             objects.remove(dynamicsMap[i][j]);
                             return;
                         }
                     }

                    }


                        if (type == 0) {
                            if(points>0) {
                                if (health > 0) {

                                    if(isAlive==true){
                                        ai.imGoingToKillHero(staticMap, dynamicsMap, i, j, objects);
                                        points -= 1;
                                    }else{
                                        return;
                                    }


                                }else{
                                    points=0;
                                    objects.remove(dynamicsMap[i][j]);
                                    //setEXP method
                                    valueByObject.setSomething(objects,heroState,"EXP",
                                            valueByObject.getSomething(objects,dynamicsMap[i][j],"EXP"));
                                }
                            }
                        }
                }


                }
            }
        isLevelFinder = globalInformation.isLevel;
        if(isLevelFinder!=isLevel) {
            isLevel = isLevelFinder;
//            staticMap = null;
//            dynamicsMap = null;

            staticMap = mapLevels.MapLevels(isLevel);
            dynamicsMap = itemMaps.ItemMaps(isLevel);
//            objects = new HashMap<String,Object>();
            uniqueMas = new UniqueMas(dynamicsMap, objects, globalInformation);
            coordMas = new CoordMas(staticMap.length, staticMap.length);
            canvTimer = 0;
            isAlive=true;

            for (int i = 0; i < dynamicsMap.length; i++) {
                for (int j = 0; j < dynamicsMap.length; j++) {
                    if (objects.containsKey(dynamicsMap[i][j]) && valueByObject.getSomething(objects, dynamicsMap[i][j], "imHeroNotMonstr") > 0) {
                        startheroXY[0] = i;
                        startheroXY[1] = j;

                    }
                }
            }
        }
        }


public void Inventory(String itemUniqueType){


    if (inventoryHashMap.containsKey(itemUniqueType)){

        if(valueByObject.getSomething(inventoryHashMap,itemUniqueType,"isWearing")==0) {


            if (heroWearingHashMap.containsKey(valueByObject.getType((AllItems) inventoryHashMap.get(itemUniqueType)))) {
                inventoryDecoder(heroWearingHashMap.get(valueByObject.getType((AllItems) inventoryHashMap.get(itemUniqueType))));

                heroWearingHashMap.put(valueByObject.getType((AllItems) inventoryHashMap.get(itemUniqueType)),itemUniqueType);
                inventoryCoder(itemUniqueType);
            }else {
                heroWearingHashMap.put(valueByObject.getType((AllItems) inventoryHashMap.get(itemUniqueType)), itemUniqueType);
                inventoryCoder(itemUniqueType);
            }





            if (valueByObject.getSomething(inventoryHashMap, itemUniqueType, "isCaniwear") == 1) {
                valueByObject.setSomething(inventoryHashMap, itemUniqueType, "isWearing", 1);
            } else {
                inventoryHashMap.remove(itemUniqueType);
            }

            //        valueByObject.setSomething(objects,heroState,"",
            //                valueByObject.getSomething(objects,heroState,"")+valueByObject.getSomething(itemsHashMap,itemUniqueType,""));

            //добавить больше вкусных добавок, мне сегодня лень (((
        }
//        if(valueByObject.getSomething(inventoryHashMap,itemUniqueType,"isWearing")==1){
        else{
            inventoryDecoder(itemUniqueType);
            heroWearingHashMap.remove(valueByObject.getType((AllItems) inventoryHashMap.get(itemUniqueType)));
        }


        }
    }

    public void inventoryDecoder(String itemUniqueType){
        valueByObject.setSomething(inventoryHashMap,itemUniqueType,"isWearing",0);

//        valueByObject.setSomething(objects, heroState, "HP",
//                valueByObject.getSomething(objects, heroState, "HP") -
//                        valueByObject.getSomething(inventoryHashMap, itemUniqueType, "addHp"));

        valueByObject.setSomething(objects, heroState, "maxHP",
                valueByObject.getSomething(objects, heroState, "maxHP") -
                        valueByObject.getSomething( inventoryHashMap, itemUniqueType, "addMaxHp"));

        valueByObject.setSomething(objects, heroState, "ATTACKDISTANCE",
                valueByObject.getSomething(objects, heroState, "ATTACKDISTANCE") -
                        valueByObject.getSomething(inventoryHashMap, itemUniqueType, "addAttackDistance"));


        valueByObject.setSomething(objects, heroState, "ATTACK",
                valueByObject.getSomething(objects, heroState, "ATTACK") -
                        valueByObject.getSomething( inventoryHashMap, itemUniqueType, "addAttack"));

        valueByObject.setSomething(objects, heroState, "SHIELD",
                valueByObject.getSomething(objects, heroState, "SHIELD") -
                        valueByObject.getSomething( inventoryHashMap, itemUniqueType, "addShield"));

        valueByObject.setSomething(objects, heroState, "SPEED",
                valueByObject.getSomething(objects, heroState, "SPEED") -
                        valueByObject.getSomething( inventoryHashMap, itemUniqueType, "addSpeed"));
    }

    public void inventoryCoder(String itemUniqueType){

//        valueByObject.setSomething(objects, heroState, "HP",
//                valueByObject.getSomething(objects, heroState, "HP") +
//                        valueByObject.getSomething(inventoryHashMap, itemUniqueType, "addHp"));

        valueByObject.onHPgot((HeroParameters)objects.get(heroState),valueByObject.getSomething(inventoryHashMap, itemUniqueType, "addHp"));

        valueByObject.setSomething(objects, heroState, "maxHP",
                valueByObject.getSomething(objects, heroState, "maxHP") +
                        valueByObject.getSomething(inventoryHashMap, itemUniqueType, "addMaxHp"));

        valueByObject.setSomething(objects, heroState, "ATTACKDISTANCE",
                valueByObject.getSomething(objects, heroState, "ATTACKDISTANCE") +
                        valueByObject.getSomething(inventoryHashMap, itemUniqueType, "addAttackDistance"));

        valueByObject.setSomething(objects, heroState, "ATTACK",
                valueByObject.getSomething(objects, heroState, "ATTACK") +
                        valueByObject.getSomething( inventoryHashMap, itemUniqueType, "addAttack"));

        valueByObject.setSomething(objects, heroState, "SHIELD",
                valueByObject.getSomething(objects, heroState, "SHIELD") +
                        valueByObject.getSomething( inventoryHashMap, itemUniqueType, "addShield"));

        valueByObject.setSomething(objects, heroState, "SPEED",
                valueByObject.getSomething(objects, heroState, "SPEED") +
                        valueByObject.getSomething( inventoryHashMap, itemUniqueType, "addSpeed"));
    }

    public void Parameters(int i){
        // HP SHIELD ATTACK SPEED
        switch(i){
            case 0: valueByObject.onPointUsed((HeroParameters)objects.get(heroState),"maxHP");
                break;
            case 1:valueByObject.onPointUsed((HeroParameters)objects.get(heroState),"SHIELD");
                break;
            case 2:valueByObject.onPointUsed((HeroParameters)objects.get(heroState),"ATTACK");
                break;
            case 3:valueByObject.onPointUsed((HeroParameters)objects.get(heroState),"SPEED");
                break;
        }
    }


    public void dropItem(AllItems allItems,String itemUniqueType){
        for(int i=startheroXY[0]-1; i<startheroXY[0]+1;i++){
            for(int j=startheroXY[1]+1; j>startheroXY[1]-1;j--) {
                if (i >= 0 && j >= 0 && i < staticMap.length && j < staticMap.length) {

                    if(j%2==0 && (i!=startheroXY[0]-1)|(i==startheroXY[0]-1&&j==startheroXY[1]) ||
                            j%2!=0 && (i!=startheroXY[0]+1)|(i==startheroXY[0]+1&&j==startheroXY[1])) {

                        if (objects.get(dynamicsMap[i][j]) == null && dynamicsMap[i][j] != "Exit" &&
                                Arrays.asList(globalInformation.stepableId).contains(staticMap[i][j])) {
                            dynamicsMap[i][j] = itemUniqueType;
                            objects.put(itemUniqueType, allItems);

                            inventoryDecoder(itemUniqueType);
                            inventoryHashMap.remove(itemUniqueType);
                            itemUniqueType = null;
                            return;
                        }
                    }
                }
            }
        }
    }
    public void sortMas(){
        for(int i =0 ;i<inventoryMas.length-1;i++) {
            Arrays.sort(inventoryMas[i]);
        }


    }
    public void brokeItem(int i,int j){
        inventoryHashMap.remove(inventoryMas[i][j]);
        inventoryDecoder(inventoryMas[i][j]);
        inventoryMas[i][j]=null;
    }

    public void afterDeath(){
        objects = new HashMap<String,Object>();
        staticMap = mapLevels.MapLevels(isLevel);
        dynamicsMap = itemMaps.ItemMaps(isLevel);
        uniqueMas = new UniqueMas(dynamicsMap, objects, globalInformation);
        coordMas = new CoordMas(staticMap.length, staticMap.length);
        canvTimer = 0;
        isAlive = true;

        for (int i = 0; i < dynamicsMap.length; i++) {
            for (int j = 0; j < dynamicsMap.length; j++) {
                if (objects.containsKey(dynamicsMap[i][j]) && valueByObject.getSomething(objects, dynamicsMap[i][j], "imHeroNotMonstr") > 0) {
                    startheroXY[0] = i;
                    startheroXY[1] = j;

                }
            }
        }
    }
}






