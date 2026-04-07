package main;

// ASSETS
import static assets.ColorManager.*;
import static assets.GeneratorManager.*;
import static assets.LogicManager.*;


// MODEL
import model.Student;
import model.Degree;

// JAVA IO
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// JAVA UTIL
import java.util.Scanner;

public class Main {
    
    public static void main(String[]args)throws IOException{
        Scanner scanner = new Scanner(System.in);
        String op;
        do{
            menu();
            op = scanner.nextLine();
            switch(op){
                case "0": System.out.println(GREEN+"Program Stopped"+RESET); break;
                case "1": addStudent(); break;
                case "2": printStudentsInDisplay(); break;
                case "3": deleteStudent(); break;
                case "4": editStudent(); break;
                case "5": searchStudent(); break;
                case "6": addDegree(); break;
                case "7": printDegreeInDisplay(); break;
                case "8": deleteDegree(); break;
                case "9": printStudentsInDegree(); break;
                default: System.out.println(RED+"Input Error"+RESET); break;
            }
        }while(!op.equals("0"));
    }
    
    public static void menu(){
        System.out.println("");
        System.out.println("== "+RED+"SCHOOL MANAGER"+RESET+" ==");
        System.out.println("- "+RED+"0"+RESET+")Exit");
        System.out.println("- "+RED+"1"+RESET+")Add Student");
        System.out.println("- "+RED+"2"+RESET+")Print Student Database");
        System.out.println("- "+RED+"3"+RESET+")Delete Student");
        System.out.println("- "+RED+"4"+RESET+")Edit Student");
        System.out.println("- "+RED+"5"+RESET+")Search Student");
        System.out.println("- "+RED+"6"+RESET+")Add Degree");
        System.out.println("- "+RED+"7"+RESET+")Print Degrees");
        System.out.println("- "+RED+"8"+RESET+")Delete Degree");
        System.out.println("- "+RED+"9"+RESET+")Students in Degree");
        System.out.println("");
        System.out.print("Option: ");
    }
    
    public static void addStudent() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("== "+RED+"STUDENT REGISTRATOR"+RESET+" ==");
        System.out.print("Student Name? ");
        String name = scanner.nextLine();
        System.out.print("Student Surname? ");
        String surname = scanner.nextLine();
        System.out.print("Student Age? ");
        String age = scanner.nextLine();
        System.out.print("Student Degree? ");
        String degree = scanner.nextLine();
        
        int num = stringToIntIfNumber(age);
        Student NS = new Student(DNIGenerator(),name,surname,num,degree);
        Degree D = new Degree(degree);
        if(D.exists()){
            if(!NS.find()){
                NS.create();
                System.out.println(GREEN+"Sudent "+name+" "+surname+" added correctly to "+degree+RESET);
            }else{System.out.println(RED+"Sudent "+name+" "+surname+" already exists in"+degree+RESET);}
        }else{System.out.println(RED+"Degree "+degree+" does not exists"+RESET);}
    }
    
    public static void printStudentsInDisplay()throws IOException{
        System.out.println("== "+RED+"STUDENT DATABASE"+RESET+" ==");
        File data = new File(System.getProperty("user.dir")+"\\data");
        for(File F: data.listFiles()){
            Degree D = new Degree(F.getName());
            D.printStudents();
        }
    }
    
    public static void deleteStudent()throws IOException{
        Scanner scanner = new Scanner(System.in);
        printStudentsInDisplay();
        System.out.println("== "+RED+"STUDENT DELETOR"+RESET+" ==");
        System.out.print("Student to delete? ");
        String input = scanner.nextLine();
        Student NS = searchAndReturnStudent(input);
        if(NS==null){return;}
        NS.delete();
        System.out.println(GREEN+"Student "+NS.getName()+" "+NS.getSurName()+" deleted correctly"+RESET);
    }
    
    public static void editStudent()throws IOException{
        Scanner scanner = new Scanner(System.in);
        printStudentsInDisplay();
        System.out.println("== "+RED+"STUDENT EDITOR"+RESET+" ==");
        System.out.print("Student to edit? ");
        String input = scanner.nextLine();
        Student NS = searchAndReturnStudent(input);
        if(NS==null){return;}
        System.out.print("What data want to edit from "+RED+NS.getName()+" "+NS.getSurName()+RESET+"? ");
        String data = scanner.nextLine();
        switch(data){
            case "1","DNI","dni","Dni": 
                System.out.print("New DNI for "+RED+NS.getName()+" "+NS.getSurName()+RESET+"? ");
                String dni = scanner.nextLine();
                if(dni.equals("gen")){dni = DNIGenerator();}
                NS.editDNI(dni);
                break;
            case "2","NAME","name","Name","NOMBRE","nombre","Nombre": 
                System.out.print("New Name for "+RED+NS.getName()+" "+NS.getSurName()+RESET+"? ");
                String name = scanner.nextLine();
                NS.editName(name);
                break;
            case "3","SURNAME","surname","Surname","APELLIDO","apellido","Apellido": 
                System.out.print("New Surname for "+RED+NS.getName()+" "+NS.getSurName()+RESET+"? ");
                String surname = scanner.nextLine();
                NS.editSurname(surname);
                break;
            case "4","AGE","age","Age","EDAD","edad","Edad": 
                System.out.print("New Age for "+RED+NS.getName()+" "+NS.getSurName()+RESET+"? ");
                String age = scanner.nextLine();
                int num = stringToIntIfNumber(age);
                NS.editAge(num);
                break;
            case "5","DEGREE","degree","Degree","ESTUDIOS","estudios","Estudios":
                printDegreeInDisplay();
                System.out.print("New Degree for "+RED+NS.getName()+RESET+"? ");
                String degree = scanner.nextLine();
                NS.changeToDegree(degree);
                break;
        }
        System.out.println(GREEN+"Student "+NS.getName()+" "+NS.getSurName()+" edited correctly"+RESET);        
    }
    
    public static void searchStudent()throws IOException{
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("== "+RED+"STUDENT SEARCHER"+RESET+" ==");
        System.out.print("Student to search? ");
        String input = scanner.nextLine();
        Student NS = searchAndReturnStudent(input);
        if(NS!= null){NS.printInBlock();}
    }
    
    public static Student searchAndReturnStudent(String input)throws IOException{
        File data = new File(System.getProperty("user.dir")+"\\data");
        for(File F: data.listFiles()){
            Degree D = new Degree(F.getName());
            Student NS = D.findAndReturnStudent(input);
            if(NS != null){
                return NS;
            }
        }
        System.out.println(RED+"Student not Found"+RESET);
        return null;
    }
    
    public static void addDegree()throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("== "+RED+"DEGREE CREATOR"+RESET+" ==");
        System.out.print("New Degree? ");
        String input = scanner.nextLine();
        Degree D = new Degree(input);
        if(D.exists()){
            System.out.println(RED+"Degree "+D.getName()+" exist yet"+RESET);
            return;
        }
        D.create();
        System.out.println(GREEN+"Degree "+D.getName()+" created correctly"+RESET); 
    }
    
    public static void printDegreeInDisplay()throws IOException{
        File data = new File(System.getProperty("user.dir")+"\\data");
        System.out.println("== "+RED+"DEGREES LIST"+RESET+" ==");
        for(File F: data.listFiles()){
            Degree D = new Degree(F.getName());
            D.printInDisplay(); 
        }
    }
    
    public static void printStudentsInDegree()throws IOException{
        Scanner scanner = new Scanner(System.in);
        printDegreeInDisplay();
        System.out.println("== "+RED+"DEGREE DATABASE"+RESET+" ==");
        System.out.print("Degree to show Students? ");
        String input = scanner.nextLine();
        Degree D = new Degree(input);
        if(D.exists()){
            D.printStudents();
        }else{System.out.println(RED+"Degree "+D.getName()+" does not exist"+RESET);}
       
    }
    
    public static void deleteDegree()throws IOException{
        Scanner scanner = new Scanner(System.in);
        printDegreeInDisplay();
        System.out.println("== "+RED+"DEGREE DELETOR"+RESET+" ==");
        System.out.print("Degree to Delete? ");
        String input = scanner.nextLine();
        Degree D = new Degree(input);
                
        if(D.exists()){
            System.out.println(GREEN+"Degree "+D.getName()+" deleted correctly"+RESET);
            D.delete();
        }else{System.out.println(RED+"Degree "+D.getName()+" does not exist"+RESET);}
    }
}
