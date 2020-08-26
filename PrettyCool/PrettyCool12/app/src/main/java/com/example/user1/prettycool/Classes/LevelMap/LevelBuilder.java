package com.example.user1.prettycool.Classes.LevelMap;
/**
 * Created by user1 on 09.01.2016.
 */
public class LevelBuilder {

    public String[][] MassBuilder(int i,int j){
        String[][] Level = new String[i][j];
        for(int a=0;a<Level.length;a++) {
            for (int b = 0; b < Level.length; b++){
                Level[a][b] = "O";
            }
        }
        return Level;
    }

    public String[][] MassNullBuilder(int i,int j){
        String[][] Level1 = new String[i][j];
        for(int a=0;a<Level1.length;a++) {
            for (int b = 0; b < Level1.length; b++){
                Level1[a][b] = "_";
            }
        }
        return Level1;
    }

    public String[][] CellLocator(String[][]Level,int i,int j,String type){
        Level[i][j] = type;
        return Level;
    }
}
