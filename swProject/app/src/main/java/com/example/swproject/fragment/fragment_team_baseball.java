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
        ??? ?????? ????????????
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
            ????????? ?????? ??????

            ???????????? ?????? ?????? ??????
            ????????? ????????? ?????? ???????????? BaseballData ????????? ??????
             */

            team_ranking_.setText(data[0].GetName() + " " + data[0].GetGame() + "?????? " + data[0].GetWon() + "??? " + data[0].GetLost() + "??? " + data[0].GetDrawn() + "???" + " ?????? " + data[0].GetWinRate() + " ????????? " + data[0].GetWinDiff() + " ?????? 10?????? " + data[0].GetLastResult());
            team_ranking_1.setText(data[1].GetName() + " " + data[1].GetGame() + "?????? " + data[1].GetWon() + "??? " + data[1].GetLost() + "??? " + data[1].GetDrawn() + "???" + " ?????? " + data[1].GetWinRate() + " ????????? " + data[1].GetWinDiff() + " ?????? 10?????? " + data[1].GetLastResult());
            team_ranking_2.setText(data[2].GetName() + " " + data[2].GetGame() + "?????? " + data[2].GetWon() + "??? " + data[2].GetLost() + "??? " + data[2].GetDrawn() + "???" + " ?????? " + data[2].GetWinRate() + " ????????? " + data[2].GetWinDiff() + " ?????? 10?????? " + data[2].GetLastResult());
            team_ranking_3.setText(data[3].GetName() + " " + data[3].GetGame() + "?????? " + data[3].GetWon() + "??? " + data[3].GetLost() + "??? " + data[3].GetDrawn() + "???" + " ?????? " + data[3].GetWinRate() + " ????????? " + data[3].GetWinDiff() + " ?????? 10?????? " + data[3].GetLastResult());
            team_ranking_4.setText(data[4].GetName() + " " + data[4].GetGame() + "?????? " + data[4].GetWon() + "??? " + data[4].GetLost() + "??? " + data[4].GetDrawn() + "???" + " ?????? " + data[4].GetWinRate() + " ????????? " + data[4].GetWinDiff() + " ?????? 10?????? " + data[4].GetLastResult());
            team_ranking_5.setText(data[5].GetName() + " " + data[5].GetGame() + "?????? " + data[5].GetWon() + "??? " + data[5].GetLost() + "??? " + data[5].GetDrawn() + "???" + " ?????? " + data[5].GetWinRate() + " ????????? " + data[5].GetWinDiff() + " ?????? 10?????? " + data[5].GetLastResult());
            team_ranking_6.setText(data[6].GetName() + " " + data[6].GetGame() + "?????? " + data[6].GetWon() + "??? " + data[6].GetLost() + "??? " + data[6].GetDrawn() + "???" + " ?????? " + data[6].GetWinRate() + " ????????? " + data[6].GetWinDiff() + " ?????? 10?????? " + data[6].GetLastResult());
            team_ranking_7.setText(data[7].GetName() + " " + data[7].GetGame() + "?????? " + data[7].GetWon() + "??? " + data[7].GetLost() + "??? " + data[7].GetDrawn() + "???" + " ?????? " + data[7].GetWinRate() + " ????????? " + data[7].GetWinDiff() + " ?????? 10?????? " + data[7].GetLastResult());
            team_ranking_8.setText(data[8].GetName() + " " + data[8].GetGame() + "?????? " + data[8].GetWon() + "??? " + data[8].GetLost() + "??? " + data[8].GetDrawn() + "???" + " ?????? " + data[8].GetWinRate() + " ????????? " + data[8].GetWinDiff() + " ?????? 10?????? " + data[8].GetLastResult());
            team_ranking_9.setText(data[9].GetName() + " " + data[9].GetGame() + "?????? " + data[9].GetWon() + "??? " + data[9].GetLost() + "??? " + data[9].GetDrawn() + "???" + " ?????? " + data[9].GetWinRate() + " ????????? " + data[9].GetWinDiff() + " ?????? 10?????? " + data[9].GetLastResult());

            //??? ?????? ????????? BaseballData Team ????????? ??????
        }
    }
}