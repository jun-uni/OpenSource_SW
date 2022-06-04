package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.swproject.R;
import com.example.swproject.data.BaseballData;
import com.example.swproject.data.Schedule;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BaseballScheduleActivity extends baseballActivity{

    private TextView schedule_;
    private EditText year_;
    private EditText month_;
    private String baseball_schedule_url_ = "https://sports.news.naver.com/kbaseball/schedule/index?";
    private String url_;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_schedule);

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

        schedule_ = findViewById(R.id.text_baseball_schedule);
    }

    public void mOnClickSearch(View v){
        url_ = baseball_schedule_url_ + "month=" + month_.getText().toString() + "&year=" + year_.getText().toString();

        new GetSchedule().execute(year_.getText().toString());
        //지금은 입력식으로 되어있는데 예외방지를 위해 좌우 버튼으로 1달씩 이동할 수 있는 기능 구현해야됨
    }


    @SuppressLint("StaticFieldLeak")
    public class GetSchedule extends AsyncTask<String, Void, List<Schedule>> {
        /*
        야구 일정 가져오기
         */
        @RequiresApi(api = Build.VERSION_CODES.O)
        protected List<Schedule> doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(url_).get();
                Elements data = doc.select("#calendarWrap");
                return MyParser.ParseBaseballSchedule(data.toString(), Integer.parseInt(year_.getText().toString()));
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
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            StringBuilder str = new StringBuilder();
            for(Schedule i : data){
                str.append(i.GetDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm z"))).append("\n");
                if(i.GetIsPlaying()){
                    str.append("[진행중] ");
                }
                if(i.GetIsCanceled()){
                    str.append("[해당 경기는 현지 사정으로 취소]" );
                }

                str.append(i.GetTeamLeft().GetName()).append(" : ").append(i.GetTeamRight().GetName()).append(" [").append(i.GetTeamLeft().GetScore()).append(" : ").append(i.GetTeamRight().GetScore()).append("]\n");
            }

            schedule_.setText(str.toString());
            //더 많은 정보는 BaseballData Team 클래스 참고
        }
    }
}
