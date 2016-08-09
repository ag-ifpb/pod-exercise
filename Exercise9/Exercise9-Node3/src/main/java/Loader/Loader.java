/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {
    
    public static void main(String[] args) throws IOException {
        
        String path = System.getProperty("user.home")+"/archive.txt";
        
        File file = new File(path);
        
        if(!file.exists()){
            
            file.createNewFile();
        }
        
        FileWriter f = new FileWriter(file,true);
        
        BufferedWriter bf = new BufferedWriter(f);
        
        bf.append("New line in:" + LocalDateTime.now().toString());
        bf.newLine();

        bf.flush();
        bf.close();
    }
    
}
