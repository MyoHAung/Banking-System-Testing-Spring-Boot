package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.Transaction;

public class TransactionResponseDTO {

    private Long transactionId;
    private String type;
    private double amount;
//    private String description;
    private LocalDateTime date;

    private String accountHolder;        // Main account
    private String relatedAccountHolder; // For TRANSFERs

    public TransactionResponseDTO(Transaction transaction) {
        this.transactionId = transaction.getId();
        this.type = transaction.getType().toString();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();

        if (transaction.getAccount() != null) {
            this.accountHolder = transaction.getAccount().getHolderName();
        }

        if (transaction.getRelatedAccount() != null) {
            this.relatedAccountHolder = transaction.getRelatedAccount().getHolderName();
        }
    }

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getRelatedAccountHolder() {
		return relatedAccountHolder;
	}

	public void setRelatedAccountHolder(String relatedAccountHolder) {
		this.relatedAccountHolder = relatedAccountHolder;
	}
    
    

    
}


