package com.example.swproject.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.swproject.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        /* home 아이콘 눌렀을 때 메인화면 */
        ImageButton imageButton = (ImageButton) findViewById(R.id.homeicon);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        /* home 아이콘 눌렀을 때 메인화면 */


        ImageButton imgstarS = (ImageButton) findViewById(R.id.soccerstaricon);
        imgstarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SoccerStarActivity.class);
                startActivity(intent);
            }
        });


        ImageButton imgstarB = (ImageButton) findViewById(R.id.baseballstaricon);
        imgstarB.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BaseballStarActivity.class);
                startActivity(intent);
            }
        });
    }
}
