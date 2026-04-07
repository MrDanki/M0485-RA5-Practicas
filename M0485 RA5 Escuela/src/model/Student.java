package model;

// MODEL
import model.Degree;

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

public class Student {
    
    // VARIABLES
    public String DNI;
    public String name;
    public String surname;
    public int age;
    public String degree;
    
    // CONSTRUCTOR
    public Student(String DNI,String name,String surname,int age,String degree){
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.degree = degree;
    }
    
    // GETTER
    public String getDNI(){return DNI;}
    public String getName(){return name;}
    public String getSurName(){return surname;}
    public int getAge(){return age;}
    public String getDegree(){return degree;}
    
    // SETTER
    public void setDNI(String DNI){this.DNI = DNI;}
    public void setName(String name){this.name = name;}
    public void setSurName(String surname){this.surname = surname;}
    public void setAge(int age){this.age = age;}
    public void setDegree(String degree){this.degree = degree;}
    
    // EDIT
    public void editDNI(String DNI)throws IOException{
        this.delete();
        this.DNI = DNI;
        this.create();
    }
    public void editName(String name)throws IOException{
        this.delete();
        this.name = name;
        this.create();
    }
    public void editSurname(String surname)throws IOException{
        this.delete();
        this.surname = surname;
        this.create();
    }
    public void editAge(int age)throws IOException{
        this.delete();
        this.age = age;
        this.create();
    }
    
    public void printInBlock(){
         System.out.println(
        "== "+RED+DNI+RESET+" =="+"\n"+
        "- Name: "+RED+name+RESET+"\n"+
        "- Surname: "+RED+surname+RESET+"\n"+
        "- DNI: "+RED+DNI+RESET+"\n"+
        "- Age: "+RED+age+RESET+"\n"+
        "- Degree: "+RED+degree+RESET+"\n");
    }
    
    public void printInBlankBlock(){
        System.out.println(
        "== "+DNI+" =="+"\n"+
        "- Name: "+name+"\n"+
        "- Surname: "+surname+"\n"+
        "- DNI: "+DNI+"\n"+
        "- Age: "+age+"\n"+
        "- Degree: "+degree+"\n");
    }
    
    public void printInDisplay(){
        String DNID = "- DNI: "+RED+DNI+RESET;
        String nameD = " / Name: "+RED+name+RESET;
        String surnameD = " / Surname: "+RED+surname+RESET;
        String ageD = " / Age: "+RED+age+RESET;
        String degreeD = " / Degree: "+RED+degree+RESET;
        System.out.println(DNID+nameD+surnameD+ageD+degreeD);   
    }
    
    public String printInBlankDisplay(){
        String DNID = "- "+DNI;
        String nameD = " / "+name;
        String surnameD = " "+surname;
        String ageD = " / "+age;
        return DNID+nameD+surnameD+ageD;       
    }
    
    public String toCSV(){
        if(DNI.equals("gen")){DNI = DNIGenerator();}
        return
        DNI+","+name+","+surname+","+age+","+degree+","+System.lineSeparator();
    }
    public void create()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+degree+"\\alumnos.txt";
        File file = new File(filePath);
        
        if(!find()){
            // WRITE FILE
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(toCSV());
            bw.flush(); 
            bw.close();    
        }else{{System.out.println(RED+name+" "+surname+" exists in file"+RESET);}}
    }
    
    public void changeToDegree(String input)throws IOException{
        Degree ND = new Degree(input);
        if(ND.exists()){
            delete();
            degree = input;
            create();
        }else{System.out.println(RED+"Degree "+input+" does not exists"+RESET);}
    }
    
    public boolean find()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+degree+"\\alumnos.txt";
        File file = new File(filePath);
        // FIND IF EXISTS
        if(isFileEmpty()){return false;}
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            if(p[0].equals(DNI) || (p[1].equals(name) && p[2].equals(surname))){
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }
    
    public void delete()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+degree+"\\alumnos.txt";
        File file = new File(filePath);
        ArrayList<Student> fileContent = new ArrayList();
       
        if(find()){
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
               String[]p = line.split(",");
               fileContent.add(new Student(p[0],p[1],p[2],stringToIntIfNumber(p[3]),p[4]));
            }
            br.close();
            int pos = 0;
            for(Student st : fileContent){
                if(st.getDNI().equals(DNI) || (st.getName().equals(name) && st.getSurName().equals(surname))){
                    fileContent.remove(pos);
                    break;
                }
                pos++;
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(Student st: fileContent){
                bw.write(st.toCSV());
            }
            bw.flush();
            bw.close();
        }
        else{System.out.println(RED+name+" "+surname+" Not found in File"+RESET);}
    }
    
    public boolean isFileEmpty()throws IOException{
        String filePath = System.getProperty("user.dir")+"\\data\\"+degree+"\\alumnos.txt";
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
    

