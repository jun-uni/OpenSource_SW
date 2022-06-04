package com.example.swproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.swproject.R;

public class MainActivity extends AppCompatActivity {

    ImageButton imgBtn;
    Button btnS, btnB;
    Button btnPs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnS = (Button) findViewById(R.id.btnSoccer);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), soccerActivity.class);
                startActivity(intent);
            }
        });

        Button btnB = (Button) findViewById(R.id.btnBaseball);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), baseballActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imgBtn = (ImageButton) findViewById(R.id.btnSetting);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}