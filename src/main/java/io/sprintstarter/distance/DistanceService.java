package io.sprintstarter.distance;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DistanceService {
	/**
	 * Return the distance between Frankfurt Main Hbf (FF) and Berlin Hbf (BLS).
	 */
	public Distance getDistanceBetweenFFAndBLS() {
		List<TrainStation> trainstationsSelected = CSVHelper.getTrainStations("Frankfurt(Main)Hbf", "Berlin Hbf");
		if (trainstationsSelected == null || trainstationsSelected.size() < 2) {
			return new Distance();
		} else {

			int theCrowFlies = (int) calculateTheCrowFlies(trainstationsSelected.get(0), trainstationsSelected.get(1));
			Distance distance = new Distance("Frankfurt(Main)Hbf", "Berlin Hbf", theCrowFlies, "km");

			return distance;

		}
	}

	/**
	 * Return the distance between two long-distance train stations
	 * 
	 * @param start  train station
	 * @param target train station
	 */
	public Distance getDistanceBetweenStartAndTarget(String start, String target) {
		List<TrainStation> trainstationsSelected = CSVHelper.getTrainStations(start, target);
		if (trainstationsSelected == null || trainstationsSelected.size() < 2) {
			return new Distance();
		} else {

			int theCrowFlies = (int) calculateTheCrowFlies(trainstationsSelected.get(0), trainstationsSelected.get(1));
			Distance distance = new Distance(start, target, theCrowFlies, "km");

			return distance;

		}
	}

	/**
	 * calculates the Distance between two locations [distance = 6.378,137 •
	 * arccos(z) with z = sin(LatitudeOfLocation1) • sin(LatitudeOflocation2) +
	 * cos(LatitudeOfLocation1) • cos(LatitudeOflocation2) •
	 * cos(LongitudeOfLocation2 - LongitudeOfLocation1)]
	 */
	private double calculateTheCrowFlies(TrainStation start, TrainStation target) {
		double temp = Math.sin(Math.toRadians(start.getLatitude())) * Math.sin(Math.toRadians(target.getLatitude()))
				+ Math.cos(Math.toRadians(start.getLatitude())) * Math.cos(Math.toRadians(target.getLatitude()))
						* Math.cos(Math.toRadians(target.getLongitude()) - Math.toRadians(start.getLongitude()));

		double openingAngle = Math.acos(temp);
		double asTheCrowFlies = 6378.137 * openingAngle;
		return asTheCrowFlies;
	}
}
