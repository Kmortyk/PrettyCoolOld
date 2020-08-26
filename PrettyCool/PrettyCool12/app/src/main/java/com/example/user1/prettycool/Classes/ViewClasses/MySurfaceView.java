//package com.example.user1.prettycool.Classes.ViewClasses;
//
//import android.content.Context;
//import android.graphics.PixelFormat;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.View;
//
///**
// * Created by user1 on 27.02.2016.
// */
//public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,View.OnTouchListener {
//
//
//    GeksThread geksThread;
//
//    public MySurfaceView(Context context) {
//        super(context);
//
//        this.setZOrderOnTop(true);
//        // Same reason here
//        this.getHolder().setFormat(PixelFormat.TRANSPARENT);
//        this.getHolder().addCallback(this);
//        this.getHolder().setSizeFromLayout();
//        // Tried without this line and with "software" and "none" types too
//        // and hardware acceleration on application and activity
//        this.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//    }
//
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//
//        geksThread.onTouch(v,event);
////        return true;
//        return super.onTouchEvent(event);
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
////        setWillNotDraw(false);
////        geksThread = new GeksThread(getContext(),getHolder());
//        geksThread = new GeksThread(getContext(),getHolder());
//        geksThread.setRunning(true);
//        geksThread.start();
//
//
//
//
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        boolean retry = true;
//        geksThread.setRunning(false);
//        while (retry) {
//            try {
//
//                geksThread.join();
//                retry = false;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//}