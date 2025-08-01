package com.cetpa.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.cetpa.repositories.AccountRepository;

@Controller
public class BalanceController 
{
	@Autowired private AccountRepository accountRepository;
	
	@GetMapping("services/view-balance")
	public ModelAndView getBalanceView(@SessionAttribute("accountno") int accountno)
	{
		int amount=accountRepository.getAmount(accountno);
		ModelAndView modelAndView=new ModelAndView("services/balance/show-balance");
		modelAndView.addObject("amount",amount);
		return modelAndView;
	}
}
