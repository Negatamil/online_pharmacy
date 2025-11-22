package com.example.onlinePharmacy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.onlinePharmacy.pharentity.Medicine_Entity;
import com.example.onlinePharmacy.pharentity.User_Entity;
import com.example.onlinePharmacy.repository.Medicine_Repository;
import com.example.onlinePharmacy.repository.User_Repository;





@Service
public class User_Service {
	@Autowired
	User_Repository userRepo;
	@Autowired
	Medicine_Repository medRepo;
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
	public List<User_Entity> fetchUserDetails()
	{
		return userRepo.findAll();
	}
	public  User_Entity insertUserDetails(User_Entity data)
	{
		return userRepo.save(data);
	}
	public String deleteUserData(int userid)
	{
		if(userRepo.existsById(userid))
		{
			userRepo.deleteById(userid);
			return "Data deleted successfully";
		}
		else
		{
			return userid+"No data found";
		}
	}
	public String updateUserDetails(User_Entity data,int userId)
	{
		if(userRepo.existsById(userId))
		{
			userRepo.save(data);
			return data+" Data updated successfully!";
		}
		else
		{
			return data+ " Data can't be updated :(";
		}
	}
	public User_Entity memberUser(User_Entity table) {
		Medicine_Entity medicine=medRepo.findById(table.getMede().get(0)
				.getMedicineId()).orElse(null);
		if(medicine!=null)
		{
			table.setMede(List.of(medicine));
		}
		return userRepo.save(table);
	}
	public List<User_Entity> getPaginatedRecords(int pageNo, int pageSize, String userName) {
		Pageable page=PageRequest.of(pageNo, pageSize, Sort.by(userName).ascending());
		return userRepo.findAll(page).getContent();
	}
	


}
