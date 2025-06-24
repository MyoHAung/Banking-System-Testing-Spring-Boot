package com.example.demo.dto;

import com.example.demo.entity.Account;

public class AccountDetailResponseDTO {
	
    private long accountId;
    private String accountName;
    private double balance;
    
    
    public AccountDetailResponseDTO(Account acc) {
    	this.accountId=acc.getId();
    	this.accountName=acc.getHolderName();
    	this.balance=acc.getBalance();
    	
    }


	public long getAccountId() {
		return accountId;
	}


	public String getAccountName() {
		return accountName;
	}


	public double getBalance() {
		return balance;
	}
  
    

}
