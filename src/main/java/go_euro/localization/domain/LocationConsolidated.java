package go_euro.localization.domain;

import go_euro.localization.generators.CsvExportable;

import java.util.ArrayList;
import java.util.List;

public class LocationConsolidated implements CsvExportable {
	
	public static final String[] FILE_HEADER = { "id", "name", "type", "latitude", "longitude" };
	
	private List<Location> locations;


	public LocationConsolidated(List<Location> locations) {
		super();
		this.locations = locations;
	}
	
	
	public List<Location> getLocations() {
		return locations;
	}

	@Override
	public String[] getCsvHeader() {
		return FILE_HEADER;
	}

	@Override
	public List<String[]> getDisplayAttributes() {
		List<String[]> csvContent = new ArrayList<>();
		if(this.locations != null && this.locations.size()>0){
			for (Location location : this.locations) {
				csvContent.add(new String [] {location.getId().toString(), location.getName(), location.getType(), 
						location.getGeoPosition().getLatitude().toString(), 
						location.getGeoPosition().getLongitude().toString()});
			}
		}
		return csvContent; 
	}
	
	
	
	
}
