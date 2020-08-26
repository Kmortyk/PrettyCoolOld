package com.example.user1.prettycool.Classes.Persons;

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
    int smallest = 100;
    int _X =-1
            ,_Y=-1;
    ValueByObject valueByObject = new ValueByObject();


   public int[] WhereHero(String[][] a){
       int[]b = null;
  for(int i=0;i<a.length;i++){
      for(int j=0;j<a.length;j++){
          if(a[i][j]=="H") {
              if(b == null)
              b = new int[]{i, j};
          }
      }
  }
       return b;

    }


    public int HowFar(int[] heroXY,int X,int Y){
        return (int) Math.sqrt(Math.pow(heroXY[0]-X,2)+Math.pow(heroXY[1]-Y,2));
    }


    public boolean walkingRobot(String map[][],int[] heroXY,int X,int Y) {
        boolean goodStep = true;
        int steps=0;
        while (X == heroXY[0] && Y == heroXY[1]&&steps<=HowFar(heroXY,X,Y)+5) {
            for (int i = X - 1; i <= X + 1; i++) {
                for (int j = Y - 1; j <= Y + 1; j++) {
                    if(i>=0&&j>=0&&i<map.length&&j<map.length) {
                        if (Arrays.asList(globalInformation.stepableId).contains(map[i][j])) {
                            if (smallest > HowFar(heroXY, i, j)) {
                                smallest = HowFar(heroXY, i, j);
                                X = i;
                                Y = j;
                            }

                        }
                    }
                }

            }
        }
        if(steps>HowFar(heroXY,X,Y)+2) goodStep = false;
        return goodStep;
    }





    public boolean CanIAttack(int howFar,String id){
    return true;
    }

public void imGoingToKillHero(String[][]map,String[][]itemsMap,int X,int Y,HashMap<String,Object> objects){
    int[] heroXY = WhereHero(itemsMap);
for(int i = X-1;i<=X+1;i++){
    for(int j = Y-1;j<=Y+1;j++){
        if(i>=0&&j>=0&&i<map.length&&j<map.length) {
            if (Arrays.asList(globalInformation.stepableId).contains(map[i][j]) && smallest > HowFar(heroXY, i, j) &&
                    valueByObject.getInt(objects,itemsMap[_X][_Y],"imHeroNotMonstr")!=1) {
                if (walkingRobot(map, heroXY, X, Y)) {
                    smallest = HowFar(heroXY, i, j);
                    _X = i;
                    _Y = j;
                }

            }
        }
    }
}


       if(objects.get(itemsMap[_X][_Y]) == null || valueByObject.getInt(objects,itemsMap[_X][_Y],"imHeroNotMonstr")==-1) {
           String s =itemsMap[X][Y];
           itemsMap[X][Y] = "_";
           itemsMap[_X][_Y] = s;
       }

    smallest = 100;
}

}
