package proyecto_oop_basquetbol;
import Entities.*;
import SubClases.Player;
import java.util.InputMismatchException;
import java.util.Timer;
import java.util.TimerTask;
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
 * V2.6
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOLfinal{
    
    public static void main(String[] args) {
        Player p1 = new Player( "Jose", "Perez",22, "pg", 77,4,1,5,0,1 );
        p1.printData();
        //System.out.println(mainMenu());
        
        
    }
    
    ///MENU PRINCIPAL para para elegir comenzar un juego o ver la estaditica
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
                    case 1://se elige el el equipo y por consiguiente manda al sub
                           // menu de agregar stats, timer, cuartos y end game 
                        menuAddTeam(indiceEquipo);
                        subMenu();
                        return x;
                    case 2:
                        System.out.println("VER ESTADISTICAS GENERAL");
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
    
    //AGREGAR EQUIPO ya sea que agregues un equipo existente o para crear uno/s nuevo/s
    public static int menuAddTeam(int indiceGlobal){
       
        Team[] numEquipos = new Team[100];
        System.out.println("*****EQUIPO 1*****");
        Scanner sc = new Scanner(System.in);
        do{
            try{
            int opcSelectTeam;
            System.out.println("Selecciona tu equipo "
                          +"\n(1)Existente"
                          +"\n(2)Crear Uno");
            opcSelectTeam = sc.nextInt(); 
                switch(opcSelectTeam){
                    case 1:
                        System.out.println("**********EQUIPO 1:*********");
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
                        //////EQUIPO 2///////
                        System.out.println("**********EQUIPO 2:*********\n");
                        //abrir o desplegar todos los equipos existentes (FILES CHOOSER) ABRIR ARCHIVOS
                        System.out.println("Abrir el archivo del equipo deseado");
                        System.out.println("Ingresar el nombre del archivo a cargar");
                        
                        sc.nextLine();//Consumir el carácter de nueva línea pendiente
                                
                   
                        String fileName2 = sc.nextLine();
                        
                        try{
                        Team loadedTeam = loadData(fileName2);
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
                        System.out.println("VAMOS AL SUBMENU...");
                        subMenu();
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
    //Crea el equipo y sus jugadores
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
        System.out.println("Equipo Agregado");
        System.out.println("Nombre Del Equipo: "+objEquipo[indice].getTeamName()+"\n");
        
        System.out.println("Agregar Jugadores");
        addPlayer();
        //Guardar el object
            saveData(CreatedTeam, fileName);
        } catch (IOException ex) {
                Logger.getLogger(PROYECTO_OOP_BASQUETBOLfinal.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void addPlayer(){
        Scanner sc = new Scanner(System.in);
        Player [] players = new Player[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("JUGADOR #"+i+":\n");
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
    //Metodos para crear los equipos en formato bin (FILES)
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
    
    //SUBMENU despues de comenzar un juego  
    public static void subMenu(){
        
        do{
            try{
                int xQuarter=0;
                Scanner sc = new Scanner(System.in);
                char pick;
                System.out.println("Selecciona una opcion\n+"
                                   +"(1)Agregar Stats\n"
                                   +"(2)Timer\n"
                                   +"(3)Quarter\n"
                                   +"(4)endGame\n");
                    pick = sc.next().charAt(0);
                    switch(pick){
                        case '1':
                            addStats();
                            break;
                        case '2':
                            //tiempo que va a correr el timer en ms
                            //ms = minutos*6000
                            timer(5000);
                            break;
                        case '3':
                            quarter(xQuarter);
                            break;
                        case '4':
                            endGame();
                            System.out.println("**********************");
                            System.out.println("      [MARCADOR]");
                            System.out.println("**********************");
                            System.out.println("(1)Volver a menu Principal\n"+"(presione cualquier otra tecla)Salir");
                            pick = sc.next().charAt(0);
                            if(pick == '1'){
                                mainMenu();
                            }
                            else{
                                //salir
                            }
                            break;
                        default:
                            break;
                    }
             }
            catch(InputMismatchException e){
                System.out.println("Input no valido, intenta de nuevo");
            }
        }while(true);
}
    //
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
    public static boolean timeOver;
    public static void timer(int milliseconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeOver = true;
                timer.cancel(); // Terminar el task del timer
            }
        }, milliseconds);
    }
    public static void quarter(int qtr) {
        //qtr = numero de cuarto en el que van.
        qtr++;
        System.out.println("QTR "+qtr);
        if(qtr>4){
            System.out.println("EL JUEGO YA AH FINALIZADO");
        }         
    }
    public static void endGame(){
            System.out.println("TERMINO EL JUEGO");
    } 

}
