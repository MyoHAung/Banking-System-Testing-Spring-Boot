package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DepoistDTO {
	@NotBlank(message = "Account Id is required")
	private long accountId;
	@Min(value = 1, message = "Deposit amount must be greater than 0")
	private double amount;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
