/*No-Name
6313139 Ruttiyaporn Kongtrakul 
6313141 Vatcharapong Laklaem
6313174 Natthabodi Bochol
6213202 Nitipoom Soomsakit*/package mainpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerSaved {
    
    public String name, tname;
    public String avatar, tavatar;
    public int level;
    
    public PlayerSaved(){
        name = "John";
        avatar = "Thara";
        level = 1;
    }
    
    public PlayerSaved(String n, String a, int l){
        name = n;
        avatar = a;
        level = 1;
    }
    public void PlayerDefault(){
        name = "John";
        avatar = "Thara";
        level = 1;
    }
    public void SetAvatar (String a){avatar = a;}
    public void SetName (String n){name = n;}
    public void SetLevel (int L){level = L;}
    public String GetAvatar (){return avatar;}
    public String GetName (){return name;}
    public int GetLevel (){return level;}
    
    public void SetTempAvatar (String a){tavatar = a;}
    public void SetTempName (String n){tname = n;}
    public String GetTempAvatar (){return tavatar;}
    public String GetTempName (){return tname;}
    
    public void printFile(){
        //create file
        File saveFile = new File("savedfile.txt");
        try{
            saveFile.createNewFile();
        }catch(Exception e){ e.printStackTrace(); }
        //printfile
        try{
            PrintWriter printfile = new PrintWriter(saveFile);
            printfile.printf("%s,%s,%d\n",name,avatar,level);
        
        printfile.close();
        }catch(Exception e){ e.printStackTrace(); }
        
        
        
    }
    
    public void readFile(){
        
        File saveFile = new File("savedfile.txt");
        
        boolean opensuccess = false;
        while(!opensuccess){
        try(
                Scanner scan = new Scanner(saveFile);
        ){
            opensuccess = true;
            while (scan.hasNext()){
                try{
                String line = scan.nextLine();
                String [] buf = line.split(",");
                SetName(buf[0]);
                SetAvatar(buf[1]);
                SetLevel(Integer.parseInt(buf[2].trim()));
                print();
                }catch(RuntimeException e){
                    System.out.print(e + "\n");
                }
            }

        }catch(FileNotFoundException e){
            System.out.print(e + "\n");
            }
        }
    }
    
    public void print(){
        System.out.printf("Name : %s Avatar : %s Level : %d \n", name, avatar, level);
    }
    

}
