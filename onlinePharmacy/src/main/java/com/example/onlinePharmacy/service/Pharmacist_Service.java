package com.example.onlinePharmacy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.onlinePharmacy.pharentity.Pharmacist_Entity;
import com.example.onlinePharmacy.pharentity.Smtp_Entity;
import com.example.onlinePharmacy.repository.Pharmacist_Repository;
import com.example.onlinePharmacy.repository.Smtp_repository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class Pharmacist_Service {
	@Autowired
	Pharmacist_Repository pharRepo;
	@Autowired
	
	Smtp_repository smtpRepo;
	@Autowired
	
	JavaMailSender sender;
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
	public List<Pharmacist_Entity> fetchPharDetails()
	{
		return pharRepo.findAll();
	}
	public  Pharmacist_Entity insertPharDetails(Pharmacist_Entity data)
	{
		return pharRepo.save(data);
	}
	public String deletePharData(int PharmacistId)
	{
		if(pharRepo.existsById(PharmacistId))
		{
			pharRepo.deleteById(PharmacistId);
			return "Data deleted successfully";
		}
		else
		{
			return PharmacistId+"No data found";
		}
	}
	public String updatePharDetails(Pharmacist_Entity data,int PharmacistId)
	{
		if(pharRepo.existsById(PharmacistId))
		{
			pharRepo.save(data);
			return data+" Data updated successfully!";
		}
		else
		{
			return data+ " Data can't be updated :(";
		}
	}
	public  String smtpEmail(String receiver, String subject, String mailBody) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message);
			
			messageHelper.setTo(receiver);
			messageHelper.setSubject(subject);
			messageHelper.setText(mailBody);
			
			sender.send(message);
			
			Smtp_Entity smtp = new Smtp_Entity();
			smtp.setReceiver(receiver);
			smtp.setSubject(subject);
			smtp.setContent(mailBody);
			smtpRepo.save(smtp);
			
			return "Mail sent successfully :)";
			
		}
		catch(MessagingException e) {
			return "Mail not sent :( "+e.getMessage();
		}
	}
	public List<Pharmacist_Entity> fetchstartName(String pName) {
		// TODO Auto-generated method stub
		return pharRepo.findByPNameStartsWith(pName);
	}
	public List<Pharmacist_Entity> fetchNameEnd(String pName) {
		// TODO Auto-generated method stub
		return pharRepo.findByPNameEndsWith(pName);
	}
	public List<Pharmacist_Entity> fetchNameContain(String pName) {
		// TODO Auto-generated method stub
		return pharRepo.findByPNameContains(pName);
	}
	public List<Pharmacist_Entity> fetchNameNotContain(String pName) {
		// TODO Auto-generated method stub
		return pharRepo.findByPNameNotContains(pName);
	}
	public List<Pharmacist_Entity> fetchNameContaining(String pName) {
		// TODO Auto-generated method stub
		return pharRepo.findByPNameContaining(pName);
	}
	
	}


