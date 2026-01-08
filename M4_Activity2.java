public class M4_Activity2 {
	public static void main(String[] args) {

		ATMSystem atm = new ATMSystem(); 
		
		System.out.println("==== ATM Withdrawal Systems ===");
		System.out.println();
		System.out.println("--- Test 1: Valid Withdrawal ---");

		atm.processWithdrawal("1" , "5000");

		System.out.println("--- Test 2: Invalid Account Index ---");

		atm.processWithdrawal("abc" , "5000");

		System.out.println("--- Test 3: Account not found ---");

		atm.processWithdrawal("10" , "5000");

		System.out.println("--- Test 4: Insufficient Funds ---");
		atm.processWithdrawal("1" , "20000");
		System.out.println();

		System.out.println("==== All tests completed! ==="); 
	}
}
