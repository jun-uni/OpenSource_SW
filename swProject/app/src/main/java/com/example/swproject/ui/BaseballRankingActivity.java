package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.swproject.R;
import com.example.swproject.data.BaseballData;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BaseballRankingActivity extends baseballActivity {

    private TextView team_ranking_;
    private TextView team_ranking_1;
    private TextView team_ranking_2;
    private TextView team_ranking_3;
    private TextView team_ranking_4;
    private TextView team_ranking_5;
    private TextView team_ranking_6;
    private TextView team_ranking_7;
    private TextView team_ranking_8;
    private TextView team_ranking_9;

    private TextView pitcher_ranking_;
    private TextView pitcher_ranking_1;
    private TextView pitcher_ranking_2;
    private TextView pitcher_ranking_3;
    private TextView pitcher_ranking_4;
    private TextView pitcher_ranking_5;
    private TextView pitcher_ranking_6;
    private TextView pitcher_ranking_7;
    private TextView pitcher_ranking_8;
    private TextView pitcher_ranking_9;

    private TextView batter_ranking_;
    private TextView batter_ranking_1;
    private TextView batter_ranking_2;
    private TextView batter_ranking_3;
    private TextView batter_ranking_4;
    private TextView batter_ranking_5;
    private TextView batter_ranking_6;
    private TextView batter_ranking_7;
    private TextView batter_ranking_8;
    private TextView batter_ranking_9;


    private TextView detailed_ranking_;

    private final String pitcher_ranking_url_ = "https://sports.news.naver.com/kbaseball/record/index?category=kbo";
    private final String batter_ranking_url_ = "https://sports.news.naver.com/kbaseball/record/index?category=kbo&year=2022&type=batter&playerOrder=hra";


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_ranking);

        /* home 아이콘 눌렀을 때 메인화면 */
        ImageButton imageButton = (ImageButton) findViewById(R.id.homeicon);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        team_ranking_ = findViewById(R.id.text_baseball_team);
        team_ranking_1 = findViewById(R.id.text_baseball_team2);
        team_ranking_2 = findViewById(R.id.text_baseball_team3);
        team_ranking_3 = findViewById(R.id.text_baseball_team4);
        team_ranking_4 = findViewById(R.id.text_baseball_team5);
        team_ranking_5 = findViewById(R.id.text_baseball_team6);
        team_ranking_6 = findViewById(R.id.text_baseball_team7);
        team_ranking_7 = findViewById(R.id.text_baseball_team8);
        team_ranking_8 = findViewById(R.id.text_baseball_team9);
        team_ranking_9 = findViewById(R.id.text_baseball_team10);

        pitcher_ranking_ = findViewById(R.id.text_baseball_pitcher);
        pitcher_ranking_1 = findViewById(R.id.text_baseball_pitcher2);
        pitcher_ranking_2 = findViewById(R.id.text_baseball_pitcher3);
        pitcher_ranking_3 = findViewById(R.id.text_baseball_pitcher4);
        pitcher_ranking_4 = findViewById(R.id.text_baseball_pitcher5);
        pitcher_ranking_5 = findViewById(R.id.text_baseball_pitcher6);
        pitcher_ranking_6 = findViewById(R.id.text_baseball_pitcher7);
        pitcher_ranking_7 = findViewById(R.id.text_baseball_pitcher8);
        pitcher_ranking_8 = findViewById(R.id.text_baseball_pitcher9);
        pitcher_ranking_9 = findViewById(R.id.text_baseball_pitcher10);


        batter_ranking_ = findViewById(R.id.text_baseball_batter);
        batter_ranking_1 = findViewById(R.id.text_baseball_batter2);
        batter_ranking_2 = findViewById(R.id.text_baseball_batter3);
        batter_ranking_3 = findViewById(R.id.text_baseball_batter4);
        batter_ranking_4 = findViewById(R.id.text_baseball_batter5);
        batter_ranking_5 = findViewById(R.id.text_baseball_batter6);
        batter_ranking_6 = findViewById(R.id.text_baseball_batter7);
        batter_ranking_7 = findViewById(R.id.text_baseball_batter8);
        batter_ranking_8 = findViewById(R.id.text_baseball_batter9);
        batter_ranking_9 = findViewById(R.id.text_baseball_batter10);






        new BaseballRankingActivity.GetTeamData().execute(pitcher_ranking_url_);
        new BaseballRankingActivity.GetPitcherData().execute(pitcher_ranking_url_);
        new BaseballRankingActivity.GetBatterData().execute(batter_ranking_url_);
    }

    @SuppressLint("StaticFieldLeak")
    private class GetTeamData extends AsyncTask<String, Void, BaseballData.Team[]> {
        /*
        팀 순위 가져오기
         */
        protected BaseballData.Team[] doInBackground(String... params) {
            try {
                Document doc;

                doc = Jsoup.connect(pitcher_ranking_url_).get();
                Elements data = doc.select("#content .tb_kbo script");
                return MyParser.ParseBaseballTeamRanking(data.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.Team[] data) {
            /*
            데이터 표시 예시

            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            team_ranking_.setText(data[0].GetName() + " " + data[0].GetGame() + "경기 " + data[0].GetWon() + "승 " + data[0].GetLost() + "패 " + data[0].GetDrawn() + "무" + " 승률 " + data[0].GetWinRate() + " 게임차 " + data[0].GetWinDiff() + " 최근 10경기 " + data[0].GetLastResult());
            team_ranking_1.setText(data[1].GetName() + " " + data[1].GetGame() + "경기 " + data[1].GetWon() + "승 " + data[1].GetLost() + "패 " + data[1].GetDrawn() + "무" + " 승률 " + data[1].GetWinRate() + " 게임차 " + data[1].GetWinDiff() + " 최근 10경기 " + data[1].GetLastResult());
            team_ranking_2.setText(data[2].GetName() + " " + data[2].GetGame() + "경기 " + data[2].GetWon() + "승 " + data[2].GetLost() + "패 " + data[2].GetDrawn() + "무" + " 승률 " + data[2].GetWinRate() + " 게임차 " + data[2].GetWinDiff() + " 최근 10경기 " + data[2].GetLastResult());
            team_ranking_3.setText(data[3].GetName() + " " + data[3].GetGame() + "경기 " + data[3].GetWon() + "승 " + data[3].GetLost() + "패 " + data[3].GetDrawn() + "무" + " 승률 " + data[3].GetWinRate() + " 게임차 " + data[3].GetWinDiff() + " 최근 10경기 " + data[3].GetLastResult());
            team_ranking_4.setText(data[4].GetName() + " " + data[4].GetGame() + "경기 " + data[4].GetWon() + "승 " + data[4].GetLost() + "패 " + data[4].GetDrawn() + "무" + " 승률 " + data[4].GetWinRate() + " 게임차 " + data[4].GetWinDiff() + " 최근 10경기 " + data[4].GetLastResult());
            team_ranking_5.setText(data[5].GetName() + " " + data[5].GetGame() + "경기 " + data[5].GetWon() + "승 " + data[5].GetLost() + "패 " + data[5].GetDrawn() + "무" + " 승률 " + data[5].GetWinRate() + " 게임차 " + data[5].GetWinDiff() + " 최근 10경기 " + data[5].GetLastResult());
            team_ranking_6.setText(data[6].GetName() + " " + data[6].GetGame() + "경기 " + data[6].GetWon() + "승 " + data[6].GetLost() + "패 " + data[6].GetDrawn() + "무" + " 승률 " + data[6].GetWinRate() + " 게임차 " + data[6].GetWinDiff() + " 최근 10경기 " + data[6].GetLastResult());
            team_ranking_7.setText(data[7].GetName() + " " + data[7].GetGame() + "경기 " + data[7].GetWon() + "승 " + data[7].GetLost() + "패 " + data[7].GetDrawn() + "무" + " 승률 " + data[7].GetWinRate() + " 게임차 " + data[7].GetWinDiff() + " 최근 10경기 " + data[7].GetLastResult());
            team_ranking_8.setText(data[8].GetName() + " " + data[8].GetGame() + "경기 " + data[8].GetWon() + "승 " + data[8].GetLost() + "패 " + data[8].GetDrawn() + "무" + " 승률 " + data[8].GetWinRate() + " 게임차 " + data[8].GetWinDiff() + " 최근 10경기 " + data[8].GetLastResult());
            team_ranking_9.setText(data[9].GetName() + " " + data[9].GetGame() + "경기 " + data[9].GetWon() + "승 " + data[9].GetLost() + "패 " + data[9].GetDrawn() + "무" + " 승률 " + data[9].GetWinRate() + " 게임차 " + data[9].GetWinDiff() + " 최근 10경기 " + data[9].GetLastResult());

            //더 많은 정보는 BaseballData Team 클래스 참고
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetPitcherData extends AsyncTask<String, Void, BaseballData.Pitcher[]> {
        /*
        투수 평균 자책점 순위 가져오기
         */
        protected BaseballData.Pitcher[] doInBackground(String... params) {
            try {
                Document doc;

                doc = Jsoup.connect(pitcher_ranking_url_).get();
                Elements data = doc.select("#content .tb_kbo script");
                return MyParser.ParseBaseballPitcherRanking(data.last().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.Pitcher[] data) {

            pitcher_ranking_.setText(data[0].GetName() + " " + data[0].GetTeam()+ " 평균자책점:" + data[0].GetEarnedRunAverage()+" "+data[0].GetGame()+"경기 "+data[0].GetWon()+" 승 "+data[0].GetLost()+" 패" );
            pitcher_ranking_1.setText(data[1].GetName() + " " + data[1].GetTeam()+ " 평균자책점:" + data[1].GetEarnedRunAverage()+" "+data[1].GetGame()+"경기 "+data[1].GetWon()+" 승 "+data[1].GetLost()+" 패" );
            pitcher_ranking_2.setText(data[2].GetName() + " " + data[2].GetTeam()+ " 평균자책점:" + data[2].GetEarnedRunAverage()+" "+data[2].GetGame()+"경기 "+data[2].GetWon()+" 승 "+data[2].GetLost()+" 패" );
            pitcher_ranking_3.setText(data[3].GetName() + " " + data[3].GetTeam()+ " 평균자책점:" + data[3].GetEarnedRunAverage()+" "+data[3].GetGame()+"경기 "+data[3].GetWon()+" 승 "+data[3].GetLost()+" 패" );
            pitcher_ranking_4.setText(data[4].GetName() + " " + data[4].GetTeam()+ " 평균자책점:" + data[4].GetEarnedRunAverage()+" "+data[4].GetGame()+"경기 "+data[4].GetWon()+" 승 "+data[4].GetLost()+" 패" );
            pitcher_ranking_5.setText(data[5].GetName() + " " + data[5].GetTeam()+ " 평균자책점:" + data[5].GetEarnedRunAverage()+" "+data[5].GetGame()+"경기 "+data[5].GetWon()+" 승 "+data[5].GetLost()+" 패" );
            pitcher_ranking_6.setText(data[6].GetName() + " " + data[6].GetTeam()+ " 평균자책점:" + data[6].GetEarnedRunAverage()+" "+data[6].GetGame()+"경기 "+data[6].GetWon()+" 승 "+data[6].GetLost()+" 패" );
            pitcher_ranking_7.setText(data[7].GetName() + " " + data[7].GetTeam()+ " 평균자책점:" + data[7].GetEarnedRunAverage()+" "+data[7].GetGame()+"경기 "+data[7].GetWon()+" 승 "+data[7].GetLost()+" 패" );
            pitcher_ranking_8.setText(data[8].GetName() + " " + data[8].GetTeam()+ " 평균자책점:" + data[8].GetEarnedRunAverage()+" "+data[8].GetGame()+"경기 "+data[8].GetWon()+" 승 "+data[8].GetLost()+" 패" );
            pitcher_ranking_9.setText(data[9].GetName() + " " + data[9].GetTeam()+ " 평균자책점:" + data[9].GetEarnedRunAverage()+" "+data[9].GetGame()+"경기 "+data[9].GetWon()+" 승 "+data[9].GetLost()+" 패" );

            //더 많은 정보는 BaseballData Pitcher 클래스 참고
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetBatterData extends AsyncTask<String, Void, BaseballData.Batter[]> {
        /*
        타자 순위 가져오기
         */
        protected BaseballData.Batter[] doInBackground(String... params) {
            try {
                Document doc;

                doc = Jsoup.connect(batter_ranking_url_).get();
                Elements data = doc.select("#content .tb_kbo script");
                return MyParser.ParseBaseballBatterRanking(data.last().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.Batter[] data) {
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            batter_ranking_.setText(data[0].GetName() + " " + data[0].GetTeam()+" 타율: "+data[0].GetHitRate()+" "+data[0].GetGame()+"경기 "+data[0].GetAtBat()+"타수 "+data[0].GetHit()+"안타 "+data[0].GetHomeRun()+"홈런 "+data[0].GetRunBattedIn()+"타점");
            batter_ranking_1.setText(data[1].GetName() + " " + data[1].GetTeam()+" 타율: "+data[1].GetHitRate()+" "+data[1].GetGame()+"경기 "+data[1].GetAtBat()+"타수 "+data[1].GetHit()+"안타 "+data[1].GetHomeRun()+"홈런 "+data[1].GetRunBattedIn()+"타점");
            batter_ranking_2.setText(data[2].GetName() + " " + data[2].GetTeam()+" 타율: "+data[2].GetHitRate()+" "+data[2].GetGame()+"경기 "+data[2].GetAtBat()+"타수 "+data[2].GetHit()+"안타 "+data[2].GetHomeRun()+"홈런 "+data[2].GetRunBattedIn()+"타점");
            batter_ranking_3.setText(data[3].GetName() + " " + data[3].GetTeam()+" 타율: "+data[3].GetHitRate()+" "+data[3].GetGame()+"경기 "+data[3].GetAtBat()+"타수 "+data[3].GetHit()+"안타 "+data[3].GetHomeRun()+"홈런 "+data[3].GetRunBattedIn()+"타점");
            batter_ranking_4.setText(data[4].GetName() + " " + data[4].GetTeam()+" 타율: "+data[4].GetHitRate()+" "+data[4].GetGame()+"경기 "+data[4].GetAtBat()+"타수 "+data[4].GetHit()+"안타 "+data[4].GetHomeRun()+"홈런 "+data[4].GetRunBattedIn()+"타점");
            batter_ranking_5.setText(data[5].GetName() + " " + data[5].GetTeam()+" 타율: "+data[5].GetHitRate()+" "+data[5].GetGame()+"경기 "+data[5].GetAtBat()+"타수 "+data[5].GetHit()+"안타"+data[5].GetHomeRun()+"홈런 "+data[5].GetRunBattedIn()+"타점");
            batter_ranking_6.setText(data[6].GetName() + " " + data[6].GetTeam()+" 타율: "+data[6].GetHitRate()+" "+data[6].GetGame()+"경기 "+data[6].GetAtBat()+"타수 "+data[6].GetHit()+"안타 "+data[6].GetHomeRun()+"홈런 "+data[6].GetRunBattedIn()+"타점");
            batter_ranking_7.setText(data[7].GetName() + " " + data[7].GetTeam()+" 타율: "+data[7].GetHitRate()+" "+data[7].GetGame()+"경기 "+data[7].GetAtBat()+"타수 "+data[7].GetHit()+"안타 "+data[7].GetHomeRun()+"홈런 "+data[7].GetRunBattedIn()+"타점");
            batter_ranking_8.setText(data[8].GetName() + " " + data[8].GetTeam()+" 타율: "+data[8].GetHitRate()+" "+data[8].GetGame()+"경기 "+data[8].GetAtBat()+"타수 "+data[8].GetHit()+"안타 "+data[8].GetHomeRun()+"홈런 "+data[8].GetRunBattedIn()+"타점");
            batter_ranking_9.setText(data[9].GetName() + " " + data[9].GetTeam()+" 타율: "+data[9].GetHitRate()+" "+data[9].GetGame()+"경기 "+data[9].GetAtBat()+"타수 "+data[9].GetHit()+"안타 "+data[9].GetHomeRun()+"홈런 "+data[9].GetRunBattedIn()+"타점");

        }
    }
}

