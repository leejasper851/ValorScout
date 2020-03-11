
import java.io.Serializable;
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
public class EventModel implements Serializable {
    
    private TreeMap<Integer, Team> teams;
    private TreeMap<Integer, QualsMatch> matches;
    private String eventKey;

    public EventModel(TreeMap<Integer, Team> teams, TreeMap<Integer, QualsMatch> matches, String eventKey) {
        this.teams = teams;
        this.matches = matches;
        this.eventKey = eventKey;
    }

    public EventModel() {
        teams = new TreeMap<>();
        matches = new TreeMap<>();
        eventKey = "";
    }

    public TreeMap<Integer, Team> getTeams() {
        return teams;
    }

    public void setTeams(TreeMap<Integer, Team> teams) {
        this.teams = teams;
    }

    public TreeMap<Integer, QualsMatch> getMatches() {
        return matches;
    }

    public void setMatches(TreeMap<Integer, QualsMatch> matches) {
        this.matches = matches;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
