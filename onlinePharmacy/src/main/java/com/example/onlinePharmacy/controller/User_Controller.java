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


import com.example.onlinePharmacy.pharentity.User_Entity;
import com.example.onlinePharmacy.service.User_Service;

@RestController
public class User_Controller {
	@Autowired
	User_Service userService;
	@GetMapping("/userdetails")
	
	public List<User_Entity> fetchuserData()
	{
		return userService.fetchUserDetails();
		}
	@PostMapping("/insertuserdata")
	public User_Entity insertUserData(@RequestBody User_Entity data)
	{
		return userService.insertUserDetails(data);
	}
	@DeleteMapping("deleteuserdata/{userId}")
	public String deleteUserData(@PathVariable int userId)
	{
		return userService.deleteUserData(userId);
	}
	@PutMapping("/updateuserdata/{userId}")
	public String updateUserDetails(@RequestBody User_Entity data, @PathVariable int userId)
	{
		return userService.updateUserDetails(data, userId);
	}
	@PostMapping("manytomany")
	public User_Entity getManyToMany(@RequestBody User_Entity table){
		return userService.memberUser(table);
		}
	
	@GetMapping("paginationuser")
	public List<User_Entity> fetchSortedRecords(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String userName){
		return userService.getPaginatedRecords(pageNo,pageSize,userName);
	}
}
