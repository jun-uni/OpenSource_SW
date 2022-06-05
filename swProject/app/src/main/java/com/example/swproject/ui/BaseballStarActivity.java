package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import java.time.LocalDate;
import java.time.ZonedDateTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class BaseballStarActivity extends baseballActivity{
    private TextView live_data_;
    private TextView teamlft_name;
    private TextView teamlft_inning_1;
    private TextView teamlft_inning_2;
    private TextView teamlft_inning_3;
    private TextView teamlft_inning_4;
    private TextView teamlft_inning_5;
    private TextView teamlft_inning_6;
    private TextView teamlft_inning_7;
    private TextView teamlft_inning_8;
    private TextView teamlft_inning_9;
    private TextView teamlft_inning_10;
    private TextView teamlft_inning_11;
    private TextView teamlft_inning_12;
    private TextView teamlft_R;
    private TextView teamlft_H;
    private TextView teamlft_E;
    private TextView teamlft_B;

    private TextView teamrgt_name;
    private TextView teamrgt_inning_1;
    private TextView teamrgt_inning_2;
    private TextView teamrgt_inning_3;
    private TextView teamrgt_inning_4;
    private TextView teamrgt_inning_5;
    private TextView teamrgt_inning_6;
    private TextView teamrgt_inning_7;
    private TextView teamrgt_inning_8;
    private TextView teamrgt_inning_9;
    private TextView teamrgt_inning_10;
    private TextView teamrgt_inning_11;
    private TextView teamrgt_inning_12;
    private TextView teamrgt_R;
    private TextView teamrgt_H;
    private TextView teamrgt_E;
    private TextView teamrgt_B;
    private TextView sms_relay;
    private boolean is_playing_ = false;

    private LocalDate now = LocalDate.now();
    private int year_;

    private String url_ = "https://mykbostats.com/schedule/";
    private String playing_url_ = "https://mykbostats.com";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_star);

        SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String team_name = prefs.getString("baseball_team", "");

        if(team_name.compareTo("두산") == 0){
            url_ += "1-Doosan-Bears";
        }else if(team_name.compareTo("한화") ==0){
            url_ += "4-Hanwha-Eagles";
        }else if(team_name.compareTo("삼성") ==0){
            url_ += "3-Samsung-Lions";
        }else if(team_name.compareTo("NC") ==0){
            url_ += "9-NC-Dinos";
        }else if(team_name.compareTo("KIA") == 0){
            url_ += "5-Kia-Tigers";
        }else if(team_name.compareTo("LG") ==0){
            url_ += "6-LG-Twins";
        }else if(team_name.compareTo("SSG") == 0){
            url_ += "24-SSG-Landers";
        }else if(team_name.compareTo("롯데") == 0){
            url_ += "2-Lotte-Giants";
        }else if(team_name.compareTo("키움") == 0){
            url_ += "23-Kiwoom-Heroes";
        }else if(team_name.compareTo("KT") ==0){
            url_ += "22-KT-Wiz";
        }

        /* home 아이콘 눌렀을 때 메인화면 */
        ImageButton imageButton = (ImageButton) findViewById(R.id.homeicon);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        /* home 아이콘 눌렀을 때 메인화면 */

        new GetLive().execute(url_);

        live_data_ = findViewById(R.id.text_baseball_live);
        teamlft_name = findViewById(R.id.text_teamlft_name);
        teamlft_inning_1 = findViewById(R.id.text_teamlft_inning_1);
        teamlft_inning_2 = findViewById(R.id.text_teamlft_inning_2);
        teamlft_inning_3 = findViewById(R.id.text_teamlft_inning_3);
        teamlft_inning_4 = findViewById(R.id.text_teamlft_inning_4);
        teamlft_inning_5 = findViewById(R.id.text_teamlft_inning_5);
        teamlft_inning_6 = findViewById(R.id.text_teamlft_inning_6);
        teamlft_inning_7 = findViewById(R.id.text_teamlft_inning_7);
        teamlft_inning_8 = findViewById(R.id.text_teamlft_inning_8);
        teamlft_inning_9 = findViewById(R.id.text_teamlft_inning_9);
        teamlft_inning_10 = findViewById(R.id.text_teamlft_inning_10);
        teamlft_inning_11 = findViewById(R.id.text_teamlft_inning_11);
        teamlft_inning_12 = findViewById(R.id.text_teamlft_inning_12);
        teamlft_R = findViewById(R.id.text_teamlft_R);
        teamlft_H = findViewById(R.id.text_teamlft_H);
        teamlft_E = findViewById(R.id.text_teamlft_E);
        teamlft_B = findViewById(R.id.text_teamlft_B);

        teamrgt_name = findViewById(R.id.text_teamrgt_name);
        teamrgt_inning_1 = findViewById(R.id.text_teamrgt_inning_1);
        teamrgt_inning_2 = findViewById(R.id.text_teamrgt_inning_2);
        teamrgt_inning_3 = findViewById(R.id.text_teamrgt_inning_3);
        teamrgt_inning_4 = findViewById(R.id.text_teamrgt_inning_4);
        teamrgt_inning_5 = findViewById(R.id.text_teamrgt_inning_5);
        teamrgt_inning_6 = findViewById(R.id.text_teamrgt_inning_6);
        teamrgt_inning_7 = findViewById(R.id.text_teamrgt_inning_7);
        teamrgt_inning_8 = findViewById(R.id.text_teamrgt_inning_8);
        teamrgt_inning_9 = findViewById(R.id.text_teamrgt_inning_9);
        teamrgt_inning_10 = findViewById(R.id.text_teamrgt_inning_10);
        teamrgt_inning_11 = findViewById(R.id.text_teamrgt_inning_11);
        teamrgt_inning_12 = findViewById(R.id.text_teamrgt_inning_12);
        teamrgt_R = findViewById(R.id.text_teamrgt_R);
        teamrgt_H = findViewById(R.id.text_teamrgt_H);
        teamrgt_E = findViewById(R.id.text_teamrgt_E);
        teamrgt_B = findViewById(R.id.text_teamrgt_B);

        sms_relay = findViewById(R.id.text_sms_relay);
    }

    @SuppressLint("StaticFieldLeak")
    private class GetLive extends AsyncTask<String, Void, Void> {
        /*
        실시간 경기 정보
         */

        @RequiresApi(api = Build.VERSION_CODES.O)
        protected Void doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(url_).get();
                String str = doc.toString();

                str = str.substring(str.indexOf("\"game-line\""));

                String tmp = str;
                if(str.contains("inning")){
                    while(str.contains("inning")){
                        tmp = str.substring(str.indexOf("\"inning\">") + "\"inning\">".length()).replace(" ", "").replace("\n","");
                        tmp = tmp.substring(0, tmp.indexOf("<"));
                        if(tmp.contains("Final")){
                            str = str.substring(str.indexOf("inning\">") + "\"inning\">".length());

                            continue;
                        }

                        is_playing_ = true;
                        str = str.substring(str.indexOf("href=\"") + "href=\"".length());
                        playing_url_ = "https://mykbostats.com";
                        playing_url_ += str.substring(0, str.indexOf("\""));
                        break;
                    }
                }



            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void a){
            //is_playing_ = true; //나중에 지워야됨
            if(is_playing_){
                //playing_url_ = "https://mykbostats.com/games/9834-LG-vs-Lotte-20220531"; //나중에 지워야 됨
                new GetData().execute(playing_url_);
            }else{
                live_data_.setText("현재 진행 중인 경기가 없습니다");
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetData extends AsyncTask<String, Void, BaseballData.LiveData> {
        /*
        실시간 경기 정보
         */
        protected BaseballData.LiveData doInBackground(String... params) {
            try {
                Document doc;

                doc = Jsoup.connect(playing_url_).get();
                Elements data = doc.select("#content-container");

                return MyParser.ParseBaseballLiveData(data.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.LiveData data) {
            /*
            경기 실시간 정보 표시 예시
            디자인 추후 변경 요망
            BaseballData.LiveData 클래스 참고
             */
            StringBuilder str = new StringBuilder();

            ZonedDateTime today = ZonedDateTime.now();

            str.append(String.valueOf(today.getMonthValue())).append("/").append(String.valueOf(today.getDayOfMonth())).append("\n").append(data.GetTeamLeft().GetName()).append(" : " ).append(data.GetTeamRight().GetName()).append("\n");
            str.append(data.GetTeamLeft().GetScore()).append(" : ").append(data.GetTeamRight().GetScore()).append("\n");


            live_data_.setText(str.toString());
            teamlft_name.setText(data.GetTeamLeft().GetName());
            teamlft_inning_1.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[0]));
            teamlft_inning_2.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[1]));
            teamlft_inning_3.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[2]));
            teamlft_inning_4.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[3]));
            teamlft_inning_5.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[4]));
            teamlft_inning_6.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[5]));
            teamlft_inning_7.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[6]));
            teamlft_inning_8.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[7]));
            teamlft_inning_9.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[8]));
            teamlft_inning_10.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[9]));
            teamlft_inning_11.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[10]));
            teamlft_inning_12.setText(String.valueOf(data.GetTeamLeft().GetScoreBoard()[11]));
            teamlft_R.setText(String.valueOf(data.GetTeamLeft().GetRun()));
            teamlft_H.setText(String.valueOf(data.GetTeamLeft().GetHit()));
            teamlft_E.setText(String.valueOf(data.GetTeamLeft().GetError()));
            teamlft_B.setText(String.valueOf(data.GetTeamLeft().GetBaseOnBall()));

            teamrgt_name.setText(data.GetTeamRight().GetName());
            teamrgt_inning_1.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[0]));
            teamrgt_inning_2.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[1]));
            teamrgt_inning_3.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[2]));
            teamrgt_inning_4.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[3]));
            teamrgt_inning_5.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[4]));
            teamrgt_inning_6.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[5]));
            teamrgt_inning_7.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[6]));
            teamrgt_inning_8.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[7]));
            teamrgt_inning_9.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[8]));
            teamrgt_inning_10.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[9]));
            teamrgt_inning_11.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[10]));
            teamrgt_inning_12.setText(String.valueOf(data.GetTeamRight().GetScoreBoard()[11]));
            teamrgt_R.setText(String.valueOf(data.GetTeamRight().GetRun()));
            teamrgt_H.setText(String.valueOf(data.GetTeamRight().GetHit()));
            teamrgt_E.setText(String.valueOf(data.GetTeamRight().GetError()));
            teamrgt_B.setText(String.valueOf(data.GetTeamRight().GetBaseOnBall()));

            str = new StringBuilder();

            str.append("[문자 중계]\n");
            for(int i = 0; i < data.GetSMSRelay().size(); i++){
                if(data.GetSMSRelay().get(i).contains("회초") || data.GetSMSRelay().get(i).contains("회말"))
                    str.append("===================================================\n");
                else if(data.GetSMSRelay().get(i).contains("타자"))
                    str.append("\n");
                str.append(data.GetSMSRelay().get(i)).append("\n");
                if(data.GetSMSRelay().get(i).contains("회초") || data.GetSMSRelay().get(i).contains("회말"))
                    str.append("===================================================\n");
            }

            sms_relay.setText(str);

        }
    }
}
