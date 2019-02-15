package br.com.dorival.petcare._____.airport;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/city")
public class CitySearch {
	private static final Logger logger = LoggerFactory.getLogger(CitySearch.class);
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value="/{cityName}", method=RequestMethod.GET)
	public List<Airport> search(@PathVariable String cityName) {
		List<Airport> retval = flightService.airportsByCity(cityName);
		if(retval != null) {
			logger.info("Aeroportos para a cidade {}: {}", cityName, retval.size());
		} else {
			logger.info("Aeroportos para a cidade {}: 0", cityName);
		}
		return retval;
	}
}
