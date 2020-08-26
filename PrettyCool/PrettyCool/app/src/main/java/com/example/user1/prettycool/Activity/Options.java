package com.example.user1.prettycool.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.user1.prettycool.R;

public class Options extends Activity {

    Canvas canvas;
    Bitmap bitmap;
    LinearLayout linearLayout;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_options);

        button =(Button) findViewById(R.id.button2);
        editText =(EditText) findViewById(R.id.editText);


    }
}
