package com.example.user1.prettycool.Classes.LevelMap;

import android.content.Context;
import android.content.res.Resources;

import com.example.user1.prettycool.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by user1 on 17.03.2016.
 */
public class ItemMaps extends LevelBuilder{

    String[][] Level;
    File file;

    public String[][] ItemMaps(String levelName) {

        switch(levelName) {

            case ("Area1"):
                Level = MassNullBuilder(4, 4);
                Level = CellLocator(Level, 0, 0, "H");
                Level = CellLocator(Level, 0, 2, "Wp");
                Level = CellLocator(Level, 0, 3, "Wc");
                Level = CellLocator(Level, 1, 2, "B");
                Level = CellLocator(Level, 3, 3, "Exit");

            break;

            case ("Area2"):

                Level = MassNullBuilder(5, 5);
                Level = CellLocator(Level, 0, 0, "H");
                Level = CellLocator(Level, 1, 3, "Bp");
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
                Level = CellLocator(Level, 9, 9, "Exit");
                break;

            case ("Area4"):

                Level = MassNullBuilder(10, 10);
                Level = CellLocator(Level, 0, 0, "H");
                Level = CellLocator(Level, 0, 3, "Gp");
                Level = CellLocator(Level, 7, 7, "B");
                Level = CellLocator(Level, 3, 0, "Zm");
                Level = CellLocator(Level, 3, 1, "Zm");
                Level = CellLocator(Level, 3, 2, "Zm");
                Level = CellLocator(Level, 6, 9, "Zm");
                Level = CellLocator(Level, 6, 8, "Zm");
                Level = CellLocator(Level, 6, 7, "Zm");
                Level = CellLocator(Level, 7, 8, "Zm");
                Level = CellLocator(Level, 9, 9, "RedMan");
                Level = CellLocator(Level, 6, 9, "Gc");
                Level = CellLocator(Level, 7, 9, "Exit");
                break;

            case ("Area5"):
                Level = MassNullBuilder(12, 12);
                Level = CellLocator(Level, 0, 0, "H");
                for(int i =0;i<12;i++){
                    for(int j =1;j<12;j++){
                        Level = CellLocator(Level, i, j, "Zm");
                    }
            }
                Level = CellLocator(Level, 11, 11, "Gu");
                Level = CellLocator(Level, 10, 11, "Gn");
                Level = CellLocator(Level, 9, 11, "Gu");

                break;

//            case ("area5"):
//                InputStream inputStream = Resources.openRawResource(R.raw.area5items);
//
//                file =
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
