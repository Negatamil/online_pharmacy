package com.example.onlinePharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinePharmacy.pharentity.Payment_Entity;

public interface Payment_Repository extends JpaRepository<Payment_Entity, Integer> {

}
