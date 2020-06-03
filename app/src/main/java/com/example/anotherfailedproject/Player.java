package com.example.anotherfailedproject;

public class Player implements Comparable<Player>{

    String playerName;
    String key;
    int wins;
    int games;
    int half;
    int points;
    int looses;
    double quote;

    public Player() {
    }

    public Player(String playerName, String key, int wins, int games, int half, int points, int looses, double quote) {
        this.playerName = playerName;
        this.key = key;
        this.wins = wins;
        this.games = games;
        this.half = half;
        this.points = points;
        this.looses = looses;
        this.quote = quote;
    }
    public Player(String playerName)
    {
        this.playerName = playerName;
        this.key = "key";
        this.wins = 0;
        this.games = 0;
        this.half = 0;
        this.points = 0;
        this.looses = 0;
        this.quote = 0;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getHalf() {
        return half;
    }

    public void setHalf(int half) {
        this.half = half;
    }

    public int getLooses() {
        return looses;
    }

    public void setLooses(int looses) {
        this.looses = looses;
    }

    public double getQuote() {
        return quote;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }

    @Override
    public int compareTo(Player o) {

        if(this.getQuote()<o.getQuote())
            return -1;
        else if(o.getQuote()<this.getQuote())
            return 1;
        return 0;
    }
}
