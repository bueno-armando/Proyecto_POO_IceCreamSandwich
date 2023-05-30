package proyecto_oop_basquetbol;
import Entities.*;
import SubClases.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOL implements Utilities{
    public static void main(String[] args) {
        System.out.println(mainMenu());
       
    }
    public static int mainMenu(){
        int indiceEquipo=0;
       
        do{
            try{
                int x;
                
                Scanner sc = new Scanner(System.in);
                System.out.print("(1) Nuevo Juego\n");
                System.out.println("(2) Ver Estadisticas");
                System.out.println("(3) Salir");

                x = sc.nextInt();
                switch(x){
                    case 1:
                        menuAddTeam(indiceEquipo);
                       
                        return x;
                    case 2:
                        System.out.println("VE LA ESTADISTICA");
                        return x; 
                    case 3:
                          System.out.println("Saliendo");
                          return 0;
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
                        System.out.println("Abrir el archivo del equipo deseado");
                        System.out.println("Ingresar el nombre del archivo a cargar");
                        
                        sc.nextLine();//Consumir el carácter de nueva línea pendiente
                                
                   
                        String fileName = sc.nextLine();
                        
                        try{
                        Team loadedTeam = loadData(fileName);
                          // Aquí puedes realizar las operaciones necesarias con el equipo cargado
                          // Por ejemplo, imprimir los detalles del equipo o acceder a sus jugadores
                          System.out.println("Equipo cargado:");
                          System.out.println("Nombre del equipo: " + loadedTeam.getTeamName());
                          // ...
                        }catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }catch(ClassNotFoundException ex){
                            System.out.println(ex.getMessage());
                        }
   
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
        try {
            
            Team CreatedTeam = new Team();//Crear una nueva instancia de Team
            Scanner sc = new Scanner(System.in);
            System.out.println("*****Agregar Equipo*****");
            
            System.out.println("Nombre del equipo");
            String nombreEquipo = sc.nextLine();
            CreatedTeam.setTeamName(nombreEquipo);
            
            // Se creo el nombre del archivo, que se guardara 
            // de forma local (El archivo del proyecto).
              String fileName ="equipo_"+CreatedTeam.getTeamName()+".bin";
            //
            
            // Asignar el equipo creado al arreglo de equipos en la posición "indice"
            objEquipo[indice]= CreatedTeam;
            System.out.println("Equipo agredado");
            System.out.println("Nombre del equipo: "+objEquipo[indice].getTeamName()+"\n");
            
            //Llamada al métod addPlayer
            System.out.println("Agregar jugadores");
            addPlayer();
            //Guardar el object
            saveData(CreatedTeam, fileName);
        } catch (IOException ex) {
            Logger.getLogger(PROYECTO_OOP_BASQUETBOL.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     
   public static void saveData(Team CreatedTeam, String fileName) throws IOException {
         FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        System.out.println("Se guardó exitosamente");
        objectOut.writeObject(CreatedTeam);
        fileOut.close();
        objectOut.close();
    }
   
   public static Team loadData( String fileName ) throws  IOException, ClassNotFoundException{
       FileInputStream openFile = new FileInputStream(fileName);
       ObjectInputStream oiStream = new ObjectInputStream(openFile);
       Team loadedTeam = (Team) oiStream.readObject();
       System.out.println("Se cargó exitosamente");
       openFile.close();
       oiStream.close();
       
       return loadedTeam;
   }
   /* public static Team loadData(String fileName) throws IOException, ClassNotFoundException {
    String absolutePath = Paths.get(fileName).toAbsolutePath().toString();
    FileInputStream fileIn = new FileInputStream(absolutePath);
    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
    Team loadedTeam = (Team) objectIn.readObject();
    fileIn.close();
    objectIn.close();
    return loadedTeam;
    }*/

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
