package com.example.swproject.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.swproject.R;
import com.example.swproject.fragment.fragment_player_baseball;
import com.example.swproject.fragment.fragment_player_recode_baseball;
import com.example.swproject.fragment.fragment_team_baseball;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseballNewsActivity extends baseballActivity{

    fragment_team_baseball teamFragmentB;
    fragment_player_baseball playerFragmentB;
    fragment_player_recode_baseball playerRecodeFragmentB;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_news);

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

        /* fragment 화면 전환 */
        teamFragmentB = new fragment_team_baseball();
        playerFragmentB = new fragment_player_baseball();
        playerRecodeFragmentB = new fragment_player_recode_baseball();

        /* 초기 화면 */
        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragmentB).commit();

        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.baseballTeam:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragmentB).commit();
                        return true;
                    case R.id.baseballPlayer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerFragmentB).commit();
                        return true;
                    case R.id.PlayerRecodeB:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerRecodeFragmentB).commit();
                        return true;
                }
                return false;
            }
        });
        /* fragment 화면 전환 */



    }
}