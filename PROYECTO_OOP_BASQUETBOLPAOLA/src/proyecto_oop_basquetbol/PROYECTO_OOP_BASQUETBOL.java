package proyecto_oop_basquetbol;
import Entities.*;
import SubClases.Player;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOL implements Utilities{
    public static void main(String[] args) {
       addStats();
       
    }
    public static int mainMenu(){
        int indiceEquipo=0;
       
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
                        System.out.println("Agregar equipo 2");
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
        System.out.println("Nombre del equipo: "+objEquipo[indice].getTeamName()+"\n");
        
        System.out.println("Agregar jugadores");
        addPlayer();
    }
    public static void addPlayer(){
        Scanner sc = new Scanner(System.in);
        Player [] players = new Player[5];
        for (int i = 0; i < players.length; i++) {
           //ENTRADA DE DATOS DE JUGADOR
            players[i] = new Player();
            System.out.println("Nombre: ");
            String name =sc.nextLine();
             players[i].setName(name);
             
            System.out.println("Apellido: ");
            String lastName = sc.nextLine();
            players[i].setLastName(lastName);
            
             System.out.println("Posición");
            String position = sc.nextLine();
            players[i].setPosition(position);
            
          
          boolean validInput=false;
           do{
              try{
               System.out.println("Número: ");
                 int number = sc.nextInt();
                players[i].setNumber(number);
                 validInput = true;
               }catch(InputMismatchException ex){
                  System.out.println("Entrada de datos incorrecta");
               sc.nextLine();
               }
           }while(!validInput);
               sc.nextLine();
             System.out.println("*****************"+"\n");
 
        }
     }
    ////////////////////////////////////////////////////////////////
 public static void addStats() {
    int foul = 0;
    int points = 0;
    int assists = 0;
    int rebounds = 0;
    int blocks = 0;

    System.out.println("*****Estadistica*****");
    Scanner sc = new Scanner(System.in);

    int opcSelectStat = 0;
   
    do {
        try {
            System.out.println("Selecciona la estadistica \n" + "(1)Foul \n" + "(2)Assist \n" + "(3)Points \n"
                    + "(4)Rebound \n" + "(5)Blocks \n" + "(0)Salir");

            opcSelectStat = sc.nextInt();

            switch (opcSelectStat) {
                case 1:
                    System.out.println("Foul agregado \n");
                    foul++;
                    break;
                case 2:
                    System.out.println("Assist agregado \n");
                    assists++;
                    break;
                case 3:
                    System.out.println("Punto agregado \n");
                    points++;
                    break;
                case 4:
                    System.out.println("Rebound agregado \n");
                    rebounds++;
                    break;
                case 5:
                    System.out.println("Block agregado \n");
                    blocks++;
                    break;
                case 0:
                    System.out.println("Saliendo del programa... \n");
                                        break;
                default:
                    System.out.print("Esta opcion no existe, ingrese una nueva opción \n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Caracter no valido, intenta de nuevo");
            sc.next(); // Consumir el valor no válido
        }
    } while (opcSelectStat !=0);

    // Call the 'marcador()' function to print the final results
    marcador(foul, assists, points, rebounds, blocks);
}

public static void marcador(int foul, int assists, int points, int rebounds, int blocks) {
    System.out.println("----------RESULTADOS----------");
    System.out.println("Total de fouls: " + foul);
    System.out.println("Total de assists: " + assists);
    System.out.println("Total de points: " + points);
    System.out.println("Total de rebounds: " + rebounds);
    System.out.println("Total de blocks: " + blocks);
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
