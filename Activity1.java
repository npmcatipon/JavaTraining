package com.bpi.training;

import java.util.Scanner;

public class Activity1 {
	public static void main(String[] args) {
		
		Scanner name_input = new Scanner(System.in);

		System.out.print("What is your name? ");
		String name = name_input.nextLine();
        System.out.println("Hello, " + name + "!");
        
	}
}
