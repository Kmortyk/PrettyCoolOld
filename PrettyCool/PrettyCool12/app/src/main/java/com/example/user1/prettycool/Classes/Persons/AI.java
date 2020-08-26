package com.example.user1.prettycool.Classes.Persons;

import android.util.Log;

import com.example.user1.prettycool.Classes.Persons.GlobalInformation;
import com.example.user1.prettycool.Classes.ViewClasses.ValueByObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 26.03.2016.
 */
public class AI {

    GlobalInformation globalInformation = new GlobalInformation();
    double smallest = 100;
    int _X =-1
            ,_Y=-1;
    ValueByObject valueByObject = new ValueByObject();


   public int[] WhereHero(String[][] a){
       int[]b = null;
  for(int i=0;i<a.length;i++){
      for(int j=0;j<a.length;j++){
          if(a[i][j].charAt(0)=='H') {
              if(b == null)
              b = new int[]{i, j};
          }
      }
  }
       return b;

    }


    public double HowFar(int[] heroXY,int X,int Y){
        return  Math.sqrt(Math.pow(heroXY[0]-X,2) + Math.pow(heroXY[1]-Y,2));
    }
    public double HowFarGekses(int[] heroXY,int X,int Y){
        return  Math.abs(heroXY[0]-X) + Math.abs(heroXY[1]-Y);
    }

    public boolean walkingRobot(String map[][],int[] heroXY,int X,int Y) {
        boolean goodStep = true;
        int steps=0;
        while (X == heroXY[0] && Y == heroXY[1]&&steps<=HowFarGekses(heroXY,X,Y)+5) {
            for (int i = X - 1; i <= X+1; i++) {
                for (int j = Y - 1; j <= Y + 1; j++) {
                    if(i>=0&&j>=0&&i<map.length&&j<map.length) {
                        if (Arrays.asList(globalInformation.stepableId).contains(map[i][j])) {
                            if (smallest > HowFar(heroXY, i, j)) {
                                smallest = HowFar(heroXY, i, j);
                                X = i;
                                Y = j;
                                smallest = 100;
                            }

                        }
                    }
                }

            }
        }
        if(steps>HowFarGekses(heroXY,X,Y)+2) goodStep = false;
        return goodStep;
    }





    public boolean CanIAttack(int howFar,String id){
    return true;
    }

public void imGoingToKillHero(String[][]map,String[][]itemsMap,int X,int Y,HashMap<String,Object> objects) {
    int[] heroXY = WhereHero(itemsMap);
    if (objects.containsKey(itemsMap[heroXY[0]][heroXY[1]])
        &&valueByObject.getSomething(objects, itemsMap[heroXY[0]][heroXY[1]], "imHeroNotMonstr") == 1
                && valueByObject.getSomething(objects, itemsMap[X][Y], "ATTACKDISTANCE") >= HowFar(heroXY, X, Y)) {
            Log.d("Starts", "Mod");
            valueByObject.setSomething(objects, itemsMap[heroXY[0]][heroXY[1]], "HP",
                    valueByObject.getSomething(objects, itemsMap[heroXY[0]][heroXY[1]], "HP") -
                            valueByObject.getSomething(objects, itemsMap[X][Y], "ATTACK"));
            Log.d("Attack", "Success");

    } else {
   for (int i = X - 1; i <= X + 1; i++) {
            for (int j = Y - 1; j <= Y + 1; j++) {
                if (i >= 0 && j >= 0 && i < map.length && j < map.length) {
                    if (Arrays.asList(globalInformation.stepableId).contains(map[i][j]) && smallest > HowFarGekses(heroXY, i, j)
                            ) {
                        if (walkingRobot(map, heroXY, X, Y)) {
                            smallest = HowFar(heroXY, i, j);
                            _X = i;
                            _Y = j;
                        }

                    }
                }
            }
        }
//    if(valueByObject.getSomething(objects,itemsMap[_X][_Y],"imHeroNotMonstr")==1){
//        valueByObject.setSomething(objects,itemsMap[_X][_Y],"HP",
//                valueByObject.getSomething(objects,itemsMap[_X][_Y],"HP")-
//                        valueByObject.getSomething(objects,itemsMap[X][Y],"ATACK"));
//    }

        if (objects.get(itemsMap[_X][_Y]) == null || valueByObject.getSomething(objects, itemsMap[_X][_Y], "imHeroNotMonstr") == -1) {
            String s = itemsMap[X][Y];
            itemsMap[X][Y] = "_";
            itemsMap[_X][_Y] = s;
        }


        smallest = 100;
    }
}
}
