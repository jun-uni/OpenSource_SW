package com.example.swproject.util;

import com.example.swproject.data.SoccerData;

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
}
