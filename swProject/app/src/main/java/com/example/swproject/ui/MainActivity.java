package com.example.swproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.swproject.R;

public class MainActivity extends AppCompatActivity {

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




    }
}