package com.example.swproject.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.swproject.data.Schedule;
import com.example.swproject.data.SoccerData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyParser {
    public static SoccerData.Team[] ParseSoccerTeamRanking(String str){
        SoccerData.Team[] result = new SoccerData.Team[20];

        for(int i =0; i<20;i++){
            result[i] = new SoccerData.Team();
        }

        for(int i = 0; i<20; i++){
            str = str.substring(str.indexOf("teamName"));
            result[i].SetName(str.substring(str.indexOf("teamName") + 11, str.indexOf(",") - 1));

            str = str.substring(str.indexOf("gainGoal"));
            result[i].SetGoal(Integer.parseInt(str.substring(str.indexOf("gainGoal") + 10, str.indexOf(","))));


            str = str.substring(str.indexOf("gameCount"));
            result[i].SetGame(Integer.parseInt(str.substring(str.indexOf("gameCount") + 11, str.indexOf(","))));

            str = str.substring(str.indexOf("lastResult"));
            result[i].SetLastResult(str.substring(str.indexOf("lastResult") + 13, str.indexOf(",") -1));

            str = str.substring(str.indexOf("gainPoint"));
            result[i].SetPoint(Integer.parseInt(str.substring(str.indexOf("gainPoint") + 11, str.indexOf(","))));

            str = str.substring(str.indexOf("loseGoal"));
            result[i].SetLoseGoal(Integer.parseInt(str.substring(str.indexOf("loseGoal") + 10, str.indexOf(","))));

            str = str.substring(str.indexOf("lost"));
            result[i].SetLost(Integer.parseInt(str.substring(str.indexOf("lost") + 6, str.indexOf(","))));

            str = str.substring(str.indexOf("won"));
            result[i].SetWon(Integer.parseInt(str.substring(str.indexOf("won") + 5, str.indexOf(","))));

            str = str.substring(str.indexOf("goalGap"));
            result[i].SetGoalGap(Integer.parseInt(str.substring(str.indexOf("goalGap") + 9, str.indexOf(","))));

            str = str.substring(str.indexOf("rank"));
            result[i].SetRank(Integer.parseInt(str.substring(str.indexOf("rank") + 6, str.indexOf(","))));

            str = str.substring(str.indexOf("drawn"));
            result[i].SetDrawn(Integer.parseInt(str.substring(str.indexOf("drawn") + 7, str.indexOf("}"))));
        }
        return result;
    }


    public static SoccerData.Player[] ParseSoccerPlayerRanking(String str){
        SoccerData.Player [] result = new SoccerData.Player[20];

        for(int i =0; i < 20; i++){
            result[i] = new SoccerData.Player();
        }

        for(int i =0; i<20; i++){
            str = str.substring(str.indexOf("<strong>"));
            result[i].SetRank(Integer.parseInt(str.substring(str.indexOf("<strong>") + "<strong>".length(), str.indexOf("</strong>"))));

            str = str.substring(str.indexOf("alt="));
            result[i].SetTeam(str.substring(str.indexOf("alt=") + 5, str.indexOf("src") - 1));

            str = str.substring(str.indexOf("name"));
            result[i].SetName(str.substring(str.indexOf("name") + 6, str.indexOf("</span>")));

            str = str.substring(str.indexOf("<span>"));
            result[i].SetGoal(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetAssist(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetPoint(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetShot(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetFoul(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetBooking(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetDismissal(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetCornerKick(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetPenaltyKick(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetOffside(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetOnTargetShot(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

            str = str.substring(str.indexOf("</span>"));
            str = str.substring(str.indexOf("<span>"));
            result[i].SetGame(Integer.parseInt(str.substring(str.indexOf("<span>") + "<span>".length(), str.indexOf("</span>"))));

        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<Schedule> ParseSoccerSchedule(String str){
        List<Schedule> result = new ArrayList<Schedule>();

        LocalDate tmp_date = LocalDate.now();
        int tmp_year = 0, tmp_day = 0, tmp_month = 0, tmp_hour = 0, tmp_min = 0;

        while(str.contains("swap-text__target")){
            if(str.substring(str.indexOf("swap-text__target") + "swap-text__target".length()).indexOf("</span>") > 30){
                str = str.substring(str.indexOf("swap-text__target"));
                str = str.substring(str.indexOf("</a>"));
                continue;
            }

            if(str.contains("fixres__header1")){
                if (str.contains("fixres__header2")) {
                    if (str.indexOf("fixres__header1") < str.indexOf("fixres__header2")) {
                        String tmp_str = str.substring(str.indexOf("fixres__header1") + "fixres__header1".length() + 2);

                        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

                        for (int i = 0; i < 12; i++) {
                            if (months[i].compareTo(tmp_str.substring(0, tmp_str.indexOf(" "))) == 0) {
                                tmp_month = i + 1;
                                break;
                            }
                        }

                        tmp_year = Integer.parseInt(tmp_str.substring(tmp_str.indexOf(" ") + 1, tmp_str.indexOf("<")));
                    }
                }
            }

            if(str.contains("fixres__header2")){
                String tmp_str = str.substring(str.indexOf("fixres__header2"));
                tmp_str = tmp_str.substring(tmp_str.indexOf("fixres__header2") + "fixres__header2".length() + 2, tmp_str.indexOf("<"));
                tmp_str = tmp_str.substring(tmp_str.indexOf(" ") + 1);
                tmp_str = tmp_str.substring(0, tmp_str.indexOf(" "));
                tmp_day = Integer.parseInt(tmp_str.replaceAll("[^0-9]",""));
                tmp_date = LocalDate.of(tmp_year, tmp_month, tmp_day);

                System.out.println(tmp_date);
            }

            Schedule tmp_schedule = new Schedule();

            str = str.substring(str.indexOf("data-status=") + "data-status=".length());

            if(str.substring(1, str.indexOf(">") - 1).compareTo("IP") == 0){
                tmp_schedule.SetIsPlaying(true);
            }else{
                tmp_schedule.SetIsPlaying(false);
            }

            str = str.substring(str.indexOf("swap-text__target") + "swap-text__target".length() + 2);
            tmp_schedule.GetTeamLeft().SetName(str.substring(0, str.indexOf("<")));

            str = str.substring(str.indexOf("matches__teamscores-side") + "matches__teamscores-side".length() + 3);
            tmp_schedule.GetTeamLeft().SetScore(Integer.parseInt(str.substring(0, str.indexOf("<") - 1)));

            str = str.substring(str.indexOf("matches__teamscores-side") + "matches__teamscores-side".length() + 3);
            tmp_schedule.GetTeamRight().SetScore(Integer.parseInt(str.substring(0, str.indexOf("<") - 1)));

            str = str.substring(str.indexOf("matches__date") + "matches__date".length() + 3);
            tmp_hour = Integer.parseInt(str.substring(0, str.indexOf(":")));
            tmp_min = Integer.parseInt(str.substring(str.indexOf(":") + 1, str.indexOf(" ")));
            LocalTime tmp_time = LocalTime.of(tmp_hour, tmp_min);
            ZonedDateTime tmp_datetime = ZonedDateTime.of(tmp_date, tmp_time, ZoneId.of("Asia/Seoul"));

            str = str.substring(str.indexOf("swap-text__target") + "swap-text__target".length() + 2);
            tmp_schedule.GetTeamRight().SetName(str.substring(0, str.indexOf("<")));

            tmp_schedule.SetDate(tmp_datetime);


            result.add(tmp_schedule);
        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<Schedule> ParseSoccerResult(String str){
        List<Schedule> result = new ArrayList<Schedule>();

        LocalDate tmp_date = LocalDate.now();
        int tmp_year = 0, tmp_day = 0, tmp_month = 0, tmp_hour = 0, tmp_min = 0;

        while(str.contains("swap-text__target")){
            if(str.substring(str.indexOf("swap-text__target") + "swap-text__target".length()).indexOf("</span>") > 30){
                str = str.substring(str.indexOf("swap-text__target"));
                str = str.substring(str.indexOf("</a>"));
                continue;
            }

            if(str.contains("fixres__header1")){
                if (str.contains("fixres__header2")) {
                    if (str.indexOf("fixres__header1") < str.indexOf("fixres__header2")) {
                        String tmp_str = str.substring(str.indexOf("fixres__header1") + "fixres__header1".length() + 2);

                        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

                        for (int i = 0; i < 12; i++) {
                            if (months[i].compareTo(tmp_str.substring(0, tmp_str.indexOf(" "))) == 0) {
                                tmp_month = i + 1;
                                break;
                            }
                        }

                        tmp_year = Integer.parseInt(tmp_str.substring(tmp_str.indexOf(" ") + 1, tmp_str.indexOf("<")));
                    }
                }
            }

            if(str.contains("fixres__header2")){
                String tmp_str = str.substring(str.indexOf("fixres__header2"));
                tmp_str = tmp_str.substring(tmp_str.indexOf("fixres__header2") + "fixres__header2".length() + 2, tmp_str.indexOf("<"));
                tmp_str = tmp_str.substring(tmp_str.indexOf(" ") + 1);
                tmp_str = tmp_str.substring(0, tmp_str.indexOf(" "));
                tmp_day = Integer.parseInt(tmp_str.replaceAll("[^0-9]",""));
                tmp_date = LocalDate.of(tmp_year, tmp_month, tmp_day);

                System.out.println(tmp_date);
            }

            Schedule tmp_schedule = new Schedule();

            str = str.substring(str.indexOf("data-status=") + "data-status=".length());

            if(str.substring(1, str.indexOf(">") - 1).compareTo("IP") == 0){
                tmp_schedule.SetIsPlaying(true);
            }else{
                tmp_schedule.SetIsPlaying(false);
            }

            str = str.substring(str.indexOf("swap-text__target") + "swap-text__target".length() + 2);
            tmp_schedule.GetTeamLeft().SetName(str.substring(0, str.indexOf("<")));

            str = str.substring(str.indexOf("matches__teamscores-side") + "matches__teamscores-side".length() + 3);
            tmp_schedule.GetTeamLeft().SetScore(Integer.parseInt(str.substring(0, str.indexOf("<") - 1)));

            str = str.substring(str.indexOf("matches__teamscores-side") + "matches__teamscores-side".length() + 3);
            tmp_schedule.GetTeamRight().SetScore(Integer.parseInt(str.substring(0, str.indexOf("<") - 1)));

            str = str.substring(str.indexOf("matches__date") + "matches__date".length() + 3);
            tmp_hour = Integer.parseInt(str.substring(0, str.indexOf(":")));
            tmp_min = Integer.parseInt(str.substring(str.indexOf(":") + 1, str.indexOf(" ")));
            LocalTime tmp_time = LocalTime.of(tmp_hour, tmp_min);
            ZonedDateTime tmp_datetime = ZonedDateTime.of(tmp_date, tmp_time, ZoneId.of("Asia/Seoul"));

            str = str.substring(str.indexOf("swap-text__target") + "swap-text__target".length() + 2);
            tmp_schedule.GetTeamRight().SetName(str.substring(0, str.indexOf("<")));

            tmp_schedule.SetDate(tmp_datetime);

            if(tmp_schedule.GetDate().isBefore(ZonedDateTime.now().minusMonths(3))){
                break;
            }

            result.add(tmp_schedule);
        }
        return result;
    }
}
