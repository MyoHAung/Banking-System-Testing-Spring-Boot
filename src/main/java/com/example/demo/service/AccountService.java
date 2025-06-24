package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountCreateDTO;
import com.example.demo.dto.AccountDetailResponseDTO;
import com.example.demo.dto.DepoistDTO;
import com.example.demo.dto.MoneyTransferDTO;
import com.example.demo.dto.TransactionResponseDTO;
import com.example.demo.dto.WidthDrawDTO;
import com.example.demo.dto.transferResponseDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepo;
	@Autowired
	TransactionRepository transactionRepo;

	
	public Account createAccount(AccountCreateDTO dto) {
		Account account=new Account();
		account.setAccountNumber(dto.getAccountNumber());
		account.setHolderName(dto.getHolderName());
		account.setPin(dto.getPin());
		account.setBalance(0.0);
		account.setCreatAt(LocalDate.now());
		return accountRepo.save(account);
		
	}
	
	public Account depositAccount(DepoistDTO dto) {
		Account acc=accountRepo.findById(dto.getAccountId()).orElseThrow(() -> new RuntimeException("Account not found"));
		acc.setBalance(dto.getAmount());
		return accountRepo.save(acc);
		
	}
	
	public Account widthAccount(WidthDrawDTO request) {
		Account acc=accountRepo.findById(request.getAccountId()).orElseThrow(()-> new RuntimeException("Account not found"));
		
		if(acc.getBalance()<request.getAmount()) {
			throw new RuntimeException("Insufficient balance");
		}else {
			acc.setBalance(acc.getBalance()-request.getAmount());
		}
		
		
		return accountRepo.save(acc);
		
	}
	
	public transferResponseDTO moneyTransfer(MoneyTransferDTO request) {
		
		Account toTransfer=accountRepo.findById(request.getAccountId()).orElseThrow(()-> new RuntimeException("Account not found"));
		Account fromTransfer=accountRepo.findById(request.getTransferAccountId()).orElseThrow(()-> new RuntimeException("Transfer account not found"));
		if(toTransfer.getBalance()<request.getAmount()) {
			throw new RuntimeException("Insufficient balance to transfer");
		}
		toTransfer.setBalance(toTransfer.getBalance()+request.getAmount());
		fromTransfer.setBalance(fromTransfer.getBalance()-request.getAmount());
		// Create Transaction object for sender
	    Transaction senderTx = new Transaction();
	    senderTx.setAccount(fromTransfer);
	    senderTx.setRelatedAccount(toTransfer);
	    senderTx.setAmount(request.getAmount());
	    senderTx.setDate(LocalDateTime.now());
	    senderTx.setType("TRANSFER");
	    
	    // Save both accounts and transaction
	    transactionRepo.save(senderTx);
	    
	    accountRepo.save(toTransfer);
	    accountRepo.save(fromTransfer);
		
		return new transferResponseDTO("Transfer is successful",request.getAmount());
	}
	

	public AccountDetailResponseDTO viewAccountDetail(long accid) {
		Account acc=accountRepo.findById(accid).orElseThrow(()-> new RuntimeException("Account not found"));
		return new AccountDetailResponseDTO(acc);
		
	}
	
	public List<TransactionResponseDTO> getTransactionsByaccount(Long accountId){
		List<Transaction> transactions=transactionRepo.findByAccountId(accountId);
		return transactions.stream().map(TransactionResponseDTO::new).collect(Collectors.toList());
		
	}
		
		

}
