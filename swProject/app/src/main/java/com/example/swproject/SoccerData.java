package com.example.swproject;

public class SoccerData {
    /*
    축구 팀
     */
    static class Team{
        private String name_;               //팀 이름
        private int goal_;                  //골 횟수
        private int game_;                  //경기 횟수
        private String last_result_;        //최근 5경기 기록
        private int point_;                 //승점
        private int lose_goal_;             //골 실점 횟수
        private int rank_;                  //순위
        private int won_;                   //승리 횟수
        private int lost_;                  //패배 횟수
        private int drawn_;                 //무승부 횟수
        private int goal_gap_;              //득실차

        Team(){
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

        protected String GetName(){ return this.name_; }

        protected int GetGoal(){
            return this.goal_;
        }

        protected int GetGame(){
            return this.game_;
        }

        protected String GetLastResult(){
            return this.last_result_;
        }

        protected int GetPoint(){
            return this.point_;
        }

        protected int GetLoseGoal(){
            return this.lose_goal_;
        }

        protected int GetRank(){
            return this.rank_;
        }

        protected int GetWon(){
            return this.won_;
        }

        protected int GetLost(){
            return this.lost_;
        }

        protected int GetDrawn(){
            return this.drawn_;
        }

        protected int GetGoalGap(){
            return this.goal_gap_;
        }
    }

    /*
    축구 선수
     */

    static class Player{
        private int goal_;
        private int assist_;
        private int point_;
        private int shot_;
        private int foul_;
        private int booking_;
        private int dismissal_;
        private int corner_kick_;
        private int penalty_kick_;
        private int offside_;
        private int on_target_shot_;
        private int game_;

        Player(){
            goal_ = 0;
            assist_ = 0;
            point_ = 0;
            shot_ = 0;
            foul_ = 0;
            booking_ = 0;
            dismissal_ = 0;
            corner_kick_ = 0;
            penalty_kick_ = 0;
            offside_ =0;
            on_target_shot_ = 0;
            game_ = 0;
        }

        protected void SetGoal(int goal) {
            goal_ = goal;
        }

        protected void SetAssist(int assist){ this.assist_ = assist; }

        protected void SetPoint(int point){ this.point_ = point; }

        protected void SetShot(int shot){ this.shot_ = shot; }

        protected void SetFoul(int foul){ this.foul_ = foul; }

        protected void SetBooking(int booking){ this.booking_ = booking; }

        protected void SetDismissal(int dismissal){ this.dismissal_ = dismissal; }

        protected void SetCornerKick(int corner_kick){ this.corner_kick_ = corner_kick; }

        protected void SetPenaltyKick(int penalty_kick) { this.penalty_kick_ = penalty_kick; }

        protected void SetOffside(int offside){ this.offside_ = offside; }

        protected void SetOnTargetShot(int on_target_shot){ this.on_target_shot_ = on_target_shot; }

        protected void SetGame(int game){ this.game_ = game; }

        protected int GetGoal(){
            return this.goal_;
        }

        protected int GetAssist(){
            return this.assist_;
        }

        protected int GetPoint(){ return this.point_; }

        protected int GetShot(){ return this.shot_; }

        protected int GetFoul(){ return this.shot_; }

        protected int GetBooking(){ return this.booking_; }

        protected int GetDismissal(){ return this.dismissal_; }

        protected int GetCornerKick(){ return this.corner_kick_; }

        protected int GetPenaltyKick(){ return this.penalty_kick_; }

        protected int GetOffside(){ return this.offside_; }

        protected int GetOnTargetShot(){ return this.on_target_shot_; }

        protected int GetGame(){ return this.game_; }
    }


}

