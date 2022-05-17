package com.example.swproject.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.swproject.R;
import com.example.swproject.data.SoccerData;
import com.example.swproject.ui.soccerActivity;
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

        team_data_ = (TextView)findViewById(R.id.text_team_ranking);
        player_data_ = (TextView)findViewById(R.id.text_player_ranking);
        new GetTeamData().execute(team_url_);
        new GetPlayerData().execute(player_url_);
    }

    private class GetTeamData extends AsyncTask<String, Void, SoccerData.Team[]>{
        /*
        팀 순위 가져오기
         */
        protected SoccerData.Team[] doInBackground(String... params){
            try {
                Document doc = null;

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
            String str = "";

            for(int i =0; i< 20; i++){
                str += data[i].GetRank() + "위: " + data[i].GetName() + " " + data[i].GetWon() + "승 " + data[i].GetLost() + "패 " + data[i].GetDrawn() + "무 " + data[i].GetPoint() + "승점\n";
            }
            team_data_.setText(str);
        }
    }


    private class GetPlayerData extends AsyncTask<String, Void, SoccerData.Player[]>{
        /*
        유저 순위 가져오기
         */
        protected SoccerData.Player[] doInBackground(String... params){
            try {
                Document doc = null;

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
            String str = "[득점 순위]\n";

            for(int i =0; i< 20; i++){
                str += data[i].GetRank() + "위: " + data[i].GetName() + " " + data[i].GetGoal() + "득점 " + data[i].GetPoint() + "공격포인트\n";
            }

            player_data_.setText(str);
        }
    }
}


