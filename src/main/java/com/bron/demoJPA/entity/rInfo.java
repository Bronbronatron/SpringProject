package com.bron.demoJPA.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "opening")
@Table(name = "Rest_info"

)

//Avoid naming things with Capitals 
public class rInfo {
	@Id
	@SequenceGenerator(
			name = "restaurant_sequence",
			sequenceName = "restaurant_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "restaurant_sequence")
	
	
	@Column(name ="Rest_ID")
	private Long rId;
	
	@Column(
			name ="Rest_Name",
			nullable = false
			)
	private String restaurantName;
	
	@Embedded
	private  Address address; 
	
	
	@Column(name ="Rest_Phone_Number")
	private String phoneNumber;
	
	@Column(name ="Rest_Email_Address")
	private String email;
	
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = true
			)
	@JoinColumn(
			name = "openingHourID",
			referencedColumnName = "OpeningHour_ID")
	private OpeningHour opening; 
			
	
	@OneToMany(
			cascade = CascadeType.ALL
			
			)
	@JoinColumn(
			name ="Rest_ID",
			referencedColumnName = "Rest_ID"
			)
	private List<Dish> dish;
	
	
}
