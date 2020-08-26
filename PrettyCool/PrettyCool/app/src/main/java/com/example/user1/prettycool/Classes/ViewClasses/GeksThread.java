package com.example.user1.prettycool.Classes.ViewClasses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.example.user1.prettycool.Classes.Persons.AllItems;
import com.example.user1.prettycool.Classes.Persons.GlobalInformation;
import com.example.user1.prettycool.R;


/**
 * Created by user1 on 07.03.2016.
 */
public class GeksThread extends Thread {
    boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    GeksSize geksSize;
    Paint rgb;
    Bitmap bitmap, staticBitmap, effectsBitmap,heartBitmap;
    SpriteById spriteById;
    Context context;
    float width = 0, height = 0;
    Dynamics dynamics;
    int[] coord, coordInv,coordParam;
    Canvas canvas, effectsCanvas;
    GlobalInformation globalInformation;
    ValueByObject valueByObject;
    // show - картинки в начале/конце уровня, inv - окно инвентаря, lvl
    String viewType = "lvl";
    int screenNumber = 0;
    RectF rectf, rectf2,rectfParam;
    Point size,paramcoord1,paramcoord2;
    int X2,Y2;
    //переменная для обочначения кратности выводимого изображения(вычисляется по формуле)
    float xes;

    int selectedInvX, selectedInvY;
    float scrolledDistanceX,scrolledDistanceY;
    float lockedCameraX,lockedCameraY;


    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public GeksThread(Context context, SurfaceHolder surfaceHolder, Point size) {
        this.context = context;
        this.surfaceHolder = surfaceHolder;
        this.context = context;
        rgb = new Paint();
        rgb.setColor(Color.RED);
        spriteById = new SpriteById(context);
        rectf = new RectF();
        rectf2 = new RectF();
        rectfParam = new RectF();
        this.size = size;

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.geks_slice);
        geksSize = new GeksSize(bitmap,1);
        xes =(float) size.x / (geksSize.width*10);
        geksSize = new GeksSize(bitmap,xes);

        rectf.set(-size.x / 2, -size.y / 2, size.x, size.y);
        dynamics = new Dynamics();
        coord = new int[2];
        coordInv = new int[2];
        coordParam = new int[2];
        valueByObject = new ValueByObject();

        selectedInvX = -1;
        selectedInvY = -1;

        paramcoord1 = new Point();
        paramcoord2 = new Point();


//        effectsBitmap = Bitmap.createBitmap(0, 0, bitmap.getConfig());
//        effectsCanvas = new Canvas(effectsBitmap);


    }


    synchronized public boolean onTouch(MotionEvent e, float distanceX1, float distanceY1) {

        switch (viewType) {
            case "lvl":
                switch (e.getAction()) {
                    case MotionEvent.ACTION_UP: // нажатие

                        bitmap = spriteById.BitmapByBitmapString("inventorycirclebutton");
                        if (e.getX() > size.x - bitmap.getWidth()*xes && e.getY() > 0 && e.getX() < size.x && e.getY() < 0 + bitmap.getHeight()*xes) {
                            viewType = "inv";

                        }
                        if (e.getX() > size.x - bitmap.getWidth()*xes && e.getY() > 0 + bitmap.getHeight()*xes && e.getX() < size.x && e.getY() < 0 + bitmap.getHeight() * 2*xes) {
                            viewType = "param";
                        }else {
                            coord = dynamics.coordMas.getIJGeks(e.getX() + distanceX1, e.getY() + distanceY1, geksSize.width, geksSize.height);
//                        X2 = coord[0];
//                        Y2 = coord[1];
                            if(dynamics.isAlive == false){
                                viewType = "deadEnd";
                            }else {
                                dynamics.Moving(coord[0], coord[1]);
                            }


//                            if (dynamics.startheroY % 2 == 0 || dynamics.startheroY == 0) {
                                lockedCameraX =size.x/2 - dynamics.startheroXY[0] * geksSize.width;
                                lockedCameraY =size.y/2 - dynamics.startheroXY[1] * geksSize.height/4*3;
//                            } else {
//                                lockedCameraX =size.x/2 - dynamics.startheroX * geksSize.width;
//                                lockedCameraY =size.y/2 - dynamics.startheroY * geksSize.height/2;
//                            }


//                            dynamics.lastheroX = dynamics.startheroX;
//                            dynamics.lastheroY = dynamics.startheroY;

                        }
                        //тост с координатами нажатия
//                                    Toast toast = Toast.makeText(context,
//                                            coord[0] + " " + coord[1], Toast.LENGTH_SHORT);
//                                    toast.show();
                        break;
//                            case MotionEvent.ACTION_MOVE: // движение
//                                if (dynamics.isLevel == "Area4") {
//
//                                }
//                                break;
                }
                break;

            case "show":
                if (e.getAction() == MotionEvent.ACTION_UP) {
                    screenNumber += 1;
                }
                break;


            case "deadEnd":
                if (e.getAction() == MotionEvent.ACTION_UP) {
                    dynamics.afterDeath();
                    viewType = "lvl";
                }
                break;

            case "inv":
                if (e.getAction() == MotionEvent.ACTION_UP) {
                    bitmap = spriteById.BitmapByBitmapString("dropbutton");
                    if(e.getX() >size.x - bitmap.getWidth()*2 * xes&& e.getY() >size.y - bitmap.getHeight()*2*xes&& e.getX() < size.x && e.getY() < size.y&&
                            coordInv[0] != -1 && coordInv[1] != -1){

                        dynamics.dropItem((AllItems)dynamics.inventoryHashMap.get(dynamics.inventoryMas[coordInv[0]][coordInv[1]]),
                                dynamics.inventoryMas[coordInv[0]][coordInv[1]]);
                        dynamics.inventoryMas[coordInv[0]][coordInv[1]]=null;

                    }
                    if(e.getX() >size.x - bitmap.getWidth()*2 * xes&& e.getY() >size.y - bitmap.getHeight()*4*xes&& e.getX() < size.x && e.getY() < size.y- bitmap.getHeight()*2*xes&&
                            coordInv[0] != -1 && coordInv[1] != -1){

                        dynamics.brokeItem(coordInv[0],coordInv[1]);
                    }
                    if(e.getX() >size.x - bitmap.getWidth()*2 * xes&& e.getY() >size.y - bitmap.getHeight()*6*xes&& e.getX() < size.x && e.getY() < size.y- bitmap.getHeight()*4*xes&&
                            coordInv[0] != -1 && coordInv[1] != -1){

//                        dynamics.sortMas();

                    }
                    bitmap = spriteById.BitmapByBitmapString("inventorycirclebutton");
                    if (e.getX() > size.x - bitmap.getWidth()*xes && e.getY() > 0 && e.getX() < size.x && e.getY() < 0 + bitmap.getHeight()*xes) {
//                                selectedInvX=-1;
//                                selectedInvY=-1;
                        viewType = "lvl";

                    }

                    if (e.getX() > size.x - bitmap.getWidth()*xes && e.getY() > 0 + bitmap.getHeight()*xes && e.getX() < size.x && e.getY() < 0 + bitmap.getHeight() * 2*xes) {
//                                selectedInvX=-1;
//                                selectedInvY=-1;
                        viewType = "param";
                    } else {

                        coordInv = dynamics.coordMasInv.getIJ(e.getX() + distanceX1, e.getY() + distanceY1, bitmap.getWidth()*xes, bitmap.getHeight()*xes);
                        if (coordInv[0] == selectedInvX && coordInv[1] == selectedInvY) {
//////в случае проблем с инвентарем
                            if (coordInv[0] != -1 && coordInv[1] != -1) {
                                dynamics.Inventory(dynamics.inventoryMas[coordInv[0]][coordInv[1]]);
                                //при использовании предмета противники делают ход

                                if(dynamics.isAlive ==false){
                                    viewType = "deadEnd";
                                }else {
                                    dynamics.Moving(coord[0], coord[1]);
                                }

                            }

                            coordInv[0] = -1;
                            coordInv[1] = -1;

                        } else {

                            selectedInvX = coordInv[0];
                            selectedInvY = coordInv[1];
                        }

                        //тост с координатами нажатого предмета в массиве
//                                Toast toast = Toast.makeText(context,
//                                        coordInv[0] + " " + coordInv[1], Toast.LENGTH_SHORT);
//                                toast.show();
                    }

                }
                break;

            case "param":
                bitmap = spriteById.BitmapByBitmapString("parambuttoncircle");
                if (e.getAction() == MotionEvent.ACTION_UP) {
                    if (e.getX() > size.x - bitmap.getWidth()*xes && e.getY() > 0 && e.getX() < size.x && e.getY() < 0 + bitmap.getHeight()*xes) {
                        viewType = "inv";
                    }
                    else if (e.getX() > size.x - bitmap.getWidth()*xes && e.getY() > 0 + bitmap.getHeight()*xes && e.getX() < size.x && e.getY() < 0 + bitmap.getHeight() * 2*xes) {
                        viewType = "lvl";
                    }else {
                        bitmap = spriteById.BitmapByBitmapString("plus");
                        coordParam = dynamics.coordMasParam.getIJ(e.getX() + distanceX1, e.getY() + distanceY1, bitmap.getWidth() * xes, bitmap.getHeight() * xes);
                        dynamics.Parameters(coordParam[0]);
                    }
                }
                break;
        }
        return true;
    }

    @Override
    public void run() {

        while (isRunning) {
            canvas = surfaceHolder.lockCanvas(null);
            try {
                switch (viewType) {
                    case "lvl":

                        if (dynamics.canvTimer == 0) {

                            lockedCameraX =size.x/2 + dynamics.startheroXY[0] * geksSize.width *xes;
                            lockedCameraY =size.y/2 + dynamics.startheroXY[1] * geksSize.height *xes;

//                            staticBitmap = Bitmap.createBitmap(2 * size.x, 2 * size.y, bitmap.getConfig());
                            staticBitmap = Bitmap.createBitmap((int) (dynamics.staticMap.length * geksSize.width+geksSize.width/2)+1,
                                    (int)  (dynamics.staticMap.length * geksSize.height)+1, bitmap.getConfig());
                            Canvas staticCanvas = new Canvas(staticBitmap);

//                            staticCanvas.drawColor(Color.BLACK);

//                            bitmap = spriteById.BitmapByBitmapString("FONE");
//                            staticCanvas.drawBitmap(bitmap, null, rectf, rgb);



                            for (int i = 0; i < dynamics.staticMap.length; i++) {
                                for (int j = 0; j < dynamics.staticMap.length; j++) {
                                    if (j % 2 == 0 || j == 0) {
                                        width =i * geksSize.width;
                                        height =j * (geksSize.height - geksSize.height / 4);
                                    } else {
                                        width =i * geksSize.width + geksSize.width / 2;
                                        height =j * (geksSize.height - geksSize.height / 4);
                                    }



                                    bitmap = spriteById.BitmapByBitmapString(dynamics.staticMap[i][j]);
                                    rectf2.set(width, height, width + bitmap.getWidth() * xes, height + bitmap.getHeight() * xes);
                                    staticCanvas.drawBitmap(bitmap, null, rectf2, rgb);

//                                    dynamics.coordMas.addMas(i, j, width+lockedCameraX, height+lockedCameraY);

                                    dynamics.canvTimer = 1;
                                }
                            }
                        }

                        canvas.drawColor(Color.BLACK);
                        canvas.drawBitmap(staticBitmap, lockedCameraX, lockedCameraY, rgb);
                        for (int i = 0; i < dynamics.staticMap.length; i++) {
                            for (int j = 0; j < dynamics.staticMap.length; j++) {
                                if (j % 2 == 0 || j == 0) {
                                    width =lockedCameraX + i * geksSize.width;
                                    height =lockedCameraY + j * (geksSize.height - geksSize.height / 4);
                                } else {
                                    width =lockedCameraX + i * geksSize.width + geksSize.width / 2;
                                    height =lockedCameraY + j * (geksSize.height - geksSize.height / 4);
                                }


                                dynamics.coordMas.addMas(i, j, width, height);

                                if (dynamics.objects.containsKey(dynamics.dynamicsMap[i][j])) {
                                    bitmap = spriteById.BitmapByBitmapId(valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "drawableId"));
//                                    rectf2.set(width, height, width + bitmap.getWidth() * xes, height+bitmap.getHeight()*xes);
                                    rectf2.set(width+geksSize.width/4, height+geksSize.height/5,
                                            width + bitmap.getWidth() * xes+geksSize.width/4, height+bitmap.getHeight()*xes+geksSize.height/5);
                                    canvas.drawBitmap(bitmap, null, rectf2, rgb);

                                }


                                if (dynamics.dynamicsMap[i][j] == "Exit") {
                                    bitmap = spriteById.BitmapByBitmapString("exit");
                                    rectf2.set(width, height,
                                            width + bitmap.getWidth() * xes, height+bitmap.getHeight()*xes);
                                    canvas.drawBitmap(bitmap, null, rectf2, rgb);


                                }

                                if (dynamics.objects.containsKey(dynamics.dynamicsMap[i][j]) &&
                                        valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "imHeroNotMonstr") == 0) {
                                    rgb.setTextSize(10 * xes);
                                    rgb.setColor(Color.RED);
//                                    canvas.drawText(valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "HP") + "", width, height, rgb);
                                    canvas.drawText(valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "HP") + "", width + geksSize.width / 4, height + geksSize.height / 5, rgb);
                                }

                                if (dynamics.objects.containsKey(dynamics.dynamicsMap[i][j]) &&
                                        valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "imHeroNotMonstr") == 1) {
                                    rgb.setTextSize(10 * xes);
                                    rgb.setColor(Color.RED);
                                    bitmap = spriteById.BitmapByBitmapString("herohp");
                                    rectf2.set(0, 0, bitmap.getWidth() * xes, bitmap.getHeight() * xes);
                                    canvas.drawBitmap(bitmap,null,rectf2,rgb);
//                                    bitmap = spriteById.BitmapByBitmapString("herohpfull");
//                                    bitmap.

//                                    canvas.drawCircle(rectf2.centerX()*xes,rectf2.centerY()*xes,
//                                            valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "HP")*100/
//                                                    valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "maxHP"),rgb);

                                        bitmap = spriteById.BitmapByBitmapString("herohpfull");
                                        heartBitmap = Bitmap.createBitmap(bitmap.getWidth()+(int)xes,
                                                bitmap.getHeight() * valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "HP") /
                                                        valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "maxHP")+(int)xes+1
                                                , bitmap.getConfig());
                                        Canvas staticCanvas = new Canvas(heartBitmap);
                                        staticCanvas.drawBitmap(bitmap,heartBitmap.getWidth()-bitmap.getWidth(),heartBitmap.getHeight()-bitmap.getHeight(), rgb);
                                    rectf2.set(rectf2.left,rectf2.bottom-heartBitmap.getHeight()*xes,rectf2.right,rectf2.bottom);
                                        canvas.drawBitmap(heartBitmap,null,rectf2, rgb);

//                                    canvas.drawText(valueByObject.getSomething(dynamics.objects, dynamics.dynamicsMap[i][j], "HP") + "",rectf2.centerX()/2*xes,rectf2.centerY()*xes, rgb);
                                }
                            }

                        }
                        bitmap = spriteById.BitmapByBitmapString("inventorycirclebutton");
                        rectf2.set(size.x - bitmap.getWidth()*xes, 0, size.x, 0 + bitmap.getHeight()*xes);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);


                        bitmap = spriteById.BitmapByBitmapString("parambuttoncircle");
                        rectf2.set(size.x - bitmap.getWidth()*xes, 0 + bitmap.getHeight()*xes, size.x, 0 + bitmap.getHeight() * 2*xes);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

                        if(valueByObject.getSomething(dynamics.objects,dynamics.heroState,"POINTS")>0){
                            bitmap = spriteById.BitmapByBitmapString("lvlup");
                            rectf2.set(size.x - bitmap.getWidth()*xes, 0 + bitmap.getHeight()*xes, size.x, 0 + bitmap.getHeight() * 2*xes);
                            canvas.drawBitmap(bitmap, null, rectf2, rgb);
                        }
                        break;


                    case "show":
                        if (spriteById.storyDrawableMas(globalInformation.isLevel) != null && screenNumber < spriteById.storyDrawableMas(globalInformation.isLevel).length) {
                            rectf2.set(0, 0, size.x, size.y);
                            bitmap = BitmapFactory.decodeResource(context.getResources(), spriteById.storyDrawableMas(globalInformation.isLevel)[screenNumber]);
                            canvas.drawBitmap(bitmap, null, rectf2, rgb);
                        } else {
                            viewType = "lvl";
                        }
                        break;

                    case "deadEnd":
                        bitmap = spriteById.BitmapByBitmapString("youre_dead");
                        rectf2.set(0, 0, size.x, size.y);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);
                        break;

                    case "inv":
                        canvas.drawColor(Color.BLACK);


                        for (int i = 0; i < dynamics.inventoryMas.length; i++) {
                            for (int j = 0; j < dynamics.inventoryMas.length; j++) {


                                if (dynamics.valueByObject.getSomething(dynamics.inventoryHashMap, dynamics.inventoryMas[i][j], "isWearing") == 1) {

                                    bitmap = spriteById.BitmapByBitmapString("itemsquareemptygreen_light");
                                } else {
                                    bitmap = spriteById.BitmapByBitmapString("itemsquareempty");
                                }


//                                width = size.x / 9 + bitmap.getWidth() * i;
//                                height = size.y / 11 + bitmap.getHeight() * j;
                                width = size.x / 13 + bitmap.getWidth() * i*xes;
                                height = size.y / 50 + bitmap.getHeight() * j*xes;

                                rectf2.set(width,height,width+bitmap.getWidth()*xes,height+bitmap.getHeight()*xes);
                                canvas.drawBitmap(bitmap,null,rectf2, rgb);
//                                canvas.drawText(dynamics.valueByObject.getSomething((HashMap) dynamics.inventoryHashMap, dynamics.inventoryMas[i][j], "isWearing") + "",
//                                        width, height, rgb);
//                                canvas.drawText(dynamics.valueByObject.getSomething( dynamics.inventoryHashMap, dynamics.inventoryMas[i][j], "imHeroNotMonstr") + "",
//                                        width,height,rgb);
                                dynamics.coordMasInv.addMas(i, j, width, height);

                                //selected square
                                if (selectedInvX == i && selectedInvY == j) {
                                    bitmap = spriteById.BitmapByBitmapString("itemsgreenselect");
                                    rectf2.set(width, height, width + bitmap.getWidth() * xes, height + bitmap.getHeight() * xes);
                                    canvas.drawBitmap(bitmap,null, rectf2, rgb);

                                    if(dynamics.inventoryHashMap.containsKey(dynamics.inventoryMas[i][j])){
                                        rgb.setColor(Color.RED);
                                        canvas.drawText("addHP: "+valueByObject.getSomething(dynamics.inventoryHashMap,dynamics.inventoryMas[i][j],"addHp")+"",
                                                width+200,0,rgb);
                                    }

                                }

                                width += bitmap.getWidth()*xes / 2;
                                height += bitmap.getHeight()*xes / 2;
                                if (dynamics.inventoryHashMap.containsKey(dynamics.inventoryMas[i][j])) {
//                                    bitmap = spriteById.BitmapByBitmapId(dynamics.inventoryHashMap.get(dynamics.inventoryMas[i][j]).drawableId);
                                    bitmap = spriteById.BitmapByBitmapId(dynamics.valueByObject.getSomething(dynamics.inventoryHashMap, dynamics.inventoryMas[i][j], "drawableId"));
                                    width -= bitmap.getWidth()*xes / 2;
                                    height -= bitmap.getHeight()*xes;
                                    rectf2.set(width, height, width + bitmap.getWidth() * 2 * xes, height + bitmap.getHeight() * 2 * xes);
                                    canvas.drawBitmap(bitmap, null, rectf2, rgb);

                                }


                            }
                        }

                        bitmap = spriteById.BitmapByBitmapString("inventorycirclebutton");
                        rectf2.set(size.x - bitmap.getWidth() * xes, 0, size.x, 0 + bitmap.getHeight() * xes);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

                        bitmap = spriteById.BitmapByBitmapString("parambuttoncircle");
                        rectf2.set(size.x - bitmap.getWidth() * xes, 0 + bitmap.getHeight() * xes, size.x, 0 + bitmap.getHeight() * 2 * xes);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

//                        bitmap = spriteById.BitmapByBitmapString("sortbutton");
//                        rectf2.set(size.x - bitmap.getWidth()*2 * xes, size.y - bitmap.getHeight()*6 * xes, size.x , size.y- bitmap.getHeight()*4 );
//                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

                        bitmap = spriteById.BitmapByBitmapString("breakbutton");
                        rectf2.set(size.x - bitmap.getWidth()*2 * xes, size.y - bitmap.getHeight()*4 * xes, size.x , size.y- bitmap.getHeight()*2 );
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

                        bitmap = spriteById.BitmapByBitmapString("dropbutton");
                        rectf2.set(size.x - bitmap.getWidth()*2 * xes, size.y - bitmap.getHeight()*2 * xes, size.x , size.y );
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

                        if(valueByObject.getSomething(dynamics.objects,dynamics.heroState,"POINTS")>0){
                            bitmap = spriteById.BitmapByBitmapString("lvlup");
                            rectf2.set(size.x - bitmap.getWidth()*xes, 0 + bitmap.getHeight()*xes, size.x, 0 + bitmap.getHeight() * 2*xes);
                            canvas.drawBitmap(bitmap, null, rectf2, rgb);
                        }

                        break;


                    case "param":
                        canvas.drawColor(Color.BLACK);

                        bitmap = spriteById.BitmapByBitmapString("paramholst");
                        rectf2.set(size.x / 13, size.y / 50*xes, size.x / 13 * 11, size.y / 3);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

                        bitmap = spriteById.BitmapByBitmapString("paramholst");
                        rectfParam.set(size.x / 13, size.y / 3, size.x / 13 * 11, size.y / 50 * 48);
                        canvas.drawBitmap(bitmap, null, rectfParam, rgb);



                        for(int i=0;i<4;i++){
                            switch(i) {
                                case 0:
                                    bitmap = spriteById.BitmapByBitmapString("addhp");
                                    break;
                                case 1:
                                    bitmap = spriteById.BitmapByBitmapString("addshield");
                                    break;
                                case 2:
                                    bitmap = spriteById.BitmapByBitmapString("addattack");
                                    break;
                                case 3:
                                    bitmap = spriteById.BitmapByBitmapString("addspeed");
                                    break;

//
                                }
                            rectf2.set(size.x / 10 + rectfParam.width() / 4 * i, rectfParam.height() / 13 * 11,
                                    size.x / 10 + rectfParam.width() / 4 * i+bitmap.getWidth()*xes,
                                    rectfParam.height() / 13 * 11 + bitmap.getHeight()*xes);

                            canvas.drawBitmap(bitmap,null,rectf2, rgb);
//                            size.x / 10+ rectf2.width() / 4 * i, rectf2.height() / 13 * 11*xes

                            if(valueByObject.getSomething(dynamics.objects,dynamics.heroState,"POINTS")>0) {
                                bitmap = spriteById.BitmapByBitmapString("plus");


                                rectf2.set(size.x / 10 + rectfParam.width() / 4 * i, rectfParam.height() / 13 * 15,
                                        size.x / 10 + rectfParam.width() / 4 * i+bitmap.getWidth()*xes,
                                        rectfParam.height() / 13 * 15+ bitmap.getHeight()*xes);
                                canvas.drawBitmap(bitmap,null,rectf2, rgb);
//                                size.x / 10+ rectf2.width() / 4 * i, rectf2.height() /13 * 15

//                                dynamics.coordMasParam.addMas(i,0,rectf2.width() / 4 * i, rectf2.height() / 13 * 15);
                                dynamics.coordMasParam.addMas(i,0,size.x / 10 + rectfParam.width() / 4 * i, rectfParam.height() / 13 * 15);
                            }
                        }


                        //size.x/13-size.x/13*11  size.y/50-size.y/3;
                        for(int i =0;i<globalInformation.params.length;i++){



//                                canvas.drawText(globalInformation.params[i]+": "+valueByObject.getSomething(dynamics.objects, dynamics.heroState,globalInformation.params[i]),
//                                        size.x/13+(size.x/13*11-size.x/13)/3,size.y/50+i*6+50,rgb);
                            rgb.setColor(Color.BLACK);
                            canvas.drawText(globalInformation.params[i]+": "+valueByObject.getSomething(dynamics.objects, dynamics.heroState,globalInformation.params[i]),
                                    size.x/11,size.y/50*3+i*11*xes,rgb);





                        }

//                        canvas.drawText();
//                        canvas.drawText(valueByObject.getSomething(dynamics.objects, dynamics.heroState, "HP") + "\n" +
//                                valueByObject.getSomething(dynamics.objects, dynamics.heroState, "ATTACK") + "\n" +
//                                valueByObject.getSomething(dynamics.objects, dynamics.heroState, "SHIELD") + "\n" +
//                                valueByObject.getSomething(dynamics.objects, dynamics.heroState, "ATTACKDISTANCE") + "", 100, 100, rgb);

                        bitmap = spriteById.BitmapByBitmapString("inventorycirclebutton");
                        rectf2.set(size.x - bitmap.getWidth()*xes, 0, size.x, 0 + bitmap.getHeight()*xes);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);

                        bitmap = spriteById.BitmapByBitmapString("parambuttoncircle");
                        rectf2.set(size.x - bitmap.getWidth()*xes, 0 + bitmap.getHeight()*xes, size.x, 0 + bitmap.getHeight() * 2*xes);
                        canvas.drawBitmap(bitmap, null, rectf2, rgb);
                        break;

                }
            }
//            catch(Exception e){
//               run();
//                }
            finally {
                if(canvas!=null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}

//осталось 2 дней;
//
//Презентация
//Переход через локации
//Ролевая система
//Огрехи рисовки
//Искусственный интеллект
//Инвентарь
//На весь экран
//Музыка
//Эффекты
//
//
//всего этого не будет!