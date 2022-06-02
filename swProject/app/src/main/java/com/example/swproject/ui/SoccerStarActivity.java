package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.swproject.Alarm.AlarmRecevier;
import com.example.swproject.R;
import com.example.swproject.data.SoccerData;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SoccerStarActivity extends soccerActivity{
    /* 알람 기능 추가 변수*/
    private AlarmManager alarmManager;
    private GregorianCalendar mCalender;

    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    /* 알람 기능 추가 변수*/



    private TextView live_data_;
    private boolean is_playing_ = false;

    /*임시로 첼시로 정함*/
    private final String schedule_url_ = "https://www.goal.com/kr/%ED%8C%80/%EC%B2%BC%EC%8B%9C/%EC%9D%BC%EC%A0%95-%EA%B2%B0%EA%B3%BC/%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8/2kwbbcootiqqgmrzs6o5inle5/9q0arba2kbnywth8bkxlhgmdr";
    private String playing_url_ = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_star);



        new GetLive().execute(schedule_url_);

        live_data_ = findViewById(R.id.text_live);

        Button btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(view -> new GetLive().execute(schedule_url_));

        /* 알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가*/

        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        mCalender = new GregorianCalendar();

        Log.v("HelloAlarmActivity", mCalender.getTime().toString());

        setContentView(R.layout.soccer_star);

        Button button = (Button) findViewById(R.id.btnNoti);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });
        /* 알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가*/

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

    }

    /* 알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가*/

    private void setAlarm() {
        //AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(SoccerStarActivity.this, AlarmRecevier.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(SoccerStarActivity.this, 0, receiverIntent, 0);

        String from = "2022-05-30 05:50:15"; //임의로 날짜와 시간을 지정

        //날짜 포맷을 바꿔주는 소스코드
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = null;
        try {
            datetime = dateFormat.parse(from);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);

        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(),pendingIntent);


    }
    /* 알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가*/




    @SuppressLint("StaticFieldLeak")
    private class GetLive extends AsyncTask<String, Void, Void> {
        /*
        실시간 경기 정보
         */
        @RequiresApi(api = Build.VERSION_CODES.O)
        protected Void doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(schedule_url_).get();
                Elements data = doc.select("div.widget-entity-matches__list");
                String str = data.toString();

                if(str.contains("match-row  status-pla")){
                    str = str.substring(str.indexOf("match-row  status-pla"));
                    str = str.substring(str.indexOf("match-main-data-link"));
                    playing_url_ = str.substring(str.indexOf("href") + "href".length() + 2, str.indexOf(">") - 1);
                    playing_url_ = "https://www.goal.com" + playing_url_;
                    is_playing_ = true;
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
                //playing_url_ = "https://www.goal.com/kr/%EA%B2%BD%EA%B8%B0/%EC%B2%BC%EC%8B%9C-v-%EB%A0%88%EC%8A%A4%ED%84%B0-%EC%8B%9C%ED%8B%B0/ejwo9te0ye4nkw4b04txqkbo4"; //나중에 지워야 됨
                new GetData().execute(playing_url_);
            }else{
                live_data_.setText("현재 진행 중인 경기가 없습니다");
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetData extends AsyncTask<String, Void, SoccerData.LiveData> {
        /*
        실시간 경기 정보
         */
        protected SoccerData.LiveData doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(playing_url_).get();
                Elements data = doc.select("body");

                return MyParser.ParseSoccerLiveData(data.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(SoccerData.LiveData data){
            /*
            경기 실시간 정보 표시 예시
            디자인 추후 변경 요망
             */
            String str = "";

            str += data.GetTeamLeft().GetName() + " vs " + data.GetTeamRight().GetName() + "\n";
            str += "점수 [" + data.GetTeamLeft().GetScore() + " : " + data.GetTeamRight().GetScore() + "]\n";
            str += "점유율 [" + data.GetTeamLeft().GetPossession() + "% : " + data.GetTeamRight().GetPossession() + "%]\n";
            str += "유효 슈팅 [" + data.GetTeamLeft().GetOnTargetShot() + " : " + data.GetTeamRight().GetOnTargetShot() + "]\n";
            str += "빗나간 슈팅 [" + data.GetTeamLeft().GetMissedShot() + " : " + data.GetTeamRight().GetMissedShot() + "]\n";
            str += "총 패스 [" + data.GetTeamLeft().GetTotalPass() + " : " + data.GetTeamRight().GetTotalPass() + "]";

            live_data_.setText(str);

        }
    }
}
