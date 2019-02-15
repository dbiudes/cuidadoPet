package br.com.dorival.petcare._____.airport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, Long> {
	List<Airport> findByCityIgnoreCase(String city);
	List<Airport> findByCountryIgnoreCase(String country);
	Airport findByIataCodeIgnoreCase(String iataCode);
}