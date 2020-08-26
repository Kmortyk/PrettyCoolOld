package com.example.user1.prettycool.Classes.ViewClasses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import com.example.user1.prettycool.R;

/**
 * Created by user1 on 19.03.2016.
 */
public class SpriteById{

    Bitmap bitmap;
    Context context;
    int idNew;
    int[]geksMas = {R.drawable.geks_slice,R.drawable.geks_slice1,R.drawable.geks_slice ,R.drawable.geks_slice,R.drawable.geks_slice,
    R.drawable.geks_slice,R.drawable.geks_slice2,R.drawable.geks_slice ,R.drawable.geks_slice3,R.drawable.geks_slice4,R.drawable.geks_slice5,R.drawable.geks_slice};

   public SpriteById(Context context){
      this.context = context;
       bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.geks_slice);
    }

     Bitmap BitmapByBitmapString(String id){
        switch(id){
            case "O":
                idNew = geksMas[(int)(Math.random()*12)];
                break;
            case "T":
                idNew = R.drawable.geks_tree;
                break;
            case "FONE":
                idNew = R.drawable.area1background;
                break;
            case "itemsquareempty":
                idNew = R.drawable.itemsquareempty;
                break;
            case "inventorybutton":
                idNew = R.drawable.inventorybutton;
                break;
            case "inventorycirclebutton":
                idNew = R.drawable.inventorycirclebutton;
                break;
            case "itemsgreenselect":
                idNew = R.drawable.itemsgreenselect;
                break;
            case "itemsquareemptygreen_light":
                idNew = R.drawable.itemsquareemptygreen_light;
                break;
            case "parambuttoncircle":
                idNew = R.drawable.parambuttoncircle;
                break;
            case "paramholst":
                idNew = R.drawable.paramholst;
                break;
            case "forward":
                idNew = R.drawable.forward;
                break;
            case "back":
                idNew = R.drawable.back;
                break;
            case "plus":
                idNew = R.drawable.plus;
                break;
            case "addhp":
                idNew = R.drawable.addhp;
                break;
            case "addshield":
                idNew = R.drawable.addshield;
                break;
            case "addattack":
                idNew = R.drawable.addattack;
                break;
            case "addspeed":
                idNew = R.drawable.addspeed;
                break;
            case "lvlup":
                idNew = R.drawable.lvlup;
                break;
            case "dropbutton":
                idNew = R.drawable.dropbutton;
                break;
            case "breakbutton":
                idNew = R.drawable.breakbutton;
                break;
            case "sortbutton":
                idNew = R.drawable.sortbutton;
                break;
            case "exit":
                idNew = R.drawable.exit;
                break;
            case "startscreen_textbiggestes":
                idNew = R.drawable.startscreen_textbiggestes;
                break;
            case "buttonsmall":
                idNew = R.drawable.buttonsmall;
                break;
            case "youre_dead":
                idNew = R.drawable.youre_dead;
                break;
            case "herohp":
                idNew = R.drawable.herohp;
                break;
            case "herohpfull":
                idNew = R.drawable.herohpfull;
                break;

        }

       return  BitmapFactory.decodeResource(context.getResources(),idNew);

    }

    Bitmap BitmapByBitmapId(int idNew){

        return BitmapFactory.decodeResource(context.getResources(),idNew);

    }


    public int[] storyDrawableMas(String mapName){
        int[] drawableMas = null;
        switch(mapName){
            case "Area1":
                drawableMas = new int[]{R.drawable.story_dreamssity, R.drawable.story_dreamssitybig,
                R.drawable.story_dreamssitybighelicopter,R.drawable.story_helicopterbig,R.drawable.story_heroface,R.drawable.story_herofacebig,R.drawable.story_judge,
                R.drawable.story_judgedark,R.drawable.story_herofaceangry,R.drawable.story_dreamssityup,R.drawable.story_dreamssityuphelicopter,
                R.drawable.story_oceanhelicopter,R.drawable.time,R.drawable.story_island,R.drawable.story_islandhelicopter,
                R.drawable.story_islandhelicopterbig,R.drawable.story_islandfone};
                break;
        }
        return drawableMas;
    }


}
