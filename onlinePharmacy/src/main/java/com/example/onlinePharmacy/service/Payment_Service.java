package com.example.onlinePharmacy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.onlinePharmacy.pharentity.Payment_Entity;

import com.example.onlinePharmacy.repository.Payment_Repository;
@Service
public class Payment_Service {
	@Autowired
	Payment_Repository payRepo;
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
	public List<Payment_Entity> fetchPayDetails()
	{
		return payRepo.findAll();
	}
	public  Payment_Entity insertPayDetails(Payment_Entity data)
	{
		return payRepo.save(data);
	}
	public String deletePayData(int PaymentId)
	{
		if(payRepo.existsById(PaymentId))
		{
			payRepo.deleteById(PaymentId);
			return "Data deleted successfully";
		}
		else
		{
			return PaymentId+"No data found";
		}
	}
	public String updatePayDetails(Payment_Entity data,int PaymentId)
	{
		if(payRepo.existsById(PaymentId))
		{
			payRepo.save(data);
			return data+" Data updated successfully!";
		}
		else
		{
			return data+ " Data can't be updated :(";
		}
	}
	


}
