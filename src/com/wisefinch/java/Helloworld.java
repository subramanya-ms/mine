package com.wisefinch.java;




public class Helloworld {
	
	static String test = "testing global";
	static int j = 0;

	public static void main(String[] args) {
		
		
		if(test.length() == 14) {
			
			String test1 =  "matches";
			
			System.out.println(test1);
		}else {
			
		//	test1 = "wrong";
			test = "wrong";
		}
		
		for(int i=0;i<10;i++) {
			
			System.out.println(i);
			
		}
		
		System.out.println(j);
		
	//	String test1 = "testing local";
		
		//test = "variable doesnt change";
		// TODO Auto-generated method stub
		
		//System.out.println("happy monday");
		
	//	test = test1;
		
	//	itsmonday();
	//	itstuesday();
	//	itswednesday();
		
	//	Firstprogram fp = new Firstprogram();
		
		
		//fp.testfile();
		
	//	fp.main(args);
		
		
		System.out.println(test);
	//	System.out.println(test1);
		
		Firstprogram fr = new Firstprogram();
		
		fr.main(args);
		
		

	}
	
	public static void itsmonday() {
		
		System.out.println("today is monday");
		
	}
	
	
public static void itstuesday() {
		
		System.out.println("today is tuesday");
		
	}

public static void itswednesday() {
	
	System.out.println("today is wednesday");
	
}
	

}
