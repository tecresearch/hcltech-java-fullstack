package com.hcl.payments;

import java.util.List;
import java.util.Scanner;

import com.hcl.payments.model.Account;
import com.hcl.payments.services.PaymentService;
import com.hcl.payments.services.PaymentServiceImpl;

public class Application {

	public static void main(String[] args) {
		PaymentService paymentService=new PaymentServiceImpl();
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Welcome to Banking Services");
			System.out.println("1. Create Account");
			System.out.println("2. UPI Payment");
			System.out.println("3. NEFT Payment");
			System.out.println("4. Search Account Via AccountNo");
			System.out.println("5. Search Account Via UPI");
			System.out.println("6. Check balance via AccountNo");
			System.out.println("7. List all Accounts");
			System.out.println("8. Deposite Money");
			System.out.println("Enter your choise");
			int ch=sc.nextInt();
			
			switch (ch) {
				case 1:
					System.out.println("Enter your name: ");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("Enter your bank name");
					String bank=sc.nextLine();
					System.out.println("Enter your bank IFSC Code");
					String ifsc=sc.next();
					paymentService.createAccount(name,bank,ifsc);
					break;
				case 2:
					System.out.println("Enter your Ammount: ");
					int ammount=sc.nextInt();
					System.out.println("Enter Sender UPI");
					String sUpi=sc.next();
					System.out.println("Enter Reciever UPI");
					String rUpi=sc.next();
					paymentService.doPayment(ammount, sUpi, rUpi);
					break;
				case 3:
					System.out.println("Enter your Ammount: ");
					int neftAmmount=sc.nextInt();
					System.out.println("Enter Sender AccountNo: ");//938659224
					int sAccountNo=sc.nextInt();
					System.out.println("Enter Reciever AccountNo");//1744731780
					int rAccountNo=sc.nextInt();
					System.out.println("Enter Reciever IFSC Code");
					String rIfsc=sc.next();
					paymentService.doPayment(neftAmmount, sAccountNo, rAccountNo, rIfsc);
					break;
				case 4:
					System.out.println("Enter AccountNo to be search account: ");
					int yAccountNo=sc.nextInt();
					Account account=paymentService.getAccountByAccountNo(yAccountNo);
					System.out.println(account==null?"not found":account);
					break;
				case 5:
					System.out.println("Enter UPIId to be search account: ");
					String yourUpi=sc.next();
					Account account1=paymentService.getAccountByUpiId(yourUpi);
					System.out.println(account1==null?"not found":account1);
					break;
				case 6:
					System.out.println("Enter AccountNo to be check balance: ");
					int yourAccountNo=sc.nextInt();
					int balance=paymentService.checkBalance(yourAccountNo);
					System.out.print("Your available balance: ");
					System.out.println(balance==0?"not found":balance);
					break;
				case 7:
					List<Account> account11=paymentService.accountList();
					for(Account acc: account11) {
						System.out.println(acc==null?"not found":acc);
					}
					break;
				case 8:
					System.out.println("Enter account no to be deposit");
					int daccountNo=sc.nextInt();
					System.out.println("Enter ammoount to be deposit");
					int damount=sc.nextInt();
				   System.out.println( paymentService.depositMoney(daccountNo, damount));
				    break;
				default:
					System.out.println("Invalid choise");
			
			}
		}while(true);

	}

}
