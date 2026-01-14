package com.bpi.m4.activity7;

@FunctionalInterface 
public interface BankTestOperation {
	public void execute() throws InvalidAmountException, InsufficientFundsException;
}
