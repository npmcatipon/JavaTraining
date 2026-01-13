package com.bpi.m4.activity6;

@FunctionalInterface 
public interface BankTestOperation {
	public void execute() throws InvalidAmountException, InsufficientFundsException;
}
