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
    private TextView team_data_1;
    private TextView team_data_2;
    private TextView team_data_3;
    private TextView team_data_4;
    private TextView team_data_5;
    private TextView team_data_6;
    private TextView team_data_7;
    private TextView team_data_8;
    private TextView team_data_9;
    private TextView team_data_10;
    private TextView team_data_11;
    private TextView team_data_12;
    private TextView team_data_13;
    private TextView team_data_14;
    private TextView team_data_15;
    private TextView team_data_16;
    private TextView team_data_17;
    private TextView team_data_18;
    private TextView team_data_19;

    private TextView player_data_;
    private final String team_url_ = "http://sports.news.naver.com/wfootball/record/index?category=epl&league=100&tab=team";
    private final String player_url_ = "https://sports.news.naver.com/wfootball/record/index?category=epl&tab=player";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_ranking);

        team_data_ = findViewById(R.id.text_team_ranking);
        team_data_1 = findViewById(R.id.text_team_ranking1);
        team_data_2=findViewById(R.id.text_team_ranking2);
        team_data_3=findViewById(R.id.text_team_ranking3);
        team_data_4=findViewById(R.id.text_team_ranking4);
        team_data_5=findViewById(R.id.text_team_ranking5);
        team_data_6=findViewById(R.id.text_team_ranking6);
        team_data_7=findViewById(R.id.text_team_ranking7);
        team_data_8=findViewById(R.id.text_team_ranking8);
        team_data_9=findViewById(R.id.text_team_ranking9);
        team_data_10=findViewById(R.id.text_team_ranking10);
        team_data_11=findViewById(R.id.text_team_ranking11);
        team_data_12=findViewById(R.id.text_team_ranking12);
        team_data_13=findViewById(R.id.text_team_ranking13);
        team_data_14=findViewById(R.id.text_team_ranking14);
        team_data_15=findViewById(R.id.text_team_ranking15);
        team_data_16=findViewById(R.id.text_team_ranking16);
        team_data_17=findViewById(R.id.text_team_ranking17);
        team_data_18=findViewById(R.id.text_team_ranking18);
        team_data_19=findViewById(R.id.text_team_ranking19);
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
        /**/
        @Override
        protected void onPostExecute(SoccerData.Team[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 SoccerData 클래스 참고
             */
            StringBuilder str = new StringBuilder();
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            StringBuilder str3 = new StringBuilder();
            StringBuilder str4 = new StringBuilder();
            StringBuilder str5 = new StringBuilder();
            StringBuilder str6 = new StringBuilder();
            StringBuilder str7 = new StringBuilder();
            StringBuilder str8 = new StringBuilder();
            StringBuilder str9 = new StringBuilder();
            StringBuilder str10 = new StringBuilder();
            StringBuilder str11 = new StringBuilder();
            StringBuilder str12 = new StringBuilder();
            StringBuilder str13= new StringBuilder();
            StringBuilder str14 = new StringBuilder();
            StringBuilder str15 = new StringBuilder();
            StringBuilder str16 = new StringBuilder();
            StringBuilder str17 = new StringBuilder();
            StringBuilder str18 = new StringBuilder();
            StringBuilder str19 = new StringBuilder();
            StringBuilder str20 = new StringBuilder();
            str.append(data[0].GetRank()).append("위:: ").append(data[0].GetName()).append(" ").append(data[0].GetWon()).append("승 ").append(data[0].GetLost()).append("패 ").append(data[0].GetDrawn()).append("무 ").append(data[0].GetPoint()).append("승점\n");
            str1.append(data[1].GetRank()).append("위: ").append(data[1].GetName()).append(" ").append(data[1].GetWon()).append("승 ").append(data[1].GetLost()).append("패 ").append(data[1].GetDrawn()).append("무 ").append(data[1].GetPoint()).append("승점\n");
            str2.append(data[2].GetRank()).append("위: ").append(data[2].GetName()).append(" ").append(data[2].GetWon()).append("승 ").append(data[2].GetLost()).append("패 ").append(data[2].GetDrawn()).append("무 ").append(data[2].GetPoint()).append("승점\n");
            str3.append(data[3].GetRank()).append("위: ").append(data[3].GetName()).append(" ").append(data[3].GetWon()).append("승 ").append(data[3].GetLost()).append("패 ").append(data[3].GetDrawn()).append("무 ").append(data[3].GetPoint()).append("승점\n");
            str4.append(data[4].GetRank()).append("위: ").append(data[4].GetName()).append(" ").append(data[4].GetWon()).append("승 ").append(data[4].GetLost()).append("패 ").append(data[4].GetDrawn()).append("무 ").append(data[4].GetPoint()).append("승점\n");
            str5.append(data[5].GetRank()).append("위: ").append(data[5].GetName()).append(" ").append(data[5].GetWon()).append("승 ").append(data[5].GetLost()).append("패 ").append(data[5].GetDrawn()).append("무 ").append(data[5].GetPoint()).append("승점\n");
            str6.append(data[6].GetRank()).append("위: ").append(data[6].GetName()).append(" ").append(data[6].GetWon()).append("승 ").append(data[6].GetLost()).append("패 ").append(data[6].GetDrawn()).append("무 ").append(data[6].GetPoint()).append("승점\n");
            str7.append(data[7].GetRank()).append("위: ").append(data[7].GetName()).append(" ").append(data[7].GetWon()).append("승 ").append(data[7].GetLost()).append("패 ").append(data[7].GetDrawn()).append("무 ").append(data[7].GetPoint()).append("승점\n");
            str8.append(data[8].GetRank()).append("위: ").append(data[8].GetName()).append(" ").append(data[8].GetWon()).append("승 ").append(data[8].GetLost()).append("패 ").append(data[8].GetDrawn()).append("무 ").append(data[8].GetPoint()).append("승점\n");
            str9.append(data[9].GetRank()).append("위: ").append(data[9].GetName()).append(" ").append(data[9].GetWon()).append("승 ").append(data[9].GetLost()).append("패 ").append(data[9].GetDrawn()).append("무 ").append(data[9].GetPoint()).append("승점\n");
            str10.append(data[10].GetRank()).append("위: ").append(data[10].GetName()).append(" ").append(data[10].GetWon()).append("승 ").append(data[10].GetLost()).append("패 ").append(data[10].GetDrawn()).append("무 ").append(data[10].GetPoint()).append("승점\n");
            str11.append(data[11].GetRank()).append("위: ").append(data[11].GetName()).append(" ").append(data[11].GetWon()).append("승 ").append(data[11].GetLost()).append("패 ").append(data[11].GetDrawn()).append("무 ").append(data[11].GetPoint()).append("승점\n");
            str12.append(data[12].GetRank()).append("위: ").append(data[12].GetName()).append(" ").append(data[12].GetWon()).append("승 ").append(data[12].GetLost()).append("패 ").append(data[12].GetDrawn()).append("무 ").append(data[12].GetPoint()).append("승점\n");
            str13.append(data[13].GetRank()).append("위: ").append(data[13].GetName()).append(" ").append(data[13].GetWon()).append("승 ").append(data[13].GetLost()).append("패 ").append(data[13].GetDrawn()).append("무 ").append(data[13].GetPoint()).append("승점\n");
            str14.append(data[14].GetRank()).append("위: ").append(data[14].GetName()).append(" ").append(data[14].GetWon()).append("승 ").append(data[14].GetLost()).append("패 ").append(data[14].GetDrawn()).append("무 ").append(data[14].GetPoint()).append("승점\n");
            str15.append(data[15].GetRank()).append("위: ").append(data[15].GetName()).append(" ").append(data[15].GetWon()).append("승 ").append(data[15].GetLost()).append("패 ").append(data[15].GetDrawn()).append("무 ").append(data[15].GetPoint()).append("승점\n");
            str16.append(data[16].GetRank()).append("위: ").append(data[16].GetName()).append(" ").append(data[16].GetWon()).append("승 ").append(data[16].GetLost()).append("패 ").append(data[16].GetDrawn()).append("무 ").append(data[16].GetPoint()).append("승점\n");
            str17.append(data[17].GetRank()).append("위: ").append(data[17].GetName()).append(" ").append(data[17].GetWon()).append("승 ").append(data[17].GetLost()).append("패 ").append(data[17].GetDrawn()).append("무 ").append(data[17].GetPoint()).append("승점\n");
            str18.append(data[18].GetRank()).append("위: ").append(data[18].GetName()).append(" ").append(data[18].GetWon()).append("승 ").append(data[18].GetLost()).append("패 ").append(data[18].GetDrawn()).append("무 ").append(data[18].GetPoint()).append("승점\n");
            str19.append(data[19].GetRank()).append("위: ").append(data[19].GetName()).append(" ").append(data[19].GetWon()).append("승 ").append(data[19].GetLost()).append("패 ").append(data[19].GetDrawn()).append("무 ").append(data[19].GetPoint()).append("승점\n");





            team_data_.setText(str.toString());
            team_data_1.setText(str1.toString());
            team_data_2.setText(str2.toString());
            team_data_3.setText(str3.toString());
            team_data_4.setText(str4.toString());
            team_data_5.setText(str5.toString());
            team_data_6.setText(str6.toString());
            team_data_7.setText(str7.toString());
            team_data_8.setText(str8.toString());
            team_data_9.setText(str9.toString());
            team_data_10.setText(str10.toString());
            team_data_11.setText(str11.toString());
            team_data_12.setText(str12.toString());
            team_data_13.setText(str13.toString());
            team_data_14.setText(str14.toString());
            team_data_15.setText(str15.toString());
            team_data_16.setText(str16.toString());
            team_data_17.setText(str17.toString());
            team_data_18.setText(str18.toString());
            team_data_19.setText(str19.toString());

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


