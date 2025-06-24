package com.example.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class AccountCreateDTO {

	@NotBlank (message="Account holder name is required")
	private String HolderName;
	
	@Pattern(regexp = "\\d{12}", message = "Account number must be 12 digits")
	private String AccountNumber;
	
	 @Size(min = 4, max = 4, message = "PIN must be 4 digits")
	private String pin;

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



}
