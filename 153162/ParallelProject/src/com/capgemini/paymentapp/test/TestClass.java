package com.capgemini.paymentapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.capgemini.paymentapp.beans.Customer;
import com.capgemini.paymentapp.beans.Wallet;
import com.capgemini.paymentapp.services.WalletServiceImpl;

class TestClass {
WalletServiceImpl service;{
service= new WalletServiceImpl();
}
@Before
	public void initData(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
				
		 data.put("9900112212", cust1);
		 data.put("9963242422", cust2);	
		 data.put("9922950519", cust3);	
			service= new WalletServiceImpl(data);
			
			
	}
	@Test
	public void testCreateAccount4()
	{
		Customer customer=new Customer(null,null,null);
		
		assertEquals(null,customer.getName());
	}
	@Test
	public void testCreateAccount5()
	{
		Customer customer=new Customer(null,"9928586780",null);
		
		assertEquals(null,customer.getName());
	}
	@Test
	public void testCreateAccount6()
	{
		Customer customer=new Customer(null,null,new Wallet(new BigDecimal(9000)));
		String bal=customer.getWallet().getBalance().toString();
		assertEquals("9000",bal);
	}
	@Test
	public void testCreateAccount7()
	{
		Customer customer=new Customer(null,"9928586780",new Wallet(new BigDecimal(9000)));
		
		assertEquals("9928586780",customer.getMobileNo());
	}
	@Test
	public void testCreateAccount()
	{
		Customer customer=new Customer("Ritvik","9928586780",new Wallet(new BigDecimal(1000)));
		String bal=customer.getWallet().getBalance().toString();
		assertEquals("1000",bal);
	}
	@Test
	public void testCreateAccount1()
	{
		Customer customer=new Customer("Ritvik","9928586780",new Wallet(new BigDecimal(1000)));
		
		assertEquals("Ritvik",customer.getName());
	}
	@Test
	public void testCreateAccount2()
	{
		Customer customer=new Customer("Ritvik","9928586780",new Wallet(new BigDecimal(1000)));
	
		assertEquals("9928586780",customer.getMobileNo());
	}
	
	@Test
	public void testValidateMobileNo()
	{	
		service.validateMobile("998");
		
	}
	@Test
	public void testValidateName()
	{
		service.validateMobile("Vamshi");
		
	}
	@Test
	public void test14()
	{
		
		 Customer cust1=new Customer(null, "9900112212",new Wallet(new BigDecimal(9000)));
		assertEquals(cust1.getMobileNo(),"9900112212");
	}	
	@Test
	public void test12()
	{
		
		 Customer cust1=new Customer(null, "9900112212",new Wallet(new BigDecimal(9000)));
		assertNull(cust1.getName());
	}	
	@Test
	public void test13()
	{
		
		 Customer cust1=new Customer(null, null,new Wallet(new BigDecimal(9000)));
		assertNull(cust1.getMobileNo());
	}	
	
	
	@Test
	
	public void test16()
	{
		
		 Customer cust1=new Customer("$RAM", "9900112212",new Wallet(new BigDecimal(9000)));
		assertEquals(cust1.getName(),"$RAM");
	}	
	
	
	
}
