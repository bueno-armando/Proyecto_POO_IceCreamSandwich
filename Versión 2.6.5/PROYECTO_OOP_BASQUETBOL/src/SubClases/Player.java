package SubClases;
import Entities.*;
import java.io.Serializable;

/**
 *
 * @author IceCreamSandwich
 */
public class Player extends Persona implements Serializable, PrintInfo{
    private String position;
    private int number;
    Statistics stats = new Statistics();

    public Player() {
     
     super();
        this.stats.setPoints(0);
        this.stats.setAssists(0);
        this.stats.setRebounds(0);
        this.stats.setBlocks(0);
        this.stats.setFouls(0) ;
    }

    public Player(String name, String lastName, int age, String position, int number, int points, int assists, int rebounds, int blocks, int fouls) {
        super(name, lastName, age);
        this.position = position;
        this.number = number;
        this.stats.setPoints(points);
        this.stats.setAssists(assists);
        this. stats.setRebounds(rebounds);
        this.stats.setBlocks(blocks);
        this. stats.setFouls(fouls);
    }
    
    
    public Statistics getStats() {
        return stats;
    }
   
    public void setStats(Statistics stats) {
        this.stats = stats;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void printData() {
 System.out.println("Nombre: "+getName());
        System.out.println("Apellido: "+getLastName());
        System.out.println("Edad: "+getAge());
        System.out.println("Posicion: "+getPosition());
        System.out.println("Numero: "+getNumber());
        System.out.println("ESTADITICAS\n");
        System.out.println("Pts: "+ stats.getPoints());
        System.out.println("Ast: "+ stats.getAssists());
        System.out.println("Rbn: "+stats.getRebounds());
        System.out.println("Blks: "+stats.getBlocks() );
        System.out.println("Fouls: "+ stats.getFouls());
    }

    @Override
    public void printStats() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
