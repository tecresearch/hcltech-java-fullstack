package com.cetpa.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.cetpa.models.TransactionInfo;
import com.cetpa.services.AccountService;
import jakarta.servlet.http.HttpSession;

@Controller
public class DepositController 
{
	@Autowired private AccountService accountService;
	
	@GetMapping("services/deposit-form")
	public String getDepositFormView()
	{
		return "services/deposit/deposit-money-form";
	}
	@GetMapping("services/deposit.do")
	public String performDepositMoneyOperation(int amount,HttpSession httpSession)
	{
		TransactionInfo transactionInfo=accountService.depositMoney(amount,(Integer)httpSession.getAttribute("accountno"));
		httpSession.setAttribute("transaction",transactionInfo);
		return "redirect:deposit-success";
	}
	@GetMapping("services/deposit-success")
	public ModelAndView depositMoneySuccess(@SessionAttribute("transaction") TransactionInfo transaction)
	{
		ModelAndView modelAndView=new ModelAndView("services/deposit/deposit-money-success");
		modelAndView.addObject("transaction",transaction);
		return modelAndView;
	}
}
