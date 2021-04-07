package com.rsk.mad_v2_lecture10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView tvWelcomeHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvWelcomeHome=findViewById(R.id.tvWelcomeHome);
        String text=tvWelcomeHome.getText().toString();

        Intent i=getIntent();
        tvWelcomeHome.setText(text+"\n"+i.getStringExtra("userEmail"));


    }
}