package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
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

public class BaseballRankingActivity extends baseballActivity{

    private TextView team_ranking_;
    private TextView pitcher_ranking_;
    private TextView batter_ranking_;
    private TextView detailed_ranking_;

    private final String pitcher_ranking_url_ = "https://sports.news.naver.com/kbaseball/record/index?category=kbo";
    private final String batter_ranking_url_ = "https://sports.news.naver.com/kbaseball/record/index?category=kbo&year=2022&type=batter&playerOrder=hra";


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_ranking);

        team_ranking_ = findViewById(R.id.text_baseball_team);
        pitcher_ranking_ = findViewById(R.id.text_baseball_pitcher);
        batter_ranking_ = findViewById(R.id.text_baseball_batter);
        detailed_ranking_ = findViewById(R.id.text_baseball_detailed);
        new BaseballRankingActivity.GetTeamData().execute(pitcher_ranking_url_);
        new BaseballRankingActivity.GetPitcherData().execute(pitcher_ranking_url_);
        new BaseballRankingActivity.GetBatterData().execute(batter_ranking_url_);
        new BaseballRankingActivity.GetDetailedData().execute(pitcher_ranking_url_);
    }

    @SuppressLint("StaticFieldLeak")
    private class GetTeamData extends AsyncTask<String, Void, BaseballData.Team[]> {
        /*
        팀 순위 가져오기
         */
        protected BaseballData.Team[] doInBackground(String... params){
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
        protected void onPostExecute(BaseballData.Team[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            team_ranking_.setText(data[0].GetName() + " " + data[0].GetLastResult());
            //더 많은 정보는 BaseballData Team 클래스 참고
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetPitcherData extends AsyncTask<String, Void, BaseballData.Pitcher[]> {
        /*
        투수 평균 자책점 순위 가져오기
         */
        protected BaseballData.Pitcher[] doInBackground(String... params){
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
        protected void onPostExecute(BaseballData.Pitcher[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            pitcher_ranking_.setText(data[0].GetName() + " " + data[0].GetTeam());
            //더 많은 정보는 BaseballData Pitcher 클래스 참고
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetBatterData extends AsyncTask<String, Void, BaseballData.Batter[]> {
        /*
        타자 순위 가져오기
         */
        protected BaseballData.Batter[] doInBackground(String... params){
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
        protected void onPostExecute(BaseballData.Batter[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            batter_ranking_.setText(data[0].GetName() + " " + data[0].GetTeam());
            //더 많은 정보는 BaseballData Batter 클래스 참고
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetDetailedData extends AsyncTask<String, Void, BaseballData.DetailedRanking[]> {
        /*
        주요 부문 선두 5인 순위 가져오기
         */
        protected BaseballData.DetailedRanking[] doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(pitcher_ranking_url_).get();
                Elements data = doc.select(".tbl_box");
                return MyParser.ParseBaseballDetailedRanking(data.eq(1).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.DetailedRanking[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            detailed_ranking_.setText(data[0].GetName() + "\n" + data[0].GetPlayers()[0].GetName() + " " + data[0].GetPlayers()[1].GetName() + " " + data[0].GetPlayers()[2].GetName() + " " + " " + data[0].GetPlayers()[3].GetName() + " " + data[0].GetPlayers()[4].GetName());
            //더 많은 정보는 BaseballData DetailedRanking 클래스 참고
            //부문은 총 12개, 5등까지 표시
        }
    }

}
