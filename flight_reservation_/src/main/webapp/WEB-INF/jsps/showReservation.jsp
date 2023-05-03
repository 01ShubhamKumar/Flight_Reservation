<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
    <h2>Flight Details</h2>
    Flight Number:${flights.flightNumber}</br>
    Operating Airline:${flights.operatingAirline}</br>
    Departure City:${flights.departureCity}</br>
    Arrival City:${flights.arrivalCity}</br>
    Departure Date:${flights.dateOfDeparture}<br/>
    <h2>Enter Passenger Details</h2>
    <form action="confirmReservation" method="post">
      <pre>
        First Name<input type="text" name="firstName"/>
        Last Name <input type="text" name="lastName"/>
        Email     <input type="text" name="email"/>
        Mobile    <input type="text" name="phone"/>
        <input type="hidden" name="flightId" value="${flights.id}"/>
        <h2>Enter the Payment Details</h2>
        Name On The Card<input type="text" name="nameOfTheCard"/>
        Card Number     <input type="text" name="cardNumber"/>
         Cvv            <input type="text" name="cvv"/>
         Expiry Date    <input type="text" name="expiryDate"/>
        <input type="submit" value="complete reservation"/>
        </pre>
    </form>
</body>
</html>