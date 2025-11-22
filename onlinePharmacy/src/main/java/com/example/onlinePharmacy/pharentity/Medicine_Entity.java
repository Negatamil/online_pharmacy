package com.example.onlinePharmacy.pharentity;






import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="medicine_data")
@Data
public class Medicine_Entity  {
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="MedicineId")
			private int MedicineId;
			@Column(name="MName")
			private String MName;
			@Column(name="MDescription")
			private String MDescription;
			@Column(name="MPrice")
			private int MPrice;
			@Column(name="Stock_Quantity")
			private int Stock_Quantity;
			@Column(name="Expiry_Date")
			private String Expiry_Date;
			
			
}
