package com.bron.demoJPA.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Dish {
	
	@Id
	@SequenceGenerator(
		name = "dish_sequence",
		sequenceName = "dish_sequence",
		allocationSize = 1
			)
	
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "dish_sequence"
			)
	@Column(name ="dish_Id")
	private Long dishId;
	
	@Column(name ="dish_name")
	private String dname;
	
	@Column(name ="dish_description")
	private String description;
	
	@Column(name ="dish_price")
	private double price;
	
	
	
	
	
	

}
