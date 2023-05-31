package Entities;
import SubClases.*;
import java.io.Serializable;
/**
 *
 * @author IceCreamSandwich
 */
public class Team implements Serializable {
    private String teamName;
    private int score;
    private Player []players; //has a
    public Team(String teamName, int score,Player[]players) {
        this.teamName = teamName;
        this.score = score;
        this.players = null;
    }

    public Team() {
        this.teamName = "------";
        this.score = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
    
}
