package com.example.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	private  double amount;
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name ="account_id")
	@JsonIgnore
	private Account account;
	
	@ManyToOne
	@JoinColumn (name ="relatedAccount_id")
	@JsonIgnore
	private Account relatedAccount;
	

	public Transaction(long id, String type, double amount, LocalDateTime date, Account account,
			Account relatedAccount) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.account = account;
		this.relatedAccount = relatedAccount;
	}
	public Transaction() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getRelatedAccount() {
		return relatedAccount;
	}

	public void setRelatedAccount(Account relatedAccount) {
		this.relatedAccount = relatedAccount;
	}
	
	
	}


