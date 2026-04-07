package model;

// ASSETS
import static assets.ColorManager.*;
import static assets.LogicManager.*;
import static assets.GeneratorManager.*;

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
        File file = new File(FILE);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write(toCSV());
        bw.flush(); 
        bw.close();
    }
}
