package com.example.onlinePharmacy.pharentity;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="prescription_data")
@Data
public class Prescription_Entity  {
				@Id
				@Column(name="PrescriptionId")
				private int PrescriptionId;
				@Column(name="DoctorName")
				private String DoctorName;
				@Column(name="PrescriptionDate")
				private String PrescriptionDate;
				@Column(name="PStatus")
				private String PStatus;
				@ManyToOne
				@JoinColumn(name="foreignkey")
				private Pharmacist_Entity pharentity ;
				
}
