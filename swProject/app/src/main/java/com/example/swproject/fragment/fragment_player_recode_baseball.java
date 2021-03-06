package com.example.swproject.fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.swproject.R;
import com.example.swproject.data.BaseballData;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class fragment_player_recode_baseball extends Fragment {

    private TextView pitcher_ranking_;
    private TextView pitcher_ranking_1;
    private TextView pitcher_ranking_2;
    private TextView pitcher_ranking_3;
    private TextView pitcher_ranking_4;
    private TextView pitcher_ranking_5;
    private TextView pitcher_ranking_6;
    private TextView pitcher_ranking_7;
    private TextView pitcher_ranking_8;
    private TextView pitcher_ranking_9;

    private TextView batter_ranking_;
    private TextView batter_ranking_1;
    private TextView batter_ranking_2;
    private TextView batter_ranking_3;
    private TextView batter_ranking_4;
    private TextView batter_ranking_5;
    private TextView batter_ranking_6;
    private TextView batter_ranking_7;
    private TextView batter_ranking_8;
    private TextView batter_ranking_9;

    private final String pitcher_ranking_url_ = "https://sports.news.naver.com/kbaseball/record/index?category=kbo";
    private final String batter_ranking_url_ = "https://sports.news.naver.com/kbaseball/record/index?category=kbo&year=2022&type=batter&playerOrder=hra";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player_recode_baseball, container, false);
        // Inflate the layout for this fragment

        pitcher_ranking_ = v.findViewById(R.id.text_baseball_pitcher);
        pitcher_ranking_1 = v.findViewById(R.id.text_baseball_pitcher2);
        pitcher_ranking_2 = v.findViewById(R.id.text_baseball_pitcher3);
        pitcher_ranking_3 = v.findViewById(R.id.text_baseball_pitcher4);
        pitcher_ranking_4 = v.findViewById(R.id.text_baseball_pitcher5);
        pitcher_ranking_5 = v.findViewById(R.id.text_baseball_pitcher6);
        pitcher_ranking_6 = v.findViewById(R.id.text_baseball_pitcher7);
        pitcher_ranking_7 = v.findViewById(R.id.text_baseball_pitcher8);
        pitcher_ranking_8 = v.findViewById(R.id.text_baseball_pitcher9);
        pitcher_ranking_9 = v.findViewById(R.id.text_baseball_pitcher10);


        batter_ranking_ = v.findViewById(R.id.text_baseball_batter);
        batter_ranking_1 = v.findViewById(R.id.text_baseball_batter2);
        batter_ranking_2 = v.findViewById(R.id.text_baseball_batter3);
        batter_ranking_3 = v.findViewById(R.id.text_baseball_batter4);
        batter_ranking_4 = v.findViewById(R.id.text_baseball_batter5);
        batter_ranking_5 = v.findViewById(R.id.text_baseball_batter6);
        batter_ranking_6 = v.findViewById(R.id.text_baseball_batter7);
        batter_ranking_7 = v.findViewById(R.id.text_baseball_batter8);
        batter_ranking_8 = v.findViewById(R.id.text_baseball_batter9);
        batter_ranking_9 = v.findViewById(R.id.text_baseball_batter10);

        new GetPitcherData().execute(pitcher_ranking_url_);
        new GetBatterData().execute(batter_ranking_url_);

        return v;
    }

    @SuppressLint("StaticFieldLeak")
    private class GetPitcherData extends AsyncTask<String, Void, BaseballData.Pitcher[]> {
        /*
        ?????? ?????? ????????? ?????? ????????????
         */
        protected BaseballData.Pitcher[] doInBackground(String... params) {
            try {
                Document doc;

                doc = Jsoup.connect(pitcher_ranking_url_).get();
                Elements data = doc.select("#content .tb_kbo script");
                return MyParser.ParseBaseballPitcherRanking(data.last().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.Pitcher[] data) {

            pitcher_ranking_.setText(data[0].GetName() + " " + data[0].GetTeam()+ " ???????????????:" + data[0].GetEarnedRunAverage()+" "+data[0].GetGame()+"?????? "+data[0].GetWon()+" ??? "+data[0].GetLost()+" ???" );
            pitcher_ranking_1.setText(data[1].GetName() + " " + data[1].GetTeam()+ " ???????????????:" + data[1].GetEarnedRunAverage()+" "+data[1].GetGame()+"?????? "+data[1].GetWon()+" ??? "+data[1].GetLost()+" ???" );
            pitcher_ranking_2.setText(data[2].GetName() + " " + data[2].GetTeam()+ " ???????????????:" + data[2].GetEarnedRunAverage()+" "+data[2].GetGame()+"?????? "+data[2].GetWon()+" ??? "+data[2].GetLost()+" ???" );
            pitcher_ranking_3.setText(data[3].GetName() + " " + data[3].GetTeam()+ " ???????????????:" + data[3].GetEarnedRunAverage()+" "+data[3].GetGame()+"?????? "+data[3].GetWon()+" ??? "+data[3].GetLost()+" ???" );
            pitcher_ranking_4.setText(data[4].GetName() + " " + data[4].GetTeam()+ " ???????????????:" + data[4].GetEarnedRunAverage()+" "+data[4].GetGame()+"?????? "+data[4].GetWon()+" ??? "+data[4].GetLost()+" ???" );
            pitcher_ranking_5.setText(data[5].GetName() + " " + data[5].GetTeam()+ " ???????????????:" + data[5].GetEarnedRunAverage()+" "+data[5].GetGame()+"?????? "+data[5].GetWon()+" ??? "+data[5].GetLost()+" ???" );
            pitcher_ranking_6.setText(data[6].GetName() + " " + data[6].GetTeam()+ " ???????????????:" + data[6].GetEarnedRunAverage()+" "+data[6].GetGame()+"?????? "+data[6].GetWon()+" ??? "+data[6].GetLost()+" ???" );
            pitcher_ranking_7.setText(data[7].GetName() + " " + data[7].GetTeam()+ " ???????????????:" + data[7].GetEarnedRunAverage()+" "+data[7].GetGame()+"?????? "+data[7].GetWon()+" ??? "+data[7].GetLost()+" ???" );
            pitcher_ranking_8.setText(data[8].GetName() + " " + data[8].GetTeam()+ " ???????????????:" + data[8].GetEarnedRunAverage()+" "+data[8].GetGame()+"?????? "+data[8].GetWon()+" ??? "+data[8].GetLost()+" ???" );
            pitcher_ranking_9.setText(data[9].GetName() + " " + data[9].GetTeam()+ " ???????????????:" + data[9].GetEarnedRunAverage()+" "+data[9].GetGame()+"?????? "+data[9].GetWon()+" ??? "+data[9].GetLost()+" ???" );

            //??? ?????? ????????? BaseballData Pitcher ????????? ??????
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class GetBatterData extends AsyncTask<String, Void, BaseballData.Batter[]> {
        /*
        ?????? ?????? ????????????
         */
        protected BaseballData.Batter[] doInBackground(String... params) {
            try {
                Document doc;

                doc = Jsoup.connect(batter_ranking_url_).get();
                Elements data = doc.select("#content .tb_kbo script");
                return MyParser.ParseBaseballBatterRanking(data.last().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.Batter[] data) {
            /*
            ????????? ?????? ??????
            ???????????? ?????? ?????? ??????
            ????????? ????????? ?????? ???????????? BaseballData ????????? ??????
             */

            batter_ranking_.setText(data[0].GetName() + " " + data[0].GetTeam()+" ??????: "+data[0].GetHitRate()+" "+data[0].GetGame()+"?????? "+data[0].GetAtBat()+"?????? "+data[0].GetHit()+"?????? "+data[0].GetHomeRun()+"?????? "+data[0].GetRunBattedIn()+"??????");
            batter_ranking_1.setText(data[1].GetName() + " " + data[1].GetTeam()+" ??????: "+data[1].GetHitRate()+" "+data[1].GetGame()+"?????? "+data[1].GetAtBat()+"?????? "+data[1].GetHit()+"?????? "+data[1].GetHomeRun()+"?????? "+data[1].GetRunBattedIn()+"??????");
            batter_ranking_2.setText(data[2].GetName() + " " + data[2].GetTeam()+" ??????: "+data[2].GetHitRate()+" "+data[2].GetGame()+"?????? "+data[2].GetAtBat()+"?????? "+data[2].GetHit()+"?????? "+data[2].GetHomeRun()+"?????? "+data[2].GetRunBattedIn()+"??????");
            batter_ranking_3.setText(data[3].GetName() + " " + data[3].GetTeam()+" ??????: "+data[3].GetHitRate()+" "+data[3].GetGame()+"?????? "+data[3].GetAtBat()+"?????? "+data[3].GetHit()+"?????? "+data[3].GetHomeRun()+"?????? "+data[3].GetRunBattedIn()+"??????");
            batter_ranking_4.setText(data[4].GetName() + " " + data[4].GetTeam()+" ??????: "+data[4].GetHitRate()+" "+data[4].GetGame()+"?????? "+data[4].GetAtBat()+"?????? "+data[4].GetHit()+"?????? "+data[4].GetHomeRun()+"?????? "+data[4].GetRunBattedIn()+"??????");
            batter_ranking_5.setText(data[5].GetName() + " " + data[5].GetTeam()+" ??????: "+data[5].GetHitRate()+" "+data[5].GetGame()+"?????? "+data[5].GetAtBat()+"?????? "+data[5].GetHit()+"??????"+data[5].GetHomeRun()+"?????? "+data[5].GetRunBattedIn()+"??????");
            batter_ranking_6.setText(data[6].GetName() + " " + data[6].GetTeam()+" ??????: "+data[6].GetHitRate()+" "+data[6].GetGame()+"?????? "+data[6].GetAtBat()+"?????? "+data[6].GetHit()+"?????? "+data[6].GetHomeRun()+"?????? "+data[6].GetRunBattedIn()+"??????");
            batter_ranking_7.setText(data[7].GetName() + " " + data[7].GetTeam()+" ??????: "+data[7].GetHitRate()+" "+data[7].GetGame()+"?????? "+data[7].GetAtBat()+"?????? "+data[7].GetHit()+"?????? "+data[7].GetHomeRun()+"?????? "+data[7].GetRunBattedIn()+"??????");
            batter_ranking_8.setText(data[8].GetName() + " " + data[8].GetTeam()+" ??????: "+data[8].GetHitRate()+" "+data[8].GetGame()+"?????? "+data[8].GetAtBat()+"?????? "+data[8].GetHit()+"?????? "+data[8].GetHomeRun()+"?????? "+data[8].GetRunBattedIn()+"??????");
            batter_ranking_9.setText(data[9].GetName() + " " + data[9].GetTeam()+" ??????: "+data[9].GetHitRate()+" "+data[9].GetGame()+"?????? "+data[9].GetAtBat()+"?????? "+data[9].GetHit()+"?????? "+data[9].GetHomeRun()+"?????? "+data[9].GetRunBattedIn()+"??????");

        }
    }
}