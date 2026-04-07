package model;

// ASSETS
import static assets.ColorManager.*;
import static assets.LogicManager.stringToIntIfNumber;

// MODEL
import model.Student;

// JAVA IO
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

// JAVA UTIL
import java.util.ArrayList;

public class Degree {
    
    // VARIABLES
    public String name;
    
    // CONSTRUCTOR
    public Degree(String name){
        this.name = name;
    }
    
    // GETTER
    public String getName(){return name;}
    
    // SETTER
    public void setName(String name){this.name = name;}
    
    public void create()throws IOException{
        String folderPath = System.getProperty("user.dir")+"\\data\\"+name;
        File folder = new File(folderPath);
        folder.mkdir();
        
        String filePath = System.getProperty("user.dir")+"\\data\\"+name+"\\alumnos.txt";
        File file = new File(filePath);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.flush(); 
        bw.close();
    }
    
    public void delete()throws IOException{
        String folderPath = System.getProperty("user.dir")+"\\data\\"+name;
        File folder = new File(folderPath);
        folder.mkdir();
        
        String filePath = System.getProperty("user.dir")+"\\data\\"+name+"\\alumnos.txt";
        File file = new File(filePath);
        
        file.delete();
        folder.delete();
    }
    
    public void printStudents()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+name+"\\alumnos.txt";
        File file = new File(filePath);
        
        ArrayList<Student> fileContent = new ArrayList();
       
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
           String[]p = line.split(",");
           fileContent.add(new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]));
        }
        br.close();
        for(Student S : fileContent){
            S.printInDisplay();
        }
        
    }
    
    public int getStudentsCount()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+name+"\\alumnos.txt";
        File file = new File(filePath);
        ArrayList<Student> fileContent = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
           String[]p = line.split(",");
           fileContent.add(new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]));
        }
        br.close();
        return fileContent.size();
    }
    
    public Student findAndReturnStudent(String input)throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+name+"\\alumnos.txt";
        File file = new File(filePath);
        ArrayList<Student> fileContent = new ArrayList();
       
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
           String[]p = line.split(",");
           fileContent.add(new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]));
        }
        br.close();
        
        for(Student S : fileContent){
            if(S.getDNI().equals(input)){return S;}
            if(S.getName().equals(input)){return S;}
        }
        return null;
    }
    
    public Student getFirstStudent()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+name+"\\alumnos.txt";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String[]p = br.readLine().split(",");
        return new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]);
    }
    
    public boolean exists()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+name;
        File file = new File(filePath);
        if(!file.exists()){
            return false;
        }
        return true;
    }
    
    public void printInDisplay(){
        System.out.println("- "+name);
    }
    
     public boolean isFileEmpty()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+name+"\\alumnos.txt";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        if (br.readLine() == null){
            br.close();
            return true;
        }
        br.close();
        return false;
    }
    
}
