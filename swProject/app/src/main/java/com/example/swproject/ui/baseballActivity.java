package com.example.swproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import com.example.swproject.R;

public class baseballActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball);

        Button btnRb = findViewById(R.id.btnRankingB);
        btnRb.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BaseballRankingActivity.class);
            startActivity(intent);
        });

        Button btnSb = findViewById(R.id.btnScheduleB);
        btnSb.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BaseballScheduleActivity.class);
            startActivity(intent);
        });


    }
}
