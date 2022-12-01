package io.sprintstarter.distance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {
	@Autowired
	public DistanceService distanceService;

	/**
	 * Return the distance between Frankfurt Main Hbf (FF) and Berlin Hbf (BLS).
	 */
	@RequestMapping("/api/v1/distance/FF/BLS")
	public Distance getDistanceBetweenFFAndBLS() {
		return distanceService.getDistanceBetweenFFAndBLS();
	}

	/**
	 * Return the distance between two long-distance train stations
	 * 
	 * @param start  train station
	 * @param target train station
	 */
	@GetMapping("/api/v1/distance/{start}/{target}")
	public Distance getDistanceBetweenStartAndTarget(@PathVariable("start") String start,
			@PathVariable("target") String target) {
		return distanceService.getDistanceBetweenStartAndTarget(start, target);
	}

}
