package com.bpi.m4.activity8;

@FunctionalInterface 
public interface BankTestOperation {
	public void execute() throws InvalidAmountException, InsufficientFundsException;
}
