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
    private TreeMap<Integer, MatchStats> teamStats;
    
    public Team(int number, String name) {
        this.number = number;
        this.name = name;
        rp = 0;
        opr = 0;
        dpr = 0;
        teamStats = new TreeMap<>();
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

    public TreeMap<Integer, MatchStats> getTeamStats() {
        return teamStats;
    }

    public void addTeamStat(int matchNum, MatchStats teamStat) {
        teamStats.put(matchNum, teamStat);
    }
}