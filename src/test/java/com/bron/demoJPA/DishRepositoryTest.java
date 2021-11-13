package com.bron.demoJPA;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bron.demoJPA.entity.Dish;
import com.bron.demoJPA.entity.Requirments;
import com.bron.demoJPA.entity.rInfo;

@SpringBootTest
public class DishRepositoryTest {
	
	
	@Autowired
	private DishRespository dishRepository;
	private RestaurantRespository restaurantRepository;

	
	@Test
	public void DishSave() {	
		rInfo rest = restaurantRepository.findByRestaurantName("Tai's Palace");
		
		Requirments req = Requirments.builder()
				.requireName("Gluten free")
				.build();
		
		Requirments req2 = Requirments.builder()
				.requireName("Vegan")
				.build();
		
		 List<Requirments> list 
         = Stream.of(req, req2)
             .collect(Collectors.toList());
	
		Dish d = Dish.builder()
			
			.dname("Fish and chip")
			.price(10.50)
			.description("Traditional fish and chips")
			.reqlist(list)
			.restaurant(rest)
			.build();
		
	
			dishRepository.save(d);
	
	}
	
	
	
	
	/*
		@Test
		public void DiSave  {
		rInfo rest; 
		rest = restaurantRepository.findByRestaurantName("Tai's Palace");
		
		
		Requirments req = Requirments.builder()
				.requireName("Gluten free")
				.build();
		
		Requirments req2 = Requirments.builder()
				.requireName("Vegan")
				.build();
		
		 List<Requirments> list 
         = Stream.of(req, req2)
             .collect(Collectors.toList());
			
		     Dish d = Dish.builder()
			.dname("Fish and chip")
			.price(10.50)
			.description("Traditional fish and chips")
			.restaurant(rest)
			.reqlist(list)
		
			.build();
		
					
	
	}
	
	
	
	
*/

}
