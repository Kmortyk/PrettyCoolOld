package com.example.user1.prettycool.Classes.ViewClasses;


import android.util.Log;
import com.example.user1.prettycool.Classes.LevelMap.ItemMaps;
import com.example.user1.prettycool.Classes.LevelMap.MapLevels;
import com.example.user1.prettycool.Classes.Persons.AI;
import com.example.user1.prettycool.Classes.Persons.GlobalInformation;
import com.example.user1.prettycool.Classes.Persons.HeroParameters;
import com.example.user1.prettycool.Classes.Persons.MonstersParameters;
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


    int X,Y;

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
       uniqueMas = new UniqueMas(dynamicsMap,objects,globalInformation);
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
                        points = valueByObject.getSomething(objects, dynamicsMap[i][j], "MOVEPOINTS");
                        health = valueByObject.getSomething(objects, dynamicsMap[i][j], "HP");

                    if (type > 0) {
                        if(points>0) {
                            if(health>0) {
                                moving.Moving(staticMap, dynamicsMap, i, j, X2, Y2, objects,globalInformation);
                            }else{
                                objects.remove(dynamicsMap[i][j]);
                            }
                        }
                    }


                        if (type == 0) {
                            if (points > 0) {
                                if (health > 0) {
                                    ai.imGoingToKillHero(staticMap, dynamicsMap, i, j, objects);
                                }else{
                                    objects.remove(dynamicsMap[i][j]);
                                }
                            }
                        }
                }


                }
            }
        isLevelFinder = globalInformation.isLevel;
        if(isLevelFinder!=isLevel){
            isLevel = globalInformation.isLevel;

            staticMap = mapLevels.MapLevels(isLevel);
            dynamicsMap = itemMaps.ItemMaps(isLevel);
            objects = new HashMap<String,Object>();
            uniqueMas = new UniqueMas(dynamicsMap,objects,globalInformation);
        }
        }

    }






