package com.example.swproject;

public class MyParser {
    static SoccerTeam[] ParseSoccerRanking(String str){
        SoccerTeam [] result = new SoccerTeam[20];

        for(int i =0; i<20;i++){
            result[i] = new SoccerTeam();
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
}
