package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
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

@RequiresApi(api = Build.VERSION_CODES.O)
public class BaseballStarActivity extends baseballActivity{
    private TextView live_data_;
    private boolean is_playing_ = false;

    private LocalDate now = LocalDate.now();
    private int year_;

    private final String url_ = "https://mykbostats.com/schedule/6-LG-Twins"; //임의로 LG로 정함
    private String team_code_;
    private String playing_url_ = "https://mykbostats.com";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_star);

        SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String team_name = prefs.getString("baseball_team", "");

        new GetLive().execute(url_);

        live_data_ = findViewById(R.id.text_live);

        Button btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(view -> new BaseballStarActivity.GetLive().execute(url_));
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
                        if(tmp.compareTo("Final") == 0){
                            str = str.substring(str.indexOf("inning\">") + "\"inning\">".length());

                            continue;
                        }

                        is_playing_ = true;
                        str = str.substring(str.indexOf("href=\"") + "href=\"".length());
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
                //playing_url_ = "https://mykbostats.com/games/9839-LG-vs-Lotte-20220601"; //나중에 지워야 됨
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
            String str = "";

            str = data.GetTeamLeft().GetName() + ":" + data.GetTeamRight().GetName() + "\n" + data.GetTeamLeft().GetScore() + ":" + data.GetTeamRight().GetScore() + "\n문자 중계\n";

            for(int i = 0; i < data.GetSMSRelay().size(); i++){
                str += data.GetSMSRelay().get(i) + "\n";
            }

            live_data_.setText(str);
        }
    }
}
