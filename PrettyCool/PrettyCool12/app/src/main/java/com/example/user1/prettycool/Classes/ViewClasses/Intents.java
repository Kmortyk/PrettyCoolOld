package com.example.user1.prettycool.Classes.ViewClasses;

import android.app.Activity;
import android.content.Intent;

import com.example.user1.prettycool.Activity.StartScreen;

/**
 * Created by user1 on 07.04.2016.
 */
public class Intents extends Activity {
    Intent intent;

    Intents(){
        intent = new Intent(this,StartScreen.class);
        startActivity(intent);
    }
}
