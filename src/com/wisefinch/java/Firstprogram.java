package com.wisefinch.java;

public class Firstprogram extends Fizzfunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello world"); 
		
		System.out.print("we are ");
		
		System.out.println("wisefinch");
		
		Variablehelper vr = new Variablehelper();
		
		//vr.main(args);
		
		//test();
		
		testfile();
		
		System.out.println(testfile1("anandh"));
		
		

	}
	
	
	public static void testfile() {
		
		System.out.println("calling via different class file");
		
		testfile1("from different");
		
	}
	
public static String testfile1(String val) {
		
		System.out.println("calling via ffdgsdg class file "+val);
		testfile2(val);
		
		return val;
		
		
	}

public static void testfile2(String test1) {
	
	System.out.println("calling via sdjgsdoghsdghi class file"+test1);
	
}

}
