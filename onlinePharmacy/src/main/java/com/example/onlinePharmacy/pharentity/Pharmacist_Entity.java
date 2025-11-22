package com.example.onlinePharmacy.pharentity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="pharmacist_data")
@Data
public class Pharmacist_Entity  {
				@Id
				@GeneratedValue (strategy=GenerationType.IDENTITY)
				@Column(name="PharmacistId")
				private int PharmacistId;
				@Column(name="PName")
				private String PName;
				@Column(name="PEmail")
				private String PEmail;
				@Column(name="PPhone")
				private String PPhone;
				@Column(name="LicenseNo")			
				private String LicenseNo;
				
}
