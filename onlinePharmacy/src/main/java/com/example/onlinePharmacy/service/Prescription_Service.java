package com.example.onlinePharmacy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinePharmacy.pharentity.Prescription_Entity;

import com.example.onlinePharmacy.repository.Prescription_Repository;
@Service
public class Prescription_Service {
	@Autowired
	Prescription_Repository presRepo;
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/pharmacy";
		String username="root";
		String password="root";
		try(Connection con=DriverManager.getConnection(url, username, password))
		{
			if(con!=null)
			{
				System.out.println("Connection established successfully");
			}
			else {
				System.out.println("Connection failed");
			}	
		}
		catch(SQLException ex)
		{
			System.out.println("Failed to connect db"+ex.getMessage());
		}
		
	} 
	public List<Prescription_Entity> fetchPresDetails()
	{
		return presRepo.findAll();
	}
	public  Prescription_Entity insertPresDetails(Prescription_Entity data)
	{
		return presRepo.save(data);
	}
	public String deletePresData(int PrescriptionId)
	{
		if(presRepo.existsById(PrescriptionId))
		{
			presRepo.deleteById(PrescriptionId);
			return "Data deleted successfully";
		}
		else
		{
			return PrescriptionId+"No data found";
		}
	}
	public String updatePresDetails(Prescription_Entity data,int PrescriptionId)
	{
		if(presRepo.existsById(PrescriptionId))
		{
			presRepo.save(data);
			return data+" Data updated successfully!";
		}
		else
		{
			return data+ " Data can't be updated :(";
		}
	}


}
