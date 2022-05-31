package com.example.swproject.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.swproject.R;
import com.example.swproject.fragment_player_soccer;
import com.example.swproject.fragment_playerRecode_soccer;
import com.example.swproject.fragment_team_soccer;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SoccerNewsActivity extends soccerActivity{

    fragment_team_soccer teamFragment;
    fragment_player_soccer playerFragment;
    fragment_playerRecode_soccer playerRecodeFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_news);

        teamFragment = new fragment_team_soccer();
        playerFragment = new fragment_player_soccer();
        playerRecodeFragment = new fragment_playerRecode_soccer();

        /* 초기 화면 */
        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragment).commit();
        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.soccerTeam:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragment).commit();
                        return true;
                    case R.id.soccerPlayer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerFragment).commit();
                        return true;
                    case R.id.PlayerRecodeS:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerRecodeFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}