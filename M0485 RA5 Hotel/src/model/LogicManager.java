package model;

// Logic Manager are Logical Functions with More Simple Names and Anti Crash Protection

// ASSETS
import static model.ColorManager.*;

public class LogicManager {
    
    // STRING IS NUMBER
    public static boolean IsNumber(String num){
        try{
            Double.parseDouble(num);
            return true;
        }
        catch(NumberFormatException e){
            System.out.println(RED+"Input Error "+num+" Is not Number"+RESET);
            return false;
        } 
    }
    
    // STRING TO BOOLEAN
    public static boolean StringToBoolean(String input){
        if(IsStringTrue(input)){
            return true;
        }
        if(IsStringFalse(input)){
            return false;
        }
        return false;
    }
    
    // STRING TO INT
    public static int StringToInt(String input){
        if(IsNumber(input)){return Integer.parseInt(input);}
        return 0; 
    }
    
    // INT TO STRING
    public static String IntToString(int input){
        return String.valueOf(input);
    }
    
    // ROUND 2 DECIMALS
    public static double Round2Decimals(double input){
        return Math.floor(input*100)/100;
    }
    
    // IS STRING TRUE
    public static boolean IsStringTrue(String input){
        String[]possibles ={
            "True","true","TRUE",
            "Yes","yes","YES",
            "Si","si","SI",
            "Affirmative","AFFIRMATIVE","affirmative",
            "Affirmativo","AFFIRMATIVO","affirmativo"
        };
        for(String p : possibles){
            if(p.equals(input)){return true;}
        }
        return false; 
    }
    
    // IS STRING FALSE
    public static boolean IsStringFalse(String input){
        String[]possibles ={
            "False","false","FALSE",
            "No","no","NO",
            "Negative","NEGATIVE","negative",
            "Negativo","NEGATIVO","negativo"
        };
        for(String p : possibles){
            if(p.equals(input)){return true;}
        }
        return false; 
    }
    
    // IS STRING GENERATOR
    public static boolean IsStringGen(String input){
        String[]possibles ={
            "Gen","gen","GEN",
            "Generator","GENERATOR","generator",
            "Generate","GENERATE","generate",
            "Generador","GENERADOR","generador"
        };
        for(String p : possibles){
            if(p.equals(input)){return true;}
        }
        return false; 
    }
    
    // IS STRING LOAD
    public static boolean IsStringLoad(String input){
        String[]possibles ={
            "Load","load","LOAD",
            "Cargar","cargar","CARGAR"
        };
        for(String p : possibles){
            if(p.equals(input)){return true;}
        }
        return false; 
    }
    
    // IS STRING OPEN
    public static boolean IsStringOpen(String input){
        String[]possibles ={
            "Open","open","OPEN",
            "Abrir","abrir","ABRIR"
        };
        for(String p : possibles){
            if(p.equals(input)){return true;}
        }
        return false; 
    }
    
    // IS STRING CLOSE
    public static boolean IsStringClose(String input){
        String[]possibles ={
            "Close","close","CLOSE",
            "Cerrar","cerrar","CERRAR"
        };
        for(String p : possibles){
            if(p.equals(input)){return true;}
        }
        return false; 
    }
}