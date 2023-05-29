package proyecto_oop_basquetbol;
import Entities.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOL implements Utilities{

    public static void main(String[] args) {
        System.out.println(mainMenu());
        
    }
    public static int mainMenu(){
        do{
            try{
                int x;
                Scanner sc = new Scanner(System.in);
                System.out.print("(1) Nuevo Juego\n");
                System.out.println("(2) Ver Estadisticas");
                x = sc.nextInt();
                switch(x){
                    case 1:
                        System.out.println("Elegiste la 1");
                        return x;
                    case 2:
                        System.out.println("Elegiste la 2");
                        return x;
                    default:
                        System.out.println("Opcion Inexistente");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Input no valido, intenta de nuevo");
            }
        }while(true);         
        
    }

    @Override
    public void time() {
        
    }

    @Override
    public void stats() {
        
    }

    @Override
    public void quarter() {
        
    }

    @Override
    public void endGame() {

    }
 
   
}
