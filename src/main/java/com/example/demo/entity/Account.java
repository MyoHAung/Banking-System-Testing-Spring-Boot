package com.example.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;




@Entity

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id; 
	private String HolderName;
	private String AccountNumber;
	private String pin;
	private double balance;
	private LocalDate creatAt;
	
	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<Transaction> transactions = new ArrayList<>();
	
	@OneToMany(mappedBy = "relatedAccount")
	@JsonIgnore
	private List<Transaction> relatedTransactions = new ArrayList<>();
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getHolderName() {
		return HolderName;
	}
	public void setHolderName(String holderName) {
		HolderName = holderName;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(LocalDate creatAt) {
		this.creatAt = creatAt;
	}
	
	
	
	

}
