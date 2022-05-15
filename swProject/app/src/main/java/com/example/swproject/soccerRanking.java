package com.example.swproject;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SoccerRanking extends soccerActivity {

    String url = "http://sports.news.naver.com/wfootball/record/index?category=epl&league=100&tab=team";
    String msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soccer_ranking);


        new Thread() {
            @Override
            public void run() {
                Document doc = null;
                try {


                    doc = Jsoup.connect(url).post();
                    Elements data = doc.select("#content script");
                    msg = data.last().toString();

                    doc = null;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


}


