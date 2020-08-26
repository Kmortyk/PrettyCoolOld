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

   public SpriteById(Context context){
      this.context = context;
       bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.geks_slice);
    }

     Bitmap BitmapByBitmapString(Bitmap bitmap,String id){
        switch(id){
            case "O":
                idNew = R.drawable.geks_slice;
                break;
            case "T":
                idNew = R.drawable.geks_slice2;
                break;
            case "FONE":
                idNew = R.drawable.game_fone;
                break;

        }

       return bitmap = BitmapFactory.decodeResource(context.getResources(),idNew);

    }

    Bitmap BitmapByBitmapId(Bitmap bitmap,int idNew){
//        switch(id){
//            case "O":
//                idNew = R.drawable.geks_slice;
//                break;
//            case "T":
//                idNew = R.drawable.geks_slice2;
//                break;
////            case "#":
//            case "Z1":
//                idNew = R.drawable.monster_redneck;
//                break;
//            case "H":
//                idNew = R.drawable.player_hero;
//                break;
//            case "B":
//                idNew = R.drawable.item_littlebag;
//                break;
//            case "FONE":
//                idNew = R.drawable.game_fone;
//                break;
//
//        }

        return bitmap = BitmapFactory.decodeResource(context.getResources(),idNew);

    }
}
