package com.example.onlinePharmacy.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.onlinePharmacy.pharentity.Pharmacist_Entity;

import com.example.onlinePharmacy.service.Pharmacist_Service;



@RestController
public class Pharmacist_Controller {
	@Autowired
	Pharmacist_Service pharService;
	
	@GetMapping("/phardetails")
	
	public List<Pharmacist_Entity> fetchPharData()
	{
		return pharService.fetchPharDetails();
		}
	@PostMapping("/insertphardata")
	public Pharmacist_Entity insertPharData(@RequestBody Pharmacist_Entity data)
	{
		return pharService.insertPharDetails(data);
	}
	@DeleteMapping("deletephardata/{PharmacistId}")
	public String deletePharData(@PathVariable int PharmacistId)
	{
		return pharService.deletePharData(PharmacistId);
	}
	@PutMapping("/updatephardata/{PharmacistId}")
	public String updatePharDetails(@RequestBody Pharmacist_Entity data, @PathVariable int PharmacistId)
	{
		return pharService.updatePharDetails(data, PharmacistId);
	}
	@PostMapping("/smtpemail")
	public String smtpEmail(@RequestParam String receiver,@RequestParam String subject,@RequestParam String mailBody) {
		return pharService.smtpEmail(receiver,subject,mailBody);
	}
	@GetMapping("/startswithname")
	public List<Pharmacist_Entity> fetchStartsWithName(@RequestParam String PName)
	{
		return pharService.fetchstartName(PName);
	}
	@GetMapping("/endswithname")
	public List<Pharmacist_Entity> fetchEndsWithName(@RequestParam String PName)
	{
		return pharService.fetchNameEnd(PName);
	}
	@GetMapping("/containsinname")
	public List<Pharmacist_Entity> fetchContains(@RequestParam String PName)
	{
		return pharService.fetchNameContain(PName);
	}
	@GetMapping("/notcontainsinname")
	public List<Pharmacist_Entity> fetchNotContains(@RequestParam String PName)
	{
		return pharService.fetchNameNotContain(PName);
	}
	@GetMapping("/containingname")
	public List<Pharmacist_Entity> fetchContaining(@RequestParam String PName)
	{
		return pharService.fetchNameContaining(PName);
	}
	
}
