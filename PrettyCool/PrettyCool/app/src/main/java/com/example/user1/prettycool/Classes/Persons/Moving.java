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

    int _X = -1, _Y = -1;
    int smallest = 100;
    ValueByObject valueByObject = new ValueByObject();


    public double HowFar(int X2, int Y2, int X, int Y) {
        Log.d("HowFar", "Startagain");
        return Math.sqrt(Math.pow(X2 - X, 2) + Math.pow(Y2 - Y, 2));
    }



    public void Moving(String[][] map, String[][] itemsMap, int X, int Y, int X2, int Y2, HashMap<String, Object> objects, GlobalInformation globalInformation,
    int[] startHeroXY) {
        if (objects.containsKey(itemsMap[X2][Y2])) {
            if (valueByObject.getSomething(objects, itemsMap[X2][Y2], "imHeroNotMonstr") == 0
                    && valueByObject.getSomething(objects, itemsMap[X][Y], "ATTACKDISTANCE") >= (int) HowFar(X2, Y2, X, Y)) {
                Log.d("Starts", "Mod");

                if(valueByObject.getSomething(objects, itemsMap[X2][Y2], "SHIELD")/25<valueByObject.getSomething(objects, itemsMap[X][Y], "ATTACK")) {
                    valueByObject.setSomething(objects, itemsMap[X2][Y2], "HP",
                            valueByObject.getSomething(objects, itemsMap[X2][Y2], "HP") -
                                    valueByObject.getSomething(objects, itemsMap[X][Y], "ATTACK") +
                                    valueByObject.getSomething(objects, itemsMap[X2][Y2], "SHIELD") / 25);
                }

                if(valueByObject.getSomething(objects,itemsMap[X2][Y2],"HP")<=0){
                    valueByObject.onExpGot((HeroParameters)objects.get(itemsMap[X][Y]),valueByObject.getSomething(objects,itemsMap[X2][Y2],"EXP"));
                    objects.remove(itemsMap[X2][Y2]);
                    }
                Log.d("Attack", "Success");
            }

            if(valueByObject.getSomething(objects, itemsMap[X2][Y2], "imHeroNotMonstr") == -1 && (HowFar(X2, Y2, X, Y)<2)){


                String s = itemsMap[X2][Y2];
                valueByObject.addItemsMas((HeroParameters) objects.get(itemsMap[X][Y]), itemsMap[X2][Y2]);
                valueByObject.addItemsHashMap((HeroParameters) objects.get(itemsMap[X][Y]), itemsMap[X2][Y2], (AllItems) objects.get(s));

                objects.remove(s);
                itemsMap[X2][Y2] = "_";

            }
        } else {

            for (int i = X - 1; i <= X + 1; i++) {
                for (int j = Y - 1; j <= Y + 1; j++) {
                    if (i >= 0 && j >= 0 && i < map.length && j < map.length) {

                        if(j%2==0 && (i!=X-1)|(i==X-1&&j==Y) ||
                                 j%2!=0 && (i!=X+1)|(i==X+1&&j==Y)) {


                            if (Arrays.asList(globalInformation.stepableId).contains(map[i][j]) && smallest > HowFar(X2, Y2, i, j)) {

                                Log.d("Moving", "Succes");
                                smallest = (int) HowFar(X2, Y2, i, j);
                                _X = i;
                                _Y = j;


                            }
                        }
                    }

                }
            }
//        if(valueByObject.getSomething(objects,itemsMap[_X][_Y],"imHeroNotMonstr")==0){
//valueByObject.setSomething(objects,itemsMap[_X][_Y],"HP",
//        valueByObject.getSomething(objects,itemsMap[_X][_Y],"HP")-
//                valueByObject.getSomething(objects,itemsMap[X][Y],"ATACK"));
//        }

        }


        if(_X!=-1&&_Y!=-1&&itemsMap[_X][_Y]== "Exit"){
            for(int i = 0;i<globalInformation.allLevels.length-1;i++){
                if(globalInformation.allLevels[i]==globalInformation.isLevel){
                    globalInformation.setIsLevel(globalInformation.allLevels[i+1]);
                    return;
                }
            }


        }



        if (_X!=-1&&_Y!=-1&&objects.get(itemsMap[_X][_Y]) == null) {


            String s = itemsMap[X][Y];
            itemsMap[X][Y] = "_";
            itemsMap[_X][_Y] = s;

            startHeroXY[0] =_X;
            startHeroXY[1]=_Y;
//            heroParameters.MOVEPOINTS -= 1;
        }


//        valueByObject.getSomething(objects,ite)
       smallest = 100;

//       if(_X==X2||_Y==Y2){
//         return false;
//       }
//        return true;
    }


}



