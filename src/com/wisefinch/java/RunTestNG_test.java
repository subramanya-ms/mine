package com.wisefinch.java;

import org.testng.*;

import java.awt.AWTException;
import java.io.IOException;
import java.util.*;

public class RunTestNG_test extends DriverScript {
	
	ReusableComponents reusableComponents = new  ReusableComponents();
	
	static String workingDir = System.getProperty("user.dir");
	

	public static void main(String[] args) throws IOException, AWTException {
		
	PlClass pl = new PlClass();
	pl.init();
	pl.setup("linux", "browser", "remote");
	pl.validate_Test_2676("linux", "browser", "remote");
	pl.wrapUpMethod();
	pl.wrapUp();
		
	}

}
