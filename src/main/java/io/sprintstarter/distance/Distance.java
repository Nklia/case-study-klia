package io.sprintstarter.distance;

public class Distance {
	private String from;
	private String to;
	private int distance;
	private String unit;
	
	public Distance() {
		
	}

	public Distance(String from, String to, int distance, String unit) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.unit = unit;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
