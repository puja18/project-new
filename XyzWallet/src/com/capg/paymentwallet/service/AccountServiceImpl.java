package com.capg.paymentwallet.service;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.dao.AccountDAOImpl;
import com.capg.paymentwallet.dao.IAccountDao;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.exception.CustomerExceptionMessage;

public class AccountServiceImpl implements IAccountService{

	@Override
	public boolean createAccount(AccountBean accountBean) throws Exception {
		IAccountDao dao=new AccountDAOImpl();
		boolean isValid = false;
		if(validations(accountBean)) {
			isValid = true;
    	boolean result=dao.createAccount(accountBean);
		}
		return isValid;
	}

	

	@Override
	public boolean deposit(AccountBean accountBean, double depositAmount)
			throws Exception {
		IAccountDao dao=new AccountDAOImpl();
		double totBalance = accountBean.getBalance()+depositAmount;
		accountBean.setBalance(totBalance);
		boolean result=dao.updateAccount(accountBean);
		return result;
	}

	@Override
	public boolean withdraw(AccountBean accountBean, double withdrawAmount)
			throws Exception {
		IAccountDao dao=new AccountDAOImpl();
		double totBalance = accountBean.getBalance()-withdrawAmount;
		accountBean.setBalance(totBalance);
		boolean result=dao.updateAccount(accountBean);
		return result;
	}

	@Override
	public boolean fundTransfer(AccountBean transferingAccountBean,
			AccountBean beneficiaryAccountBean, double transferAmount) throws Exception {
		double totBalance = transferingAccountBean.getBalance()-transferAmount;
		transferingAccountBean.setBalance(totBalance);
		double totBalance1 = beneficiaryAccountBean.getBalance()-transferAmount;
		beneficiaryAccountBean.setBalance(totBalance1);
		
		
		IAccountDao dao=new AccountDAOImpl();
		boolean result1=dao.updateAccount(transferingAccountBean);
		boolean result2=dao.updateAccount(beneficiaryAccountBean);
		return result1 && result2;
	}

	



	@Override
	public AccountBean findAccount(int accId, String phoneNo) throws Exception {
		IAccountDao dao=new AccountDAOImpl();
		AccountBean bean=dao.findAccount(accId, phoneNo);
		return bean;
	}



	@Override
	public boolean validations(AccountBean accountBean) throws CustomerException {
		// TODO Auto-generated method stub
		boolean isValid=true;
		
		if(!( accountBean.getCustomerBean().getFirstName().matches("[a-zA-Z]{3,}")))
		{
			isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR1);
		}
		if(!( accountBean.getCustomerBean().getLastName().matches("[a-zA-Z]{4,}")))
		{
			isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR2);
		}
		if(!(accountBean.getCustomerBean().getPhoneNo().toString().matches("^[6-9][0-9]{9}"))){
			
			isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR3);
		}
		if((accountBean.getCustomerBean().getEmailId() == null || !(accountBean.getCustomerBean().getEmailId().matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+")))){

			isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR4);
		}
		if((accountBean.getCustomerBean().getPanNum()==null) || (!(accountBean.getCustomerBean().getPanNum().matches("^[A-Z][A-Z0-9]{9}")))){
			
			isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR5);
		}
		if((accountBean.getCustomerBean().getAddress()==null)||(!(accountBean.getCustomerBean().getAddress().matches("[A-Za-z]{5,50}"))))
		{
			isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR6);
		}
		if(accountBean.getBalance()==0||!(accountBean.getBalance()>0)){
			isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR7);
	 
		}
		return isValid;
		
	}




}
