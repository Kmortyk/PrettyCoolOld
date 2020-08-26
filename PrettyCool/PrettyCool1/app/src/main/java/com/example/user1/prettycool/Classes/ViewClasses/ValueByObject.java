package com.example.user1.prettycool.Classes.ViewClasses;

import com.example.user1.prettycool.R;

import java.util.HashMap;

/**
 * Created by user1 on 13.04.2016.
 */
public class ValueByObject {
int type;
    Class clas;
    public int getInt(HashMap<String,Object> hm,String uniqueType,String fieldName){

        try {
           clas = hm.get(uniqueType).getClass();
                  type = clas.getField(fieldName).getInt(hm.get(uniqueType));

        } catch (IllegalAccessException e) {
            type = R.drawable.player_hero;
        } catch (NoSuchFieldException e) {
            type = R.drawable.player_hero;
        }
     return type;
    }
}
