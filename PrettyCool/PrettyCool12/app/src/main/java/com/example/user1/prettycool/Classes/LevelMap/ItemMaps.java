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
                Level = CellLocator(Level, 1, 2, "B");
                Level = CellLocator(Level, 3, 3, "Exit");

            break;

            case ("Area2"):

                Level = MassNullBuilder(5, 5);
                Level = CellLocator(Level, 0, 0, "H");
                Level = CellLocator(Level, 3, 3, "Zm");
                Level = CellLocator(Level, 1, 2, "B");
                Level = CellLocator(Level, 4, 4, "Exit");

            break;

            case ("Area3"):

                Level = MassNullBuilder(10, 10);
                Level = CellLocator(Level, 0, 0, "H");
                Level = CellLocator(Level, 1, 1, "B");
                Level = CellLocator(Level, 6, 8, "Zm");
                Level = CellLocator(Level, 7, 8, "Zm");
                Level = CellLocator(Level, 8, 8, "Zm");
                Level = CellLocator(Level, 9, 0, "Exit");
                break;
        }
        return Level;
    }
}
