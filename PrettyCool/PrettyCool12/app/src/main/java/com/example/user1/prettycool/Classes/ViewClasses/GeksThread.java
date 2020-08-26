//package com.example.user1.prettycool.Classes.ViewClasses;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.View;
//import android.widget.Toast;
//
//import com.example.user1.prettycool.R;
//
//
///**
// * Created by user1 on 07.03.2016.
// */
//public class GeksThread extends Thread {
//    boolean isRunning = false;
//    private SurfaceHolder surfaceHolder;
//    GeksSize geksSize;
//    Paint rgb;
//    Bitmap bitmap;
//    SpriteById spriteById;
//    Context context;
//    int width = 0,height = 0;
//    int width1 = 0,height1 = 0;
//    float touchX,touchY;
//    Dynamics dynamics;
//    CoordMas coordMas;
//    int[]coord;
//
//
//
//
//    public void setRunning(boolean isRunning) {
//        this.isRunning = isRunning;
//
//    }
//    public GeksThread(Context context, SurfaceHolder surfaceHolder) {
//    this.context = context;
//        rgb = new Paint();
//        rgb.setColor(Color.RED);
//        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.geks_slice);
//        geksSize = new GeksSize(bitmap);
//        spriteById = new SpriteById(context);
//        this.surfaceHolder = surfaceHolder;
//
//        dynamics = new Dynamics();
//
//        coordMas = new CoordMas(dynamics.staticMap.length,dynamics.staticMap.length);
//        coord = new int[2];
//    }
//
//
//   synchronized public void onTouch(View v,MotionEvent e){
//
////        touchX = X;
////        touchY = Y;
//       Toast toast = Toast.makeText(context,
//               "Пора покормить кота!", Toast.LENGTH_SHORT);
//       toast.show();
//       coord = coordMas.getIJ(e.getX(),e.getY(),geksSize.width,geksSize.height);
//       dynamics.Moving(coord[0],coord[1]);
//    }
//
//
//
//    @Override
//    public void run() {
//
////        while (isRunning) {
//            for (int i = 0; i < dynamics.staticMap.length; i++) {
//                for (int j = 0; j < dynamics.staticMap.length; j++) {
//
//                    Canvas canvas = surfaceHolder.lockCanvas();
//
//
//                    try {
//                        //     bitmap = BitmapFactory.decodeResource(context.getApplicationContext().getResources(),  locationDrawableAnalizator.LocationDrawableAnalizator(i,j,ViewLevel));
////                        canvas.drawARGB(255, 112, 115, 255);
//
//                        bitmap = spriteById.BitmapByBitmapId(bitmap, dynamics.staticMap[i][j]);
//                        canvas.drawBitmap(bitmap, width, height, rgb);
//
//                        bitmap = spriteById.BitmapByBitmapId(bitmap, dynamics.dynamicsMap[i][j]);
//                        canvas.drawBitmap(bitmap, width, height, rgb);
//
////                      canvas.drawText(i + "," + j, width * 3 / 2, height * 3 / 2 + 10, rgb);
//                        canvas.drawText(coord[0] + "," + coord[1], 50, 50, rgb);
//
//                        coordMas.addMas(i, j, width, height);
//
//                        if (j % 2 == 0 || j == 0) {
//                            width = i * geksSize.width;
//                            height = j * (geksSize.height - geksSize.height / 4);
//                        } else {
//                            width = i * geksSize.width + geksSize.width / 2;
//                            height = j * (geksSize.height - geksSize.height / 4);
//                        }
//
//
//                    } finally {
//                        if (canvas != null) {
//                            bitmap = spriteById.BitmapByBitmapId(bitmap, "FONE");
//                            canvas.drawBitmap(bitmap, 0, 0, rgb);
//                            surfaceHolder.unlockCanvasAndPost(canvas);
//                        }
//                    }
//                }
//
//            }
//        }
//
//    }
////    }
//
//
