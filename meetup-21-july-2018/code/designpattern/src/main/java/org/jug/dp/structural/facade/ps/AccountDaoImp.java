package org.jug.dp.structural.facade.ps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoImp implements AccountDao {
	
		private Map<Integer, Account> accouts = new HashMap<Integer, Account>();
	
		{
			accouts.put(1, new Account(1, "raja", 5000));
			accouts.put(2, new Account(2, "ravi", 1000));
		}
	
		@Override
		public void update(Account account) {
			accouts.put(account.getId(), account);
		}
	
		@Override
		public Account find(int id) {
			return accouts.get(id);
		}

		public List<Account> getAllAccounts(){
			return null;
		}
	
	}
