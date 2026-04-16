package app;

// JAVA IO
import java.io.IOException;

// VIEW
import view.Hotel;

// MODEL
import model.Room;

public class Main {
    public static String FILE = System.getProperty("user.dir")+"\\data\\rooms.txt";
    
    public static void main(String[]args)throws IOException{
        OpenHotel();
    }
    
    public static void OpenHotel()throws IOException{
        java.awt.EventQueue.invokeLater(()->{
            try {
                Hotel H = new Hotel();
                H.setVisible(true);
            } catch (IOException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
    }
    
    public static void LoadRooms()throws IOException{
        Room R1 = new Room(100,"First",30,true);
        R1.create();
        Room R2 = new Room(200,"Second",60,false);
        R2.create();
        Room R3 = new Room(300,"Third",90,false);
        R3.create();
        Room R4 = new Room(400,"Fourth",120,true);
        R4.create();
    }
    
}
