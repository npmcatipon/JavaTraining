import java.util.Scanner;

public class Activity2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    
		System.out.print("Enter your age: ");
	    String ageParamStr = scanner.nextLine();
	    
	    int ageParInt = Integer.parseInt(ageParamStr);
	    double ageParamDob = (double) ageParInt;
	    
	    System.out.println("Your age as int: " + ageParInt);
	    System.out.println("Your age as double: " + ageParamDob);
	    scanner.close();
	}
}
