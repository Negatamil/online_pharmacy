package com.example.onlinePharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinePharmacy.pharentity.Prescription_Entity;

public interface Prescription_Repository extends JpaRepository<Prescription_Entity, Integer> {

}
