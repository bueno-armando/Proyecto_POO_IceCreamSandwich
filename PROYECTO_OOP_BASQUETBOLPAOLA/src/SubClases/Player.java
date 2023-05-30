package SubClases;
import Entities.*;

/**
 *
 * @author IceCreamSandwich
 */
public class Player extends Persona{
    private String position;
    private int number;

    public Player() {
    }

    public Player(String position, int number, String name, String lastName, int age) {
        super(name, lastName, age);
        this.position = position;
        this.number = number;
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
    
    
}
