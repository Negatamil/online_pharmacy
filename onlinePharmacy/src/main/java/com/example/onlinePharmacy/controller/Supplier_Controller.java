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

import com.example.onlinePharmacy.pharentity.Supplier_Entity;

import com.example.onlinePharmacy.service.Supplier_Service;


@RestController
public class Supplier_Controller {
	@Autowired
	Supplier_Service supService;
	@GetMapping("/supdetails")
	
	public List<Supplier_Entity> fetchsupData()
	{
		return supService.fetchSupDetails();
		}
	@PostMapping("/insertsupdata")
	public Supplier_Entity insertSupData(@RequestBody Supplier_Entity data)
	{
		return supService.insertSupDetails(data);
	}
	@DeleteMapping("deletesupdata/{SupplierId}")
	public String deleteSupData(@PathVariable int SupplierId)
	{
		return supService.deleteSupData(SupplierId);
	}
	@PutMapping("/updatesupdata/{SupplierId}")
	public String updateSupDetails(@RequestBody Supplier_Entity data, @PathVariable int SupplierId)
	{
		return supService.updateSupDetails(data, SupplierId);
	}
}
