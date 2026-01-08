public class M4_Activity1 {
	
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();

		System.out.println("=== Bank Account Name Display ===");

		bankAccount.getAccountNameString("ACC-001"); // Output: Juna Dela Cruz
        bankAccount.getAccountNameString("ACC-999"); // Output: Error message

        System.out.println("=== Program completed succesfully! ===");
	}
}
