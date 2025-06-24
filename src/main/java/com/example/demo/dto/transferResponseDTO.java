package com.example.demo.dto;


public class transferResponseDTO {
	
	private String message;
	private double amount;
	public transferResponseDTO(String message, double amount) {
		super();
		this.message = message;
		this.amount = amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
