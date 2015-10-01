package go_euro.localization.business;

import go_euro.localization.Dao.LocationDao;
import go_euro.localization.domain.Location;
import go_euro.localization.domain.LocationConsolidated;
import go_euro.localization.generators.CsvGenerator;

import java.util.List;

public class LocationBo {

	private LocationDao dao;
	
	private CsvGenerator csvGenerator;

	private static final String BASE_CSV_NAME = "-locations.csv";	

	
	public LocationBo(LocationDao dao, CsvGenerator csvGenerator) {
		this.dao = dao;
		this.csvGenerator = csvGenerator;
	}

	/**
	 * This method orchestra the methods to generate the CSV with the locations data.
	 * 
	 * @param cityName
	 */
	public void generateCsvFileLocationsFor(String cityName) {

		if(cityName != null){
			LocationConsolidated locationConsolidated = this.getLocations(cityName);
			
			if(locationConsolidated.getLocations().size() > 0){
				String fileName = generateFileName(cityName);
	
				csvGenerator.writeCsvFile(locationConsolidated, fileName);
			}else{
				
				System.out.println("No suggestions of locations were found");
			}
		}else{
			System.out.println("It needs to receive a valid input");
		}
		
	}
	
	
	/**
	 * go to the DAO implementation to fetch the locations for a given city name.
	 * 
	 * @param cityName
	 * @return List of Locations
	 */
	private LocationConsolidated getLocations(String cityName){
		
		List<Location> locationList = dao.getLocationFor(cityName);
		return new LocationConsolidated(locationList);
	}
	
	
	
	/**
	 * this method defined the name of the CSV files.
	 * 
	 * @param cityName
	 * @return String with the name of the csv that should be generated
	 */
	public String generateFileName(String cityName){
		return cityName + BASE_CSV_NAME;
	}
}
