package model;

// ASSETS
import static model.ColorManager.*;

public class LogicManager {
    
    // STRING IS NUMBER
    public static boolean isNumber(String num){
        try{
            Double.parseDouble(num);
            return true;
        }
        catch(NumberFormatException e){
            System.out.println(RED+"Input Error"+RESET);
            return false;
        } 
    }
    
    // STRING TO INT
    public static int stringToInt(String input){
        if(isNumber(input)){return Integer.parseInt(input);}
        return 0; 
    }
    
    // INT TO STRING
    public static String intToString(int input){
        return String.valueOf(input);
    }
    
    // ROUND 2 DECIMALS
    public static double round2Decimals(double input){
        return Math.floor(input*100)/100;
    }
    
    // IS STRING TRUE
    public static boolean isStringTrue(String input){
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
    public static boolean isStringFalse(String input){
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
    public static boolean isStringGen(String input){
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
    public static boolean isStringLoad(String input){
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
    public static boolean isStringOpen(String input){
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
    public static boolean isStringClose(String input){
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