package com.example.onlinePharmacy.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.onlinePharmacy.pharentity.Payment_Entity;
import com.example.onlinePharmacy.service.Payment_Service;

@RestController
public class Payment_Controller {
	@Autowired
	Payment_Service payService;
	
	@GetMapping("/paydetails")
	
	public List<Payment_Entity> fetchPayData()
	{
		return payService.fetchPayDetails();
		}
	@PostMapping("/insertpaydata")
	public Payment_Entity insertPayData(@RequestBody Payment_Entity data)
	{
		return payService.insertPayDetails(data);
	}
	@DeleteMapping("deletepaydata/{PaymentId}")
	public String deletePayData(@PathVariable int PaymentId)
	{
		return payService.deletePayData(PaymentId);
	}
	@PutMapping("/updatepaydata/{PaymentId}")
	public String updatePayDetails(@RequestBody Payment_Entity data, @PathVariable int PaymentId)
	{
		return payService.updatePayDetails(data, PaymentId);
	}
	
	
}
