package com.example.swproject.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.swproject.R;
import com.example.swproject.fragment_player_baseball;
import com.example.swproject.fragment_player_recode_baseball;
import com.example.swproject.fragment_team_baseball;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseballNewsActivity extends baseballActivity{

    fragment_team_baseball teamFragmentB;
    fragment_player_baseball playerFragmentB;
    fragment_player_recode_baseball playerRecodeFragmentB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_news);

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
    }
}