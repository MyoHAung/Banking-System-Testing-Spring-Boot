package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MoneyTransferDTO {
	
   @NotNull (message ="AccountId is required")
   private long accountId;
   @NotNull (message ="AccountId is required")
   private long transferAccountId;
   @Min(value = 1000, message = "Transfer amount is must be greater than 1000")
   private double amount;
public long getAccountId() {
	return accountId;
}
public void setAccountId(long accountId) {
	this.accountId = accountId;
}
public long getTransferAccountId() {
	return transferAccountId;
}
public void setTransferAccountId(long transferAccountId) {
	this.transferAccountId = transferAccountId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
   
   

}
