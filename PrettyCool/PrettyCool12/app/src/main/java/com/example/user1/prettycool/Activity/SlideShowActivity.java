//package com.example.user1.prettycool.Activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Point;
//import android.graphics.RectF;
//import android.os.Bundle;
//import android.view.Display;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.HorizontalScrollView;
//import android.widget.LinearLayout;
//import android.widget.ScrollView;
//
//import com.example.user1.prettycool.Classes.Persons.GlobalInformation;
//import com.example.user1.prettycool.Classes.ViewClasses.SpriteById;
//import com.example.user1.prettycool.R;
///**
// * Created by user1 on 28.04.2016.
// */
//
//
//public class SlideShowActivity extends Activity {
//
//    LinearLayout linearLayout;
//    ScrollView scrollView;
//    HorizontalScrollView horizontalScrollView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        linearLayout= new LinearLayout(getApplicationContext());
//        linearLayout.addView(new MyView(this));
//        setContentView(linearLayout);
//    }
//
//
//    public class MyView extends View {
//        RectF rectf;
//        Paint rgb;
//        Bitmap bitmap,buttonBitmap;
//        Context context;
//        float width,height;
//        int screenNumber = 0;
//        GlobalInformation globalInformation;
//        SpriteById spriteById;
//
//
//        public MyView(Context context) {
//            super(context);
//            this.context = context;
//            rgb = new Paint();
//            rgb.setColor(Color.RED);
//            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.startscreen_textbiggestes);
//            buttonBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.buttonsmall);
//            Point size = new Point();
//            Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
//            display.getSize(size);
//            width = size.x;
//            height=size.y;
//            rectf = new RectF();
//            rectf.set(0, 0, size.x, size.y);
//            globalInformation = new GlobalInformation();
//            spriteById = new SpriteById(getApplicationContext());
//
//
//
//
//            setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent e) {
//
//                    invalidate();
//                    return false;
//                }
//            });
//        }
//
//
//
//        @Override
//        public void onDraw(Canvas canvas){
//
//        }
//    }
//
//}
//
//
//
//
//
//
