package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.swproject.R;
import com.example.swproject.data.News;
import com.example.swproject.fragment.fragment_news_b;
import com.example.swproject.fragment.fragment_player_baseball;
import com.example.swproject.fragment.fragment_player_recode_baseball;
import com.example.swproject.fragment.fragment_team_baseball;
import com.example.swproject.util.MyParser;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BaseballNewsActivity extends baseballActivity{

    fragment_news_b newsFragmentB;
    fragment_team_baseball teamFragmentB;
    fragment_player_baseball playerFragmentB;
    fragment_player_recode_baseball playerRecodeFragmentB;

    private TextView text_news_;
    private final String news_url_ = "https://sports.news.naver.com/kbaseball/index";



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_news);

        text_news_ = findViewById(R.id.text_news);

        new GetNews().execute(news_url_);
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

        /* fragment 화면 전환 */
        newsFragmentB = new fragment_news_b();
        teamFragmentB = new fragment_team_baseball();
        playerFragmentB = new fragment_player_baseball();
        playerRecodeFragmentB = new fragment_player_recode_baseball();

        /* 초기 화면 */
        getSupportFragmentManager().beginTransaction().replace(R.id.container, newsFragmentB).commit();

        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.baseballNews:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, newsFragmentB).commit();
                        return true;
                    case R.id.baseballTeam:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragmentB).commit();
                        return true;
                    case R.id.baseballPlayer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerFragmentB).commit();
                        return true;
                    case R.id.PlayerRecodeB:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerRecodeFragmentB).commit();
                        return true;
                }
                return false;
            }
        });
        /* fragment 화면 전환 */




    }

    @SuppressLint("StaticFieldLeak")
    private class GetNews extends AsyncTask<String, Void, ArrayList<News>> {
        /*
        뉴스 정보 가져오기
         */
        @RequiresApi(api = Build.VERSION_CODES.O)
        protected ArrayList<News> doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(news_url_).get();
                String str = doc.toString();
                str = str.substring(str.indexOf("ol class=\"news_list\"") , str.indexOf("\"home_news_list division\""));
                return MyParser.ParseBaseballNews(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onPostExecute(ArrayList<News> data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 News 클래스 참고
            야구 뉴스는 기사 작성 시간 파악 불가능
             */

            String str = "";

            for(int i =0; i< data.size(); i++){
                str += data.get(i).GetTitle() + "\n" + data.get(i).GetUrl() + "\n\n";
            }
            text_news_.setText(str);
            //더 많은 정보는 News 클래스 참고
        }
    }
}