package com.example.swproject.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.ZonedDateTime;
import java.util.Date;

public class Schedule {
    private ZonedDateTime date_;             //경기 날짜, 시간
    private Team left_;
    private Team right_;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Schedule(){
       date_ = ZonedDateTime.now();
       left_ = new Team();
       right_ = new Team();
    }

    public static class Team{
        private String name_;       //팀 이름
        private int score_;         //점수

        Team(){
            name_ = "";
            score_ = 0;
        }

        public void SetName(String name){
            this.name_ = name;
        }

        public void SetScore(int score){
            this.score_ = score;
        }

        public String GetName(){ return name_; }

        public int GetScore(){ return score_; }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isYet(){
        Date today_ = new Date();
        return this.date_.isBefore(ZonedDateTime.now());
    }

    public void SetDate(ZonedDateTime date){
        this.date_ = date;
    }

    public void SetTeamLeft(Team team) { this.left_ = team; }

    public void SetTeamRight(Team team) { this.right_ = team; }

    public Team GetTeamLeft() { return this.left_; }

    public Team GetTeamRight() { return this.right_; }

    public ZonedDateTime GetDate() { return this.date_; }
}
