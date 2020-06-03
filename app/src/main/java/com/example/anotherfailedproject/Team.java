package com.example.anotherfailedproject;

import java.util.List;

public class Team {
    public String TeamName;
    public List<Player> TeamPlayerList;
    public boolean[] doneList;
    public boolean TeamDone;

    public Team(String teamName, List<Player> teamPlayerList) {
        TeamName = teamName;
        TeamPlayerList = teamPlayerList;
        TeamDone = false;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public List<Player> getTeamPlayerList() {
        return TeamPlayerList;
    }

    public void setTeamPlayerList(List<Player> teamPlayerList) {
        TeamPlayerList = teamPlayerList;
    }

    public String printPlayers()
    {
        String Players ="";
        for(int i = 0; i < TeamPlayerList.size(); i++)
        {
            Players = Players.concat(TeamPlayerList.get(i).getPlayerName()+"\n");
        }
        return Players;
    }

    public boolean isTeamDone()
    {
        for (int i = 0; i < doneList.length; i++)
        {
            if (!doneList[i]) return TeamDone = false;
        }
        return TeamDone = true;
    }
}
