package com.example.swproject;

public class SoccerTeam {
    String name_;               //팀 이름
    int goal_;                  //골 횟수
    int game_;                  //경기 횟수
    String last_result_;        //최근 5경기 기록
    int point_;                 //승점
    int lose_goal_;             //골 실점 횟수
    int rank_;                  //순위
    int won_;                   //승리 횟수
    int lost_;                  //패배 횟수
    int drawn_;                 //무승부 횟수
    int goal_gap_;              //득실차

    SoccerTeam(){
        name_ = "";
        goal_ = 0;
        game_ = 0;
        last_result_ = "";
        point_ = 0;
        lose_goal_ = 0;
        rank_ = 0;
        won_ = 0;
        lost_ = 0;
        drawn_ = 0;
        goal_gap_ = 0;
    }

    protected void SetName(String name){this.name_ = name;}

    protected void SetGoal(int goal){
        this.goal_ = goal;
    }

    protected void SetGame(int game){
        this.game_ = game;
    }

    protected void SetLastResult(String last_result){
        this.last_result_ = last_result;
    }

    protected void SetPoint(int point){
        this.point_ = point;
    }

    protected void SetLoseGoal(int lose_goal){
        this.lose_goal_ = lose_goal;
    }

    protected void SetRank(int rank){
        this.rank_ = rank;
    }

    protected void SetWon(int won){
        this.won_ = won;
    }

    protected void SetLost(int lost){
        this.lost_ = lost;
    }

    protected void SetDrawn(int drawn){
        this.drawn_ = drawn;
    }

    protected void SetGoalGap(int goal_gap){
        this.goal_gap_ = goal_gap;
    }

    protected String GetName(){
        return name_;
    }

    protected int GetGoal(){
        return goal_;
    }

    protected int GetGame(){
        return game_;
    }

    protected String GetLastResult(){
        return last_result_;
    }

    protected int GetPoint(){
        return point_;
    }

    protected int GetLoseGoal(){
        return lose_goal_;
    }

    protected int GetRank(){
        return rank_;
    }

    protected int GetWon(){
        return won_;
    }

    protected int GetLost(){
        return lost_;
    }

    protected int GetDrawn(){
        return drawn_;
    }

    protected int GetGoalGap(){
        return goal_gap_;
    }
}
