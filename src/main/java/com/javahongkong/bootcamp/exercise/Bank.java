package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;

public class Bank implements BankInterface{

	private LinkedHashMap<Long, Account> accounts; // object reference

	private static long count = 0;

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		CommercialAccount commercialAccount = new CommercialAccount(company, count++, pin, startingDeposit);
		this.accounts.put(commercialAccount.getAccountNumber(), commercialAccount);
		return commercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		ConsumerAccount consumerAccount =
				new ConsumerAccount(person, count++, pin, startingDeposit);
		this.accounts.put(consumerAccount.getAccountNumber(), consumerAccount);
		return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		return accounts.getAccount(accountNumber).getPin(validatePin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return accounts.getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		this.accounts.getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return this.getAccount(accountNumber).debitAccount(amount);
	}
}
