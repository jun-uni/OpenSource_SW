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
}
