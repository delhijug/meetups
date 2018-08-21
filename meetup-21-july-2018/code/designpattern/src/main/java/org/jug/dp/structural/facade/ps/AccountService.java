package org.jug.dp.structural.facade.ps;

import java.util.List;

public interface AccountService {
		public void transfer(int from, int to, int amount);
		public void deposit(int id, int amount);
		public Account getAccount(int id);
		public List<Account> getAllAccounts();
	}