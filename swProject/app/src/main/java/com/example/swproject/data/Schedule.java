package com.example.swproject.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.ZonedDateTime;
import java.util.Date;

public class Schedule {
    private ZonedDateTime date_;             //경기 날짜, 시간
    private Team left_;
    private Team right_;
    private boolean is_playing_;
    private String stadium_;                 //경기장
    private String broadcast_;               //방송사
    private boolean is_canceled_;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Schedule(){
       date_ = ZonedDateTime.now();
       left_ = new Team();
       right_ = new Team();
       is_playing_ = false;
       stadium_ = "";
       broadcast_ = "";
       is_canceled_ = false;
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

    public void SetIsPlaying(boolean is_playing) { this.is_playing_ = is_playing; }

    public void SetIsCanceled(boolean is_canceled_) { this.is_canceled_ = is_canceled_; }

    public void SetStadium(String stadium) { this.stadium_ = stadium; }

    public void SetBroadcast(String broadcast) { this.broadcast_ = broadcast; }

    public Team GetTeamLeft() { return this.left_; }

    public Team GetTeamRight() { return this.right_; }

    public ZonedDateTime GetDate() { return this.date_; }

    public boolean GetIsPlaying() { return this.is_playing_; }

    public boolean GetIsCanceled() { return this.is_canceled_; }

    public String GetStadium() { return this.stadium_; }

    public String GetBroadcast() { return this.broadcast_; }
}
