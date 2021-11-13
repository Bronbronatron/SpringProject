package com.bron.demoJPA;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bron.demoJPA.entity.Dish;

@Repository
public interface DishRespository extends JpaRepository<Dish, Long>  {
	
	//Native
		@Modifying
		@Transactional
		@Query(
			value = "update Rest_info set dish_restaurant = ?1 where Rest_Name = ?2",
			nativeQuery = true
			)
		
		int updateOpeningHourByRestaurantName(Long dr, String name);
		
	}
	
	
	


