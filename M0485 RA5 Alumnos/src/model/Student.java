package model;

// ASSETS
import static assets.ColorManager.*;

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
    
    public String printInBlock(){
        return
        "== "+RED+DNI+RESET+" =="+"\n"+
        "- Name: "+RED+name+RESET+"\n"+
        "- SurName: "+RED+surname+RESET+"\n"+
        "- DNI: "+RED+DNI+RESET+"\n"+
        "- Age: "+RED+age+RESET+"\n"+
        "- Degree: "+RED+degree+RESET+"\n";
    }
    
    public String printInDisplay(){
        String DNID = "- DNI: "+RED+DNI+RESET;
        String nameD = " / Name: "+RED+name+RESET;
        String surnameD = " / SurName: "+RED+surname+RESET;
        String ageD = " / Age: "+RED+age+RESET;
        String degreeD = " / Degree: "+RED+degree+RESET;
        return DNID+nameD+surnameD+ageD+degreeD;       
    }
    
    public String toTxt(){
        return
        DNI+","+name+","+surname+","+age+","+degree+System.lineSeparator();
    }
}
