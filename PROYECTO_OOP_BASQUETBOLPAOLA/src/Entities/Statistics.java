package Entities;

import java.util.InputMismatchException;
import java.util.Scanner;
import static proyecto_oop_basquetbol.PROYECTO_OOP_BASQUETBOL.addTeam;

/**
 *
 * @author IceCreamSandwich
 */
public class Statistics {
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
        this.points = 0;
        this.assists = 0;
        this.rebounds = 0;
        this.blocks = 0;
        this.fouls = 0;
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

    

