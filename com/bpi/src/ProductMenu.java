import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class ProductMenu {

    public static void main(String[] args) {
        HashSet<String> products = new HashSet<>();
        products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n === Product Menu ===");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                	System.out.print("Enter product to search: ");
                    String searchProduct = scanner.nextLine().trim();
                    if (products.contains(searchProduct)) {
                        System.out.println(searchProduct + " found.");
                        System.out.println("");
                    } else {
                        System.out.println("Product not found.");
                        System.out.println("");
                    }
                    break;

                case "2":
                	System.out.print("Enter product to add: ");
                    String newProduct = scanner.nextLine().trim();
                    if (newProduct.isEmpty()) {
                    	System.out.println("Product name cannot be empty.");    
                    	System.out.println("");
                    } 
                    else if (products.contains(newProduct)) {
                    	System.out.println(newProduct + " is already existing.");
                    	System.out.println("");
                    }
                    else {
                    	products.add(newProduct);
                        System.out.println("Product " + newProduct + " is added successfully.");
                        System.out.println("");
                    }
                    
                    break;

                case "3":
                    if (products.isEmpty()) {
                        System.out.println("No products in the list.");
                        System.out.println("");
                    } else {
                    	System.out.println("List of all the products: ");
                    	
                    	for (String productList : products) {
                			System.out.println(productList);
                		}
                    	
                    	System.out.println("Total unique products: " + products.size());
                    }
                    break;

                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
                    System.out.println("");
            }
        }
    }
}
