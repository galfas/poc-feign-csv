package go_euro.localization.Dao;

import feign.Param;
import go_euro.localization.domain.Location;

import java.util.List;

public interface LocationDao {
	

	/**
	 * Fetching in the API all the locations for a given name.
	 * 
	 * @param cityName
	 * @return List of locations
	 */
	public List<Location> getLocationFor(@Param("cityName") String cityName);
}
