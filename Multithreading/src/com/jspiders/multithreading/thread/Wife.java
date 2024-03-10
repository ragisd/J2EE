package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resources.Account;

public class Wife extends Thread{
	private Account account;
	
	public Wife(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		account.deposit(12000);
		account.withdraw(4000);
	}
}
