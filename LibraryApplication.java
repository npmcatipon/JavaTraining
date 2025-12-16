/*
 * 1. Upon application start, ask user to create one User
 * 2. Create one Library object
 * 3. Initialize 5 Book objects and add it to all Library slots
 * 4. Display options:
 * 
 * - [1] Display All Books
 * - [2] Display Available Books
 * - [3] Display All Borrowed Books
 * - [4] Borrow Book
 * - [5] Return Book
 * - [6] Exit
 * 
 * - user selects the number of the option
 * ===============================================
 * 
 *	 [1] Display All Books
 * - Display all Books (ID, Title and Author) regardless if there is a Loan existing for that Book.
 *   
 *   [2] Display Available Books
 * - Display Books that do not have a Loan slot
 * 
 *   [3] Display All Borrowed Books 
 * - Display Books that have a Loan equivalent.
 * - Display the Book title and the User name of borrower
 *   
 *	 [4] Borrow Book
 * - Displays all available books and User selects what book to borrow
 * - Create a Loan object, set Loan id set Book and set User to current user
 * 
 * 	 [5] Return Book
 * - Display all Loans, user selects the Loan and removes that from the slot
 * 
 *   [6] Exit
 * - Stops the program  
 * */

import java.util.Scanner;


public class LibraryApplication {
	
	private User user;
	private Library library;
	private static Book[] books = {
	new Book(1, "Book1", "Author1", "AVAILABLE"),
	new Book(2, "Book2", "Author2", "AVAILABLE"),
	new Book(3, "Book3", "Author3", "AVAILABLE"),
	new Book(4, "Book4", "Author4", "AVAILABLE"),
	new Book(5, "Book5", "Author5", "BORROWED")
	};
	// Main Application Logic, call this in your Main.java
	public void start() {
		// initial user creation
		this.user = new User();

		// initial library creation
		this.library = new Library();
		
		// add code here
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a name: ");
		user.setName(sc.nextLine());
		
		System.out.println("Hello, " + user.getName());
		
		showMenu();
		
		System.out.print("Enter Choice: (1-6)");
		int menuChoice = sc.nextInt();
		
		switch(menuChoice) {
		case 1:
			displayAllBooks();
			break;
		case 2:
			displayAvailableBooks();
			break;
		case 3:
			displayAllBorrowedBooks();
			break;
		case 4:
			borrowBook();
			break;
		case 5:
			returnBook();
			break;
		case 6:
			System.out.println("Thank you for using the application.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Selection.");
			break;
		}
	}
	
	private void returnBook() {
		// TODO Auto-generated method stub
		
	}

	private void borrowBook() {
		// TODO Auto-generated method stub
		
	}

	private void displayAllBorrowedBooks() {
		System.out.println("List of Books Available");
		for (Book book: books) {
			if (book.getStatus() == "BORROWED") {
				System.out.println("ID: " + book.getId());
				System.out.println("Title: " + book.getTitle());
				System.out.println("Author: " + book.getAuthor());				
			}
		}
	}

	private void displayAvailableBooks() {
		availableBooks();
	}

	private void displayAllBooks() {
		System.out.println("List of Books");
		for (Book book: books) {
			System.out.println("ID: " + book.getId());
			System.out.println("Title: " + book.getTitle());
			System.out.println("Author: " + book.getAuthor());				
		}

		
	}

	private static void showMenu() {
		System.out.println("[1] Display All Books");
		System.out.println("[2] Display Available Books");
		System.out.println("[3] Display All Borrowed Books");
		System.out.println("[4] Borrow Book");
		System.out.println("[5] Return Book");
		System.out.println("[6] Exit");
	}
	
	private static void availableBooks() {
		System.out.println("List of Books Available");
		for (Book book: books) {
			if (book.getStatus() == "AVAILABLE") {
				System.out.println("ID: " + book.getId());
				System.out.println("Title: " + book.getTitle());
				System.out.println("Author: " + book.getAuthor());				
			}
		}
	}
		
}
