import java.util.Scanner;

public class Activity2 {
	public static void main(String[] args) {
		
		Scanner scanner1 = new Scanner(System.in);
		
		System.out.print("Enter your age:");
		String age = scanner1.nextLine();
		
		int ageInt = Integer.parseInt(age);
		double ageDouble = Double.parseDouble(age);
		
		System.out.println("Your age as int: " + ageInt);
		System.out.println("Your age as double: " + ageDouble);
		
	}

}
