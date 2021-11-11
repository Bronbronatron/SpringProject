package com.bron.demoJPA;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bron.demoJPA.entity.OpeningHour;
import com.bron.demoJPA.entity.rInfo;

@Repository
public interface RestaurantRespository extends JpaRepository<rInfo, Long>  {
	
	List<rInfo> findByRestaurantNameAndPhoneNumber(String restaurantName, String phoneNumber);
	
	List<rInfo> findByRestaurantNameContaining(String name);
	
	List<rInfo> findByPhoneNumberNotNull();
	
	List<rInfo> findByAddressCity(String address);
	
	List<rInfo> findByAddressPostcode(String pos);
	
	List<rInfo> findByAddressTown(String tow);
	
	List<rInfo> findByAddressLineone(String one);
	
	List<rInfo> findByAddressLinetwo(String two);


	
	
		//JPQL
	@Query("select r.restaurantName from rInfo r where r.email = ?1")
	String getRInfoRestaurantNameByEmail(String email);
	
	
	@Query("select r from rInfo r where r.phoneNumber= ?1")
	rInfo getrInfoByPhoneNumber(String phoneNumber);
	//Native
	@Query(
		value = "SELECT * from Rest_info r where r.Rest_Email_Address = ?1",
		nativeQuery = true
		)
	rInfo getRInfoRestaurantNameByEmailNative(String email);
	
	
	
	//Native
	@Query(
		value = "SELECT * from Rest_info r where r.Rest_Email_Address = :email",
		nativeQuery = true
		)
	rInfo getRInfoRestaurantNameByEmailNativeNamedParam(
			@Param("email")String email
			);
	
	//Native
	@Modifying
	@Transactional
	@Query(
		value = "update Rest_info set Rest_Name = ?1 where Rest_Email_Address = ?2",
		nativeQuery = true
		)
	
	int updateRestaurantNameByEmail(String name, String email);
	
	
	
	
	//Native
	@Modifying
	@Transactional
	@Query(
		value = "update Rest_info set opening_hourid = ?1 where Rest_Name = ?2",
		nativeQuery = true
		)
	
	int updateOpeningHourByRestaurantName(Long hour, String name);
	
}
	



