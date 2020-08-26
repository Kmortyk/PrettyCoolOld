package com.example.user1.prettycool.Classes.ViewClasses;

/**
 * Created by user1 on 06.04.2016.
 */
public class CoordMas {

    float[][][] coordMas;
    float []coord;
    int[] coord2;
    int i,j;

    CoordMas(int i,int j){
        this.i = i;
        this.j = j;
        coordMas = new float[i][j][2];
        coord = new float[2];
        coord2 = new int[2];
    }


    public void addMas(int i,int j,float X,float Y){
        coord[0] = X; coord[1] = Y;
        coordMas[i][j][0] = coord[0];
        coordMas[i][j][1] = coord[1];
    }

    public int[] getIJ(float X,float Y,int geksSizewidth,int geksSizeheight){
        for(int i=0;i<this.i;i++){
            for(int j=0;j<this.j;j++){
                if(coordMas[i][j][0]< X && X <coordMas[i][j][0]+geksSizewidth
                       && coordMas[i][j][1]<Y && Y < coordMas[i][j][1]+geksSizeheight){
                    coord2[0] = i;
                    coord2[1] = j;
                    }
            }
        }
        return coord2;
    }

}
