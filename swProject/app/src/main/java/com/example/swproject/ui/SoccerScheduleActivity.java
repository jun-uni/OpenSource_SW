package com.example.swproject.ui;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.swproject.R;
import com.example.swproject.data.Schedule;
import com.example.swproject.data.SoccerData;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SoccerScheduleActivity extends soccerActivity {
    private TextView schedule_;

    private final String schedule_url_ = "https://www.skysports.com/premier-league-fixtures";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_schedule);

        schedule_ = (TextView)findViewById(R.id.text_schedule);
        new GetSchedule().execute(schedule_url_);

    }

    private class GetSchedule extends AsyncTask<String, Void, List<Schedule>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        protected List<Schedule> doInBackground(String... params){
            try {
                Document doc = null;

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
            String str = "";
            for(Schedule i : data){
                str += i.GetDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm z")) + "\n";
                if(i.GetIsPlaying())
                    str+= "[진행중] ";
                str += i.GetTeamLeft().GetName() + " : " + i.GetTeamRight().GetName() + " [" + i.GetTeamLeft().GetScore() + " : " + i.GetTeamRight().GetScore() + "]\n";
            }

            schedule_.setText(str);
        }
    }
}
