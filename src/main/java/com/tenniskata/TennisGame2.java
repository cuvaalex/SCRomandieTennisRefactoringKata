package com.tenniskata;

public class TennisGame2 implements TennisGame
{
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String LOVE = "Love";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";
    public static final String ALL = "-All";
    public Player player1;
    public Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore(){
        String score = "";
        if (isPlayersScoreEquals() && player1Score() < 4)
        {
            if (player1Score()==0)
                score = LOVE;
            if (player1Score()==1)
                score = FIFTEEN;
            if (player1Score()==2)
                score = THIRTY;
            score += ALL;
        }
        if (isPlayersScoreEquals() && player1Score()>=3)
            score = DEUCE;

        if (player1Score() > 0 && player2Score()==0)
        {
            if (player1Score()==1)
                player1GivenScore(FIFTEEN);
            if (player1Score()==2)
                player1GivenScore(THIRTY);
            if (player1Score()==3)
                player1GivenScore(FORTY);

            player2GivenScore(LOVE);
            score = getJoinScore();
        }
        if (player2Score() > 0 && player1Score()==0)
        {
            if (player2Score()==1)
                player2GivenScore(FIFTEEN);
            if (player2Score()==2)
                player2GivenScore(THIRTY);
            if (player2Score()==3)
                player2GivenScore(FORTY);

            player1GivenScore(LOVE);
            score = getJoinScore();
        }

        if (player1Score()>player2Score() && player1Score() < 4)
        {
            if (player1Score()==2)
                player1GivenScore(THIRTY);
            if (player1Score()==3)
                player1GivenScore(FORTY);
            if (player2Score()==1)
                player2GivenScore(FIFTEEN);
            if (player2Score()==2)
                player2GivenScore(THIRTY);
            score = getJoinScore();
        }
        if (player2Score()>player1Score() && player2Score() < 4)
        {
            if (player2Score()==2)
                player2GivenScore(THIRTY);
            if (player2Score()==3)
                player2GivenScore(FORTY);
            if (player1Score()==1)
                player1GivenScore(FIFTEEN);
            if (player1Score()==2)
                player1GivenScore(THIRTY);
            score = getJoinScore();
        }

        if (player1Score() > player2Score() && player2Score() >= 3)
        {
            score = ADVANTAGE_PLAYER_1;
        }

        if (player2Score() > player1Score() && player1Score() >= 3)
        {
            score = ADVANTAGE_PLAYER_2;
        }

        if (player1Score()>=4 && player2Score()>=0 && (player1Score()-player2Score())>=2)
        {
            score = WIN_FOR_PLAYER_1;
        }
        if (player2Score()>=4 && player1Score()>=0 && (player2Score()-player1Score())>=2)
        {
            score = WIN_FOR_PLAYER_2;
        }
        return score;
    }

    private boolean isPlayersScoreEquals() {
        return player1Score() == player2Score();
    }

    private String getJoinScore() {
        return currentPlayer1Score() + "-" + currentPlayer2Score();
    }

    private String currentPlayer2Score() {
        return this.player2.currentScore();
    }

    private void player2GivenScore(String score) {
        this.player2.giveScore(score);
    }

    private String currentPlayer1Score() {
        return this.player1.currentScore();
    }

    private void player1GivenScore(String score) {
        this.player1.giveScore(score);
    }


    public void P1WinPoint(){
        player1.winpoint();
    }

    private int player1Score(){
        return this.player1.currentPoint();
    }

    private int player2Score(){
        return this.player2.currentPoint();
    }

    public void P2Score(){
        player2.winpoint();
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1WinPoint();

        if (player == "player2")
            P2Score();
    }
}
