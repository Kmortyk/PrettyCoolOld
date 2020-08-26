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
    String isLevel;
    Moving moving;
    AI ai;
    UniqueMas uniqueMas;
    HashMap<String,Object> objects;
    int type;
    ValueByObject valueByObject;

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
                       type = valueByObject.getInt(objects,dynamicsMap[i][j],"imHeroNotMonstr");


                  if(type>0)
                    moving.Moving(staticMap, dynamicsMap, i, j, X2, Y2,objects);


                    if(type==0)
                        ai.imGoingToKillHero(staticMap,dynamicsMap,i,j,objects);

                }
            }

        }

    }






