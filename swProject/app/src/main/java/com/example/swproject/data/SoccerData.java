package com.example.swproject.data;

public class SoccerData {
    /*
    축구 팀
     */
    public static class Team{
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

        public Team(){
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

        public void SetName(String name){this.name_ = name;}

        public void SetGoal(int goal){
            this.goal_ = goal;
        }

        public void SetGame(int game){
            this.game_ = game;
        }

        public void SetLastResult(String last_result){
            this.last_result_ = last_result;
        }

        public void SetPoint(int point){
            this.point_ = point;
        }

        public void SetLoseGoal(int lose_goal){
            this.lose_goal_ = lose_goal;
        }

        public void SetRank(int rank){
            this.rank_ = rank;
        }

        public void SetWon(int won){
            this.won_ = won;
        }

        public void SetLost(int lost){
            this.lost_ = lost;
        }

        public void SetDrawn(int drawn){
            this.drawn_ = drawn;
        }

        public void SetGoalGap(int goal_gap){
            this.goal_gap_ = goal_gap;
        }

        public String GetName(){ return this.name_; }

        public int GetGoal(){
            return this.goal_;
        }

        public int GetGame(){
            return this.game_;
        }

        public String GetLastResult(){
            return this.last_result_;
        }

        public int GetPoint(){
            return this.point_;
        }

        public int GetLoseGoal(){
            return this.lose_goal_;
        }

        public int GetRank(){
            return this.rank_;
        }

        public int GetWon(){
            return this.won_;
        }

        public int GetLost(){
            return this.lost_;
        }

        public int GetDrawn(){
            return this.drawn_;
        }

        public int GetGoalGap(){
            return this.goal_gap_;
        }
    }

    /*
    축구 선수
     */

    public static class Player{
        private String team_;       //소속팀
        private String name_;       //이름
        private int goal_;          //득점
        private int assist_;        //도움
        private int point_;         //공격포인트
        private int shot_;          //슈팅
        private int foul_;          //파울
        private int booking_;       //경고
        private int dismissal_;     //퇴장
        private int corner_kick_;   //코너킥
        private int penalty_kick_;  //페널티킥
        private int offside_;       //오프사이드
        private int on_target_shot_;//유효 슈팅
        private int game_;          //경기수
        private int rank_;          //득점 순위

        public Player(){
            team_ = "";
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
            rank_ = 0;
        }

        public void SetTeam(String team){
            this.team_ = team;
        }

        public void SetName(String name) { this.name_ = name; }

        public void SetGoal(int goal) {
            this.goal_ = goal;
        }

        public void SetAssist(int assist){ this.assist_ = assist; }

        public void SetPoint(int point){ this.point_ = point; }

        public void SetShot(int shot){ this.shot_ = shot; }

        public void SetFoul(int foul){ this.foul_ = foul; }

        public void SetBooking(int booking){ this.booking_ = booking; }

        public void SetDismissal(int dismissal){ this.dismissal_ = dismissal; }

        public void SetCornerKick(int corner_kick){ this.corner_kick_ = corner_kick; }

        public void SetPenaltyKick(int penalty_kick) { this.penalty_kick_ = penalty_kick; }

        public void SetOffside(int offside){ this.offside_ = offside; }

        public void SetOnTargetShot(int on_target_shot){ this.on_target_shot_ = on_target_shot; }

        public void SetGame(int game){ this.game_ = game; }

        public void SetRank(int rank){ this.rank_ = rank; }

        public String GetTeam() { return this.team_; }

        public String GetName() { return this.name_; }

        public int GetGoal(){
            return this.goal_;
        }

        public int GetAssist(){
            return this.assist_;
        }

        public int GetPoint(){ return this.point_; }

        public int GetShot(){ return this.shot_; }

        public int GetFoul(){ return this.foul_; }

        public int GetBooking(){ return this.booking_; }

        public int GetDismissal(){ return this.dismissal_; }

        public int GetCornerKick(){ return this.corner_kick_; }

        public int GetPenaltyKick(){ return this.penalty_kick_; }

        public int GetOffside(){ return this.offside_; }

        public int GetOnTargetShot(){ return this.on_target_shot_; }

        public int GetGame(){ return this.game_; }

        public int GetRank(){ return this.rank_; }
    }


}

