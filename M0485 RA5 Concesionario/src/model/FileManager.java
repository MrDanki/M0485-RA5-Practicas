package model;

// JAVA IO
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

// JAVA UTIL
import java.util.ArrayList;

public class FileManager{
    
    // IS FILE EMPTY
    public static boolean isFileEmpty(String filePath)throws IOException{
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        if (br.readLine() == null){
            br.close();
            return true;
        }
        br.close();
        return false;
    }
    
    // EXISTS IN FILE BY ID
    public static boolean existIDInFile(String filePath,String ID)throws IOException{
        File file = new File(filePath);
        if(isFileEmpty(filePath)){return false;}
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            if(p[0].equals(ID)){
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }
    
    // EXISTS IN FILE BY ID
    public static String[] getByIDFromFile(String filePath,String ID)throws IOException{
        File file = new File(filePath);
        if(isFileEmpty(filePath)){return null;}
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            int pos = 0;
            for(String f : p){
                if(f.equals(ID)){
                    br.close();
                    return p;
                }
                pos++;
                if(pos==2){break;}
            }
        }
        br.close();
        return null;
    }
    
    // EXTRACT ALL FILE CONTENT
    public static ArrayList<String[]> getAllFileContent(String filePath)throws IOException{
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String[]> fileContent = new ArrayList();
        while((line = br.readLine()) != null){
            fileContent.add(line.split(","));
        }
        br.close();
        return fileContent;
    }
    
    // WHRITE ALL FILE CONTENT 
    public static void writeAllFileContent(String filePath,ArrayList<String[]> fileContent)throws IOException{
        File file = new File(filePath);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(String[] F : fileContent){
            String line = "";
            for(String f : F){
                line = line+f+",";
            }
            bw.write(line+"\n");
        }
        bw.flush(); 
        bw.close();
    }
}
