package com.cetpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.Account;
import com.cetpa.models.User;
import com.cetpa.repositories.AccountRepository;
import com.cetpa.repositories.UserRepository;
import com.cetpa.services.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired private UserRepository userRepository;
	@Autowired private AccountRepository accountRepository;

	public int saveUser(User user) 
	{
		//Command to persist user object
		userRepository.persistUser(user);
		Account account=new Account();
		account.setUserid(user.getUserid());
		//Command to account object;
		accountRepository.persistAccount(account);
		return account.getAccountno();
	}
}
