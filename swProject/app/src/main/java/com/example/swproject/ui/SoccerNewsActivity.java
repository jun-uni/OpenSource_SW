package com.example.swproject.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.ImageTransformation;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.swproject.R;
import com.example.swproject.data.News;
import com.example.swproject.fragment.fragment_news_s;
import com.example.swproject.fragment.fragment_player_recode_soccer;
import com.example.swproject.fragment.fragment_player_soccer;
import com.example.swproject.fragment.fragment_team_soccer;
import com.example.swproject.util.MyParser;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoccerNewsActivity extends soccerActivity{

    TextView linkNews;

    fragment_news_s newsFragmentS;
    fragment_team_soccer teamFragmentS;
    fragment_player_soccer playerFragmentS;
    fragment_player_recode_soccer playerRecodeFragmentS;

    private TextView text_news_;

    private final String news_url_ = "https://www.goal.com/kr/%ED%94%84%EB%A6%AC%EB%AF%B8%EC%96%B4%EB%A6%AC%EA%B7%B8/2kwbbcootiqqgmrzs6o5inle5";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_news);

        linkNews = (TextView)findViewById(R.id.text_news);

        new GetNews().execute(news_url_);

        text_news_ = findViewById(R.id.text_news);

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
        newsFragmentS = new fragment_news_s();
        teamFragmentS = new fragment_team_soccer();
        playerFragmentS = new fragment_player_soccer();
        playerRecodeFragmentS = new fragment_player_recode_soccer();

        /* 초기 화면 */
        getSupportFragmentManager().beginTransaction().replace(R.id.container, newsFragmentS).commit();

        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.soccrNew:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, newsFragmentS).commit();
                        return true;
                    case R.id.soccerTeam:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, teamFragmentS).commit();
                        return true;
                    case R.id.soccerPlayer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerFragmentS).commit();
                        return true;
                    case R.id.PlayerRecodeS:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playerRecodeFragmentS).commit();
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
                str = str.substring(str.indexOf("data-page=\"next\"") , str.indexOf("\"commercial\""));
                return MyParser.ParseSoccerNews(str);
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
             */


            String str = "";
            linkNews.setText(str);

            Linkify.TransformFilter transformFilter = new Linkify.TransformFilter() {
                @Override
                public String transformUrl(Matcher match, String url) {
                    return "";
                }
            };


            for(int i=0; i<data.size(); i++){
                str += data.get(i).GetTitle()+"\n\n";
                Pattern pattern1 = Pattern.compile(data.get(i).GetTitle());
                Linkify.addLinks(linkNews, pattern1,data.get(i).GetUrl());
            }
            linkNews.setText(str);


            /*
            for(int i =0; i< data.size(); i++){
                str += data.get(i).GetTitle() + " " + data.get(i).GetTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm z")) + "\n" + data.get(i).GetUrl() + "\n\n";
            }
            text_news_.setText(str);
            //더 많은 정보는 News 클래스 참고
            */

        }
    }
}