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

    HeroParameters heroParameters;
    boolean find = true;
    int _X = -1, _Y = -1;
    int smallest = 100;
    ValueByObject valueByObject = new ValueByObject();


    public int HowFar(int X2, int Y2, int X, int Y) {
        Log.d("HowFar", "Startagain");
        return (int) Math.sqrt(Math.pow(X2 - X, 2) + Math.pow(Y2 - Y, 2));
    }


    public void Moving(String[][] map, String[][] itemsMap, int X, int Y, int X2, int Y2,HashMap<String,Object> objects,GlobalInformation globalInformation) {

        if (objects.containsKey(itemsMap[X2][Y2])) {
            if (valueByObject.getSomething(objects, itemsMap[X2][Y2], "imHeroNotMonstr") == 0
                    && valueByObject.getSomething(objects, itemsMap[X][Y], "ATTACKDISTANCE") >=  HowFar(X2, Y2, X, Y)) {
                Log.d("Starts", "Mod");
                valueByObject.setSomething(objects, itemsMap[X2][Y2], "HP",
                        valueByObject.getSomething(objects, itemsMap[X2][Y2], "HP") -
                                valueByObject.getSomething(objects, itemsMap[X][Y], "ATTACK"));
                Log.d("Attack", "Success");
            }
        } else {

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
//        if(valueByObject.getSomething(objects,itemsMap[_X][_Y],"imHeroNotMonstr")==0){
//valueByObject.setSomething(objects,itemsMap[_X][_Y],"HP",
//        valueByObject.getSomething(objects,itemsMap[_X][_Y],"HP")-
//                valueByObject.getSomething(objects,itemsMap[X][Y],"ATACK"));
//        }

            if(itemsMap[_X][_Y]== "Exit"){
                for(int i = 0;i<globalInformation.allLevels.length-1;i++){
                    if(globalInformation.allLevels[i]==globalInformation.isLevel){
                        globalInformation.setIsLevel(globalInformation.allLevels[i+1]);
                        break;
                    }
                }


            }

            if(objects.containsKey(itemsMap[_X][_Y])

//                    && valueByObject.getSomething(objects, itemsMap[_X][_Y], "imHeroNotMonstr") == -1


                    ){
//            valueByObject.addItemsMas((HeroParameters) objects.get(itemsMap[X][Y]), itemsMap[_X][_Y]);
//                valueByObject.setItemsHashMap((HeroParameters)objects.get(itemsMap[X][Y]),itemsMap[_X][_Y],(AllItems)objects.get(itemsMap[_X][_Y]));

                objects.remove(itemsMap[_X][_Y]);
                itemsMap[_X][_Y] = "_";

            }

            if (objects.get(itemsMap[_X][_Y]) == null) {
                String s = itemsMap[X][Y];
                itemsMap[X][Y] = "_";
                itemsMap[_X][_Y] = s;
//            heroParameters.MOVEPOINTS -= 1;
            }


//        valueByObject.getSomething(objects,ite)

            smallest = 100;
        }


    }


}



