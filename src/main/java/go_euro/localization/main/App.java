package go_euro.localization.main;

import go_euro.localization.business.LocationBo;
import go_euro.localization.factory.LocationBoFactory;


public class App {
    public static void main( String[] args ){
    	
    	if(args.length < 1 ){
    		throw new IllegalArgumentException("should have an argument as name parameter");
    	}
    	
    	String cityName = args[0];

    	LocationBo locationBo = LocationBoFactory.getLocationBo();
		
        locationBo.generateCsvFileLocationsFor(cityName);
    }
}
