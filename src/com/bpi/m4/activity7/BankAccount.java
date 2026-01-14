package com.bpi.m4.activity7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(BankAccount.class);
	double balance = 10000.00;

	public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {

			logger.info("Withdraw requested : ₱{} ", amount );

			if(amount < 0 ) {
					logger.error("ERROR : cannot withdraw amount entered : ₱{} ",amount);
					throw new InvalidAmountException("ERROR : cannot withdraw amount entered ");
			}

		if(amount > balance ){
				logger.warn("WARNING : Insufficient funds, amount entered : ₱{} ; current balance is : Balance {}", amount,balance);
				throw  new InsufficientFundsException("ERROR : Insufficient amount requested");
		}

		// process
			balance -= amount;

			logger.info("Withdrawal Completed: ₱{}", balance);
	}

	public void deposit(double amount) throws  InvalidAmountException {
			logger.info("Deposit Requested : ₱ {}", amount);

			if (amount <= 0){
					logger.error("ERROR : Cannot deposit negative value : ₱{}", amount);
					throw new InvalidAmountException("ERROR : Invalid ammount entered");
			}

			if (amount > 50000){
					logger.warn("Large deposit: ₱{} - requires verification", amount);
					balance += amount;
					logger.info("Deposit Completed : ₱{}, New balance : ₱{}", amount,balance);
			}
	}


	public static void runTest(BankTestOperation operation, String operationName) {
			try {
					operation.execute();
					logger.info("Test '{}' completed successfully.", operationName);
			} catch (InvalidAmountException e) {
					// Log ERROR with exception object
					logger.error("Test '{}' failed due to invalid amount.", operationName, e);
			} catch (InsufficientFundsException e) {
					// Log ERROR with exception object
					logger.error("Test '{}' failed due to insufficient funds.", operationName, e);
			} catch (Exception e) {
					// Optional: catch any other unexpected exceptions
					logger.error("Test '{}' encountered an unexpected error.", operationName, e);
			}
	}

}
