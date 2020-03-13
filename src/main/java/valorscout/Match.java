package valorscout;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee_934859
 */
public abstract class Match implements Serializable {
    private int red1;
    private int red2;
    private int red3;
    private int blue1;
    private int blue2;
    private int blue3;
    private int red1Score;
    private int red2Score;
    private int red3Score;
    private int blue1Score;
    private int blue2Score;
    private int blue3Score;
    private int scoutRedScore;
    private int scoutBlueScore;
    private int realRedScore;
    private int realBlueScore;

    public Match(int red1, int red2, int red3, int blue1, int blue2, int blue3, int realRedScore, int realBlueScore) {
        this.red1 = red1;
        this.red2 = red2;
        this.red3 = red3;
        this.blue1 = blue1;
        this.blue2 = blue2;
        this.blue3 = blue3;
        this.realRedScore = realRedScore;
        this.realBlueScore = realBlueScore;
        
        red1Score = 0;
        red2Score = 0;
        red3Score = 0;
        blue1Score = 0;
        blue2Score = 0;
        blue3Score = 0;
        scoutRedScore = 0;
        scoutBlueScore = 0;
    }

    public int getRed1() {
        return red1;
    }

    public int getRed2() {
        return red2;
    }

    public int getRed3() {
        return red3;
    }

    public int getBlue1() {
        return blue1;
    }

    public int getBlue2() {
        return blue2;
    }

    public int getBlue3() {
        return blue3;
    }

    public int getRed1Score() {
        return red1Score;
    }

    public void setRed1Score(int red1Score) {
        this.red1Score = red1Score;
    }

    public int getRed2Score() {
        return red2Score;
    }

    public void setRed2Score(int red2Score) {
        this.red2Score = red2Score;
    }

    public int getRed3Score() {
        return red3Score;
    }

    public void setRed3Score(int red3Score) {
        this.red3Score = red3Score;
    }

    public int getBlue1Score() {
        return blue1Score;
    }

    public void setBlue1Score(int blue1Score) {
        this.blue1Score = blue1Score;
    }

    public int getBlue2Score() {
        return blue2Score;
    }

    public void setBlue2Score(int blue2Score) {
        this.blue2Score = blue2Score;
    }

    public int getBlue3Score() {
        return blue3Score;
    }

    public void setBlue3Score(int blue3Score) {
        this.blue3Score = blue3Score;
    }

    public int getScoutRedScore() {
        return scoutRedScore;
    }

    public void setScoutRedScore(int scoutRedScore) {
        this.scoutRedScore = scoutRedScore;
    }

    public int getScoutBlueScore() {
        return scoutBlueScore;
    }

    public void setScoutBlueScore(int scoutBlueScore) {
        this.scoutBlueScore = scoutBlueScore;
    }

    public int getRealRedScore() {
        return realRedScore;
    }

    public void setRealRedScore(int realRedScore) {
        this.realRedScore = realRedScore;
    }

    public int getRealBlueScore() {
        return realBlueScore;
    }

    public void setRealBlueScore(int realBlueScore) {
        this.realBlueScore = realBlueScore;
    }
    
    public void updateScore(int team, int score) {
        if (team == red1) {
            red1Score = score;
        }
        if (team == red2) {
            red2Score = score;
        }
        if (team == red3) {
            red3Score = score;
        }
        if (team == blue1) {
            blue1Score = score;
        }
        if (team == blue2) {
            blue2Score = score;
        }
        if (team == blue3) {
            blue3Score = score;
        }
        
        updateTotalScores();
    }

    public void updateMatchScores(int red1Score, int red2Score, int red3Score, int blue1Score, int blue2Score, int blue3Score) {
        this.red1Score = red1Score;
        this.red2Score = red2Score;
        this.red3Score = red3Score;
        this.blue1Score = blue1Score;
        this.blue2Score = blue2Score;
        this.blue3Score = blue3Score;
    }
    
    
    
    private void updateTotalScores() {
        scoutRedScore = red1Score + red2Score + red3Score;
        scoutBlueScore = blue1Score + blue2Score + blue3Score;
    }
}
