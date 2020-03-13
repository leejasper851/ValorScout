package valorscout;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel Diaz
 */
public class TestSheet {
    
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        Team t = new Team(400, "cool");
        t.addTeamStat(1, new MatchStat());
        t.addTeamStat(2, new MatchStat());
        t.addTeamStat(3, new MatchStat());
        t.addTeamStat(4, new MatchStat());
        
        TreeMap<Integer, Team> map = new TreeMap<>();
        map.put(400, t);
        
        //SheetsAndJava.writeToSheet(map);
        TreeMap<Integer, Team> teams = SheetsAndJava.readFromSheet();
        
        for(Integer teamNumber: teams.keySet()) {
            System.out.println(teamNumber);
        }
        
        //SheetsAndJava.write();
    }
    
}
