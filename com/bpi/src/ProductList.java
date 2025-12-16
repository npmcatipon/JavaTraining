import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {
	public static void main(String[] args) {
		List<String> products = new ArrayList<>();
		products.add("Laptop");
		products.add("Monitor");
		products.add("Printer");
		products.add("Mouse");
		products.add("Keyboard");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("All Products:");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(i + ") " + products.get(i));
		}
		
		System.out.println("");
		
		products.remove(1);
		products.add("Webcam");
		
		System.out.println("After adding and removing products:");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(i + ") " + products.get(i));
		}

		System.out.println("");
		
		System.out.println("Enter product name to search: ");
		String searchProduct = scanner.nextLine().trim();
		if (products.contains(searchProduct)) {
			System.out.println("Product found: " + searchProduct);
			scanner.close();
		}
		else {
			System.out.println(searchProduct + " not found...");
		}
	}
}
