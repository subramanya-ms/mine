package com.wisefinch.java;

import org.testng.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.runtime.*;
//
//public class Jar_runner extends DriverScript {
//	
//	ReusableComponents reusableComponents = new  ReusableComponents();
//	
//	static String workingDir = System.getProperty("user.dir");
//	
//
//	public static void main(String[] args) {
//		
//		File dir = new File(workingDir);
//		
//		try {
//            String[] command = {"cmd.exe", "java", "-jar", dir+"/TC-2676.jar"};
//            Process p =  Runtime.getRuntime().exec(command);           
//        } catch (IOException ex) {
//        }
//		
//		
////		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "java", "-jar", dir+"/TC-2676.jar");
////        pb.directory(dir);
////        try {
////            Process p = pb.start();
////            
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////		
//		
//		
//	}
//
//}


public class Jar_runner {
	
	static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) {
    	
    	
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "TC-2677.jar");
        pb.directory(new File(workingDir));
        try {
            Process p = pb.start();
            LogStreamReader lsr = new LogStreamReader(p.getInputStream());
            Thread thread = new Thread(lsr, "LogStreamReader");
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LogStreamReader implements Runnable {

    private BufferedReader reader;

    public LogStreamReader(InputStream is) {
        this.reader = new BufferedReader(new InputStreamReader(is));
    }

    public void run() {
        try {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}