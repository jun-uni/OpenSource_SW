package com.example.swproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.swproject.R;

public class soccerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer);


        Button btnNs = (Button) findViewById(R.id.btnNewsS);
        btnNs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SoccerNewsActivity.class);
                startActivity(intent);
            }
        });

        Button btnRs = (Button) findViewById(R.id.btnRankingS);
        btnRs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SoccerRankingActivity.class);
                startActivity(intent);
            }
        });

        Button btnSs = (Button) findViewById(R.id.btnScheduleS);
        btnSs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SoccerScheduleActivity.class);
                startActivity(intent);
            }
        });

        Button btnStars = (Button) findViewById(R.id.btnStarS);
        btnStars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SoccerStarActivity.class);
                startActivity(intent);
            }
        });


    }
}
