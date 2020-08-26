package com.example.user1.prettycool.Classes.Persons;

/**
 * Created by user1 on 24.03.2016.
 */
public class InventoryClass extends HeroParameters{

    int[][]inventoryMas = new int[10][10];
    AllItems allItems;

     InventoryClass(){
        for(int i=0;i<inventoryMas.length;i++){
            for(int j=0;j<inventoryMas.length;j++){
                inventoryMas[i][j] = 0;
            }
        }
    }

    public void onItemGot(int id){
        for(int i=0;i<inventoryMas.length;i++) {
            for (int j = 0; j < inventoryMas.length; j++) {
                if(inventoryMas[i][j]==0){
                    inventoryMas[i][j] = id;

                }
            }
        }
    }
}
