package com.example.user1.prettycool.Classes.ViewClasses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
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
    Bitmap bitmap,staticBitmap;
    SpriteById spriteById;
    Context context;
    float width = 0, height = 0;
    Dynamics dynamics;
    CoordMas coordMas;
    int[] coord;
    int canvTimer = 0;
    Canvas canvas;
    GlobalInformation globalInformation;
    ValueByObject valueByObject;
    // slide - картинки в начале.конче уровня, i - окно инвентаря
    String viewType = "show";
    int screenNumber = 100;
    private final GestureDetector gestureDetector;
    float distanceX1, distanceY1;
    boolean longClick;
    RectF rectf,rectf2;
    Point size;


    public MyView(final Context context, Point size) {

        super(context);
        this.context = context;
        rgb = new Paint();
        rgb.setColor(Color.RED);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.geks_slice);
        geksSize = new GeksSize(bitmap,2);
        spriteById = new SpriteById(context);
        rectf = new RectF();
        rectf2 = new RectF();
        this.size = size;
        rectf.set(-size.x / 2, -size.y / 2, size.x, size.y);
        dynamics = new Dynamics();
        coordMas = new CoordMas(dynamics.staticMap.length, dynamics.staticMap.length);
        coord = new int[2];
        gestureDetector = new GestureDetector(context, new MyGestureListener());

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                switch (viewType) {
                    case "lvl":
                        switch (e.getAction()) {
                            case MotionEvent.ACTION_DOWN: // нажатие
                                coord = coordMas.getIJ(e.getX() + distanceX1, e.getY() + distanceY1, geksSize.width, geksSize.height);
                                dynamics.Moving(coord[0], coord[1]);
                                Toast toast = Toast.makeText(context,
                                coord[0] + " " + coord[1], Toast.LENGTH_SHORT);
                                invalidate();
                                toast.show();
                                break;
                            case MotionEvent.ACTION_MOVE: // движение
                                if (dynamics.isLevel == "Area4") {
                                    if (gestureDetector.onTouchEvent(e)) return true;
                                }
                                break;
                        }
                        break;

                    case "show":
                        screenNumber += 1;
                        invalidate();
                        break;
                }
                return true;
            }
        });


    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            distanceX1 += distanceX;
            distanceY1 += distanceY;
            scrollBy((int) distanceX, (int) distanceY);
            return true;
        }
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if(canvTimer==0&& viewType=="lvl") {
            canvas.drawColor(Color.BLACK);

            staticBitmap = Bitmap.createBitmap(2*size.x, 2*size.y, bitmap.getConfig());
            Canvas staticCanvas = new Canvas(staticBitmap);


            for (int i = 0; i < dynamics.staticMap.length; i++) {
            for (int j = 0; j < dynamics.staticMap.length; j++) {
                if (j % 2 == 0 || j == 0) {
                    width = i * geksSize.width;
                    height = j * (geksSize.height - geksSize.height / 4);
                } else {
                    width = i * geksSize.width + geksSize.width / 2;
                    height = j * (geksSize.height - geksSize.height / 4);
                }

                bitmap = spriteById.BitmapByBitmapString(dynamics.staticMap[i][j]);
                staticCanvas.drawBitmap(bitmap, width, height, rgb);
//                canvas.drawBitmap(bitmap, width, height, rgb);
                coordMas.addMas(i, j, width, height);
                canvTimer=1;
                }
            }
        }
//        if(this.canvas!=canvas) canvas = this.canvas;


        switch (viewType) {
            case "lvl":
                bitmap = spriteById.BitmapByBitmapString("FONE");
                canvas.drawBitmap(bitmap, null, rectf, rgb);
//                bitmap = spriteById.BitmapByBitmapString(bitmap, "FONE");
//                canvas.drawBitmap(bitmap, null, rectf, rgb);
                canvas.drawBitmap(staticBitmap,0,0,rgb);
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

//                            bitmap = spriteById.BitmapByBitmapString(bitmap, dynamics.staticMap[i][j]);
//                            canvas.drawBitmap(bitmap, width, height, rgb);
//
//                            coordMas.addMas(i, j, width, height);

                            if(dynamics.objects.containsKey(dynamics.dynamicsMap[i][j])){
                            bitmap = spriteById.BitmapByBitmapId(valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "drawableId"));
                                canvas.drawBitmap(bitmap, width, height, rgb);
                            }

                            if (dynamics.objects.containsKey(dynamics.dynamicsMap[i][j]) &&
                                    valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "imHeroNotMonstr") != -1) {
                                canvas.drawText(valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "HP") + "", width, height, rgb);
                            }
//                            canvas.drawText(dynamics.dynamicsMap[i][j], width + 400, height + 50, rgb);
                            bitmap = spriteById.BitmapByBitmapString("itemsquareempty");
//                    rectf.set()
//                    canvas.drawBitmap(bitmap,null);

                        } finally{
                            bitmap = spriteById.BitmapByBitmapString("inventorybutton");
                            rectf2.set(size.x-bitmap.getWidth(),0,size.x,0+bitmap.getHeight());
                            canvas.drawBitmap(bitmap,null,rectf2,rgb);
                        }
                    }

                }
                break;
            case "show":
                if (spriteById.storyDrawableMas(globalInformation.isLevel)!=null && screenNumber < spriteById.storyDrawableMas(globalInformation.isLevel).length) {
                    rectf2.set(0,0,size.x,size.y);
                    bitmap = BitmapFactory.decodeResource(context.getResources(), spriteById.storyDrawableMas(globalInformation.isLevel)[screenNumber]);
                    canvas.drawBitmap(bitmap, null, rectf2, rgb);
                }else{
                    viewType = "lvl";
                    invalidate();
                }
                break;

        }
    }
}
