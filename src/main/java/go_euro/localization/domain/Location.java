package go_euro.localization.domain;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author msacilo
 *
 *Defines the structure for location.
 *
 */
public class Location {
	
	@SerializedName("_id")
	private Long id;

	@SerializedName("geo_position")
	private Position geoPosition;
	
	private String name;	
	private String type;
	
	
	public Location(Long id, String name, String type, Double latitude,
			Double longitude) {
		
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.geoPosition = new Position(latitude, longitude);
	}


	public Long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public Position getGeoPosition() {
		return geoPosition;
	}
	
}
