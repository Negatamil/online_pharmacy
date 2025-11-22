package com.example.onlinePharmacy.pharentity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="user_data")
@Data
public class User_Entity {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="Email")
	private String Email;
	@Column(name="Address")
	private String Address;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="medicinebrought",
	joinColumns=@JoinColumn(name="userId"),
	inverseJoinColumns=@JoinColumn(name="MedicineId"))
	private List<Medicine_Entity> mede;
	
}
