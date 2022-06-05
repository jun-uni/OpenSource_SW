package com.example.swproject.fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swproject.R;
import com.example.swproject.data.SoccerData;
import com.example.swproject.util.MyParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class fragment_player_recode_soccer extends Fragment {
    private final String player_url_ = "https://sports.news.naver.com/wfootball/record/index?category=epl&tab=player";
    private TextView player_data_;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_player_recode_soccer, container, false);
        player_data_ = v.findViewById(R.id.text_player_ranking);

        new GetPlayerData().execute(player_url_);
        return v;
    }

    @SuppressLint("StaticFieldLeak")
    private class GetPlayerData extends AsyncTask<String, Void, SoccerData.Player[]> {
        /*
        유저 순위 가져오기
         */
        protected SoccerData.Player[] doInBackground(String... params){
            try {
                Document doc;

                doc = Jsoup.connect(player_url_).get();
                Elements data = doc.select("#content #wfootballPlayerRecordBody table tbody td");
                return MyParser.ParseSoccerPlayerRanking(data.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(SoccerData.Player[] data){
            /*
            데이터 표시 예시
            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 SoccerData 클래스 참고
             */
            StringBuilder str = new StringBuilder("[득점 순위]\n");

            for(int i =0; i< 20; i++){
                str.append(data[i].GetRank()).append("위: ").append(data[i].GetName()).append(" ").append(data[i].GetGoal()).append("득점 ").append(data[i].GetPoint()).append("공격포인트\n");
            }

            player_data_.setText(str.toString());
        }
    }
}