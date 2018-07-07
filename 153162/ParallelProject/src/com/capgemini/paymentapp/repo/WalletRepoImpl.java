package com.capgemini.paymentapp.repo;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.capgemini.paymentapp.beans.Customer;

public class WalletRepoImpl implements WalletRepo {
	private Map<String, Customer> data; 
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

	public boolean save(Customer customer) {
			if(data==null)
			{
				
				return false;
			}
			else
			{
				data.put(customer.getMobileNo(), customer);
				return true;
			}
	}

	public Customer findOne(String mobileNo) {
		Set s=data.entrySet();
		Customer customer = null;
		Iterator itr=s.iterator();
		while(itr.hasNext())
		{
			Map.Entry map=(Entry) itr.next();
			String mobile=(String) map.getKey();
			if(mobile.equals(mobileNo))
			{
				customer=(Customer) map.getValue();
			}
		}
		return customer;
	}
}
