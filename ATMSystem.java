import java.lang.ArrayIndexOutOfBoundsException;

public class ATMSystem {
	public void processWithdrawal(String accountIndex, String amountInput) {
		double[] accounts = {1000, 2000, 3000};

		System.out.print("Account=" + accountIndex + ",");
		System.out.println(" Amount=" + amountInput);

		int idx = 0;
		double amount = 0;

		try {
			idx = Integer.parseInt(accountIndex);
			amount = Double.parseDouble(amountInput);

			if (amount > accounts[idx]) {
				System.out.printf("Current balance: ₱" + "%.2f%n", accounts[idx]);
				System.out.printf("Withdrawal: ₱" + "%.2f%n", amount); 
				System.out.printf("Insufficient funds. Cannot withdraw ₱"+ "%.2f%n", amount);
				return;
			}

		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid input!");
			System.out.println("Please enter valid numbers.");
			return; 

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Account not found!");
			System.out.println("Invalid account index.");
			return;

		} catch (Exception e) {
			System.out.println("Transaction failed!");
			return;

		}

		System.out.printf("Current balance: ₱" + "%.2f%n", accounts[idx]);

		accounts[idx] -= amount;

		System.out.printf("Withdrawal: ₱" + "%.2f%n", amount);        
		System.out.printf("New balance: " + "%.2f%n", accounts[idx]);           
		System.out.println("Withdrawal successful!");
	}
}
