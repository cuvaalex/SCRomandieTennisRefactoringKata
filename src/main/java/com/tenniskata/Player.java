package com.tenniskata;

public class Player {

    private String score = "";
    private int point = 0;
    public final String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void winpoint() {
        this.point++;
    }

    public int currentPoint() {
        return this.point;
    }

    public void giveScore(String score) {
        this.score = score;
    }

    public String currentScore() {
        return this.score;
    }
}
