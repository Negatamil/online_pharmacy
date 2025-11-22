package com.example.onlinePharmacy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinePharmacy.pharentity.Supplier_Entity;
import com.example.onlinePharmacy.repository.Supplier_Repository;


@Service
public class Supplier_Service {
	@Autowired
	Supplier_Repository supRepo;
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
	public List<Supplier_Entity> fetchSupDetails()
	{
		return supRepo.findAll();
	}
	public  Supplier_Entity insertSupDetails(Supplier_Entity data)
	{
		return supRepo.save(data);
	}
	public String deleteSupData(int SupplierId)
	{
		if(supRepo.existsById(SupplierId))
		{
			supRepo.deleteById(SupplierId);
			return "Data deleted successfully";
		}
		else
		{
			return SupplierId+"No data found";
		}
	}
	public String updateSupDetails(Supplier_Entity data,int SupplierId)
	{
		if(supRepo.existsById(SupplierId))
		{
			supRepo.save(data);
			return data+" Data updated successfully!";
		}
		else
		{
			return data+ " Data can't be updated :(";
		}
	}


}
