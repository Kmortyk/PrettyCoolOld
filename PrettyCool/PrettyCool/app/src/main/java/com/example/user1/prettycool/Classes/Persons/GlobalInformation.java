package com.example.user1.prettycool.Classes.Persons;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by user1 on 30.03.2016.
 */
public class GlobalInformation {



    public String isLevel = "Area1";
    final public static String[] monstersId = {"Zmd","Zm","Gu","Gn"};
    final public static String[]itemId = {"B","Pb","Bp","Gp","RedMan","Wp","Wc","Gc"};
    final public static String[]stepableId={"O","O1"};
    final public static String[]allLevels={"area5","Area1","Area2","Area3","Area4","Area5"};
    final public static String[]params={"LVL","HP","maxHP","EXP","ATTACK","ATTACKDISTANCE","SHIELD","SPEED","POINTS"};
    public static int heroId = 0;
// HP ATTACK SHIELD SPEED

    public void setIsLevel(String isLevel) {
        this.isLevel = isLevel;
    }

    String[] slideShowText(String mapName){
        String[] text = null;
        switch(mapName){
            case "Area1":
                text =new String[]{"TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT","TEXT"};
                break;
        }
        return text;
    }

}
