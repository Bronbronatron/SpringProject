package com.bron.demoJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bron.demoJPA.entity.Dish;

@Repository
public interface DishRespository extends JpaRepository<Dish, Long>  {

}
