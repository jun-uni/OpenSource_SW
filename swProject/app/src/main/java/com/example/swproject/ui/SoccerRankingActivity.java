package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.swproject.R;
import com.example.swproject.data.SoccerData;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SoccerRankingActivity extends soccerActivity {

    private TextView team_data_;
    private TextView player_data_;
    private final String team_url_ = "http://sports.news.naver.com/wfootball/record/index?category=epl&league=100&tab=team";
    private final String player_url_ = "https://sports.news.naver.com/wfootball/record/index?category=epl&tab=player";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_ranking);

        team_data_ = findViewById(R.id.text_team_ranking);
        player_data_ = findViewById(R.id.text_player_ranking);
        new GetTeamData().execute(team_url_);
        new GetPlayerData().execute(player_url_);
    }

    @SuppressLint("StaticFieldLeak")
    private class GetTeamData extends AsyncTask<String, Void, SoccerData.Team[]>{
        /*
        팀 순위 가져오기
         */
        protected SoccerData.Team[] doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(team_url_).get();
                Elements data = doc.select("#content script");
                return MyParser.ParseSoccerTeamRanking(data.last().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(SoccerData.Team[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 SoccerData 클래스 참고
             */
            StringBuilder str = new StringBuilder();

            for(int i =0; i< 20; i++){
                str.append(data[i].GetRank()).append("위: ").append(data[i].GetName()).append(" ").append(data[i].GetWon()).append("승 ").append(data[i].GetLost()).append("패 ").append(data[i].GetDrawn()).append("무 ").append(data[i].GetPoint()).append("승점\n");
            }
            team_data_.setText(str.toString());
        }
    }


    @SuppressLint("StaticFieldLeak")
    private class GetPlayerData extends AsyncTask<String, Void, SoccerData.Player[]>{
        /*
        유저 순위 가져오기
         */
        protected SoccerData.Player[] doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(player_url_).get();
                Elements data = doc.select("#content #wfootballPlayerRecordBody table tbody td");
                return MyParser.ParseSoccerPlayerRanking(data.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(SoccerData.Player[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 SoccerData 클래스 참고
             */
            StringBuilder str = new StringBuilder("[득점 순위]\n");

            for(int i =0; i< 20; i++){
                str.append(data[i].GetRank()).append("위: ").append(data[i].GetName()).append(" ").append(data[i].GetGoal()).append("득점 ").append(data[i].GetPoint()).append("공격포인트\n");
            }

            player_data_.setText(str.toString());
        }
    }
}


