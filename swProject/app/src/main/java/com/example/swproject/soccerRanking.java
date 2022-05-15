package com.example.swproject;

import android.net.Network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SoccerRanking extends soccerActivity {

    private TextView team_data_;
    private String url = "http://sports.news.naver.com/wfootball/record/index?category=epl&league=100&tab=team";
    private String msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_ranking);

        team_data_ = (TextView)findViewById(R.id.text_data);
        new GetData().execute(url);
    }

    private class GetData extends AsyncTask<String, Void, SoccerTeam[]>{
        protected SoccerTeam[] doInBackground(String... params){
            try {
                Document doc = null;

                doc = Jsoup.connect(url).post();
                Elements data = doc.select("#content script");
                msg = data.last().toString();
                return MyParser.ParseSoccerRanking(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(SoccerTeam[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 SoccerTeam 클래스 참고
             */
            String str = "";

            for(int i =0; i< 20; i++){
                str += data[i].GetRank() + "위: " + data[i].GetName() + " " + data[i].GetWon() + "승 " + data[i].GetLost() + "패 " + data[i].GetDrawn() + "무 " + data[i].GetPoint() + "승점\n";
            }
            team_data_.setText(str);
        }
    }
}


