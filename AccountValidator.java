public class AccountValidator {
	static void validateAccountNumber(String accountNumber) throws Exception{
		if (accountNumber == null) {
			throw new NullPointerException("Account Number cannot be null");
		} else if (accountNumber.length() != 10) {
			throw new Exception("Account Number must be 10 digits");
		} else {
			System.out.println("Valid Account: " + accountNumber);
		}
	}
	
	public static void main(String[] args) {
		try {
			validateAccountNumber("1234567890");
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			validateAccountNumber("123");
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			validateAccountNumber(null);
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		
	}

}
