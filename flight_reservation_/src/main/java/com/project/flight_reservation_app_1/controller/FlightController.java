package com.project.flight_reservation_app_1.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.flight_reservation_app_1.entity.Flights;
import com.project.flight_reservation_app_1.repository.FlightRepository;



@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlight(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,ModelMap modelMap) {
		List<Flights> findFlights = flightRepo.findFlights(from, to, departureDate);
	
		modelMap.addAttribute("findFlights", findFlights);
		 
		return"displayFlights";
	}
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Optional<Flights> findById = flightRepo.findById(flightId);
		Flights flights = findById.get();
		modelMap.addAttribute("flights", flights);
		return"showReservation";
	}
	
}
