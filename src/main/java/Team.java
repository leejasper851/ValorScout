/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.TreeMap;

/**
 *
 * @author lee_934859
 */
public class Team {
    private int number;
    private String name;
    private int rp;
    private int opr;
    private int dpr;
    private TreeMap<Integer, MatchStat> teamStats;
    
    public Team(int number, String name) {
        this.number = number;
        this.name = name;
        rp = 0;
        opr = 0;
        dpr = 0;
        teamStats = new TreeMap<>();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
    
    public int getRp() {
        return rp;
    }
    
    public void setRp(int rp) {
        this.rp = rp;
    }
    
    public int getOpr() {
        return opr;
    }

    public void setOpr(int opr) {
        this.opr = opr;
    }

    public int getDpr() {
        return dpr;
    }

    public void setDpr(int dpr) {
        this.dpr = dpr;
    }

    public TreeMap<Integer, MatchStat> getTeamStats() {
        return teamStats;
    }

    public void addTeamStat(int matchNum, MatchStat teamStat) {
        teamStats.put(matchNum, teamStat);
    }
    
    public int getAverageScore() {
        int sum = 0;
        int num = 0;
        for (int match : teamStats.keySet()) {
            if (teamStats.get(match).isPlayed()) {
                sum += teamStats.get(match).getTotalPoints();
                num++;
            }
        }
        if (num == 0) {
            return 0;
        }
        return sum / num;
    }
    
    public double getAverageDefense() {
        int sum = 0;
        int num = 0;
        for (int match : teamStats.keySet()) {
            if (teamStats.get(match).isPlayed()) {
                sum += teamStats.get(match).getDefense();
                num++;
            }
        }
        if (num == 0) {
            return 0;
        }
        return ((double) sum) / num;
    }
}