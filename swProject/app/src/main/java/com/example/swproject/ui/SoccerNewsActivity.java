package com.example.swproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.swproject.R;
import com.example.swproject.fragment.fragment_playerRecode_soccer;
import com.example.swproject.fragment.fragment_player_soccer;
import com.example.swproject.fragment.fragment_team_soccer;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SoccerNewsActivity extends soccerActivity{

    fragment_team_soccer teamFragmentS;
    fragment_player_soccer playerFragmentS;
    fragment_playerRecode_soccer playerRecodeFragmentS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_news);

        /* home 아이콘 눌렀을 때 메인화면 */
        ImageButton imageButton = (ImageButton) findViewById(R.id.homeicon);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        /* home 아이콘 눌렀을 때 메인화면 */


        /* fragment 화면 전환 */
        teamFragmentS = new fragment_team_soccer();
        playerFragmentS = new fragment_player_soccer();
        playerRecodeFragmentS = new fragment_playerRecode_soccer();

        /* 초기 화면 */
        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragmentS).commit();

        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.soccerTeam:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragmentS).commit();
                        return true;
                    case R.id.soccerPlayer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerFragmentS).commit();
                        return true;
                    case R.id.PlayerRecodeS:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerRecodeFragmentS).commit();
                        return true;
                }
                return false;
            }
        });
        /* fragment 화면 전환 */
    }
}