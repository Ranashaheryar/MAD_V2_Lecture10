package com.rsk.mad_v2_lecture10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    final int SPLASH_TIMEOUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentLogin=new Intent(MainActivity.this,com.rsk.mad_v2_lecture10.Login.class);
                startActivity(intentLogin);


            }
        },SPLASH_TIMEOUT);


    }


}