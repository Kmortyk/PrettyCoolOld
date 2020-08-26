package com.example.user1.prettycool.Classes.Persons;

import android.util.Log;

import com.example.user1.prettycool.Classes.ViewClasses.ValueByObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 27.03.2016.
 */
public class Moving {

    GlobalInformation globalInformation = new GlobalInformation();
    HeroParameters heroParameters = new HeroParameters();
    int _X = -1, _Y = -1;
    int smallest = 100;
    ValueByObject valueByObject = new ValueByObject();


    public int HowFar(int X2, int Y2, int X, int Y) {
        Log.d("HowFar", "Startagain");
        return (int) Math.sqrt(Math.pow(X2 - X, 2) + Math.pow(Y2 - Y, 2));
    }


    public void Moving(String[][] map, String[][] itemsMap, int X, int Y, int X2, int Y2,HashMap<String,Object> objects) {
        for (int i = X - 1; i <= X + 1; i++) {
            for (int j = Y - 1; j <= Y + 1; j++) {
                if (i >= 0 && j >= 0 && i < map.length && j < map.length) {
                    if (Arrays.asList(globalInformation.stepableId).contains(map[i][j]) && smallest > HowFar(X2, Y2, i, j)) {

                        Log.d("Moving", "Succes");
                        smallest = HowFar(X2, Y2, i, j);
                        _X = i;
                        _Y = j;


                    }
                }


            }
        }


        if (objects.get(itemsMap[_X][_Y]) == null || valueByObject.getInt(objects,itemsMap[_X][_Y],"imHeroNotMonstr")==-1) {
            String s = itemsMap[X][Y];
            itemsMap[X][Y] = "_";
            itemsMap[_X][_Y] = s;
//            heroParameters.MOVEPOINTS -= 1;
        }
        smallest = 100;
    }





}



