package assets;

// JAVA UTIL
import java.util.Random;
import java.util.ArrayList;

public class GeneratorManager {
    
    // DNI ARRAYLIST
    public static ArrayList<String> DNIs = new ArrayList();
    
    // DNI GENERATOR 11111111A
    public static String DNIGenerator(){
        Random random = new Random();
        String[] letras = {
            "A","B","C","D","E","F","G","H","I",
            "J","K","L","M","N","O","P","Q","R",
            "S","T","U","V","W","X","Y","Z"};
        int num = 8;
        int let = 1;
        String lastDNI = "";
        for(int i=0; i<num;i++){
            int indice = random.nextInt(1,9);
            lastDNI = lastDNI + String.valueOf(indice);
        }
        for(int i=0; i<let;i++){
            int indice = random.nextInt(letras.length);
            lastDNI = lastDNI + letras[indice];
        }
        // CHECK FOR LAST DNI
        for(String d : DNIs){
            if(d.equals(lastDNI)){
                DNIGenerator();
                break;
            }
        }
        DNIs.add(lastDNI);
        return lastDNI;
    } 
    
}
