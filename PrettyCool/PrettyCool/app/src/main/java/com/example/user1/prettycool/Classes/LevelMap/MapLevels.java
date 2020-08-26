package com.example.user1.prettycool.Classes.LevelMap;

import java.io.File;

/**
 * Created by user1 on 24.02.2016.
 */
public class MapLevels extends LevelBuilder {

    String[][] Level;
    File file;

    public String[][] MapLevels(String levelName){

        switch(levelName) {


         case("Area1") :
              Level = MassBuilder(4, 4);
              Level = CellLocator(Level,0, 1,"T");

         break;

         case("Area2"):
            Level = MassBuilder(5, 5);
            Level = CellLocator(Level, 1, 1, "T");
            Level = CellLocator(Level,2, 2, "T");

         break;


            case("Area3"):
                Level = MassBuilder(10, 10);
                break;

            case("Area4"):
                Level = MassBuilder(10, 10);
                Level = CellLocator(Level, 9, 8, "T");
                Level = CellLocator(Level, 8, 9, "T");
                Level = CellLocator(Level,8, 8, "T");
                break;

            case("Area5"):
                Level = MassBuilder(12, 12);
                break;
//            case ("area5"):
//                file =new File(levelName);
//                String s = file.toString();
//                String mas[] = s.split(";");
//
//                for(int i=0; i<mas.length; i++){
//                    for(int j=0; j<mas.length; j++) {
//                        Level[j][i] = String.valueOf(mas[j].split(","));
//                    }
//                }
//                break;

        }
        return Level;
    }

}
