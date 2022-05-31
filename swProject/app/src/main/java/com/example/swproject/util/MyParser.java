package com.example.swproject.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.swproject.data.BaseballData;
import com.example.swproject.data.Schedule;
import com.example.swproject.data.SoccerData;

import org.jsoup.Connection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
        List<Schedule> result = new ArrayList<>();

        LocalDate tmp_date = LocalDate.now();
        int tmp_year = 0, tmp_day, tmp_month = 0, tmp_hour, tmp_min;

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

                        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

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
            }

            Schedule tmp_schedule = new Schedule();

            str = str.substring(str.indexOf("data-status=") + "data-status=".length());

            tmp_schedule.SetIsPlaying(str.substring(1, str.indexOf(">") - 1).compareTo("IP") == 0);

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
        List<Schedule> result = new ArrayList<>();

        LocalDate tmp_date = LocalDate.now();
        int tmp_year = 0, tmp_day, tmp_month = 0, tmp_hour, tmp_min;

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

                        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

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
            }

            Schedule tmp_schedule = new Schedule();

            str = str.substring(str.indexOf("data-status=") + "data-status=".length());

            tmp_schedule.SetIsPlaying(str.substring(1, str.indexOf(">") - 1).compareTo("IP") == 0);

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

    public static SoccerData.LiveData ParseSoccerLiveData(String str){
       SoccerData.LiveData result = new SoccerData.LiveData();

       str = str.substring(str.indexOf("widget-match-header__name--full"));

       result.GetTeamLeft().SetName(str.substring(str.indexOf(">") + 1, str.indexOf("<")));

       str = str.substring(str.indexOf("<span data-slot=\"score\">") + "<span data-slot=\"score\">".length());

       result.GetTeamLeft().SetScore(Integer.parseInt(str.substring(0, str.indexOf(" "))));

       str = str.substring(str.indexOf("-") + 2);

       result.GetTeamRight().SetScore(Integer.parseInt(str.substring(0, str.indexOf("<"))));

       str = str.substring(str.indexOf("widget-match-header__name--full"));

       result.GetTeamRight().SetName(str.substring(str.indexOf(">") + 1, str.indexOf("<")));

       str = str.substring(str.indexOf("점유율"));

       result.GetTeamLeft().SetPossession(Integer.parseInt(str.substring(str.indexOf("lbl lbl-home") + "lbl lbl-home".length() + 9, str.indexOf("%"))));

       str = str.substring(str.indexOf("lbl lbl-away"));

       result.GetTeamRight().SetPossession(Integer.parseInt(str.substring(str.indexOf("lbl lbl-away") + "lbl lbl-away".length() + 9, str.indexOf("%"))));

       str = str.substring(str.indexOf("value-home"));

       result.GetTeamLeft().SetMissedShot(Integer.parseInt(str.substring(str.indexOf("value-home") + "value-home".length() + 2, str.indexOf("<"))));

       str = str.substring(str.indexOf("value-away"));

       result.GetTeamRight().SetMissedShot(Integer.parseInt(str.substring(str.indexOf("value-away") + "value-away".length() + 2, str.indexOf("<"))));

       str = str.substring(str.indexOf("value-home"));

       result.GetTeamLeft().SetOnTargetShot(Integer.parseInt(str.substring(str.indexOf("value-home") + "value-home".length() + 2, str.indexOf("<"))));

       str = str.substring(str.indexOf("value-away"));

       result.GetTeamRight().SetOnTargetShot(Integer.parseInt(str.substring(str.indexOf("value-away") + "value-away".length() + 2, str.indexOf("<"))));

       str = str.substring(str.indexOf("value-home"));

       result.GetTeamLeft().SetTotalPass(Integer.parseInt(str.substring(str.indexOf("value-home") + "value-home".length() + 2, str.indexOf("<"))));

       str = str.substring(str.indexOf("value-away"));

       result.GetTeamRight().SetTotalPass(Integer.parseInt(str.substring(str.indexOf("value-away") + "value-away".length() + 2, str.indexOf("<"))));

       return result;
    }

    public static BaseballData.Team[] ParseBaseballTeamRanking(String str){
        BaseballData.Team[] result = new BaseballData.Team[10];

        for(int i =0; i<10;i++){
            result[i] = new BaseballData.Team();
        }

        for(int i =0; i<10; i++){
            str = str.substring(str.indexOf("\"teamName\":\"") + "\"teamName\":\"".length());

            result[i].SetName(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"winDiff\":") + "\"winDiff\":".length());

            result[i].SetWinDiff(str.substring(0, str.indexOf(",")));

            str = str.substring(str.indexOf("\"gameCount\":") + "\"gameCount\":".length());

            result[i].SetGame(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"wra\":") + "\"wra\":".length());

            result[i].SetWinRate(str.substring(0, str.indexOf(",")));

            str = str.substring(str.indexOf("\"teamCode\":\"") + "\"teamCode\":\"".length());

            result[i].SetTeamCode(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"streak\":\"") + "\"streak\":\"".length());

            result[i].SetStreak(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"bra\":") + "\"bra\":".length());

            result[i].SetOnBasePercentage(str.substring(0, str.indexOf(",")));

            str = str.substring(str.indexOf("\"lost\":") + "\"lost\":".length());

            result[i].SetLost(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"won\":") + "\"won\":".length());

            result[i].SetWon(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"rank\":") + "\"rank\":".length());

            result[i].SetRank(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"lra\":") + "\"lra\":".length());

            result[i].SetSluggingPercentage(str.substring(0, str.indexOf(",")));

            str = str.substring(str.indexOf("\"recentResult\":\"") + "\"recentResult\":\"".length());

            result[i].SetLastResult(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"drawn\":") + "\"drawn\":".length());

            result[i].SetDrawn(Integer.parseInt(str.substring(0, str.indexOf("}"))));
        }

        return result;
    }

    public static BaseballData.Pitcher[] ParseBaseballPitcherRanking(String str){
        BaseballData.Pitcher[] result = new BaseballData.Pitcher[20];

        for(int i =0; i<20;i++){
            result[i] = new BaseballData.Pitcher();
        }

        for(int i =0 ; i<20; i++){
            str = str.substring(str.indexOf("\"pa_kk_rt\":\"") + "\"pa_kk_rt\":\"".length());

            result[i].SetStrikeOutPerPlateAppearances(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"kk_bb_rt\":\"") + "\"kk_bb_rt\":\"".length());

            result[i].SetStrikeOutPerBaseOnBalls(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"hp\":") + "\"hp\":".length());

            result[i].SetDeadBall(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"hr\":") + "\"hr\":".length());

            result[i].SetHomeRun(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"hold\":") + "\"hold\":".length());

            result[i].SetHold(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"whip\":\"") + "\"whip\":\"".length());

            result[i].SetWhip(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"hit\":") + "\"hit\":".length());

            result[i].SetHit(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"innk\":\"") + "\"innk\":\"".length());

            result[i].SetStrikeOutPerNineInnings(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"era\":\"") + "\"era\":\"".length());

            result[i].SetEarnedRunAverage(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"rank\":") + "\"rank\":".length());

            result[i].SetRank(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"kk\":") + "\"kk\":".length());

            result[i].SetStrikeOut(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"sv\":") + "\"sv\":".length());

            result[i].SetSave(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"winp\":\"") + "\"winp\":\"".length());

            result[i].SetWinRate(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"inn\":\"") + "\"inn\":\"".length());

            result[i].SetInnings(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"innb\":\"") + "\"innb\":\"".length());

            result[i].SetBaseOnBallsPerNineInnings(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"war\":\"") + "\"war\":\"".length());

            result[i].SetWar(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"wpa\":\"") + "\"wpa\":\"".length());

            result[i].SetWpa(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"team\":\"") + "\"team\":\"".length());

            result[i].SetTeam(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"l\":") + "\"l\":".length());

            result[i].SetLost(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"game_count\":") + "\"game_count\":".length());

            result[i].SetGame(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"r\":") + "\"r\":".length());

            result[i].SetRuns(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"w\":") + "\"w\":".length());

            result[i].SetWon(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"name\":\"") + "\"name\":\"".length());

            result[i].SetName(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"pa_bb_rt\":\"") + "\"pa_bb_rt\":\"".length());

            result[i].SetBaseOnBallsPerPlateAppearances(str.substring(0, str.indexOf("\"")));
        }

        return result;
    }

    public static BaseballData.Batter[] ParseBaseballBatterRanking(String str){
        BaseballData.Batter[] result = new BaseballData.Batter[20];

        for(int i =0; i<20;i++){
            result[i] = new BaseballData.Batter();
        }

        for(int i =0 ; i<20; i++){
            str = str.substring(str.indexOf("\"wrc_plus\":\"") + "\"wrc_plus\":\"".length());

            result[i].SetWrcPlus(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"hr\":") + "\"hr\":".length());

            result[i].SetHomeRun(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"run\":") + "\"run\":".length());

            result[i].SetRun(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"h2\":") + "\"h2\":".length());

            result[i].SetHit2(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"h3\":") + "\"h3\":".length());

            result[i].SetHit3(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"sb\":") + "\"sb\":".length());

            result[i].SetStolenBase(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"hit\":") + "\"hit\":".length());

            result[i].SetHit(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"hra\":\"") + "\"hra\":\"".length());

            result[i].SetHitRate(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"rank\":") + "\"rank\":".length());

            result[i].SetRank(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"kk\":") + "\"kk\":".length());

            result[i].SetStrikeOut(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"woba\":\"") + "\"woba\":\"".length());

            result[i].SetWoba(str.substring(0, str.indexOf(",")));

            str = str.substring(str.indexOf("\"ab\":") + "\"ab\":".length());

            result[i].SetAtBat(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"wpa\":\"") + "\"wpa\":\"".length());

            result[i].SetWpa(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"war\":\"") + "\"war\":\"".length());

            result[i].SetWar(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"team\":\"") + "\"team\":\"".length());

            result[i].SetTeam(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"slg\":\"") + "\"slg\":\"".length());

            result[i].SetSluggingPercentage(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"game_count\":") + "\"game_count\":".length());

            result[i].SetGame(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"ops\":\"") + "\"ops\":\"".length());

            result[i].SetOps(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"name\":\"") + "\"name\":\"".length());

            result[i].SetName(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"rbi\":") + "\"rbi\":".length());

            result[i].SetRunBattedIn(Integer.parseInt(str.substring(0, str.indexOf(","))));

            str = str.substring(str.indexOf("\"babip\":\"") + "\"babip\":\"".length());

            result[i].SetBabip(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"isop\":\"") +  "\"isop\":\"".length());

            result[i].SetIsop(str.substring(0, str.indexOf("\"")));

            str = str.substring(str.indexOf("\"obp\":\"") +"\"obp\":\"".length());

            result[i].SetOnBasePercentage(str.substring(0, str.indexOf("\"")));
        }

        return result;
    }

    public static BaseballData.DetailedRanking[] ParseBaseballDetailedRanking(String str){
        BaseballData.DetailedRanking[] result = new BaseballData.DetailedRanking[12];

        for(int i =0; i< 12;i ++){
            result[i] = new BaseballData.DetailedRanking();
        }

        str = str.substring(str.indexOf("pitcher") + "pitcher".length());

        for(int i = 0; i < 4; i++){
            str = str.substring(str.indexOf("\"title\">") + "\"title\">".length());

            result[i].SetName(str.substring(0, str.indexOf("<")));
        }

        for(int i =0; i< 4; i ++){
            BaseballData.DetailedRanking.Player[] players = new BaseballData.DetailedRanking.Player[5];

            for(int k = 0; k < 5; k++){
                players[k] = new BaseballData.DetailedRanking.Player();
            }

            for(int j = 0; j < 5; j++){
                str = str.substring(str.indexOf("\"ord\">") + "\"ord\">".length());

                players[j].SetRank(Integer.parseInt(str.substring(0, str.indexOf("<"))));

                str = str.substring(str.indexOf("<strong>") + "<strong>".length());

                players[j].SetName(str.substring(0, str.indexOf("<")));

                str = str.substring(str.indexOf("\"team\">") + "\"team\">".length());

                players[j].SetTeam(str.substring(0, str.indexOf("<")));

                str = str.substring(str.indexOf("<em>") + "<em>".length());

                players[j].SetRecord(str.substring(0, str.indexOf("<")));
            }

            result[i].SetPlayers(players);
        }

        str = str.substring(str.indexOf("hitter") + "hitter".length());

        for(int i = 4; i < 8; i++){
            str = str.substring(str.indexOf("\"title\">") + "\"title\">".length());

            result[i].SetName(str.substring(0, str.indexOf("<")));
        }

        for(int i =4; i< 8; i ++){
            BaseballData.DetailedRanking.Player[] players = new BaseballData.DetailedRanking.Player[5];

            for(int k = 0; k < 5; k++){
                players[k] = new BaseballData.DetailedRanking.Player();
            }

            for(int j = 0; j < 5; j++){
                str = str.substring(str.indexOf("\"ord\">") + "\"ord\">".length());

                players[j].SetRank(Integer.parseInt(str.substring(0, str.indexOf("<"))));

                str = str.substring(str.indexOf("<strong>") + "<strong>".length());

                players[j].SetName(str.substring(0, str.indexOf("<")));

                str = str.substring(str.indexOf("\"team\">") + "\"team\">".length());

                players[j].SetTeam(str.substring(0, str.indexOf("<")));

                str = str.substring(str.indexOf("<em>") + "<em>".length());

                players[j].SetRecord(str.substring(0, str.indexOf("<")));
            }

            result[i].SetPlayers(players);
        }


        str = str.substring(str.indexOf("etc") + "etc".length());

        for(int i = 8; i < 12; i++){
            str = str.substring(str.indexOf("\"title\">") + "\"title\">".length());

            result[i].SetName(str.substring(0, str.indexOf("<")));
        }

        for(int i =8; i< 12; i ++){
            BaseballData.DetailedRanking.Player[] players = new BaseballData.DetailedRanking.Player[5];

            for(int k = 0; k < 5; k++){
                players[k] = new BaseballData.DetailedRanking.Player();
            }

            for(int j = 0; j < 5; j++){
                str = str.substring(str.indexOf("\"ord\">") + "\"ord\">".length());

                players[j].SetRank(Integer.parseInt(str.substring(0, str.indexOf("<"))));

                str = str.substring(str.indexOf("<strong>") + "<strong>".length());

                players[j].SetName(str.substring(0, str.indexOf("<")));

                str = str.substring(str.indexOf("\"team\">") + "\"team\">".length());

                players[j].SetTeam(str.substring(0, str.indexOf("<")));

                str = str.substring(str.indexOf("<em>") + "<em>".length());

                players[j].SetRecord(str.substring(0, str.indexOf("<")));
            }

            result[i].SetPlayers(players);
        }

        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static List<Schedule> ParseBaseballSchedule(String str, int tmp_year){
        List<Schedule> result = new ArrayList<>();

        LocalDate tmp_date = LocalDate.now();
        int tmp_day, tmp_month = 0, tmp_hour, tmp_min;

        while(str.contains("td_date")){
            str = str.substring(str.indexOf("\"td_date\"><strong>") + "\"td_date\"><strong>".length());

            tmp_month = Integer.parseInt(str.substring(0, str.indexOf(".")));
            tmp_day = Integer.parseInt(str.substring(str.indexOf(".") + 1, str.indexOf("<")));

            tmp_date = LocalDate.of(tmp_year, tmp_month, tmp_day);

            while(str.contains("td_hour")){
                str = str.substring(str.indexOf("\"td_hour\">") + "\"td_hour\">".length());

                if(str.substring(0, str.indexOf("<")).length() == 1)
                    break;

                tmp_hour = Integer.parseInt(str.substring(0, str.indexOf(":")));
                tmp_min = Integer.parseInt(str.substring(str.indexOf(":") + 1, str.indexOf("<")));

                Schedule tmp_schedule = new Schedule();


                //경기 진행 중 여부는 경기 진행 중일 때 구현예정 tmp_schedule.SetIsPlaying();

                str = str.substring(str.indexOf("\"team_lft\">") + "\"team_lft\">".length());
                tmp_schedule.GetTeamLeft().SetName(str.substring(0, str.indexOf("<")));

                str = str.substring(str.indexOf("\"td_score\">") + "\"td_score\">".length());

                if(str.indexOf("cancel") < 600 && str.contains("cancel"))
                    tmp_schedule.SetIsCanceled(true);

                if(str.indexOf("<") != 0){
                    tmp_schedule.GetTeamLeft().SetScore(Integer.parseInt(str.substring(0, str.indexOf("<"))));

                    str = str.substring(str.indexOf("</em>") + "</em>".length());
                    tmp_schedule.GetTeamRight().SetScore(Integer.parseInt(str.substring(0, str.indexOf("<"))));

                    str = str.substring(str.indexOf("\"team_rgt\">") + "\"team_rgt\">".length());
                    tmp_schedule.GetTeamRight().SetName(str.substring(0, str.indexOf("<")));

                    str = str.substring(str.indexOf("\"td_stadium\"> ") + "\"td_stadium\"> ".length());
                    if(str.indexOf("<") < 2){
                        tmp_schedule.SetBroadcast("없음");
                    }else{
                        tmp_schedule.SetBroadcast(str.substring(0, str.indexOf("<") - 1));
                    }

                    str = str.substring(str.indexOf("\"td_stadium\">") + "\"td_stadium\">".length());
                    tmp_schedule.SetStadium(str.substring(0, str.indexOf("<")));
                }else{
                    str = str.substring(str.indexOf("\"team_rgt\">") + "\"team_rgt\">".length());
                    tmp_schedule.GetTeamRight().SetName(str.substring(0, str.indexOf("<")));

                   if(str.indexOf("cancel") < 600 && str.contains("cancel")) {
                       tmp_schedule.SetIsCanceled(true);

                       str = str.substring(str.indexOf("\"td_stadium\">") + "\"td_stadium\">".length());
                       tmp_schedule.SetStadium(str.substring(0, str.indexOf("<")));
                   }
                }



                LocalTime tmp_time = LocalTime.of(tmp_hour, tmp_min);
                ZonedDateTime tmp_datetime = ZonedDateTime.of(tmp_date, tmp_time, ZoneId.of("Asia/Seoul"));

                tmp_schedule.SetDate(tmp_datetime);

                result.add(tmp_schedule);

                if(str.contains("td_date") && str.contains("td_hour")){
                    if(str.indexOf("td_date") < str.indexOf("td_hour"))
                        break;
                }
            }
        }
        return result;

    }
}
