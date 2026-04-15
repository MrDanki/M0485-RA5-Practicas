package main;

// MODEL
import model.Student;

// ASSETS
import static assets.LogicManager.*;
import static assets.ColorManager.*;
import static assets.GeneratorManager.*;

// JAVA IO
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


// JAVA UTIL
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    // GLOBALS
    public static String filePath = System.getProperty("user.dir")+"\\register.txt";
    
    public static void main(String[] args)throws IOException{
        Scanner scanner = new Scanner(System.in);
        String op;
        do{
            menu();
            op = scanner.nextLine();
            switch(op){
                case "0": System.out.println("Program Stopped"); break;
                case "1": addStudent(); break;
                case "2": printStudentsInDisplay(); break;
                case "3": deleteStudent(); break;
                case "4": findStudent(); break;
                default: System.out.println(RED+"Input Error"+RESET); break;
            }
        }while(!op.equals("0"));
    }
    
    public static void menu(){
        System.out.println("");
        System.out.println("== "+RED+"STUDENT MANAGER"+RESET+" ==");
        System.out.println("- 0)Exit");
        System.out.println("- 1)Add Student");
        System.out.println("- 2)Print Students");
        System.out.println("- 3)Delete Student");
        System.out.println("- 4)Search Student");
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
        WriteStudentInFile(NS);
        System.out.println(GREEN+"Sudent "+name+" added correctly"+RESET);
    }
   
    public static void WriteStudentInFile(Student input)throws IOException{
        File file = new File(filePath);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write(input.toTxt());
        bw.flush(); 
        bw.close(); 
    }
    
    public static void printStudentsInDisplay()throws IOException{
        System.out.println("== "+RED+"STUDENT DATABASE"+RESET+" ==");
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            Student NS = new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]);
            System.out.println(NS.printInDisplay());
        }
        System.out.println("");
        br.close();
    }
    
    @SuppressWarnings("empty-statement")
    public static void deleteStudent()throws IOException{
        Scanner scanner = new Scanner(System.in);
        printStudentsInDisplay();
        System.out.println("== "+RED+"STUDENT DELETOR"+RESET+" ==");
        System.out.print("Student to delete? ");
        String input = scanner.nextLine();
        Student s = findStudentInFileReturnS(input);
        if(s == null){return;}
        
        ArrayList<Student> fileContent = new ArrayList();
        
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            Student NS = new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]);
            fileContent.add(NS);
        }
        
        br.close();
        
        int pos = 0;
        for(Student st : fileContent){
            if(st.getDNI().equals(s.getDNI())){
                fileContent.remove(pos);
                System.out.println(GREEN+"Student "+s.getName()+" deleted correctly"+RESET);
                break;
            }
            pos++;
        }
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        
        for(Student st: fileContent){
            bw.write(st.toTxt());
        }
        
        bw.flush();
        bw.close();
    }
    
    public static void findStudent()throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("== "+RED+"STUDENT SEARCHER"+RESET+" ==");
        System.out.print("Student to search? "); 
        String input = scanner.nextLine();
        Student s = findStudentInFileReturnS(input);
        if(s==null){return;}
        System.out.println("");
        System.out.println(s.printInBlock());
    }
    
    public static Student findStudentInFileReturnS(String input)throws IOException{
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            Student NS = new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]);
            if(p[0].equals(input) || p[1].equals(input)){br.close(); return NS;}
        }
        System.out.println(RED+"Student not Found"+RESET);
        return null;
    }
}
