package com.capgemini.paymentapp.repo;

import com.capgemini.paymentapp.beans.Customer;

public interface WalletRepo {
public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);
}
