package com.example.user1.prettycool.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.user1.prettycool.Classes.ViewClasses.GeksThread;
import com.example.user1.prettycool.R;

import java.util.Locale;

public class StartScreen extends Activity {

    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        linearLayout= new LinearLayout(getApplicationContext());
        linearLayout.addView(new MyView(this));
        setContentView(linearLayout);
    }


    public class MyView extends View{

        RectF rectf;
        Paint rgb;
        Bitmap bitmap,buttonBitmap;
        Context context;
        float width,height,buttonBitmapHeight;
        int screenNumber = 0;
        float[][] buttonsCoordMas = new float[3][3];
        Point size;


    public MyView(Context context) {
        super(context);
        this.context = context;
        rgb = new Paint();

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.startscreen_textbiggestes);
        buttonBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.buttonsmall);

        size = new Point();
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        display.getSize(size);
        width = size.x;
        height=size.y;
        buttonBitmapHeight = buttonBitmap.getHeight() * height / buttonBitmap.getHeight() / 6;

        rectf = new RectF();
        rectf.set(0, 0, size.x, size.y);

        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                Context context = getApplicationContext();

                if(screenNumber==0){
                    screenNumber = 1;
                    invalidate();
                }else{

                      if(e.getX()>buttonsCoordMas[0][0]&&e.getX()<width - buttonsCoordMas[0][0]&&
                              e.getY()>buttonsCoordMas[0][1]&&e.getY()<buttonsCoordMas[0][1]+buttonBitmapHeight){

                          Intent intent = new Intent(context, LevelView.class);
                          startActivity(intent);
                      }
//                    if(e.getX()>buttonsCoordMas[1][0]&&e.getX()<width - buttonsCoordMas[1][0]&&
//                            e.getY()>buttonsCoordMas[1][1]&&e.getY()<buttonsCoordMas[1][1]+buttonBitmapHeight){
//                        Intent intent = new Intent(context, Options.class);
//                        intent.putExtra("Size",size);
//                        startActivity(intent);
//                    }
//                    if(e.getX()>buttonsCoordMas[2][0]&&e.getX()<width - buttonsCoordMas[2][0]&&
//                            e.getY()>buttonsCoordMas[2][1]&&e.getY()<buttonsCoordMas[2][1]+buttonBitmapHeight){
//                        Intent intent = new Intent(context, Options.class);
//                        intent.putExtra("Size",size);
//                        startActivity(intent);
//                    }

                }

                return false;
            }
        });
    }



    @Override
    public void onDraw(Canvas canvas) {
        if(screenNumber==0) {
            canvas.drawBitmap(bitmap, null, rectf, rgb);
            rgb.setTextSize(width / 23);
            rgb.setTextAlign(Paint.Align.CENTER);
            rgb.setColor(Color.RED);


            canvas.drawText("Нажмите на экран, чтобы начать", width / 2, height * 18 / 19, rgb);
        }else{

            rgb.setColor(Color.BLACK);
            rectf.set(0, 0, size.x, size.y);
            canvas.drawBitmap(bitmap, null, rectf, rgb);

            buttonsCoordMas[0][0] =width/2-buttonBitmap.getWidth()/2;
            buttonsCoordMas[0][1] =height / 3;

            rectf.set(buttonsCoordMas[0][0], buttonsCoordMas[0][1], width - buttonsCoordMas[0][0],
                    buttonsCoordMas[0][1] + buttonBitmapHeight);
            canvas.drawBitmap(buttonBitmap, null, rectf, null);
            rgb.setTextSize(height / 23);
            canvas.drawText("Новая игра", width / 2, buttonsCoordMas[0][1] + buttonBitmapHeight / 2, rgb);

//            buttonsCoordMas[1][0] =width/2-buttonBitmap.getWidth()/2;
//            buttonsCoordMas[1][1] = buttonsCoordMas[0][1]+buttonBitmap.getHeight()+buttonBitmapHeight / 3;
//            rectf.set(buttonsCoordMas[1][0], buttonsCoordMas[1][1], width - buttonsCoordMas[1][0],
//                    buttonsCoordMas[1][1] + buttonBitmapHeight);
//            canvas.drawBitmap(buttonBitmap, null, rectf, null);
//            rgb.setTextSize(height/23);
//            canvas.drawText("Опции", width/2, buttonsCoordMas[1][1]+buttonBitmapHeight/2, rgb);

//            buttonsCoordMas[2][0] =width/2-buttonBitmap.getWidth()/2;
//            buttonsCoordMas[2][1] =buttonsCoordMas[1][1]+buttonBitmap.getHeight()+buttonBitmapHeight / 3;
//            rectf.set(buttonsCoordMas[2][0], buttonsCoordMas[2][1], width - buttonsCoordMas[2][0],
//                    buttonsCoordMas[2][1] + buttonBitmapHeight);
//            canvas.drawBitmap(buttonBitmap,null,rectf,null);
//            rgb.setTextSize(height/23);
//            canvas.drawText("Продолжить",width/2,buttonsCoordMas[2][1]+buttonBitmapHeight/2,rgb);
        }
    }
    }

}






