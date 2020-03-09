/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee_934859
 */
public class MatchStats {
    private boolean crossLine;
    private int autoShieldBottom;
    private int autoShieldTop;
    private int autoShieldInner;
    private int teleShieldBottom;
    private int teleShieldTop;
    private int teleShieldInner;
    private boolean rotControl;
    private boolean posControl;
    private boolean park;
    private boolean hang;
    private boolean level;
    private int host;
    private int penalties;
    private int totalPoints;

    public MatchStats() {
        crossLine = false;
        autoShieldBottom = 0;
        autoShieldTop = 0;
        autoShieldInner = 0;
        teleShieldBottom = 0;
        teleShieldTop = 0;
        teleShieldInner = 0;
        rotControl = false;
        posControl = false;
        park = false;
        hang = false;
        level = false;
        host = 0;
        penalties = 0;
        totalPoints = 0;
    }
    
    
    public MatchStats(boolean crossLine, int autoShieldBottom, int autoShieldTop, int autoShieldInner, int teleShieldBottom, int teleShieldTop, int teleShieldInner, boolean rotControl, boolean posControl, boolean park, boolean hang, boolean level, int host, int penalties) {
        this.crossLine = crossLine;
        this.autoShieldBottom = autoShieldBottom;
        this.autoShieldTop = autoShieldTop;
        this.autoShieldInner = autoShieldInner;
        this.teleShieldBottom = teleShieldBottom;
        this.teleShieldTop = teleShieldTop;
        this.teleShieldInner = teleShieldInner;
        this.rotControl = rotControl;
        this.posControl = posControl;
        this.park = park;
        this.hang = hang;
        this.level = level;
        this.host = host;
        this.penalties = penalties;
        totalPoints = 0;
    }
    
    
    public boolean isCrossLine() {
        return crossLine;
    }

    public void setCrossLine(boolean crossLine) {
        this.crossLine = crossLine;
    }

    public int getAutoShieldBottom() {
        return autoShieldBottom;
    }

    public void setAutoShieldBottom(int autoShieldBottom) {
        this.autoShieldBottom = autoShieldBottom;
    }

    public int getAutoShieldTop() {
        return autoShieldTop;
    }

    public void setAutoShieldTop(int autoShieldTop) {
        this.autoShieldTop = autoShieldTop;
    }

    public int getAutoShieldInner() {
        return autoShieldInner;
    }

    public void setAutoShieldInner(int autoShieldInner) {
        this.autoShieldInner = autoShieldInner;
    }

    public int getTeleShieldBottom() {
        return teleShieldBottom;
    }

    public void setTeleShieldBottom(int teleShieldBottom) {
        this.teleShieldBottom = teleShieldBottom;
    }

    public int getTeleShieldTop() {
        return teleShieldTop;
    }

    public void setTeleShieldTop(int teleShieldTop) {
        this.teleShieldTop = teleShieldTop;
    }

    public int getTeleShieldInner() {
        return teleShieldInner;
    }

    public void setTeleShieldInner(int teleShieldInner) {
        this.teleShieldInner = teleShieldInner;
    }

    public boolean isRotControl() {
        return rotControl;
    }

    public void setRotControl(boolean rotControl) {
        this.rotControl = rotControl;
    }

    public boolean isPosControl() {
        return posControl;
    }

    public void setPosControl(boolean posControl) {
        this.posControl = posControl;
    }

    public boolean isPark() {
        return park;
    }

    public void setPark(boolean park) {
        this.park = park;
    }

    public boolean isHang() {
        return hang;
    }

    public void setHang(boolean hang) {
        this.hang = hang;
    }

    public boolean isLevel() {
        return level;
    }

    public void setLevel(boolean level) {
        this.level = level;
    }

    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }
    
    public int getTotalPoints() {
        totalPoints = (crossLine ? 5 : 0) + autoShieldBottom * 2 + autoShieldTop * 4 + autoShieldInner * 6
                + teleShieldBottom + teleShieldTop * 2 + teleShieldInner * 3
                + (rotControl ? 10 : 0) + (posControl ? 20 : 0)
                + (park ? 5 : 0) + (hang ? 25 : 0) + (level ? 15 : 0) + host * 25
                - penalties;
        return totalPoints;
    }
}