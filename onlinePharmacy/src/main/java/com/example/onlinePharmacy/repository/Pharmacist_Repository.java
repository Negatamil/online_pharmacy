package com.example.onlinePharmacy.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinePharmacy.pharentity.Pharmacist_Entity;


public interface Pharmacist_Repository extends JpaRepository<Pharmacist_Entity, Integer> {
	

	public List<Pharmacist_Entity> findByPNameEndsWith(String pName);

	public List<Pharmacist_Entity> findByPNameStartsWith(String pName);

	public List<Pharmacist_Entity> findByPNameContains(String pName);

	public List<Pharmacist_Entity> findByPNameNotContains(String pName);

	public List<Pharmacist_Entity> findByPNameContaining(String pName);
}
