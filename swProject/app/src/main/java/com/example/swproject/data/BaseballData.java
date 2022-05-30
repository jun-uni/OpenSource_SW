package com.example.swproject.data;

public class BaseballData {
    /*
   야구 팀
    */
    public static class Team{
        private String name_;               //팀 이름
        private String team_code_;          //팀 코드
        private int game_;                  //경기 횟수
        private String win_rate_;           //승률
        private String win_diff_;           //게임차
        private int rank_;                  //순위
        private int won_;                   //승리
        private int drawn_;                 //무승부
        private int lost_;                  //패배
        private String streak_;             //연속 승리/패배
        private String on_base_percentage_; //출루율
        private String slugging_percentage_;//장타율
        private String last_result_;        //최근 10경기 기록

        public Team(){
            name_ = "";
            team_code_ = "";
            game_ = 0;
            win_rate_ = "";
            win_diff_ = "";
            rank_ = 0;
            won_ = 0;
            drawn_ = 0;
            lost_ = 0;
            streak_ = "";
            on_base_percentage_ = "";
            slugging_percentage_ = "";
            last_result_ = "";
        }

        public void SetName(String name) { this.name_ = name; }

        public void SetTeamCode(String team_code) { this.team_code_ = team_code; }

        public void SetGame(int game) { this.game_ = game; }

        public void SetWinRate(String win_rate) { this.win_rate_ = win_rate; }

        public void SetWinDiff(String win_diff) { this.win_diff_ = win_diff; }

        public void SetRank(int rank) { this.rank_ = rank; }

        public void SetWon(int won) { this.won_ = won; }

        public void SetLost(int lost) { this.lost_ = lost; }

        public void SetDrawn(int drawn) { this.drawn_ = drawn; }

        public void SetStreak(String streak) { this.streak_ = streak; }

        public void SetOnBasePercentage(String on_base_percentage) { this.on_base_percentage_ = on_base_percentage; }

        public void SetSluggingPercentage(String slugging_percentage) { this.slugging_percentage_ = slugging_percentage; }

        public void SetLastResult(String last_result) { this.last_result_ = last_result; }

        public String GetName() { return this.name_; }

        public String GetTeamCode() { return this.team_code_; }

        public int GetGame() { return this.game_; }

        public String GetWinRate() { return this.win_rate_; }

        public String GetWinDiff() { return this.win_diff_; }

        public int GetRank() { return this.rank_; }

        public int GetWon() { return this.won_; }

        public int GetLost() { return this.lost_; }

        public int GetDrawn() { return this.drawn_; }

        public String GetStreak() { return this.streak_; }

        public String GetOnBasePercentage() { return this.on_base_percentage_; }

        public String GetSluggingPercentage() {return this.slugging_percentage_; }

        public String GetLastResult() { return this.last_result_; }
    }

    /*
    야구 선수
     */

    public static class Pitcher{
        /*
        투수
         */
        private String team_;                               //소속팀
        private String name_;                               //이름
        private String strike_out_per_plate_appearances_;    //타석 당 삼진 비율 "K%" 로 표시
        private String strike_out_per_base_on_balls_;        //볼넷 당 삼진 비율 "K/BB" 로 표시
        private int dead_ball_;                             //사구 hp
        private int home_run_;                              //피홈런
        private int hit_;                                   //피안타
        private int hold_;                                  //홀드
        private String whip_;                               //WHIP
        private String strike_out_per_nine_innings_;         //9이닝 당 삼진 수 "K/9"로 표시
        private String earned_run_average_;                 //평균자책점 era
        private int rank_;                                  //평균 자책 순위
        private int strike_out_;                             //탈삼진
        private int save_;                                  //세이브
        private String win_rate_;                           //승률
        private String innings_;                            //이닝
        private String base_on_balls_per_nine_innings_;     //9이닝 당 볼넷 수 "BB/9"로 표시
        private String war_;                                //WAR
        private String wpa_;                                //WPA
        private int lost_;                                  //패
        private int won_;                                   //승
        private int game_;                                  //게임 수
        private int runs_;                                  //실점 r
        private String base_on_balls_per_plate_appearances_;//타석 당 볼넷 비율 "BB%"로 표시

        public Pitcher(){
            team_ = "";
            name_ = "";
            strike_out_per_plate_appearances_ = "";
            strike_out_per_base_on_balls_ = "";
            dead_ball_ = 0;
            home_run_ = 0;
            hit_ = 0;
            hold_ = 0;
            whip_ = "";
            strike_out_per_nine_innings_ = "";
            earned_run_average_ = "";
            rank_ = 0;
            strike_out_ = 0;
            save_ = 0;
            win_rate_ = "";
            innings_ = "";
            base_on_balls_per_nine_innings_ = "";
            war_ = "";
            wpa_ = "";
            lost_ = 0;
            won_ = 0;
            game_ = 0;
            runs_ = 0;
            base_on_balls_per_plate_appearances_ = "";
        }

        public void SetTeam(String team) { this.team_ = team; }

        public void SetName(String name) { this.name_ = name; }

        public void SetStrikeOutPerPlateAppearances(String strike_out_per_plate_appearances) { this.strike_out_per_plate_appearances_ = strike_out_per_plate_appearances; }

        public void SetStrikeOutPerBaseOnBalls(String strike_out_per_base_on_balls) { this.strike_out_per_base_on_balls_ = strike_out_per_base_on_balls; }

        public void SetDeadBall(int dead_ball) { this.dead_ball_ = dead_ball; }

        public void SetHomeRun(int home_run) { this.home_run_ = home_run; }

        public void SetHit(int hit) { this.hit_ = hit; }

        public void SetHold(int hold) { this.hold_ = hold; }

        public void SetWhip(String whip) { this.whip_ = whip; }

        public void SetStrikeOutPerNineInnings( String strike_out_per_nine_innings) { this.strike_out_per_nine_innings_ = strike_out_per_nine_innings; }

        public void SetEarnedRunAverage(String earned_run_average) { this.earned_run_average_ = earned_run_average; }

        public void SetRank(int rank) { this.rank_ = rank; }

        public void SetStrikeOut( int strike_out) { this.strike_out_ = strike_out; }

        public void SetSave(int save) { this.save_ = save; }

        public void SetWinRate(String win_rate) { this.win_rate_ = win_rate; }

        public void SetInnings(String innings) { this.innings_ = innings; }

        public void SetBaseOnBallsPerNineInnings(String base_on_balls_per_nine_innings) { this.base_on_balls_per_nine_innings_ = base_on_balls_per_nine_innings; }

        public void SetWar(String war) { this.war_ = war; }

        public void SetWpa(String wpa) { this.wpa_ = wpa; }

        public void SetLost(int lost) { this.lost_ = lost; }

        public void SetWon(int won) { this.won_ = won; }

        public void SetGame(int game) { this.game_ = game; }

        public void SetRuns(int runs) { this.runs_ = runs; }

        public void SetBaseOnBallsPerPlateAppearances(String base_on_balls_per_plate_appearances_) { this.base_on_balls_per_plate_appearances_ = base_on_balls_per_plate_appearances_; }

        public String GetTeam() { return this.team_; }

        public String GetName() { return this.name_; }

        public String GetBaseOnBallsPerNineInnings() {
            return this.base_on_balls_per_nine_innings_;
        }

        public String GetBaseOnBallsPerPlateAppearances() {
            return this.base_on_balls_per_plate_appearances_;
        }

        public String GetInnings() {
            return this.innings_;
        }

        public String GetEarnedRunAverage() {
            return this.earned_run_average_;
        }

        public String GetWar() {
            return this.war_;
        }

        public String GetWinRate() {
            return this.win_rate_;
        }

        public String GetWhip() {
            return this.whip_;
        }

        public String GetStrikeOutPerBaseOnBalls() {
            return this.strike_out_per_base_on_balls_;
        }

        public String GetStrikeOutPerNineInnings() {
            return this.strike_out_per_nine_innings_;
        }

        public String GetStrikeOutPerPlateAppearances() {
            return strike_out_per_plate_appearances_;
        }

        public String GetWpa() {
            return this.wpa_;
        }

        public int GetGame() {
            return this.game_;
        }

        public int GetRank() {
            return this.rank_;
        }

        public int GetDeadBall() {
            return this.dead_ball_;
        }

        public int GetHit() {
            return this.hit_;
        }

        public int GetHold() {
            return this.hold_;
        }

        public int GetHomeRun() {
            return this.home_run_;
        }

        public int GetLost() {
            return this.lost_;
        }

        public int GetRuns() {
            return this.runs_;
        }

        public int GetSave() {
            return this.save_;
        }

        public int GetStrikeOut() {
            return this.strike_out_;
        }

        public int GetWon() {
            return this.won_;
        }
    }

    public static class Batter{
        /*
        타자
         */
        private String team_;                               //소속팀
        private String name_;                               //이름
        private String wrc_plus_;                           //wRC+
        private int home_run_;                              //홈런
        private int run_;                                   //득점
        private int hit_2_;                                 //2루타 h2
        private int hit_3_;                                 //3루타 h3
        private int stolen_base_;                           //도루 sb
        private int hit_;                                   //안타
        private String hit_rate_;                           //타율 hra
        private int rank_;                                  //타율 순위
        private int strike_out_;                            //삼진
        private String woba_;                               //wOBA
        private int at_bat_;                             //타수
        private String wpa_;                                //WPA
        private String war_;                                //WAR
        private String slugging_percentage_;                //장타율 slg
        private int game_;                                  //게임 수
        private String ops_;                                //OPS
        private int run_batted_in_;                      //타점 rbi
        private String babip_;                              //BABIP
        private String isop_;                               //IsoP
        private String on_base_percentage_;                 //출루율 obp

        public Batter(){
            team_ = "";
            name_ = "";
            wrc_plus_ = "";
            home_run_ = 0;
            run_ = 0;
            hit_ = 0;
            hit_2_ = 0;
            hit_3_ = 0;
            stolen_base_ = 0;
            hit_rate_ = "";
            rank_  = 0;
            woba_ = "";
            strike_out_ = 0;
            at_bat_ = 0;
            wpa_ = "";
            war_ = "";
            slugging_percentage_ = "";
            game_ = 0;
            ops_ = "";
            run_batted_in_ = 0;
            babip_ = "";
            isop_ = "";
            on_base_percentage_ = "";
        }

        public void SetTeam(String team) { this.team_ = team; }

        public void SetName(String name) { this.name_ = name; }

        public void SetWrcPlus(String wrc_plus){ this.wrc_plus_ = wrc_plus; }

        public void SetHomeRun(int home_run){ this.home_run_ = home_run; }

        public void SetRun(int run){ this.run_ = run;}

        public void SetHit(int hit){ this.hit_ = hit;}

        public void SetHit2(int hit_2){ this.hit_2_ = hit_2; }

        public void SetHit3(int hit_3){ this.hit_3_ = hit_3; }

        public void SetStolenBase(int stolen_base) { this.stolen_base_ = stolen_base; }

        public void SetHitRate(String hit_rate) { this.hit_rate_ = hit_rate; }

        public void SetRank(int rank){ this.rank_ = rank;}

        public void SetWoba(String woba) { this.woba_ = woba;}

        public void SetStrikeOut(int strike_out) { this.strike_out_ = strike_out; }

        public void SetAtBat(int at_bat) { this.at_bat_ = at_bat; }

        public void SetWpa(String wpa) { this.wpa_ = wpa; }

        public void SetWar(String war) { this.war_ = war;}

        public void SetSluggingPercentage(String slugging_percentage) { this.slugging_percentage_ = slugging_percentage; }

        public void SetGame(int game) { this.game_ = game; }

        public void SetOps(String ops) { this.ops_ = ops; }

        public void SetRunBattedIn(int run_batted_in_) { this.run_batted_in_ = run_batted_in_; }

        public void SetBabip(String babip) { this.babip_ = babip; }

        public void SetIsop(String isop){ this.isop_ = isop;}

        public void SetOnBasePercentage(String on_base_percentage) { this.on_base_percentage_ = on_base_percentage; }

        public String GetName() { return this.name_; }

        public String GetTeam() { return this.team_; }

        public String GetWrcPlus() { return this.wrc_plus_; }

        public int GetHomeRun() { return this.home_run_; }

        public int GetRun() { return this.run_; }

        public int GetHit() { return this.hit_; }

        public int GetHit2() { return this.hit_2_; }

        public int GetHit3() { return this.hit_3_; }

        public int GetStolenBase() { return this.stolen_base_; }

        public String GetHitRate() { return this.hit_rate_; }

        public int GetRank() { return this.rank_; }

        public String GetWoba() { return this.woba_; }

        public int GetStrikeOut() { return this.strike_out_; }

        public int GetAtBat() { return this.at_bat_; }

        public String GetWpa() { return this.wpa_; }

        public String GetWar(){ return this.war_; }

        public String GetSluggingPercentage() { return this.slugging_percentage_; }

        public int GetGame() { return this.game_; }

        public String GetOps() { return this.ops_; }

        public int GetRunBattedIn() { return this.run_batted_in_; }

        public String GetBabip() { return this.babip_; }

        public String GetIsop() { return this.isop_; }

        public String GetOnBasePercentage() { return this.on_base_percentage_; }
    }

    public static class DetailedRanking{
        /*
        세부 부문 랭킹
         */
        private String name_;                       //부문 이름
        private Player players_[];                  //선수들

        public DetailedRanking(){
            name_ = "";
            players_ = new Player[5];
        }

        public static class Player{
            private String name_;                   //선수 이름
            private String team_;                   //팀
            private int rank_;                      //순위
            private String record_;                 //기록

            public Player(){
                name_ = "";
                team_ = "";
                rank_ = 0;
                record_ = "";
            }

            public void SetName(String name) { this.name_ = name; }

            public void SetTeam(String team) { this.team_ = team; }

            public void SetRank(int rank) { this.rank_ = rank; }

            public void SetRecord(String record) { this.record_ = record; }

            public String GetName() { return this.name_; }

            public String GetTeam() { return this.team_; }

            public int GetRank() { return this.rank_; }

            public String GetRecord() { return this.record_; }
        }

        public void SetName(String name) { this.name_ = name; }

        public void SetPlayers(Player[] players) { this.players_ = players; }

        public String GetName() { return this.name_; }

        public Player[] GetPlayers() { return this.players_; }
    }


    public static class LiveData{
        private SoccerData.LiveData.Team left_;
        private SoccerData.LiveData.Team right_;

        public LiveData(){
            left_ = new SoccerData.LiveData.Team();
            right_ = new SoccerData.LiveData.Team();
        }

        public static class Team{
            public Team(){

            }


        }

        public void SetTeamLeft(SoccerData.LiveData.Team left) { this.left_ = left; }

        public void SetTeamRight(SoccerData.LiveData.Team right) { this.right_ = right; }

        public SoccerData.LiveData.Team GetTeamLeft() { return this.left_; }

        public SoccerData.LiveData.Team GetTeamRight() { return this.right_; }
    }
}
