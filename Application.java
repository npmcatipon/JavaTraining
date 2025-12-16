import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Map<String, Integer> products = new HashMap<>();
		
		int choice = 0;
		String stringInput;
		
		products.put("Mouse", 10);
		products.put("Monitor", 20);
		products.put("Keyboard", 25);
		products.put("Webcam", 55);
		products.put("Laptop", 5);
		
		while (choice != 5) {
			System.out.println("Select an option:");
			System.out.println("1. Search a product");
			System.out.println("2. Add a product");
			System.out.println("3. Print all products and prices");
			System.out.println("4. Find the Cheapest product");
			System.out.println("5. Exit");
			System.out.println();
			System.out.print("Select option: ");
			
			Scanner input = new Scanner(System.in);

			if (input.hasNextInt()) {
				choice = input.nextInt();
				Scanner product = new Scanner(System.in);
				switch(choice) {
					case 1 :
						System.out.print("Enter a product to search: ");
						stringInput = product.nextLine();

						if (isExistingProduct(products,stringInput)) {
							System.out.println("Product found");
							System.out.println();
						} else {
							System.out.println("Product not found");
							System.out.println();
						}
						break;

					case 2:

						System.out.print("Enter product name to add: ");
						String productName = product.nextLine();
						System.out.print("Enter price:");
						String productPrice = product.nextLine();

						products.put(productName, Integer.parseInt(productPrice));

						System.out.println("Product added: " + productName);
						System.out.println();
						break;

					case 3:
						System.out.println("All products and prices");
						System.out.println();

						for (Map.Entry<String, Integer> i : products.entrySet()) {
							System.out.println(i.getKey() + " - " + i.getValue());
						}
						break;

					case 4:
						Integer lowestPrice = Integer.MAX_VALUE;
						String  lowestName = "";
						for (Map.Entry<String, Integer> i : products.entrySet()) {
							if(i.getValue() < lowestPrice) {
								lowestPrice = i.getValue();
								lowestName = i.getKey();
							}
						}
						System.out.println("Cheapest Product: " + lowestName + " - " + lowestPrice);
						System.out.println();
						break;

					case 5: 
						System.out.println("Goodbye!");
						System.exit(0);

					default:
						System.out.println("Enter proper input");
						break;
				}
			} else {
				System.out.println("Please select 1 - 5.");
			}
			
			
		}
	}
	
	public static void displayMenu() {
		System.out.println("Select an option:");
		System.out.println("1. Search a product");
		System.out.println("2. Add a product");
		System.out.println("3. Print all products and prices");
		System.out.println("4. Find the Cheapest product");
		System.out.println("5. Exit");
	}
	
	public static boolean isExistingProduct(Map<String, Integer> products, String findString) {
		return products.containsKey(findString);
	}
}
