package com.example.user1.prettycool.Classes.LevelMap;
/**
 * Created by user1 on 17.03.2016.
 */
public class ItemMaps extends LevelBuilder{

    String[][] Level;


    public String[][] ItemMaps(String levelName) {

        switch(levelName) {

            case ("Area1"):
                Level = MassNullBuilder(4, 4);
                Level = CellLocator(Level, 0, 0, "H");
                Level = CellLocator(Level, 3, 3, "Z1");
                Level = CellLocator(Level, 1, 2, "B");

            break;

            case ("Area2"):

                Level = MassNullBuilder(5, 5);
                Level = CellLocator(Level, 0, 0, "H");
                Level = CellLocator(Level, 1, 2, "B");

            break;
        }
        return Level;
    }
}
