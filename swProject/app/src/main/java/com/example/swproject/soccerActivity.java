package com.example.swproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

public class soccerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer);

        Button btnRs = (Button) findViewById(R.id.btnRankingS);
        btnRs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), soccerRanking.class);
                startActivity(intent);
            }
        });

        Button btnPs = (Button) findViewById(R.id.btnPlayerS);
        btnPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),soccerPlayer.class);
                startActivity(intent);

            }
        });


    }
}
