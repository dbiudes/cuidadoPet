package br.com.dorival.petcare._____.airport;

import java.util.List;

public interface FlightService {
	List<Airport> airportsByCity(String city);
	List<Airport> airportsByCountry(String country);
	Airport airportByIataCode(String iataCode);
}