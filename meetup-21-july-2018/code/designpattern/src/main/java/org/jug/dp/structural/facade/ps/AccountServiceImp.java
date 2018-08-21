package org.jug.dp.structural.facade.ps;

import java.util.List;

public class AccountServiceImp implements AccountService {
	
		private AccountDao accountDao;
		
	
		public void setAccountDao(AccountDao accountDao) {
			this.accountDao = accountDao;
		}
	
		@Override
		public void transfer(int from, int to, int amount) {
			Account fromAccount = accountDao.find(from);
		Account toAccount = accountDao.find(to);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountDao.update(fromAccount);
		accountDao.update(toAccount);

		}
	
		@Override
		public void deposit(int id, int amount) {
			Account account=accountDao.find(id);
			account.setBalance(account.getBalance()+amount);
			accountDao.update(account);
		}
	
		@Override
		public Account getAccount(int id) {
			// TODO Auto-generated method stub
			return accountDao.find(id);
		}
	

		public List<Account> getAllAccounts(){
			return accountDao.getAllAccounts();
		}
	}

