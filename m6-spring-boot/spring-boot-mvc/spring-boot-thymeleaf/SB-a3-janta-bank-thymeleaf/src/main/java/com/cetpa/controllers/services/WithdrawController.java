package com.cetpa.controllers.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.cetpa.models.TransactionInfo;
import com.cetpa.services.AccountService;

@Controller
public class WithdrawController 
{
	@Autowired private AccountService accountService;
	@GetMapping("services/withdraw-form")
	public String getWithdrawFormView()
	{
		return "services/withdraw/withdraw-money-form";
	}
	@GetMapping("services/withdraw.do")
	public String performWithdrawMoneyOperation(Model model,int amount,HttpSession httpSession)
	{
		int accountno=(Integer)httpSession.getAttribute("accountno");
		int accountBalance=accountService.getAccountBalance(accountno);
		if(amount>accountBalance)
		{
			model.addAttribute("msg","You do not have sufficient amount into your account");
			model.addAttribute("amount",amount);
			return "services/withdraw/withdraw-money-form";
		}
		TransactionInfo transactionInfo=accountService.withdrawMoney(amount,accountno);
		httpSession.setAttribute("transaction",transactionInfo);
		return "redirect:withdraw-success";
	}
	@GetMapping("services/withdraw-success")
	public ModelAndView withdrawMoneySuccess(@SessionAttribute("transaction") TransactionInfo transaction)
	{
		ModelAndView modelAndView=new ModelAndView("services/withdraw/withdraw-money-success");
		modelAndView.addObject("transaction",transaction);
		return modelAndView;
	}
}
