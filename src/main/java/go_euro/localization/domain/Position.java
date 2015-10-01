package go_euro.localization.domain;

import com.google.gson.annotations.SerializedName;

public class Position {

	@SerializedName("latitude")
	private Double latitude;

	@SerializedName("longitude")
	private Double longitude;

	
	public Position(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
