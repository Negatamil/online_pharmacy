package com.example.onlinePharmacy.pharentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="payment_data")
@Data
	public class Payment_Entity  {
			@Id
			@GeneratedValue (strategy=GenerationType.IDENTITY)
			@Column(name="PaymentId")
			private int PaymentId;
			@Column(name="PayAmount")
			private int PayAmount;
			@Column(name="PayDate")
			private String PayDate;
			@Column(name="Payment_Status")
			private String Payment_Status;
			@OneToOne
			@JoinColumn(name="useid")
			private User_Entity useentity;
}
