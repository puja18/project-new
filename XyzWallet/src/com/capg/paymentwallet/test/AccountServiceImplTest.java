package com.capg.paymentwallet.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.AccountServiceImpl;
import com.capg.paymentwallet.service.IAccountService;

public class AccountServiceImplTest {

	private static IAccountService service = null;
@BeforeClass	
public static void createInstance() {
	service = new AccountServiceImpl();
}
@Test(expected = CustomerException.class)
public void testEidForFirstNameLength() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("pu");
	bean.setLastName("radha");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}
@Test(expected = CustomerException.class)
public void testEidForFirstNameNotNull() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName(" ");
	bean.setLastName("radha");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test(expected = CustomerException.class)
public void testEidForFirstNameNumbers() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("12342");
	bean.setLastName("radha");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test
public void testEidForFirstNamePositive() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("Bommidi");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertTrue(result);
}
@Test(expected = CustomerException.class)
public void testEidForLastNameLength() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("ra");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}
@Test(expected = CustomerException.class)
public void testEidForLastNameNotNull() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja ");
	bean.setLastName(" ");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test(expected = CustomerException.class)
public void testEidForLastNameNumbers() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("1234");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test
public void testEidForLastNamePositive() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("Bommidi");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertTrue(result);
	
	
}
@Test(expected = CustomerException.class)
public void testEidForEmailNegative() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja ");
	bean.setLastName("Bommidi ");
	bean.setEmailId("@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test(expected = CustomerException.class)
public void testEidForEmailInvalid() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("Bommidi");
	bean.setEmailId(".com@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test
public void testEidForEmailPositive() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("Bommidi");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertTrue(result);
}
@Test(expected = CustomerException.class)
public void testEidForPhoneNumberAlphabets() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("Bommidi");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6246sajd");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}
@Test(expected = CustomerException.class)
public void testEidForPhoneNUmberNotNull() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja ");
	bean.setLastName("Bommidi ");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo(" ");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test(expected = CustomerException.class)
public void testEidForPhoneNUmberLenghth() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("1234");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertFalse(result);
	
}

@Test
public void testEidForPhoneNumPositive() throws Exception {
	CustomerBean bean = new CustomerBean();
	bean.setFirstName("puja");
	bean.setLastName("Bommidi");
	bean.setEmailId("puja19@gmail.com");
	bean.setPhoneNo("6302088199");
	bean.setPanNum("HDDSFH1234");
	bean.setAddress("CHENNAI");
	AccountBean accountBean = new AccountBean();
	accountBean.setAccountId(101);
	accountBean.setBalance(5000);
	accountBean.setDateOfOpening(new Date());
	accountBean.setInitialDeposit(1000);
	accountBean.setCustomerBean(bean);
	boolean result=service.createAccount(accountBean);
	assertTrue(result);
	
	
}

}