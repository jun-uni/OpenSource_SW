package com.example.swproject.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import com.example.swproject.R;

public class baseballActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball);

        Button btnSb = findViewById(R.id.btnScheduleB);
        btnSb.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BaseballScheduleActivity.class);
            startActivity(intent);
        });

        Button btnStarb = findViewById(R.id.btnStarB);
        btnStarb.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BaseballStarActivity.class);
            startActivity(intent);
        });


        Button btnNb = (Button) findViewById(R.id.btnNewsB);
        btnNb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BaseballNewsActivity.class);
                startActivity(intent);
            }
        });
    }
}
