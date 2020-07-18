package com.company;

public class SaveScore implements Comparable {
    private String playerName;
    private int playerScore;

    public SaveScore(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    @Override
    public int compareTo(Object o) {
        SaveScore saveScore = (SaveScore) o;
        if (playerScore < saveScore.getPlayerScore()) {
            return 1;
        } else if (playerScore > saveScore.getPlayerScore()) {
            return -1;

        } else {
            return 0;
        }


    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    @Override
    public String toString() {
        return playerName + "," + playerScore;
    }
}
