package com.wisefinch.java;

public class Fizzfunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i=1,n=100;
		
		for (i=1;i<=n;i++) { // for every number from i to 100 i.e. 1 to 100
			
			if(i % 3 ==0 && i % 5 == 0) { // here the number is multiple of both 3 and 5
				
				System.out.println("fizzbuzz "+i);
				
			}
			if(i % 3 ==0 && i % 5 != 0) { // multiple of only 3 but not 5  !=
				
				System.out.println("divisible by 3 fizz "+i);
				
			}
			
			if(i % 3 !=0 && i % 5 == 0) { // multiple of 5 but not 3
				
				System.out.println("divisible by 5 buzz "+i);
				
			}
			if(i % 3 !=0 && i % 5 != 0) { // not a multiple of 3 and 5
				
				System.out.println("not divisible by 3 or 5 "+i);
				
			}
			
			
		}
		

		
		
		
	}
	
	public static void test() {
		
		System.out.println("extends");
		
	}

}
