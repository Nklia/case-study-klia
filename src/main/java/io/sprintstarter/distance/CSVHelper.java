package io.sprintstarter.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

public class CSVHelper {

	/**
	 * Return a list with two train stations (start and target) objects
	 * 
	 * @param start  train station
	 * @param target train station
	 */
	public static List<TrainStation> getTrainStations(String start, String target) {
		List<TrainStation> trainStations = new ArrayList<TrainStation>();
		ClassPathResource cl = new ClassPathResource("D_Bahnhof_2020_alle.CSV");
		URL url = null;
		try {
			url = cl.getURL();
		} catch (IOException e1) {
			throw new RuntimeException("the resource cannot be resolved as URL " + e1.getMessage());
		}

		InputStreamReader input = null;
		try {
			if (url != null) {
				input = new InputStreamReader(url.openStream(), "UTF-8");
			}

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			if (input != null) {

				BufferedReader fileReader = new BufferedReader(input);

				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.EXCEL.withDelimiter(';').withHeader("EVA_NR", "DS100", "IFOPT", "NAME", "Verkehr",
								"Laenge", "Breite", "Betreiber_Name", "Betreiber_Nr", "Status"));

				Iterable<CSVRecord> csvRecords = csvParser.getRecords();

				for (CSVRecord csvRecord : csvRecords) {

					if (csvRecord.get("Verkehr").equals("FV") && (csvRecord.get("NAME").equalsIgnoreCase(start)
							|| csvRecord.get("NAME").equalsIgnoreCase(target))) {
						TrainStation trainStation = new TrainStation(csvRecord.get("DS100"), csvRecord.get("NAME"),
								csvRecord.get("Verkehr"), Double.parseDouble(csvRecord.get("Breite").replace(",", ".")),
								Double.parseDouble(csvRecord.get("Laenge").replace(",", ".")));
						trainStations.add(trainStation);

					}

				}
				csvParser.close();
			}
		} catch (

		UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return trainStations;
	}

}
