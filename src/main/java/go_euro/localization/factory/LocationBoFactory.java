package go_euro.localization.factory;

import go_euro.localization.Dao.LocationDao;
import go_euro.localization.Dao.LocationDaoImpl;
import go_euro.localization.business.LocationBo;
import go_euro.localization.generators.CsvGenerator;


/**
 * This class is a factory for the locationBo
 * 
 * @author msacilo
 */
public class LocationBoFactory {
	
	private static LocationBo locationBo;
	
	private LocationBoFactory(){
		locationBo = getLocationBo();
	}
	
	public static LocationBo getLocationBo(){

		if(locationBo == null){
			LocationDao locationDao = new LocationDaoImpl();
			CsvGenerator csvGenerator = new CsvGenerator();
			locationBo = new LocationBo(locationDao, csvGenerator);
		}
		
		return locationBo;
	}
}
