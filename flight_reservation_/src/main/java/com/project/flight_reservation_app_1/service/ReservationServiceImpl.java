


package com.project.flight_reservation_app_1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.flight_reservation_app_1.dto.ReservationRequest;
import com.project.flight_reservation_app_1.entity.Flights;
import com.project.flight_reservation_app_1.entity.Passenger;
import com.project.flight_reservation_app_1.entity.Reservation;
import com.project.flight_reservation_app_1.repository.FlightRepository;
import com.project.flight_reservation_app_1.repository.PassengerRepository;
import com.project.flight_reservation_app_1.repository.ReservationRepository;
import com.project.flight_reservation_app_1.utilities.EmailUtil;
import com.project.flight_reservation_app_1.utilities.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
	    String filePath="F:\\Tickets\\booking";
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flights> findById = flightRepo.findById(flightId);
		Flights flights = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flights);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		
		reservationRepo.save(reservation);
		
		PDFgenerator pdf=new PDFgenerator();
		pdf.generatePDF(filePath+reservation.getId()+".pdf",request.getFirstName()+request.getLastName(), request.getEmail(),request.getPhone(),flights.getOperatingAirline(),flights.getDateOfDeparture(), flights.getDepartureCity(), flights.getArrivalCity());
		
		emailUtil.sendItinerary(passenger.getEmail(), filePath+reservation.getId()+".pdf");
		
		return reservation;
	}

}
