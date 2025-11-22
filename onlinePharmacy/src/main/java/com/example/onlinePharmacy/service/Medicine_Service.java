package com.example.onlinePharmacy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinePharmacy.pharentity.Medicine_Entity;

import com.example.onlinePharmacy.repository.Medicine_Repository;
import com.example.onlinePharmacy.repository.User_Repository;

@Service
public class Medicine_Service {

	@Autowired
	Medicine_Repository medRepo;
	@Autowired
	User_Repository userRepo;
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
	public List<Medicine_Entity> fetchMedDetails()
	{
		return medRepo.findAll();
	}
	public  Medicine_Entity insertMedDetails(Medicine_Entity data)
	{
		return medRepo.save(data);
	}
	public String deleteMedData(int MedicineId)
	{
		if(medRepo.existsById(MedicineId))
		{
			medRepo.deleteById(MedicineId);
			return "Data deleted successfully";
		}
		else
		{
			return MedicineId+"No data found";
		}
	}
	public String updateMedDetails(Medicine_Entity data,int medId)
	{
		if(medRepo.existsById(medId))
		{
			medRepo.save(data);
			return data+" Data updated successfully!";
		}
		else
		{
			return data+ " Data can't be updated :(";
		}
	}
	

}

