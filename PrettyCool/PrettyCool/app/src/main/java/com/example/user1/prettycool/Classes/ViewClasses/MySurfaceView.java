package com.example.user1.prettycool.Classes.ViewClasses;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user1 on 27.02.2016.
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{


   public static GeksThread geksThread;
    float distanceX1, distanceY1;
    private GestureDetector gestureDetector;
    Context context;
    Point size;

    public MySurfaceView(Context context,Point size) {
        super(context);
        this.context = context;
        this.size = size;

        this.setZOrderOnTop(true);
        // Same reason here
        this.getHolder().setFormat(PixelFormat.TRANSPARENT);
        this.getHolder().addCallback(this);
        this.getHolder().setSizeFromLayout();
        // Tried without this line and with "software" and "none" types too
        // and hardware acceleration on application and activity
        this.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        gestureDetector = new GestureDetector(context, new MyGestureListener());

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        setWillNotDraw(false);
//        geksThread = new GeksThread(getContext(),getHolder());
        geksThread = new GeksThread(getContext(), getHolder(),size);
//        geksThread.setRunning(true);
        geksThread.dynamics.firstRun();
        geksThread.setRunning(true);
        geksThread.start();

    }


    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("Scroll", "imScrollingMathafaka!!!!");
            distanceX1 += distanceX;
            distanceY1 += distanceY;
            scrollBy((int) distanceX, (int) distanceY);
            return true;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        geksThread.onTouch(v, event);
        Log.d("Touch", "succes");
//        gestureDetector.onTouchEvent(event);
        geksThread.onTouch(event, distanceX1, distanceY1);
//        geksThread.setRunning(true);

        return true;
    }




    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        geksThread.setRunning(false);
        while (retry) {
            try {

                geksThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

