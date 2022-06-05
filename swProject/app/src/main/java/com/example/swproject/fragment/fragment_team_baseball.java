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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_team_baseball#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_team_baseball extends Fragment {
    private final String pitcher_ranking_url_ = "https://sports.news.naver.com/kbaseball/record/index?category=kbo";

    private TextView team_ranking_;
    private TextView team_ranking_1;
    private TextView team_ranking_2;
    private TextView team_ranking_3;
    private TextView team_ranking_4;
    private TextView team_ranking_5;
    private TextView team_ranking_6;
    private TextView team_ranking_7;
    private TextView team_ranking_8;
    private TextView team_ranking_9;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_team_baseball() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_team_baseball.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_team_baseball newInstance(String param1, String param2) {
        fragment_team_baseball fragment = new fragment_team_baseball();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_team_baseball, container, false);
        team_ranking_ = v.findViewById(R.id.text_baseball_team);
        team_ranking_1 = v.findViewById(R.id.text_baseball_team2);
        team_ranking_2 = v.findViewById(R.id.text_baseball_team3);
        team_ranking_3 = v.findViewById(R.id.text_baseball_team4);
        team_ranking_4 = v.findViewById(R.id.text_baseball_team5);
        team_ranking_5 = v.findViewById(R.id.text_baseball_team6);
        team_ranking_6 = v.findViewById(R.id.text_baseball_team7);
        team_ranking_7 = v.findViewById(R.id.text_baseball_team8);
        team_ranking_8 = v.findViewById(R.id.text_baseball_team9);
        team_ranking_9 = v.findViewById(R.id.text_baseball_team10);
        new GetTeamData().execute(pitcher_ranking_url_);

        return v;
    }

    @SuppressLint("StaticFieldLeak")
    private class GetTeamData extends AsyncTask<String, Void, BaseballData.Team[]> {
        /*
        팀 순위 가져오기
         */
        protected BaseballData.Team[] doInBackground(String... params) {
            try {
                Document doc;

                doc = Jsoup.connect(pitcher_ranking_url_).get();
                Elements data = doc.select("#content .tb_kbo script");
                return MyParser.ParseBaseballTeamRanking(data.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(BaseballData.Team[] data) {
            /*
            데이터 표시 예시

            디자인은 추후 변경 요망
            데이터 종류와 관련 메소드는 BaseballData 클래스 참고
             */

            team_ranking_.setText(data[0].GetName() + " " + data[0].GetGame() + "경기 " + data[0].GetWon() + "승 " + data[0].GetLost() + "패 " + data[0].GetDrawn() + "무" + " 승률 " + data[0].GetWinRate() + " 게임차 " + data[0].GetWinDiff() + " 최근 10경기 " + data[0].GetLastResult());
            team_ranking_1.setText(data[1].GetName() + " " + data[1].GetGame() + "경기 " + data[1].GetWon() + "승 " + data[1].GetLost() + "패 " + data[1].GetDrawn() + "무" + " 승률 " + data[1].GetWinRate() + " 게임차 " + data[1].GetWinDiff() + " 최근 10경기 " + data[1].GetLastResult());
            team_ranking_2.setText(data[2].GetName() + " " + data[2].GetGame() + "경기 " + data[2].GetWon() + "승 " + data[2].GetLost() + "패 " + data[2].GetDrawn() + "무" + " 승률 " + data[2].GetWinRate() + " 게임차 " + data[2].GetWinDiff() + " 최근 10경기 " + data[2].GetLastResult());
            team_ranking_3.setText(data[3].GetName() + " " + data[3].GetGame() + "경기 " + data[3].GetWon() + "승 " + data[3].GetLost() + "패 " + data[3].GetDrawn() + "무" + " 승률 " + data[3].GetWinRate() + " 게임차 " + data[3].GetWinDiff() + " 최근 10경기 " + data[3].GetLastResult());
            team_ranking_4.setText(data[4].GetName() + " " + data[4].GetGame() + "경기 " + data[4].GetWon() + "승 " + data[4].GetLost() + "패 " + data[4].GetDrawn() + "무" + " 승률 " + data[4].GetWinRate() + " 게임차 " + data[4].GetWinDiff() + " 최근 10경기 " + data[4].GetLastResult());
            team_ranking_5.setText(data[5].GetName() + " " + data[5].GetGame() + "경기 " + data[5].GetWon() + "승 " + data[5].GetLost() + "패 " + data[5].GetDrawn() + "무" + " 승률 " + data[5].GetWinRate() + " 게임차 " + data[5].GetWinDiff() + " 최근 10경기 " + data[5].GetLastResult());
            team_ranking_6.setText(data[6].GetName() + " " + data[6].GetGame() + "경기 " + data[6].GetWon() + "승 " + data[6].GetLost() + "패 " + data[6].GetDrawn() + "무" + " 승률 " + data[6].GetWinRate() + " 게임차 " + data[6].GetWinDiff() + " 최근 10경기 " + data[6].GetLastResult());
            team_ranking_7.setText(data[7].GetName() + " " + data[7].GetGame() + "경기 " + data[7].GetWon() + "승 " + data[7].GetLost() + "패 " + data[7].GetDrawn() + "무" + " 승률 " + data[7].GetWinRate() + " 게임차 " + data[7].GetWinDiff() + " 최근 10경기 " + data[7].GetLastResult());
            team_ranking_8.setText(data[8].GetName() + " " + data[8].GetGame() + "경기 " + data[8].GetWon() + "승 " + data[8].GetLost() + "패 " + data[8].GetDrawn() + "무" + " 승률 " + data[8].GetWinRate() + " 게임차 " + data[8].GetWinDiff() + " 최근 10경기 " + data[8].GetLastResult());
            team_ranking_9.setText(data[9].GetName() + " " + data[9].GetGame() + "경기 " + data[9].GetWon() + "승 " + data[9].GetLost() + "패 " + data[9].GetDrawn() + "무" + " 승률 " + data[9].GetWinRate() + " 게임차 " + data[9].GetWinDiff() + " 최근 10경기 " + data[9].GetLastResult());

            //더 많은 정보는 BaseballData Team 클래스 참고
        }
    }
}