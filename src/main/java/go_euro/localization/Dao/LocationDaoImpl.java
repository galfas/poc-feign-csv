package go_euro.localization.Dao;

import java.util.List;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import go_euro.localization.domain.Location;

public class LocationDaoImpl implements LocationDao{
	
	private String endpoint = "http://api.goeuro.com/api/v2/position";
	
	interface LocationProvider{
		@RequestLine("GET /suggest/en/{city}")
		public List<Location> getLocationFor(@Param("city") String city);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Location> getLocationFor(String cityName){
		LocationProvider locationProvider = Feign.builder().decoder(new GsonDecoder())
				.target(LocationProvider.class, endpoint);
		
		return locationProvider.getLocationFor(cityName);
	}

}
