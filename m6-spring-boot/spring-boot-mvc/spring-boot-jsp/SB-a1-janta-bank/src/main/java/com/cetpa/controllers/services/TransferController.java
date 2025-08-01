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
public class TransferController 
{
	@Autowired private AccountService accountService;
	
	@GetMapping("services/transfer-form")
	public String getTransferFormView()
	{
		return "services/transfer/transfer-money-form";
	}
	@GetMapping("services/verify-account.do")
	public ModelAndView verifyAccountNo(int accountno,HttpSession session)
	{
		ModelAndView modelAndView=new ModelAndView("services/transfer/transfer-money-form");
		session.setAttribute("raccountno",accountno);
		if((Integer)session.getAttribute("accountno")==accountno)
		{
			modelAndView.addObject("msg","This is your own account number");
			return modelAndView;
		}
		String name=accountService.getAccountHolder(accountno);
		if(name==null)
		{
			modelAndView.addObject("msg","Entered account number does not exist");
			return modelAndView;
		}
		modelAndView.setViewName("services/transfer/transfer-money-form2");
		session.setAttribute("rname",name);
		return modelAndView;
	}
	@GetMapping("services/transfer.do")
	public String performTransferMoneyOperation(Model model,int amount,HttpSession httpSession)
	{
		int accountno=(Integer)httpSession.getAttribute("accountno");
		int accountBalance=accountService.getAccountBalance(accountno);
		if(amount>accountBalance)
		{
			model.addAttribute("msg","You do not have sufficient amount into your account");
			model.addAttribute("amount",amount);
			return "services/transfer/transfer-money-form2";
		}
		TransactionInfo transactionInfo=accountService.transferMoney(amount,accountno,(Integer)httpSession.getAttribute("raccountno"));
		httpSession.setAttribute("transaction",transactionInfo);
		return "redirect:transfer-success";
	}
	@GetMapping("services/transfer-success")
	public ModelAndView transferMoneySuccess(@SessionAttribute("transaction") TransactionInfo transaction)
	{
		ModelAndView modelAndView=new ModelAndView("services/transfer/transfer-money-success");
		modelAndView.addObject("transaction",transaction);
		return modelAndView;
	}
}
