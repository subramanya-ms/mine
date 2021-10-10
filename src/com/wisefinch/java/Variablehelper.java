package com.wisefinch.java;

public class Variablehelper {
	

static String first = "test";
static int j = (int) 10.3, i = 1512214234;
static float fval=(float) 13.5, testval = (float) 19.7;

static double test1 = 1.5, test2= 2.5;
	
	public static void main(String [] args) {
		
		float f1, f2;
		
		f1 = (float) 12.3;
		
		long testing = 1231241243;
		double ttt = 993992929;
		
		String valtesting = "wisefinch";
		
		System.out.println("int add "+(i+j));
		System.out.println("float printer "+(fval+testval));
		System.out.println("double add "+(test1+test2));
		System.out.println("string add "+(first+valtesting));
		
		System.out.println(f1+j);
		
		
		first = Integer.toString(i) + 10;
		
		
		
		System.out.println(first);
		
		
		
	}
}

