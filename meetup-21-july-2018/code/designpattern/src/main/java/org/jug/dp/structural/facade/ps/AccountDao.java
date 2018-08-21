package org.jug.dp.structural.facade.ps;

import java.util.List;

public interface AccountDao {
	 public void update(Account account);
	 public Account find(int id);
	 public List<Account> getAllAccounts();
}
