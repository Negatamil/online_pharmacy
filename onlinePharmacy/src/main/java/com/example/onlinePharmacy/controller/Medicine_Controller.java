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

import com.example.onlinePharmacy.pharentity.Medicine_Entity;

import com.example.onlinePharmacy.service.Medicine_Service;

@RestController
public class Medicine_Controller {
	@Autowired
	Medicine_Service medService;
	
	@GetMapping("/meddetails")
	
	public List<Medicine_Entity> fetchmedData()
	{
		return medService.fetchMedDetails();
		}
	@PostMapping("/insertmeddata")
	public Medicine_Entity insertMedData(@RequestBody Medicine_Entity data)
	{
		return medService.insertMedDetails(data);
	}
	@DeleteMapping("deletemeddata/{MedicineId}")
	public String deletemedData(@PathVariable int MedicineId)
	{
		return medService.deleteMedData(MedicineId);
	}
	@PutMapping("/updatemeddata/{MedicineId}")
	public String updateMedDetails(@RequestBody Medicine_Entity data, @PathVariable int MedicineId)
	{
		return medService.updateMedDetails(data, MedicineId);
	}
	
}
