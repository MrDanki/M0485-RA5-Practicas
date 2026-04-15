package controller;

// ASSETS
import static model.LogicManager.*;
import static model.GeneratorManager.*;
import static model.ColorManager.*;
import static model.FileManager.*;

// JAVA IO
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
// MODEL
import model.Vehicle;

// JAVA UTIL
import java.util.Scanner;
import view.Concesionario;

public class Main {
    
    public static String FILE = System.getProperty("user.dir")+"\\data\\vehicles.txt";
    
    public static void main(String[]args)throws IOException{
        Scanner scanner = new Scanner(System.in);
        String op;
        do{
            menu();
            op = scanner.nextLine();
            if(isStringLoad(op)){LoadVehicles(); op="skip";}
            switch(op){
                case "0": System.out.println("Program Stopped"); break;
                case "1": addVehicle(); break;
                case "2": printVehicles(); break;
                case "3": deleteVehicle(); break;
                case "4": findVehicle(); break;
                case "skip": break;
                default: System.out.println(RED+"Input Error"+RESET); break;
            }
        }while(!op.equals("0"));
    }
    public static void menu(){
        System.out.println("");
        System.out.println("== "+RED+"VEHICLES MANAGER"+RESET+" ==");
        System.out.println("- 0)Exit");
        System.out.println("- 1)Add Vehicle");
        System.out.println("- 2)Print Vehicles");
        System.out.println("- 3)Delete Vehicle");
        System.out.println("- 4)Search Vehcile");
        System.out.println("");
        System.out.print("Option: ");
    }
    
    public static void addVehicle()throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("== "+RED+"VEHICLE REGISTRATOR"+RESET+" ==");
        System.out.print("Vehilce Plate? ");
        String plate = scanner.nextLine();
        if(isStringGen(plate)){plate = PlateGenerator();}
        System.out.print("Vehilce Brand? ");
        String brand = scanner.nextLine();
        System.out.print("Vehilce Model? ");
        String model = scanner.nextLine();
        System.out.print("Vehicle Price? ");
        String price = scanner.nextLine();
        int num = Integer.parseInt(price);
        System.out.print("Vehicle Type? ");
        String type = scanner.nextLine();
        Vehicle NV = new Vehicle(plate,brand,model,num,type);
        NV.create();
    }
    
    public static void printVehicles()throws IOException{
        if(isFileEmpty(FILE)){System.out.println(RED+"Not Vehicles Yet"+RESET); return;}
        System.out.println("== "+RED+"VEHICLES DATABASE"+RESET+" ==");
        File file = new File(FILE);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            Vehicle NV = new Vehicle(p[0],p[1],p[2],Integer.parseInt(p[3]),p[4]);
            NV.printInDisplay();
        }
        br.close();
    }
    
    public static void deleteVehicle()throws IOException{
        Scanner scanner = new Scanner(System.in);
        printVehicles();
        if(isFileEmpty(FILE)){return;}
        System.out.println("== "+RED+"VEHICLE DELETOR"+RESET+" ==");
        System.out.print("Vehilce to Delete? ");
        String delete = scanner.nextLine();
        
        String[] V = getByIDFromFile(FILE,delete);
        if(V == null){System.out.println(RED+"Vehicle "+delete+" not Found"+RESET); return;}
        Vehicle NV = new Vehicle(V[0],V[1],V[2],Integer.parseInt(V[3]),V[4]);
        NV.delete();
    }
    
    public static void findVehicle()throws IOException{
        Scanner scanner = new Scanner(System.in);
        if(isFileEmpty(FILE)){System.out.println(RED+"Not Vehicles Yet"+RESET); return;}
        System.out.println("== "+RED+"VEHICLE SEARCHER"+RESET+" ==");
        System.out.print("Vehilce to Search? ");
        String find = scanner.nextLine();
        
        String[] V = getByIDFromFile(FILE,find);
        if(V == null){System.out.println(RED+"Vehicle "+find+" not Found"+RESET); return;}
        Vehicle NV = new Vehicle(V[0],V[1],V[2],Integer.parseInt(V[3]),V[4]);
        NV.printInBlock();
    }
    
    public static void LoadVehicles()throws IOException{
        System.out.println("== "+RED+"VEHICLE LOADER"+RESET+" ==");
        Vehicle Sasha = new Vehicle("8044GLB","Susuki","Marauder",500,"Motorbike");
        Sasha.create();
        Vehicle Jordi = new Vehicle("1200JLP","Citroen","Picasso",3000,"Car");
        Jordi.create();
        Vehicle Supra = new Vehicle("2027JPN","Toyota","Supra-MK3",5000,"Car");
        Supra.create();
        Vehicle Lada = new Vehicle("1970ESP","Lada","2100",1000,"Car");
        Lada.create();
        Vehicle Tankov = new Vehicle("2017RUS","Ural","T-90M",4000000,"Tank");
        Tankov.create();
        Vehicle Tupolev = new Vehicle("1980RUS","Tupolev","TU-160M",4000000,"Plane");
        Tupolev.create();
        Vehicle Mustang = new Vehicle("1200ESP","Ford","Mustang-V8",1500,"Car");
        Mustang.create();
    }
    
    public static boolean LoadSort(String input)throws IOException{
        System.out.println("== "+RED+"VEHICLE LOADER"+RESET+" ==");
        if(input.equals("Sasha")){
            Vehicle Sasha = new Vehicle("8044GLB","Susuki","Marauder",500,"Motorbike");
            Sasha.create();
            return true;
        }
        if(input.equals("Pantsir")){
            Vehicle Kamaz = new Vehicle("2010RUS","Kamaz","6250",10000,"Truck");
            Kamaz.create();
            return true;
        }
        if(input.equals("Katyusha")){
            Vehicle Ural = new Vehicle("1960RUS","Ural","4320",30000,"Truck");
            Ural.create();
            return true;
        }
        if(input.equals("Jordi")){
            Vehicle Jordi = new Vehicle("1200JLP","Citroen","Picasso",3000,"Car");
            Jordi.create();
            return true;
        }
        if(input.equals("Mista")){
            Vehicle Mista = new Vehicle("1972RUS","Ural","2S19",200000,"Artillery");
            Mista.create();
            return true;
        }
        if(input.equals("Tunguska")){
            Vehicle Tunguska = new Vehicle("1982RUS","KBP","2K22",40000,"SPAA");
            Tunguska.create();
            return true;
        }
        if(input.equals("Armata")){
            Vehicle Armata = new Vehicle("2014RUS","Ural","T-14M",40000,"Tank");
            Armata.create();
            return true;
        }
        return false;
    }
    
    public static void OpenConcesionario()throws IOException{
        java.awt.EventQueue.invokeLater(()->{
            try {
                Concesionario C = new Concesionario();
                C.setVisible(true); 
            } catch (IOException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
    }
}
