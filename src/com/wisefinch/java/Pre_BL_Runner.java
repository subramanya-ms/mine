package com.wisefinch.java;

import org.testng.*;
import java.util.*;

public class Pre_BL_Runner extends DriverScript {
	
	ReusableComponents reusableComponents = new  ReusableComponents();
	
	static String workingDir = System.getProperty("user.dir");
	

	public static void main(String[] args) {
		
		TestNG runner = new TestNG();
		
		List<String> suitefiles=new ArrayList<String>();
		
		suitefiles.add(workingDir+"/PreBl-runner.xml");
		
		System.out.println("working directory is "+workingDir);
		
		runner.setTestSuites(suitefiles);
		
		runner.run();	
		
	}

}
