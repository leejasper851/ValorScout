/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee_934859
 */
public class QualsMatch extends Match {
    
    private int matchNumber;
    
    public QualsMatch (int matchNumber, Team red1, Team red2, Team red3, Team blue1, Team blue2, Team blue3) {
        super(red1, red2, red3, blue1, blue2, blue3);
        this.matchNumber = matchNumber;
    }
    
    public String toString(){
        return "";
    }
}
