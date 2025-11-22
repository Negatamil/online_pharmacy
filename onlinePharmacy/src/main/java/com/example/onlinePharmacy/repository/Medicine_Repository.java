package com.example.onlinePharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinePharmacy.pharentity.Medicine_Entity;

public interface Medicine_Repository extends JpaRepository<Medicine_Entity, Integer> {

}
