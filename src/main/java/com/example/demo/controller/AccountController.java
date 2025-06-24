package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountCreateDTO;
import com.example.demo.dto.AccountDetailResponseDTO;
import com.example.demo.dto.DepoistDTO;
import com.example.demo.dto.MoneyTransferDTO;
import com.example.demo.dto.TransactionResponseDTO;
import com.example.demo.dto.WidthDrawDTO;
import com.example.demo.dto.transferResponseDTO;
import com.example.demo.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;
	@PostMapping("/create") 
	public ResponseEntity<String> createAccount(@Valid @RequestBody AccountCreateDTO dto){
		
		accountService.createAccount(dto);
		return ResponseEntity.ok("New account created successfully");	
	}
	
	@PostMapping("/deposit")
	public ResponseEntity<String> depositAccount(@Valid @RequestBody DepoistDTO dto){
		accountService.depositAccount(dto);
		return ResponseEntity.ok(dto.getAmount()+" is deposit to you account");
	}
	
	@PostMapping("/widthdraw")
	public ResponseEntity<String> widthdrawAccount(@Valid @RequestBody WidthDrawDTO request){
		accountService.widthAccount(request);
		return ResponseEntity.ok(request.getAmount()+ "is widthdraw from you account");
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<transferResponseDTO> transferMoney(@Valid @RequestBody MoneyTransferDTO request){
		transferResponseDTO transaction=accountService.moneyTransfer(request);
		
		return ResponseEntity.ok(transaction);
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<AccountDetailResponseDTO> viewAccountDetail(@PathVariable long id){
		AccountDetailResponseDTO view=accountService.viewAccountDetail(id);
		return ResponseEntity.ok(view);
		
	}
	@GetMapping("/transactions/{accountId}")
	public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions(@PathVariable Long accountId){
		List<TransactionResponseDTO> transactions =accountService.getTransactionsByaccount(accountId);
		return ResponseEntity.ok(transactions);
		
	}
	

}
