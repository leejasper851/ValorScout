/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee_934859
 */
public abstract class Match {
    private int red1;
    private int red2;
    private int red3;
    private int blue1;
    private int blue2;
    private int blue3;
    private int redScore1;
    private int redScore2;
    private int redScore3;
    private int blueScore1;
    private int blueScore2;
    private int blueScore3;
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
        
        redScore1 = 0;
        redScore2 = 0;
        redScore3 = 0;
        blueScore1 = 0;
        blueScore2 = 0;
        blueScore3 = 0;
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

    public int getRedScore1() {
        return redScore1;
    }

    public void setRedScore1(int redScore1) {
        this.redScore1 = redScore1;
    }

    public int getRedScore2() {
        return redScore2;
    }

    public void setRedScore2(int redScore2) {
        this.redScore2 = redScore2;
    }

    public int getRedScore3() {
        return redScore3;
    }

    public void setRedScore3(int redScore3) {
        this.redScore3 = redScore3;
    }

    public int getBlueScore1() {
        return blueScore1;
    }

    public void setBlueScore1(int blueScore1) {
        this.blueScore1 = blueScore1;
    }

    public int getBlueScore2() {
        return blueScore2;
    }

    public void setBlueScore2(int blueScore2) {
        this.blueScore2 = blueScore2;
    }

    public int getBlueScore3() {
        return blueScore3;
    }

    public void setBlueScore3(int blueScore3) {
        this.blueScore3 = blueScore3;
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
}
