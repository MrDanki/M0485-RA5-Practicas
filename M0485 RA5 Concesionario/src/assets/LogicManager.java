package assets;

// ASSETS
import static assets.ColorManager.*;

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
    public static int stringToIntIfNumber(String input){
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
            "True","true","TRUE","T","t",
            "Yes","yes","YES","Y","y",
            "Si","si","SI","S","s",
            "Affirmative","AFFIRMATIVE","Affirmative","A","a"
        };
        for(String p : possibles){
            if(p.equals(input)){return true;}
        }
        return false; 
    }
}