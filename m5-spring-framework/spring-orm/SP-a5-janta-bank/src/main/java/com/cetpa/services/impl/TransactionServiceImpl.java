package com.cetpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.repositories.TransactionRepository;
import com.cetpa.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService 
{
	@Autowired private TransactionRepository transactionRepository;
}
