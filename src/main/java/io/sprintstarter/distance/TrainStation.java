package io.sprintstarter.distance;

public class TrainStation {
	private String ds100;
	private String name;
	private String traffic;
	private double latitude;
	private double Longitude;

	public TrainStation(String ds100, String name, String traffic, double latitude, double longitude) {
		super();
		this.ds100 = ds100;
		this.name = name;
		this.traffic = traffic;
		this.latitude = latitude;
		this.Longitude = longitude;
	}

	public String getDs100() {
		return ds100;
	}

	public void setDs100(String ds100) {
		this.ds100 = ds100;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
