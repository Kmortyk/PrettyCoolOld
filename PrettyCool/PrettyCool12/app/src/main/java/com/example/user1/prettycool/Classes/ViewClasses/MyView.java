package com.example.user1.prettycool.Classes.ViewClasses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Toast;


import com.example.user1.prettycool.Classes.Persons.GlobalInformation;
import com.example.user1.prettycool.R;

/**
 * Created by user1 on 09.01.2016.
 */
public class MyView extends View {

    private SurfaceHolder surfaceHolder;
    GeksSize geksSize;
    Paint rgb;
    Bitmap bitmap;
    SpriteById spriteById;
    Context context;
    int width = 0, height = 0;
    Dynamics dynamics;
    CoordMas coordMas;
    int[] coord;
    int canvTimer =0;
    Canvas canvas;
    GlobalInformation globalInformation;
    ValueByObject valueByObject;

    private final GestureDetector gestureDetector;
    float distanceX1,distanceY1;
    boolean longClick;


    public MyView(final Context context) {

        super(context);
        this.context = context;
        rgb = new Paint();
        rgb.setColor(Color.RED);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.geks_slice);
        geksSize = new GeksSize(bitmap);
        spriteById = new SpriteById(context);

        dynamics = new Dynamics();

        coordMas = new CoordMas(dynamics.staticMap.length, dynamics.staticMap.length);

        coord = new int[2];
        valueByObject = new ValueByObject();

        gestureDetector = new GestureDetector(context, new MyGestureListener());

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {









                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN: // нажатие
                        coord = coordMas.getIJ(e.getX() + distanceX1, e.getY() + distanceY1, geksSize.width, geksSize.height);

                        dynamics.Moving(coord[0], coord[1]);
                        Toast toast = Toast.makeText(context,
                                coord[0] + " " + coord[1], Toast.LENGTH_SHORT);
                        toast.show();
                        invalidate();
                        break;
                    case MotionEvent.ACTION_MOVE: // движение
                        if(dynamics.isLevel=="Area3") {
                            if (gestureDetector.onTouchEvent(e)) return true;
                        }
                       break;
//                    case MotionEvent.ACTION_UP: // отпускание
//                        break;
//                    case MotionEvent.ACTION_CANCEL:
//                       break;
                }


//                if(dynamics.dynamicsMap[coord[0]][coord[1]].charAt(0)!='H'){
//                   dynamics.Moving(coord[0],coord[1]);
//                }
//                return true;


                return true;
            }
        });


    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event)
//    {
//
//    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener
    {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
        {
            distanceX1+= distanceX;
            distanceY1+= distanceY;
            scrollBy((int) distanceX, (int) distanceY);
            return true;
        }
    }




    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//
//        if(canvTimer==0) {
//
//
//            for (int i = 0; i < dynamics.staticMap.length; i++) {
//            for (int j = 0; j < dynamics.staticMap.length; j++) {
//                if (j % 2 == 0 || j == 0) {
//                    width = i * geksSize.width;
//                    height = j * (geksSize.height - geksSize.height / 4);
//                } else {
//                    width = i * geksSize.width + geksSize.width / 2;
//                    height = j * (geksSize.height - geksSize.height / 4);
//                }
//
//                bitmap = spriteById.BitmapByBitmapString(bitmap, dynamics.staticMap[i][j]);
//                canvas.drawBitmap(bitmap, width, height, rgb);
//                coordMas.addMas(i, j, width, height);
//                this.canvas = canvas;
//                canvTimer=1;
//                }
//            }
//        }



//        if(this.canvas!=canvas) canvas = this.canvas;
        canvas.drawColor(Color.BLACK);
        for (int i = 0; i < dynamics.staticMap.length; i++) {
            for (int j = 0; j < dynamics.staticMap.length; j++) {
                try {

                    if (j % 2 == 0 || j == 0) {
                        width = i * geksSize.width;
                        height = j * (geksSize.height - geksSize.height / 4);
                    } else {
                        width = i * geksSize.width + geksSize.width / 2;
                        height = j * (geksSize.height - geksSize.height / 4);
                    }

                    bitmap = spriteById.BitmapByBitmapString(bitmap, dynamics.staticMap[i][j]);
                    canvas.drawBitmap(bitmap, width, height, rgb);

                    coordMas.addMas(i, j, width, height);

                    bitmap = spriteById.BitmapByBitmapId(bitmap, valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j],"drawableId"));
                    canvas.drawBitmap(bitmap, width, height, rgb);

          if(dynamics.objects.containsKey(dynamics.dynamicsMap[i][j])&&
                  valueByObject.getSomething(dynamics.objects,dynamics.dynamicsMap[i][j], "imHeroNotMonstr")!=-1) {
              canvas.drawText(valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "HP") + "", width, height, rgb);
          }
                    canvas.drawText(dynamics.dynamicsMap[i][j],width+400,height+50,rgb);

                } catch(Exception e){

                    }
//                } finally {
//                    if (canvas != null) {
//                        bitmap = spriteById.BitmapByBitmapId(bitmap, "FONE");
//                        canvas.drawBitmap(bitmap, 0, 0, rgb);
//                        surfaceHolder.unlockCanvasAndPost(canvas);
//                    }
//                }

            }
        }


    }
}
