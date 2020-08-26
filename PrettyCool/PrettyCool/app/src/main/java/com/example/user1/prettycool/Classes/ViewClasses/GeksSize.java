package com.example.user1.prettycool.Classes.ViewClasses;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import com.example.user1.prettycool.R;

/**
 * Created by user1 on 17.03.2016.
 */
public class GeksSize extends BitmapFactory {
  final float width,height;
  public  GeksSize(Bitmap bitmap,float xes){
        width = bitmap.getWidth()*xes;
        height = bitmap.getHeight()*xes;
    }
}
