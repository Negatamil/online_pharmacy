package com.example.onlinePharmacy.pharentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="supplier_data")
@Data
public class Supplier_Entity  {
			@Id
			@Column(name="SupplierId")
			private int SupplierId;
			@Column(name="SName")
			private String SName;
			@Column(name="SPhone")
			private String SPhone;
			@Column(name="SAddress")
			private String SAddress;
}
