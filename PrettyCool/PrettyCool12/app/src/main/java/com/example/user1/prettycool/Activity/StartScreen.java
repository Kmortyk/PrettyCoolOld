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

import com.example.user1.prettycool.R;

public class StartScreen extends Activity {

    LinearLayout linearLayout;
    ScrollView scrollView;
    HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        linearLayout= new LinearLayout(getApplicationContext());
        linearLayout.addView(new MyView(this));

//        scrollView = new ScrollView(getApplicationContext());
//        horizontalScrollView = new HorizontalScrollView(getApplicationContext());
//
//
//        scrollView.addView(new MyView(this));
//horizontalScrollView.addView(new MyView(this));
        setContentView(linearLayout);
    }


    public class MyView extends View{

        RectF rectf;
    Paint rgb;
    Bitmap bitmap,buttonBitmap;
    Context context;
    float width,height;
        int screenNumber = 0;
        float[][] buttonsCoordMas = new float[3][3];

    public MyView(Context context) {
        super(context);
        this.context = context;
        rgb = new Paint();
        rgb.setColor(Color.RED);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.startscreen_textbiggestes);
        buttonBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.buttonsmall);

        Point size = new Point();
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        display.getSize(size);
        width = size.x;
        height=size.y;


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

                      if(e.getX()>buttonsCoordMas[0][0]&&e.getX()<buttonsCoordMas[0][0]+buttonBitmap.getWidth()&&
                              e.getY()>buttonsCoordMas[0][1]&&e.getY()<buttonsCoordMas[0][1]+buttonBitmap.getHeight()){
                          Intent intent = new Intent(context, LevelView.class);
                          startActivity(intent);
                      }
                    if(e.getX()>buttonsCoordMas[1][0]&&e.getX()<buttonsCoordMas[1][0]+buttonBitmap.getWidth()&&
                            e.getY()>buttonsCoordMas[1][1]&&e.getY()<buttonsCoordMas[1][1]+buttonBitmap.getHeight()){
                        Intent intent = new Intent(context, LevelView.class);
                        startActivity(intent);
                    }
                    if(e.getX()>buttonsCoordMas[2][0]&&e.getX()<buttonsCoordMas[2][0]+buttonBitmap.getWidth()&&
                            e.getY()>buttonsCoordMas[2][1]&&e.getY()<buttonsCoordMas[2][1]+buttonBitmap.getHeight()){
                        Intent intent = new Intent(context, LevelView.class);
                        startActivity(intent);
                    }

                }

                return false;
            }
        });
    }



    @Override
    public void onDraw(Canvas canvas) {
        if(screenNumber==0) {
            canvas.drawBitmap(bitmap, null, rectf, rgb);
            canvas.drawText("Нажмите на экран, чтобы начать", width * 5 / 13, height * 18 / 19, rgb);
        }else{
            canvas.drawBitmap(bitmap, null, rectf, rgb);
            buttonsCoordMas[0][0] =width/2-buttonBitmap.getWidth()/2;
            buttonsCoordMas[0][1] =height/3;
            canvas.drawBitmap(buttonBitmap,buttonsCoordMas[0][0],buttonsCoordMas[0][1],null);
            canvas.drawText("Новая игра",width/3, buttonsCoordMas[0][1]+buttonBitmap.getHeight()/2, rgb);

            buttonsCoordMas[1][0] =width/2-buttonBitmap.getWidth()/2;
            buttonsCoordMas[1][1] = buttonsCoordMas[0][1]+buttonBitmap.getHeight();
            canvas.drawBitmap(buttonBitmap,buttonsCoordMas[1][0],buttonsCoordMas[1][1],null);
            canvas.drawText("Продолжить", width/3, buttonsCoordMas[1][1]+buttonBitmap.getHeight()/2, rgb);

            buttonsCoordMas[2][0] =width/2-buttonBitmap.getWidth()/2;
            buttonsCoordMas[2][1] =buttonsCoordMas[1][1]+buttonBitmap.getHeight();
            canvas.drawBitmap(buttonBitmap,buttonsCoordMas[2][0],buttonsCoordMas[2][1],null);
            canvas.drawText("Опции",width/3,buttonsCoordMas[2][1]+buttonBitmap.getHeight()/2,rgb);
        }
    }
    }

}






