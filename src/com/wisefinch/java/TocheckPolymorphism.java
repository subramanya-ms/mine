package com.wisefinch.java;

public class TocheckPolymorphism extends TocheckPolymorphismparent {

	static int add1;
	static String test = "one", test1 = "two", test3 = null;
	final int test111 = 10;
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
//		System.out.println(addition(1,2));
	//	System.out.println(addition(1,2,3));
//		System.out.println(addition("wise","finch"));
		
		TocheckPolymorphismparent parent = new TocheckPolymorphismparent();
		
		parent.printer();
		
		TocheckPolymorphismparent child = new TocheckPolymorphism();
		
		child.printer();
		

	}

	
	public static int addition(int a, int b) {
		
		add1 = a+b;
		
		return add1;
		
	}
	
	public static String addition(String one, String two) {
		
		
		test3 = one+two;
		return test3;
		
	}
	
	
	public static int addition(int a, int b, int c) {
		
		add1 = a+b+c;
		
		return add1;
	}
	
@Override	
void printer() {
		
		System.out.println("this is child class");
	}
	
}
