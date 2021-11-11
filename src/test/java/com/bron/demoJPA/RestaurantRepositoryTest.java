package com.bron.demoJPA;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bron.demoJPA.entity.Address;
import com.bron.demoJPA.entity.OpeningHour;
import com.bron.demoJPA.entity.rInfo;
import com.bron.demoJPA.entity.rInfo.rInfoBuilder;

@SpringBootTest
public class RestaurantRepositoryTest {
		
	@Autowired
	private RestaurantRespository restaurantRepository;
	

	@Autowired
	private OpeningHourRespository openingHourRespository;
	

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
		openingHourRespository.save(o);
	}
	
	@Test
	public void RestaurantSave () {
		rInfo r = rInfo.builder()
				.restaurantName("Jimmy's house")
				.phoneNumber("0879967354")	
				.email("jimmy@gmail.com")
				.build();		
		restaurantRepository.save(r);	
	} 
	
	
	@Test
	public void RestaurantOpeningSave () {
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
	//	openingHourRespository.save(o);
		
		rInfo r = rInfo.builder()
				.restaurantName("Joey's house")
				.email("Joey@gmail.com")
				.opening(o)
				.build();		
		restaurantRepository.save(r);	
	} 
	
	
	@Test
	public void saveAddressWithRestauarant() {
		Address a = Address.builder()
				.lineone("Mainer Street")
				.linetwo("Mountcharles")
				.town("Donegal")
				.city("Donegal")
				.postcode("F94C986")
				.build(); 
								
		rInfo r = rInfo.builder()
				.restaurantName("Tai Palace")
				.phoneNumber("0985556673")
				.address(a)
				.email("TaiTai69@gmail.com")
				.build();	
		restaurantRepository.save(r);	
		
	}
	

	
//	@Test 
//	public void updateRestaurantNameByEmailTest() {	
//		restaurantRepository.updateRestaurantNameByEmail("Jimmys house", "jimmy@gmail.com");
//	}
	
	
	@Test 
	public void updateOpeningHourByRestaurantNameTest() {	
		
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
	//	openingHourRespository.save(o);
		Long hi = o.getOpeningHourID();
		
		restaurantRepository.updateOpeningHourByRestaurantName(hi, "Jimmy's house");
	}
	
	
	@Test
	public void printAllOpeningHour() {
		List<OpeningHour> openingList = openingHourRespository.findAll();
	System.out.println("--------- OpeningList-------------- " + openingList);
	}
	
	/*
	@Test
	public void printAllrInfo() {
		List<rInfo> info = restaurantRepository.findAll();
				System.out.println("--------- OpeningList-------------- " + info);
	}
	

 
	@Test 
	public void printfindByAddressLineone() {
		List<rInfo> InfoListName = restaurantRepository.findByAddressLineone("Mainer Street");
		System.out.println("RestaurantByAddress1------------------" + InfoListName);	
	}
	
		@Test 
		public void printgetrInfoByEmail() {
			String r = restaurantRepository.getRInfoRestaurantNameByEmail("jimmy@gmail.com");	
			System.out.println("RestaurantByEmail------------------" + r);	
		}
		
		@Test 
		public void  getRInfoRestaurantNameByEmailNativeNamedParam() {
			rInfo r  = restaurantRepository.getRInfoRestaurantNameByEmailNativeNamedParam("jimmy@gmail.com");
			System.out.println("Email using NativeParam Q------------------" + r);	
		}
		
		@Test 
		public void printgetrInfoByPhoneNumber() {
			rInfo r = restaurantRepository.getrInfoByPhoneNumber("0985556673");	
			System.out.println("RestaurantByNumber------------------" + r);	
		}
		
		
		@Test 
		public void printfindByAddressLinetwo() {
			List<rInfo> InfoListName = restaurantRepository.findByAddressLinetwo("Mountcharles");
			System.out.println("RestaurantByAddress2------------------" + InfoListName);	
		}
	

	@Test 
	public void printAllRestaurants() {
		
		List<rInfo> rInfoList = 
				restaurantRepository.findAll();
				System.out.println("Restaurant list" + rInfoList);	
	}
	
	
	
	@Test 
	public void printByPhoneNumberNotNull() {
		List<rInfo> InfoListName  =
				restaurantRepository.findByPhoneNumberNotNull();
				System.out.println( "Phone number not null"  + InfoListName );
	}

	

	
	@Test
	public void printRestaurantByName() {
		List<rInfo> InfoListName  =
				restaurantRepository.findByRestaurantNameAndPhoneNumber("Jimmy's house","0879967354");
				System.out.println("Restaurant by Name" + InfoListName);
	}
	

	@Test 
	public void printByRestaurantNameContaining() {
		List<rInfo> InfoListName  =
				restaurantRepository.findByRestaurantNameContaining("i");
				System.out.println("---------Name containing List-------------- " + InfoListName);
	}
	
	
	@Test 
	public void printByAddressPostcode() {
		List<rInfo> InfoListName  =
				restaurantRepository.findByAddressPostcode("F94C986");
				System.out.println("--------- Post List-------------- " + InfoListName);
	}

	
	@Test 
	public void printByAddressTown() {
		List<rInfo> InfoListName  =
				restaurantRepository.findByAddressTown("Donegal");
				System.out.println("--------- Town List-------------- " + InfoListName);
	}
	
	
	@Test 
	public void printByAddressLineone() {
		List<rInfo> InfoListName  =
				restaurantRepository.findByAddressLineone("Mainer Street");
				System.out.println("--------- LineOne List-------------- " + InfoListName);
	}

*/
}
