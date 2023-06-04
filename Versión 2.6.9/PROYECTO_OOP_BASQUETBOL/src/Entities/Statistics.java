package Entities;

import java.io.Serializable;

/**
 *
 * @author IceCreamSandwich
 */
public  class Statistics implements Serializable {
    private int points;
    private int assists;
    private int rebounds;
    private int blocks;
    private int fouls;

    public Statistics(int points, int assists, int rebounds, int blocks, int fouls) {
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.blocks = blocks;
        this.fouls = fouls;
    }

    public Statistics() {
        this.points = -1;
        this.assists = -1;
        this.rebounds = -1;
        this.blocks = -1;
        this.fouls = -1;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }
    
    
}
