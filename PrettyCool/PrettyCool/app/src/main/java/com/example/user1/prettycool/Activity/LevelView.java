package com.example.user1.prettycool.Activity;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.example.user1.prettycool.Classes.ViewClasses.MySurfaceView;
import com.example.user1.prettycool.Classes.ViewClasses.MyView;

public class LevelView extends Activity {

    Point size;
    Display display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        size = new Point();
        display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        display.getSize(size);
        setContentView(new MySurfaceView(this, size));
    }


    @Override
    protected void onPause() {
        super.onPause();
        MySurfaceView.geksThread.setRunning(false);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

