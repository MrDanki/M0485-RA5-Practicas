package model;

// ASSETS
import static model.ColorManager.*;
import static model.LogicManager.*;
import static model.FileManager.*;

// JAVA IO
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// JAVA UTIL
import java.util.ArrayList;

public class Room {
    
    // VARIABLES
    public int NUMBER;
    public String FLOOR;
    public int PRICE;
    public boolean DISPONIBLE;
    
    // CONSTRUCTOR
    public Room(int number,String floor,int price,boolean disponible){
        this.NUMBER = number;
        this.FLOOR = floor;
        this.PRICE = price;
        this.DISPONIBLE = disponible;
    }
    
    // GETTER
    public int getNumber(){return NUMBER;}
    public String getFloor(){return FLOOR;}
    public int getPrice(){return PRICE;}
    public boolean getDisponible(){return DISPONIBLE;}
    
    // SETTER
    public void setNumber(int number){this.NUMBER = number;}
    public void setFloor(String floor){this.FLOOR = floor;}
    public void setPrice(int price){this.PRICE = price;}
    public void setDisponible(boolean disponible){this.DISPONIBLE = disponible;}
    
    String FILE = System.getProperty("user.dir")+"\\data\\rooms.txt";
    
    public String toCSV(){
        return NUMBER+","+FLOOR+","+PRICE+","+DISPONIBLE+","+System.lineSeparator();
    }
    
    public void create()throws IOException{
        if(ExistIDInFile(FILE,IntToString(NUMBER))){System.out.println(RED+"Room "+NUMBER+" Already Registered"+RESET); return;}
        File file = new File(FILE);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write(toCSV());
        bw.flush(); 
        bw.close();
        System.out.println(GREEN+"+ Room "+NUMBER+" Added"+RESET);
    }
    
    public String toJList()throws IOException{
        String D = "Disponible";
        if(!DISPONIBLE){D="Occupied";}
        return NUMBER+" / "+D;
    }
    
    public void delete()throws IOException{
        if(!ExistIDInFile(FILE,IntToString(NUMBER))){System.out.println(RED+"Room "+NUMBER+" Does Not Exists"+RESET); return;}
        ArrayList<String[]> fileContent = GetAllFileContent(FILE);
        int pos = 0;
        for(String[] V : fileContent){
            if(StringToInt(V[0]) == NUMBER){
                fileContent.remove(pos);
                break;
            }
            pos++;
        }
        WriteAllFileContent(FILE,fileContent);
        System.out.println(RED+"+ Room "+NUMBER+" Deleted"+RESET);
    }
    
}
