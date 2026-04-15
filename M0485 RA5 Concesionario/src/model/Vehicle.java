package model;

// ASSETS
import static model.ColorManager.*;
import static model.LogicManager.*;
import static model.GeneratorManager.*;
import static model.FileManager.*;

// JAVA IO
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

// JAVA UTIL
import java.util.ArrayList;

public class Vehicle{
    
    // VARIABLES
    public String PLATE;
    public String BRAND;
    public String MODEL;
    public int PRICE;
    public String TYPE;
    
    // CONSTRUCTOR
    public Vehicle(String PLATE,String BRAND,String MODEL,int PRICE,String TYPE){
        this.PLATE = PLATE;
        this.BRAND = BRAND;
        this.MODEL = MODEL;
        this.PRICE = PRICE;
        this.TYPE = TYPE;
    }
    
    // GETTER
    public String getPlate(){return PLATE;}
    public String getBrand(){return BRAND;}
    public String getModel(){return MODEL;}
    public int getPrice(){return PRICE;}
    public String getType(){return TYPE;}
    
    // SETTER
    public void setPlate(String plate){this.PLATE = plate;}
    public void setBrand(String brand){this.BRAND = brand;}
    public void setModel(String model){this.MODEL = model;}
    public void setPrice(int price){this.PRICE = price;}
    public void setType(String type){this.TYPE = type;}
    
    String FILE = System.getProperty("user.dir")+"\\data\\vehicles.txt";
    
    public String toCSV(){
        if(PLATE.equals("gen")){PLATE = PlateGenerator();}
        return PLATE+","+BRAND+","+MODEL+","+PRICE+","+TYPE+","+System.lineSeparator();
    }
    
    public void create()throws IOException{
        if(existIDInFile(FILE,PLATE)){System.out.println(RED+PLATE+" Already Registered"+RESET); return;}
        File file = new File(FILE);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write(toCSV());
        bw.flush(); 
        bw.close();
        System.out.println(GREEN+"+ "+BRAND+" "+MODEL+" Added"+RESET);
    }
    
    public void printInDisplay()throws IOException{
        String plate = "Plate: "+RED+PLATE+RESET;
        String brand = "Model: "+RED+BRAND+RESET;
        String model = RED+MODEL+RESET;
        System.out.println("- "+plate+" / "+brand+" "+model);
    }
    
    public String returnInList()throws IOException{
        return PLATE+" / "+BRAND+" "+MODEL;
    }
    
    public void printInBlock()throws IOException{
        String head = "== "+RED+PLATE+RESET+" ==";
        String plate = "- Plate: "+RED+PLATE+RESET;
        String brand = "- Brand: "+RED+BRAND+RESET;
        String model = "- Model: "+RED+MODEL+RESET;
        String price = "- Price: "+RED+PRICE+"$"+RESET;
        String type = "- Type: "+ RED+TYPE+RESET;
        System.out.println(
            head+"\n"+
            plate+"\n"+
            brand+"\n"+
            model+"\n"+
            price+"\n"+
            type+"\n"
        );
    }
    
    public void delete()throws IOException{
        if(!existIDInFile(FILE,PLATE)){System.out.println(RED+PLATE+" does not exist"+RESET); return;}
        ArrayList<String[]> fileContent = getAllFileContent(FILE);
        int pos = 0;
        for(String[] V : fileContent){
            if(V[0].equals(PLATE)){
                fileContent.remove(pos);
                break;
            }
            pos++;
        }
        writeAllFileContent(FILE,fileContent);
        System.out.println(RED+"+ "+BRAND+" "+MODEL+" Deleted"+RESET);
    }
}
