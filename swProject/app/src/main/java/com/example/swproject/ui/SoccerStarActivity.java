package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.preference.PreferenceManager;
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
    private final String team_url_ = "http://sports.news.naver.com/wfootball/record/index?category=epl&league=100&tab=team";



    private TextView live_data_;
    private boolean is_playing_ = false;

    private String url_ = "https://www.goal.com/kr/";
    private String playing_url_ = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_star);

        SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String team_name = prefs.getString("soccer_team", "");

        if(team_name.compareTo("노리치 시티") == 0){
            url_ += "팀/노리치-시티/일정-결과/suz80crpy3anixyzccmu6jzp";
        }else if(team_name.compareTo("뉴캐슬 유나이티드") ==0){
            url_ += "팀/뉴캐슬-유나이티드/일정-결과/7vn2i2kd35zuetw6b38gw9jsz";
        }else if(team_name.compareTo("레스터 시티") ==0){
            url_ += "팀/레스터-시티/일정-결과/avxknfz4f6ob0rv9dbnxdzde0";
        }else if(team_name.compareTo("리버풀") ==0){
            url_ += "팀/리버풀/일정-결과/c8h9bw1l82s06h77xxrelzhur";
        }else if(team_name.compareTo("리즈 유나이티드") == 0){
            url_ += "팀/리즈-유나이티드/일정-결과/48gk2hpqtsl6p9sx9kjhaydq4";
        }else if(team_name.compareTo("맨체스터 시티") ==0){
            url_ += "팀/맨체스터-시티/일정-결과/a3nyxabgsqlnqfkeg41m6tnpp";
        }else if(team_name.compareTo("맨체스터 유나이티드") == 0){
            url_ += "팀/맨체스터-유나이티드/일정-결과/6eqit8ye8aomdsrrq0hk3v7gh";
        }else if(team_name.compareTo("번리") == 0){
            url_ += "팀/번리/일정-결과/64bxxwu2mv2qqlv0monbkj1om";
        }else if(team_name.compareTo("브라이튼 앤 호브") == 0){
            url_ += "팀/브라이튼-앤-호브/일정-결과/e5p0ehyguld7egzhiedpdnc3w";
        }else if(team_name.compareTo("브렌트포드") ==0){
            url_ += "팀/브렌트포드/일정-결과/7yx5dqhhphyvfisohikodajhv";
        }else if(team_name.compareTo("사우샘프턴") ==0){
            url_ += "팀/사우샘프턴/일정-결과/d5ydtvt96bv7fq04yqm2w2632";
        }else if(team_name.compareTo("아스널") == 0){
            url_ += "팀/아스널/일정-결과/4dsgumo7d4zupm2ugsvm4zm4d";
        }else if(team_name.compareTo("아스톤 빌라") ==0){
            url_ += "팀/아스톤-빌라/일정-결과/b496gs285it6bheuikox6z9mj";
        }else if(team_name.compareTo("에버튼") == 0){
            url_ += "팀/에버튼/일정-결과/ehd2iemqmschhj2ec0vayztzz";
        }else if(team_name.compareTo("왓퍼드") == 0){
            url_ += "팀/왓퍼드/일정-결과/4t83rqbdbekinxl5fz2ygsyta";
        }else if(team_name.compareTo("울버햄튼 원더러스") == 0){
            url_ += "팀/울버햄튼-원더러스/일정-결과/b9si1jn1lfxfund69e9ogcu2n";
        }else if(team_name.compareTo("웨스트햄 유나이티드") ==0){
            url_ += "팀/웨스트햄-유나이티드/일정-결과/4txjdaqveermfryvbfrr4taf7";
        }else if(team_name.compareTo("첼시") == 0){
            url_ += "팀/첼시/일정-결과/9q0arba2kbnywth8bkxlhgmdr";
        }else if(team_name.compareTo("크리스털 팰리스") ==0){
            url_ += "팀/크리스털-팰리스/일정-결과/1c8m2ko0wxq1asfkuykurdr0y";
        }else if(team_name.compareTo("토트넘 홋스퍼") ==0){
            url_ += "팀/토트넘-홋스퍼/일정-결과/22doj4sgsocqpxw45h607udje";
        }

        live_data_ = findViewById(R.id.text_live);

        new GetLive().execute(url_);



        Button btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(view -> new GetLive().execute(url_));

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
        team_data_ = findViewById(R.id.teamName1);
        team_data_1 = findViewById(R.id.teamName2);
        team_data_2=findViewById(R.id.teamName3);
        team_data_3=findViewById(R.id.teamName4);
        team_data_4=findViewById(R.id.teamName5);
        team_data_5=findViewById(R.id.teamName6);
        team_data_6=findViewById(R.id.teamName7);
        team_data_7=findViewById(R.id.teamName8);
        team_data_8=findViewById(R.id.teamName9);
        team_data_9=findViewById(R.id.teamName10);
        team_data_10=findViewById(R.id.teamName11);
        team_data_11=findViewById(R.id.teamName12);
        team_data_12=findViewById(R.id.teamName13);
        team_data_13=findViewById(R.id.teamName14);
        team_data_14=findViewById(R.id.teamName15);
        team_data_15=findViewById(R.id.teamName16);
        team_data_16=findViewById(R.id.teamName17);
        team_data_17=findViewById(R.id.teamName18);
        team_data_18=findViewById(R.id.teamName19);
        team_data_19=findViewById(R.id.teamName20);

        new GetTeamData().execute(team_url_);
    }
    @SuppressLint("StaticFieldLeak")
    private class GetTeamData extends AsyncTask<String, Void, SoccerData.Team[]> {
        /*
        팀 순위 가져오기
         */
        protected SoccerData.Team[] doInBackground(String... params) {
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

        /* 알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가*/
        @Override
        protected void onPostExecute(SoccerData.Team[] data) {
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
            StringBuilder str13 = new StringBuilder();
            StringBuilder str14 = new StringBuilder();
            StringBuilder str15 = new StringBuilder();
            StringBuilder str16 = new StringBuilder();
            StringBuilder str17 = new StringBuilder();
            StringBuilder str18 = new StringBuilder();
            StringBuilder str19 = new StringBuilder();
            StringBuilder str20 = new StringBuilder();
            str.append(data[0].GetName()).append(" ");
            str1.append(data[1].GetName()).append(" ");
            str2.append(data[2].GetName()).append(" ");
            str3.append(data[3].GetName()).append(" ");
            str4.append(data[4].GetName()).append(" ");
            str5.append(data[5].GetName()).append(" ");
            str6.append(data[6].GetName()).append(" ");
            str7.append(data[7].GetName()).append(" ");
            str8.append(data[8].GetName()).append(" ");
            str9.append(data[9].GetName()).append(" ");
            str10.append(data[10].GetName()).append(" ");
            str11.append(data[11].GetName()).append(" ");

            str12.append(data[12].GetName()).append(" ");
            str13.append(data[13].GetName()).append(" ");
            str14.append(data[14].GetName()).append(" ");
            str15.append(data[15].GetName()).append(" ");
            str16.append(data[16].GetName()).append(" ");
            str17.append(data[17].GetName()).append(" ");
            str18.append(data[18].GetName()).append(" ");
            str19.append(data[19].GetName()).append(" ");


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
    /* 알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가알람 기능 추가*/

    private void setAlarm() {
        //AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(SoccerStarActivity.this, AlarmRecevier.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(SoccerStarActivity.this, 0, receiverIntent, 0);

        String from = "2022-06-05 08:22:15"; //임의로 날짜와 시간을 지정

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

                doc = Jsoup.connect(url_).get();
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
