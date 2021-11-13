package com.bron.demoJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bron.demoJPA.entity.OpeningHour;

@SpringBootTest
public class OpeningHourRepositoryTest {
	
	@Autowired
	private  OpeningHourRespository openingHourRepository;
	
	/*
	@Test
	public void OpeningHourSave () {
		OpeningHour o = OpeningHour.builder()
				.openingHourMon("9.00")
				.closingHourMon("18.00")
				.openingHourTue("9.00")
				.closingHourTue("18.00")
				.openingHourWed("Closed")
				.closingHourWed("Closed")
				.openingHourThurs("9.00")
				.closingHourThurs("18.00")
				.openingHourFri("9.00")
				.closingHourFri("20.00")
				.openingHourSat("9.00")
				.closingHourSat("21.00")
				.openingHourSun("Closed")
				.closingHourSun("Closed")
				.build();		
		openingHourRepository.save(o);
	}
*/
}
