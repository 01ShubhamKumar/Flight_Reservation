package com.project.flight_reservation_app_1.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.flight_reservation_app_1.entity.Flights;



public interface FlightRepository extends JpaRepository<Flights, Long> {
	
	
	@Query(" from Flights where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flights> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);


}
