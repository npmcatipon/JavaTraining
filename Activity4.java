import java.util.Scanner;

public class Activity4 {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		
		System.out.print("Enter your age: ");
        int age = scanner1.nextInt();

        if (age < 18) {
            System.out.println("Minor");
        } else if (age >= 18 && age <= 59) {
            System.out.println("Adult");
        } else {
            System.out.println("Senior");
        }
	}
}
