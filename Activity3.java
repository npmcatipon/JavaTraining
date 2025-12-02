package com.bpi.training;

import java.util.Scanner;

public class Activity3 {
	public  static 	int addNum(int num1, int num2) {
		return num1 + num2;
	}
	
	public  static 	int subNum(int num1, int num2) {
		return num1 - num2;
	}
	
	public  static	int mulNum(int num1, int num2) {
		return num1 * num2;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num1;
		int num2;
		
		System.out.println("Enter first Integer: ");
		num1 = input.nextInt();
		
		System.out.println("Enter second Integer: ");
		num2 = input.nextInt();
		
		System.out.println("Sum: " + addNum(num1,num2));
		System.out.println("Difference: " + subNum(num1,num2));
		System.out.println("Product: " + mulNum(num1,num2));
		
	}

}
