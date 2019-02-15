package br.com.dorival.petcare._____.airport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/iata")
public class IataCodeSearch {
	private static final Logger logger = LoggerFactory.getLogger(IataCodeSearch.class);
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value="/{iataCode}", method=RequestMethod.GET)
	public Airport search(@PathVariable String iataCode) {
		Airport retval = flightService.airportByIataCode(iataCode);
		if(retval != null) {
			logger.info("Aeroporto com codigo IATA {}: {}/{}/{}", iataCode, retval.getName(), retval.getCity(), retval.getCountry());
		} else {
			logger.info("Aeroporto com codigo IATA {}: 0", iataCode);
		}
		return retval;
	}
}
