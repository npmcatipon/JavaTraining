public class BankAccount {

	String accountName = "";

	public void getAccountNameString(String accountNumber) {
        try {
            if ("ACC-001".equals(accountNumber)) {
                accountName = "Juan Dela Cruz";
                System.out.println("Looking up account: " + accountNumber);
                System.out.println("Account Holder: " + accountName);
                System.out.println();
            } else if ("ACC-002".equals(accountNumber)) {
                accountName = "Juan Dela Cruz2";
                System.out.println("Looking up account: " + accountNumber);
                System.out.println("Account Holder: " + accountName);
                System.out.println();
            } else {
            	System.out.println("Looking up account: " + accountNumber);
                throw new IllegalArgumentException("Account not found!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println(" ");
        }
	}
}
