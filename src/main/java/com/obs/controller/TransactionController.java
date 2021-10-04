package com.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obs.dto.Transfer;
import com.obs.service.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
@Autowired
TransactionService tser;
@PostMapping("/transfer")
public int doTransfer(@RequestBody Transfer transfer)
{
	return tser.setTransaction(transfer);
	
}
}
