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

import com.example.onlinePharmacy.pharentity.Prescription_Entity;
import com.example.onlinePharmacy.service.Prescription_Service;



@RestController
public class Prescription_Controller {
	@Autowired
	 Prescription_Service presService;
	@GetMapping("/presdetails")
	
	public List<Prescription_Entity> fetchuserData()
	{
		return presService.fetchPresDetails();
		}
	@PostMapping("/insertpresdata")
	public Prescription_Entity insertPresData(@RequestBody Prescription_Entity data)
	{
		return presService.insertPresDetails(data);
	}
	@DeleteMapping("deletepresdata/{PrescriptionId}")
	public String deletePresData(@PathVariable int PrescriptionId)
	{
		return presService.deletePresData(PrescriptionId);
	}
	@PutMapping("/updatepresdata/{PrescriptionId}")
	public String updatePresDetails(@RequestBody Prescription_Entity data, @PathVariable int PrescriptionId)
	{
		return presService.updatePresDetails(data, PrescriptionId);
	}
}
