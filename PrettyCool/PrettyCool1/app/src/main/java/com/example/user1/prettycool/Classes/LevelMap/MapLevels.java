package com.example.user1.prettycool.Classes.LevelMap;
/**
 * Created by user1 on 24.02.2016.
 */
public class MapLevels extends LevelBuilder {

    String[][] Level;


    public String[][] MapLevels(String levelName){

        switch(levelName) {


         case("Area1") :
              Level = MassBuilder(4, 4);
              Level = CellLocator(Level,0, 1,"T");

         break;

         case("Area2"):
            Level = MassBuilder(5, 5);
            Level = CellLocator(Level,1, 1, "T");
            Level = CellLocator(Level,2, 2, "T");

         break;

        }
        return Level;
    }

}
