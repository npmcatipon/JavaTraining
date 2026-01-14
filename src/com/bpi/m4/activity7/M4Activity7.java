package com.bpi.m4.activity7;

public class M4Activity7 {

	public static void main(String[] args) {
		BankAccount bac = new BankAccount();

		BankAccount.runTest(()-> bac.deposit(5000),"Deposit");
		BankAccount.runTest(() -> bac.withdraw(3000), "Withdrawal");
		BankAccount.runTest(() -> bac.deposit(-500), "Deposit");
		BankAccount.runTest(() -> bac.withdraw(20000), "Withdrawal");
		BankAccount.runTest(() -> bac.deposit(60000), "Deposit");
	}
}