package com.project.flight_reservation_app_1.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{
private boolean checkedIn;
private int numberOfBags;
@OneToOne
private Passenger passenger;
@OneToOne
private Flights flight;
public boolean isCheckedIn() {
	return checkedIn;
}
public void setCheckedIn(boolean checkedIn) {
	this.checkedIn = checkedIn;
}
public int getNumberOfBags() {
	return numberOfBags;
}
public void setNumberOfBags(int numberOfBags) {
	this.numberOfBags = numberOfBags;
}
public Passenger getPassenger() {
	return passenger;
}
public void setPassenger(Passenger passenger) {
	this.passenger = passenger;
}
public Flights getFlight() {
	return flight;
}
public void setFlight(Flights flight) {
	this.flight = flight;
}

}
