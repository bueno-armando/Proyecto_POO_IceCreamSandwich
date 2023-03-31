package proyecto_oop_basquetbol;
import Entities.*;
import java.util.Scanner;

/**
 *
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOL {

    public static void main(String[] args) {
        Team team1 = new Team();
        Team team2 = new Team();
        int option=0;
        Scanner sc = new Scanner(System.in);
        
        team1.setTeamName("ITCH II");
        team2.setTeamName("MAZATLÁN");
        
        //match start
        while(option != 4){
            System.out.println("---- OPCIONES -----");
            System.out.println("1. Anotación");
            System.out.println("2. Sustitución");
            System.out.println("3. Registrar estadística");
            System.out.println("4. Acabar Partido");
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    //anotation code
                    break;
                case 2:
                    //substitution code
                    break;
                case 3:
                    //register stat code
                    break;
                case 4:
                    //finish match code
                    break;
                default:
                    break;
            }
        }
        System.out.println("*** MARCADOR FINAL ***");
        System.out.println(team1.getTeamName()+"  "+team1.getScore()+team2.getScore()
                           +"  --  "+team2.getTeamName());
                           
    }
    
}
