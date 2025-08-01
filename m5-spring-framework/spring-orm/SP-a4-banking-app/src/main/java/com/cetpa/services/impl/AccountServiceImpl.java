package com.cetpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cetpa.repositories.AccountRepository;
import com.cetpa.services.AccountService;


@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountRepository accountRepository;
}
