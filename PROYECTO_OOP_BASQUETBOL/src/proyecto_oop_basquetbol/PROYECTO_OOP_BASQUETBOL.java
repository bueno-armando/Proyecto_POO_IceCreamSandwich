package proyecto_oop_basquetbol;
import Entities.*;
import SubClases.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOL implements Utilities{
    public static void main(String[] args) {
        System.out.println(mainMenu());
        addPlayer();
        
    }
    public static int mainMenu(){
        int indiceEquipo=0;
        boolean salir = true;
        do{
            try{
                int x;
                
                Scanner sc = new Scanner(System.in);
                System.out.print("(1) Nuevo Juego\n");
                System.out.println("(2) Ver Estadisticas");

                x = sc.nextInt();
                switch(x){
                    case 1:
                        menuAddTeam(indiceEquipo);
                        return x;
                    case 2:
                        System.out.println("VE LA ESTADISTICA");
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
    public static int menuAddTeam(int indiceGlobal){
       
        Team[] numEquipos = new Team[100];
        System.out.println("*****EQUIPO 1*****");
        Scanner sc = new Scanner(System.in);
        do{
            try{
            int opcSelectTeam;
            System.out.println("Selecciona tu equipo "
                          +"(1)Existente"
                          +" (2)Crear Uno");
            opcSelectTeam = sc.nextInt(); 
                switch(opcSelectTeam){
                    case 1:
                        //abrir o desplegar todos los equipos existentes (FILES CHOOSER) ABRIR ARCHIVOS
                        return opcSelectTeam;
                    case 2:
                        System.out.println("Agregar equipo 1");
                        addTeam(indiceGlobal, numEquipos);
                        indiceGlobal++;
                        return opcSelectTeam;
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
    public static void addTeam(int indice, Team[] objEquipo){
        Team CreatedTeam = new Team();//Crear una nueva instancia de Team
        Scanner sc = new Scanner(System.in);
        System.out.println("*****Agregar Equipo*****");
        
        System.out.println("Nombre del equipo");
        String nombreEquipo = sc.nextLine();
        CreatedTeam.setTeamName(nombreEquipo);  
        
        // Asignar el equipo creado al arreglo de equipos en la posición "indice"
        objEquipo[indice]= CreatedTeam;
        System.out.println("Equipo agredado");
        System.out.println("Nombre del equipo"+objEquipo[indice].getTeamName()+"\n");
        
        System.out.println("Agregar jugadores");
        addPlayer();
    }
    public static void addPlayer(){
        Scanner sc = new Scanner(System.in);
        Player [] players = new Player[5];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
            System.out.println("Nombre: ");
            String name =sc.nextLine();
             players[i].setName(name);
             
            System.out.println("Apellido: ");
            String lastName = sc.nextLine();
            players[i].setLastName(lastName);
            
            System.out.println("Número: ");
            int number = sc.nextInt();
            players[i].setNumber(number);
            
            System.out.println("Posición");
            String position = sc.nextLine();
            players[i].setPosition(position);
            System.out.println("********************");
            
        }
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
