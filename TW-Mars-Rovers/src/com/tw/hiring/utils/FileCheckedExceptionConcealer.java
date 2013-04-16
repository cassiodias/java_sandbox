package com.tw.hiring.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileCheckedExceptionConcealer {

    private BufferedReader input;
    
    public FileCheckedExceptionConcealer(String aFile) throws Exception {
	try {
	    input =  new BufferedReader(new FileReader(aFile));
	} catch (FileNotFoundException e) {
	    throw new Exception("Error to load file");
	}
    }
    
    public String getContent(){
          String line = null;
          try {
	    while (( line = input.readLine()) != null){
	        //contents.append(line);
	        //contents.append(System.getProperty("line.separator"));
	      }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
        return null;
        
    }
    
}
