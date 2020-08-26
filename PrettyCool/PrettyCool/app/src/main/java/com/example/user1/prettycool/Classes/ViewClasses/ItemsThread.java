//package com.example.user1.prettycool.Classes.ViewClasses;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.view.SurfaceHolder;
//
//import com.example.user1.prettycool.Classes.LevelMap.MapLevels;
//import com.example.user1.prettycool.R;
//
///**
// * Created by user1 on 24.03.2016.
// */
//public class ItemsThread extends Thread {
//    private boolean isRunning = false;
//    private SurfaceHolder surfaceHolder;
//    GeksSize geksSize;
//    Paint rgb;
//    MapLevels mapLevels;
//    int[][] ViewLevel;
//    Bitmap bitmap;
//    SpriteById spriteById;
//    Context context;
//    int a;
//    int width = 0,height = 0;
//    public void setRunning() {
//        this.isRunning = false;
//
//    }
//    public ItemsThread(Context context, SurfaceHolder surfaceHolder) {
//        this.context = context;
//        rgb = new Paint();
//        rgb.setColor(Color.RED);
//        mapLevels = new MapLevels();
//        ViewLevel = mapLevels.A2();
//        bitmap = BitmapFactory.decodeResource(context.getApplicationContext().getResources(), R.drawable.geks_slice);
//        geksSize = new GeksSize(bitmap);
//        spriteById = new SpriteById(context);
//        this.surfaceHolder = surfaceHolder;
//
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < ViewLevel.length; i++) {
//            for (int j = 0; j < ViewLevel.length; j++) {
//                Canvas canvas = surfaceHolder.lockCanvas();
//                if (canvas != null) {
//                    try {
//
//                        bitmap = spriteById.SpriteByIde(ViewLevel[i][j]);
//                        canvas.drawBitmap(bitmap,width,height, rgb);
//                        width=i*geksSize.width;
//                        height=j*geksSize.height;
//                    } finally {
//
//                        surfaceHolder.unlockCanvasAndPost(canvas);
//
//                    }
//                }
//            }
//        }
//    }
//
//}
