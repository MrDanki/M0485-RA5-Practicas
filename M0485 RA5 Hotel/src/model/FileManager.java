package model;

// File Manager Helps to Work With Files

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
    public static boolean IsFileEmpty(String filePath)throws IOException{
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
    public static boolean ExistIDInFile(String filePath,String ID)throws IOException{
        File file = new File(filePath);
        if(IsFileEmpty(filePath)){return false;}
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
    
    // GET FROM FILE BY ID -> CODE = #1000 -> Where ID in File -> ID,Name,Surname1,Surname2 
    public static String[] GetByIDFromFile(String filePath,String ID,String code)throws IOException{
        File file = new File(filePath);
        if(IsFileEmpty(filePath)){return null;}
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            String[]p = line.split(",");
            int pos = 0;
            for(String f : p){
                if(f.equals(ID) && code.charAt(pos)=='1'){
                    br.close();
                    return p;
                }
                pos++;
            }
        }
        br.close();
        return null;
    }
    
    // EXTRACT ALL FILE CONTENT
    public static ArrayList<String[]> GetAllFileContent(String filePath)throws IOException{
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
    public static void WriteAllFileContent(String filePath,ArrayList<String[]>fileContent)throws IOException{
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
