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
import com.example.swproject.data.Schedule;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SoccerScheduleActivity extends soccerActivity {
    private TextView schedule_;
    private TextView result_;

    private final String schedule_url_ = "https://www.skysports.com/premier-league-fixtures";
    private final String result_url_ = "https://www.skysports.com/premier-league-results";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_schedule);

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

        result_ = findViewById(R.id.text_result);
       //new GetSchedule().execute(schedule_url_); //일정이 끝나서 오류
        new GetResult().execute(result_url_);

    }

    @SuppressLint("StaticFieldLeak")
    public class GetSchedule extends AsyncTask<String, Void, List<Schedule>> {
        /*
        경기 일정 및 실시간 경기 정보
         */
        @RequiresApi(api = Build.VERSION_CODES.O)
        protected List<Schedule> doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(schedule_url_).get();
                Elements data = doc.select("div.fixres__body");
                return MyParser.ParseSoccerSchedule(data.last().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onPostExecute(List<Schedule> data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 SoccerSchedule 클래스 참고
             */
            StringBuilder str = new StringBuilder();
            for(Schedule i : data){
                str.append(i.GetDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm z"))).append("\n");
                if(i.GetIsPlaying())
                    str.append("[진행중] ");
                str.append(i.GetTeamLeft().GetName()).append(" : ").append(i.GetTeamRight().GetName()).append(" [").append(i.GetTeamLeft().GetScore()).append(" : ").append(i.GetTeamRight().GetScore()).append("]\n");
            }

            schedule_.setText(str.toString());
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetResult extends AsyncTask<String, Void, List<Schedule>> {
        /*
        과거 경기 결과
         */
        @RequiresApi(api = Build.VERSION_CODES.O)
        protected List<Schedule> doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(result_url_).get();
                Elements data = doc.select("div.fixres__body");
                return MyParser.ParseSoccerResult(data.last().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onPostExecute(List<Schedule> data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 SoccerSchedule 클래스 참고
             */
            StringBuilder str = new StringBuilder();
            for(Schedule i : data){
                str.append(i.GetDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm z"))).append("\n");
                if(i.GetIsPlaying()){
                    str.append("[진행중] ");
                }

                str.append(i.GetTeamLeft().GetName()).append(" : ").append(i.GetTeamRight().GetName()).append(" [").append(i.GetTeamLeft().GetScore()).append(" : ").append(i.GetTeamRight().GetScore()).append("]\n\n");
            }

            result_.setText(str.toString());
        }
    }
}
