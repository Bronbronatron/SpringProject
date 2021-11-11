package com.bron.demoJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bron.demoJPA.entity.OpeningHour;


public interface OpeningHourRespository extends JpaRepository<OpeningHour, Long> {

}
