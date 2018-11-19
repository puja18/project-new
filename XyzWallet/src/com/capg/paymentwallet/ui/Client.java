package com.capg.paymentwallet.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.bean.WalletTransaction;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.AccountServiceImpl;
import com.capg.paymentwallet.service.IAccountService;

public class Client {
	   
	IAccountService service=new AccountServiceImpl();
	CustomerBean customer=new CustomerBean();
	Scanner scanner=new Scanner(System.in);
	
	
	public static void main(String[] args) throws Exception {
		char ch;
		Client client=new  Client();
		do
		{
		System.out.println("========Payment wallet application========");
		System.out.println("1. Create Account ");
		System.out.println("2. Show Balance ");
		System.out.println("3. Deposit ");
		System.out.println("4. Withdraw ");
		System.out.println("5. Fund Transfer");
		System.out.println("6. Print Transactions");
		System.out.println("7. Exit");
		System.out.println("Choose an option");
		int option =client. scanner.nextInt();
		
		switch (option) {
		case 1:client.create();
               break;
		case 2:client.showbalance();

			break;

		case 3:client.deposit();

			break;
			
			
		case 4:client.withdraw();

			break;
			
	
		case 5:client.fundtransfer();

			break;
			
		
		case 6:client.printTransaction();

			break;
		case 7:System.exit(0);

			break;
			
			
		default:System.out.println("invalid option");
			break;
		}
		
		System.out.println("Do you want to continue press Y/N");
		ch=client.scanner.next().charAt(0);
		
		}while(ch=='y' || ch=='Y');

		
	}
	
	
	void create() throws Exception
	{
	/*	System.out.println("Enter Customer Id \t :");
		int cId = scanner.nextInt();
		*/
		System.out.print("Enter Customer firstname \t :");
		String fname=scanner.next();
		
		System.out.print("Enter Customer lastname \t :");
		String lname=scanner.next();
		
		System.out.print("Enter  Customer  email id \t");
		String email=scanner.next();
		
		System.out.print("Enter  Customer  phone number \t");
		String phone=scanner.next();
		
		System.out.print("Enter  Customer PAN number \t");
		String pan=scanner.next();
		
		System.out.print("Enter  Customer  address \t");
		scanner.nextLine();
		String address=scanner.nextLine();
		
		
		
		CustomerBean customerBean=new CustomerBean();
		
		//customerBean.setcId(cId);
		customerBean.setAddress(address);
		customerBean.setEmailId(email);
		customerBean.setPanNum(pan);
		customerBean.setPhoneNo(phone);
		customerBean.setFirstName(fname);
		customerBean.setLastName(lname);
		
		
		System.out.print("Enter  Account ID \t");
		int accId=scanner.nextInt();
		
		System.out.print("Enter Date of Opening (DD/MM/YYYY) \t");
		String accDateInput=scanner.next();
		
	
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfOpeining=sdf.parse(accDateInput);
		
		
		System.out.print("Enter balance to create account \t");
		double balance=scanner.nextDouble();
		
		AccountBean accountBean=new AccountBean();
		accountBean.setAccountId(accId);
		accountBean.setBalance(balance);
		accountBean.setInitialDeposit(balance);
		accountBean.setCustomerBean(customerBean);;
		accountBean.setDateOfOpening(dateOfOpeining);
		
		boolean result=service.createAccount(accountBean);
		
		if(result)
		{
			System.out.println("******Account is created succesfully******");
       }
		     
		else
		{
			System.out.println("Enter valid details....");
		}
	
	}
	
	void showbalance() throws CustomerException, Exception 
	{
		System.out.println("Enter phone number");
		String phoneNo = scanner.next();
		
		System.out.println("Enter the account Id to show balance");
		int accId = scanner.nextInt();
		
		AccountBean accountBean=service.findAccount(accId,phoneNo);
		
		if(accountBean==null){
			System.out.println("\n\nAccount Does not exist\t\t");
			
		}
		
		double balance=accountBean.getBalance();
				
		System.out.println(accountBean.getCustomerBean());
		System.out.println("\n\nYour balance is\t\t: " +balance);
		
			
		
	}
	
	void deposit() throws Exception
	{
		
		System.out.println("Enter phone number");
		String phoneNo = scanner.next(); 
		
		System.out.println("Enter the account Id you want to deposit");
		int accId = scanner.nextInt();
		
		AccountBean accountBean=service.findAccount(accId, phoneNo);
		if(accountBean==null){
			System.out.println("Account Does not exist");
		
		}
		
		System.out.println("Enter amount that you want to deposit");
		double depositAmt=scanner.nextDouble();
		
		WalletTransaction walletTransaction=new WalletTransaction();
		walletTransaction.setTransactionType(1);
		walletTransaction.setTransactionDate(new Date());
		walletTransaction.setTransactionAmt(depositAmt);
		walletTransaction.setBeneficiaryAccountBean(null);
		
		accountBean.addTransation(walletTransaction);
		
		
		
		boolean result=service.deposit(accountBean, depositAmt);
		
		
		if(result){
			System.out.println("Deposited Money into Account ");
			System.out.println("Total balance in your account is:" + accountBean.getBalance());
		}else{
			System.out.println("NOT Deposited Money into Account ");
		}
			
	}
	
	void withdraw() throws Exception
	{
		System.out.println("Enter the account Id you want to deposit");
		int accId = scanner.nextInt();
		
		System.out.println("Enter phone number");
		String phoneNo = scanner.next(); 
		
		AccountBean accountBean=service.findAccount(accId,phoneNo);
		if(accountBean==null){
			System.out.println("Account Does not exist");
		
		}	
		System.out.println("Enter amount that you want to withdraw");
		double withdrawAmt=scanner.nextDouble();
		
		
		
		WalletTransaction walletTransaction=new WalletTransaction();
		walletTransaction.setTransactionType(2);
		walletTransaction.setTransactionDate(new Date());
		walletTransaction.setTransactionAmt(withdrawAmt);
		walletTransaction.setBeneficiaryAccountBean(null);
		
		accountBean.addTransation(walletTransaction);
		
	
		
		boolean result=service.withdraw(accountBean, withdrawAmt);
		if(result){
			System.out.println("Withdaw Money from Account done");
			System.out.println("Total balance in your account is:" + accountBean.getBalance());
		}else{
			System.out.println("Withdaw Money from Account -Failed ");
		}
		
	}
	
	void fundtransfer() throws Exception
	{
		System.out.println("Enter the account Id you want to deposit");
		int accId = scanner.nextInt();
		
		System.out.println("Enter phone number to transfer money");
		String srcphoneNo = scanner.next(); 
		
		AccountBean accountBean1=service.findAccount(accId,srcphoneNo);
		
		
		System.out.println("Enter phone number to Transfer Money to");
		String targetphoneNo=scanner.next();
		
		AccountBean accountBean2=service.findAccount(accId,targetphoneNo);
		
		System.out.println("Enter amount that you want to transfer");
		double transferAmt=scanner.nextDouble();
		
		WalletTransaction walletTransaction=new WalletTransaction();
		walletTransaction.setTransactionType(3);
		walletTransaction.setTransactionDate(new Date());
		walletTransaction.setTransactionAmt(transferAmt);
		walletTransaction.setBeneficiaryAccountBean(accountBean2);
		
		accountBean1.addTransation(walletTransaction);
		
		
		
		boolean result=service.fundTransfer(accountBean1, accountBean2, transferAmt);
		
		if(result){
			System.out.println("Transfering Money from Account done");
			System.out.println("total balance in your account is :" + accountBean1.getBalance());
			System.out.println("Total balance in your account is :" + accountBean2.getBalance());
		}else{
			System.out.println("Transfering Money from Account Failed ");
		}
		
	}
	
	
	void printTransaction() throws Exception
	{
		System.out.println("Enter the account Id you want to deposit");
		int accId = scanner.nextInt();
		
		System.out.println("Enter phone number for printing Transaction Details");
		String phoneNo = scanner.next(); 
		
		AccountBean accountBean=service.findAccount(accId,phoneNo);
		
		List<WalletTransaction>  transactions=accountBean.getAllTransactions();
		
		System.out.println(accountBean);
		System.out.println(accountBean.getCustomerBean());
		
		System.out.println("------------------------------------------------------------------");
		
		Iterator<WalletTransaction> it = transactions.iterator();
			while(it.hasNext()) {
				WalletTransaction walletTransaction=it.next();
				String s = " ";
				if(walletTransaction.getTransactionType()==1){ 
					s=s+"DEPOSIT";
				}
				if(walletTransaction.getTransactionType()==2){
					s=s+"WITHDRAW";
				}
				if(walletTransaction.getTransactionType()==3){
					s=s+"FUND TRANSFER";
				}
				s=s+"\t\t"+walletTransaction.getTransactionDate();
				
				s=s+"\t\t"+walletTransaction.getTransactionAmt();
				System.out.println(s);
			}
			
			System.out.println("------------------------------------------------------------------");
		
		}
		
				
			
		/*
		for(WalletTransaction wt:transactions){
			
			String str="";
			if(wt.getTransactionType()==1){ 
				s=s+"DEPOSIT";
			}
			if(wt.getTransactionType()==2){
				s=s+"WITHDRAW";
			}
			if(wt.getTransactionType()==3){
				s=s+"FUND TRANSFER";
			}
			
			s=s+"\t\t"+wt.getTransactionDate();
			
			s=s+"\t\t"+wt.getTransactionAmt();
			System.out.println(s);
		}
		
		System.out.println("------------------------------------------------------------------");
	
	}*/
	
		
	    
	
}
