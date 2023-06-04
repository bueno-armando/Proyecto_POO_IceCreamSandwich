package proyecto_oop_basquetbol;
import Entities.*;
import SubClases.Player;
import java.awt.BorderLayout;
import java.awt.Font;
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
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.InputMismatchException; 
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



/**
 *
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOLfinal implements Utilities{
    public static void main(String[] args) {
         
         System.out.println(mainMenu());
      
     
    }
    public static boolean timeOver;
    private static JLabel countdownLabel;
    public static Team t1,t2;
    
   
    
    public static void subMenu(){
        Scanner sc = new Scanner(System.in);
        int xQuarter=0;
        char pick;
        System.out.println("Selecciona una opcion\n+"
                           +"(1)Agregar Stats\n"
                           +"(2)Timer\n"
                           +"(3)Quarter\n"
                           +"(4)endGame\n");
        while(true){
            
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
                    pick = sc.next().charAt(0);
                    if(pick == '1'){
                        //regresar a menú
                    }
                    else{
                        //salir
                    }
                    break;
                default:
                    break;
            }
        }
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
    
    public static int menuAddTeam(int indiceGlobal){
        Team[] numEquipos = new Team[100];
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
                        System.out.println("!!Equipos listos para usar equipo_Chicago_Bulls.bin y equipo_Mavericks.bin!! \n");
                        System.out.println("**********EQUIPO 1**********");
                        //abrir o desplegar todos los equipos existentes (FILES CHOOSER) ABRIR ARCHIVOS
                        boolean validFileName = false;
                        boolean validFileName2 = false;
                        while(!validFileName){
                          System.out.println("Abrir el archivo del equipo deseado");
                          System.out.println("Ingresar el nombre del archivo a cargar");
                        
                          sc.nextLine();//Consumir el carácter de nueva línea pendiente
                          String fileName = sc.nextLine();
                       
                        
                          try{
                             Team loadedTeam1 = loadData(fileName);
                              t1 = loadedTeam1;
                             // Aquí puedes realizar las operaciones necesarias con el equipo cargado
                              // Por ejemplo, imprimir los detalles del equipo o acceder a sus jugadores
                              System.out.println("Equipo cargado:");
                              System.out.println("Nombre del equipo: " + loadedTeam1.getTeamName());
                              // ...
                               //Obtener jugadores cargados en el equipo(T
                              Player[] playersCargados = loadedTeam1.getPlayers();
                              if(playersCargados != null && playersCargados.length>0){
                                  System.out.println("Jugadores cargados");
                                   for (Player players : playersCargados) {
                                       System.out.println(
                                          //"*******************************************************"
                                          "\nNombre : "+players.getName()+" | "
                                          +"Apellido: "+players.getLastName()+" | "
                                          +"Posición: "+players.getPosition()+" | "
                                          );                               
                                }
                                  
                            }else{
                              System.out.println("El equipo no cuenta con ningún jugador cargado");
                          }
                          validFileName = true;
                        }catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }catch(ClassNotFoundException ex){
                            System.out.println(ex.getMessage());
                        }
                          
                       }
                      
                        //////EQUIPO 2///////
                        System.out.println("**********EQUIPO 2**********\n");
                        //abrir o desplegar todos los equipos existentes (FILES CHOOSER) ABRIR ARCHIVOS
                        while(!validFileName2){
                          System.out.println("Abrir el archivo del equipo deseado");
                          System.out.println("Ingresar el nombre del archivo a cargar");
                                
                          sc.nextLine();//Consumir el carácter de nueva línea pendiente
                          String fileName2 = sc.nextLine();
                        
                          try{
                              Team loadedTeam2 = loadData(fileName2);
                              t2 = loadedTeam2;
                              // Aquí puedes realizar las operaciones necesarias con el equipo cargado
                              // Por ejemplo, imprimir los detalles del equipo o acceder a sus jugadores
                              System.out.println("Equipo cargado:");
                              System.out.println("Nombre del equipo: " + loadedTeam2.getTeamName());
                              // ..
                              //Obtener jugadores cargados en el equipo(T
                              Player[] playersCargados = loadedTeam2.getPlayers();
                              if(playersCargados != null && playersCargados.length>0){
                                 System.out.println("Jugadores cargados");
                                  for (Player players : playersCargados) {
                                     System.out.println(
                                         // "*************************************************"
                                          "\nNombre : "+players.getName()+" | "
                                          +"Apellido: "+players.getLastName()+" | "
                                          +"Posición: "+players.getPosition()+" | "
                                          );                                    
                                    }
                            }else{
                              System.out.println("El equipo no cuenta con ningún jugador cargado");
                          }
                          validFileName2 = true;
                        }catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }catch(ClassNotFoundException ex){
                            System.out.println(ex.getMessage());
                        }
                       // addStats(t1, t2);                         
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
        
        System.out.println("Agregar jugadores");
         addPlayer(CreatedTeam);
        
        //Guardar el object
            saveData(CreatedTeam, fileName);
        } catch (IOException ex) {
                Logger.getLogger(PROYECTO_OOP_BASQUETBOLfinal.class.getName()).log(Level.SEVERE, null, ex);
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

    public static void addPlayer(Team CreatedTeam){
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player [5];
        for (int i = 0; i < 5; i++) {
           
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

            System.out.println(
                    "________________"
                    +"\nJugador #"+(i+1)
                    +"\nnombre: "+players[i].getLastName()
                    +"\nApellido: "+players[i].getLastName()
                    +"\nPosición: "+players[i].getPosition()
                    +"\n________________\n");
            CreatedTeam.setPlayers(players);
        }
     }
    //
    public static void addStats(){
    
    Scanner sc = new Scanner(System.in);
    int opcTeam;
    int opcPlayer;
    Player [] playersCargados;
    do{
        System.out.println("***** Estadisticas *****");
        System.out.println("SELECCIONE EL EQUIPO (1-2)");
        System.out.println("Volver al submenú (0)");
        opcTeam = sc.nextInt();
  
        switch(opcTeam){
            case 1:
                playersCargados = t1.getPlayers();
                selecStatMenu(playersCargados);
            break;
            case 2:
                playersCargados = t2.getPlayers();
                selecStatMenu(playersCargados);
            break;    
            case 0:
                System.out.println("Volver al submenú");
                subMenu();
            break;
            
            default:
            System.out.println("Esta opción no existe, ingrese una nueva opción \n");
            break;
        }
    }while(opcTeam !=0);
   }
   
    public static void selecStatMenu(Player[]playersCargados){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿A qué jugardor desea cargar stats?");
        for (int i=0; i<playersCargados.length;i++) {
                Player players = playersCargados[i];
                System.out.println((i+1)+")"+"#"+ players.getNumber()+" "+ players.getName()+ " "+players.getLastName());   
            }
        System.out.println("0)Regresa a la selección de equipos");
        int opcPlayer; 
         opcPlayer=sc.nextInt(); 
             
        try{
             opcPlayer=sc.nextInt(); 
             switch(opcPlayer){
                    case 1:
                          System.out.println("Seleccionó jugardor 1");
                          System.out.println("#"+playersCargados[0].getNumber()+" "+playersCargados[0].getName()+" "+playersCargados[0].getLastName());
                          selectStat(playersCargados,0);
                          break;
                    case 2:
                          System.out.println("Seleccionó jugardor 2");
                          System.out.println("#"+playersCargados[1].getNumber()+" "+playersCargados[1].getName()+" "+playersCargados[1].getLastName());
                          selectStat(playersCargados,1);
                          break;
                    case 3:
                          System.out.println("Seleccionó jugardor 3");
                          System.out.println("#"+playersCargados[2].getNumber()+" "+playersCargados[2].getName()+" "+playersCargados[2].getLastName());
                          selectStat(playersCargados,2);
                          break;
                    case 4:
                          System.out.println("Seleccionó jugardor 4");
                          System.out.println("#"+playersCargados[3].getNumber()+" "+playersCargados[3].getName()+" "+playersCargados[3].getLastName());
                          selectStat(playersCargados,3);
                          break;
                    case 5:
                         System.out.println("Seleccionó jugardor 5");
                         System.out.println("#"+playersCargados[4].getNumber()+" "+playersCargados[4].getName()+" "+playersCargados[4].getLastName());
                         selectStat(playersCargados,4);
                        break;
                     //7AGREGAR CASE 0
                    case 0:
                        System.out.println("regresando al anterio menú");
                        break;
                    default:
                          System.out.println("Esta opción no existe, ingrese una nueva opción \n");
                          break;
                     }
                   }catch(InputMismatchException ex){
                      System.out.println("Carácter no válido, intenta de nuevo "+ex.getMessage());
                      sc.next(); // Consumir el valor no válido
                     }
   }
   
    public static void selectStat(Player[]playersCargados, int i){
    Scanner sc =  new Scanner(System.in);
    int opcStat;
    
    
    do{
        System.out.println("Selecciona la estadistica: \n"
                    + "(1)Foul \n"
                    + "(2)Assist \n"
                    + "(3)Points \n"
                    + "(4)Rebound \n"
                    + "(5)Blocks \n"
                    + "(0)Escoger otro jugador");
        opcStat = sc.nextInt();
        try{
            switch(opcStat){
                  case 1:
                     System.out.println("Foul agregado");
                 
                      playersCargados[i].getStats().setFouls(playersCargados[i].getStats().getFouls() + 1);
                    break;
                   case 2:
                      System.out.println("Assist agregado");
                    
                     playersCargados[i].getStats().setAssists(playersCargados[i].getStats().getAssists() + 1);
                    break;
                   case 3:
                     System.out.println("Punto agregado");
                     playersCargados[i].getStats().setPoints(playersCargados[i].getStats().getPoints() + 1);
                    break;
                    case 4:
                     System.out.println("Rebound agregado");
                     playersCargados[i].getStats().setRebounds(playersCargados[i].getStats().getRebounds() + 1);
                    break;
                   case 5:
                     System.out.println("Block agregado");
                    playersCargados[i].getStats().setBlocks(playersCargados[i].getStats().getBlocks() + 1);
                    break;
                   case 0:
                     System.out.println("Regresando al menú anterior");
                       selecStatMenu(playersCargados);
                    break; 
                   
                default:
                    System.out.print("Esta opción no existe, ingrese una nueva opción \n");
                    break;
            }
       }catch(InputMismatchException ex){
         System.out.println("Carácter no válido, intenta de nuevo "+ex.getMessage());
         sc.next(); 
        }  
      }while(opcStat !=0);
   }
   //
    public static void marcador(int teamNumber, int foul, int assists, int points, int rebounds, int blocks) {
     System.out.println("---------- RESULTADOS EQUIPO " + teamNumber + " ----------");
     System.out.println("Total de fouls: " + foul);
     System.out.println("Total de assists: " + assists);
     System.out.println("Total de points: " + points);
     System.out.println("Total de rebounds: " + rebounds);
     System.out.println("Total de blocks: " + blocks);
    }


    public static void timer(int milliseconds) {
        // Create and configure the countdown label
        countdownLabel = new JLabel();
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create the main frame
        JFrame frame = new JFrame("Countdown Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());
        frame.add(countdownLabel, BorderLayout.CENTER);
        frame.setVisible(true);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int seconds = milliseconds / 1000;

            @Override
            public void run() {
                if (seconds > 0) {
                    int minutes = seconds / 60;
                    int remainingSeconds = seconds % 60;
                    countdownLabel.setText(String.format("%02d:%02d", minutes, remainingSeconds));
                    seconds--;
                } else {
                    countdownLabel.setText("Program finished");
                    timer.cancel(); // Terminate the timer task
                }
            }
        }, 0, 1000); // Schedule the task to run every 1 second (1000 milliseconds)
    }

    public static void quarter(int qtr){
        //qtr = numero de cuarto en el que van.
        qtr++;
        System.out.println("QTR "+qtr);
        if(qtr>4){
            System.out.println("EL JUEGO YA AH FINALIZADO");
        }         
    }
    public static void endGame(){
            System.out.println("TERMINO EL JUEGO");
            System.exit(0);
    } 
 
   
}
