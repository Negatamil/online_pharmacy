package com.example.onlinePharmacy.repository;



import org.springframework.data.domain.Page;




import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.onlinePharmacy.pharentity.User_Entity;



@Repository
public interface User_Repository extends JpaRepository<User_Entity, Integer> {
	public Page<User_Entity> findAll(Pageable page);
}
	
