public class ATMTransactions {
	public static void main(String[] args) {
		System.out.println("ATM BALANCE INQUIRY SYSTEM");
		
		System.out.println("\nTest Case #1: Valid Savings Account");
		checkBalance("100000001", 10000.00);
		
		System.out.println("\nTest Case #2: Valid Checking Account");
		 checkBalance("200000001", 10000.00);
		
		System.out.println("\nTest Case #3: Invalid Account Number Format");
		 checkBalance("A1B2C3D4", 10000.00);
		
		System.out.println("\nTest Case #4: Empty Account Number");
		 checkBalance("", 10000.00);
		
		System.out.println("\nAll test completed!");
	}
	
	public static void checkBalance(String accountNumber,double balance) {
		try {
			Integer.parseInt(accountNumber);
		
			char accountType = accountNumber.charAt(0);
			
			if(accountType == '1')
				System.out.println("Account Type: Savings");
			else if(accountType == '2')
				System.out.println("Account Type: Checking");
			else
				System.out.println("Account Type: Unknown");
			
			
			System.out.println("Account Number: "+ accountNumber);
			System.out.printf("Current Balance: ₱ %.2f", balance);
			System.out.println("\nBalance inquiry successful!\n");
			
		} catch (NumberFormatException e){
			System.out.println("Account Number: " + accountNumber);
			System.out.println("Error: Invalid Account Number!\n");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Account Number: " + accountNumber);
			System.out.println("Error: Account Number is empty or invalid!\n");
		} finally {
			System.out.println("\n========== RECEIPT ==========\n"
                            +  "Transaction Date: January 2, 2026\n"
							+  "Transaction Type: Balance Inquiry\n"
							+  "ATM Location: Main Branch\n"
							+  "Thank you for banking with us!\n"
							+  "==============================\n");
		}
	}
}
