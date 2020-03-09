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
    
    public QualsMatch (int matchNumber, int red1, int red2, int red3, int blue1, int blue2, int blue3, int realRedScore, int realBlueScore) {
        super(red1, red2, red3, blue1, blue2, blue3, realRedScore, realBlueScore);
        this.matchNumber = matchNumber;
    }
    
    public String toString(){
        return "Q-" + matchNumber;
    }
}
