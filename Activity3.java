import java.util.Scanner;

public class Activity3 {
	public static void main(String[] args) {
		
		Scanner scanner1 = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int value1 = Integer.parseInt(scanner1.nextLine());
		System.out.print("Enter second integer: ");
		int value2 = Integer.parseInt(scanner1.nextLine());

		System.out.println("Sum is: "+ Sum(value1, value2));
		System.out.println("Difference is: "+ Diff(value1, value2));
		System.out.println("Product is: "+ Prod(value1, value2));

		sc.close();
		
	}
	
	public static int Sum(int int1, int int2) {
		
		return int1 + int2;
	}

	public static int Diff(int int1, int int2) {
			
		return int1 - int2;
	}
	
	public static int Prod(int int1, int int2) {
	
	return int1 * int2;
	}
	
	
}
