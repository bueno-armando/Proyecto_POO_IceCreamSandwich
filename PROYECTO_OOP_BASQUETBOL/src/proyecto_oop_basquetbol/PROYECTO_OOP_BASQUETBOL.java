package proyecto_oop_basquetbol;
import Entities.*;
import SubClases.Player;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author IceCreamSandwich
 */
public class PROYECTO_OOP_BASQUETBOL implements Utilities{
    public static void main(String[] args) {
        System.out.println(mainMenu());
        
        
    }
    
    //VARIABLES IMPORTANTES
    public static boolean timeOver;
    private static JLabel countdownLabel;
    
    public void subMenu(){
        Scanner sc = new Scanner(System.in);
        char pick;
        
        while(true){
            pick = sc.next().charAt(0);
            switch(pick){
                case '1':
                    stats();
                    break;
                case '2':
                    //tiempo que va a correr el timer en ms
                    //ms = minutos*6000
                    timer(5000);
                    break;
                case '3':
                    quarter();
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
             System.out.println("*****************"+"\n");
         
        }
     }
    @Override
    public void timer(int milliseconds) {
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
