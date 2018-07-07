package com.capgemini.paymentapp.pl;

import java.math.BigDecimal;
import java.util.Scanner;

import com.capgemini.paymentapp.beans.Customer;
import com.capgemini.paymentapp.services.WalletService;
import com.capgemini.paymentapp.services.WalletServiceImpl;

public class Client {
	static Scanner sc;
	static WalletService service;
	static
	{
		sc=new Scanner(System.in);
		service=new WalletServiceImpl();
	}
	   public static void main( String[] args ){
		   String ans;
		   do
		   {
			   ans="no";
		  System.out.println("\t enter the choice");
		  System.out.println("\t 1. create an account");
		  System.out.println("\t 2. show balance");
		  System.out.println("\t 3. fund transfer");
		  System.out.println("\t 4. deposit amount");
		  System.out.println("\t 5. withdraw amount");
		  int choice=sc.nextInt();
		  
		  switch (choice) {
		case 1:
			System.out.println("enter the name of customer");
			String name=sc.next();
			System.out.println("enter the mobile no");
			String mobileno=sc.next();
			System.out.println("enter the amount");
			BigDecimal amount=sc.nextBigDecimal();
			Customer customer=service.createAccount(name, mobileno, amount);
			System.out.println(customer);
			break;

		case 2:
			System.out.println("enter the mobile no for which you want customer wallet balance");
			String mobileno1=sc.next();
			Customer customer2=service.showBalance(mobileno1);
			System.out.println(customer2);
			break;

		case 3:
			System.out.println("enter the mobile no");
			String sourceMobileNo=sc.next();
			System.out.println("enter the mobile no");
			String targetMobileNo=sc.next();
			System.out.println("enter the amount");
			BigDecimal amount3=sc.nextBigDecimal();
			Customer customer3=service.fundTransfer(sourceMobileNo, targetMobileNo, amount3);
			System.out.println(customer3);
			break;

		case 4:
			System.out.println("enter the mobile no for which you want to deposit");
			String mobileNo2=sc.next();
			System.out.println("enter the amount");
			BigDecimal amount4=sc.nextBigDecimal();
			Customer customer4=service.depositAmount(mobileNo2, amount4);
			System.out.println(customer4);
			break;

		case 5:
			System.out.println("enter the mobile no for which you want to withdraw");
			String mobileNo3=sc.next();
			System.out.println("enter the amount");
			BigDecimal amount5=sc.nextBigDecimal();
			Customer customer5=service.withdrawAmount(mobileNo3, amount5);
			System.out.println(customer5);
			break;

			
		default:
			System.exit(0);
			break;
		}
		 System.out.println("enter yes to continue");
		 ans=sc.next();
		 
			} while (ans.equals("yes") || ans.equals("y") || ans.equals("Yes"));
	}
}
