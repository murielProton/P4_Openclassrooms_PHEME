package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class that reads the data from file and returns it's data as a list of String
 * Used by : AnalyticsCounter.java
 * Interface : ISymptomReader.java
 * Uses class Symptom
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * CONSTRUCTOR of the object ReadSymptomDataFromFile<br>
	 * parameter path to the file is called in AnalyticsCounter
	 * 
	 * @param filepath
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * methode of the class ReadSymptomDataFromFile must be used after having<br>
	 * instanciate the object ReadSymptomDataFromFile<br>
	 * gets a file and returns a Map ordered ASC<br>
	 * Takes filepath as parameter<br>
	 * Used in AnalyticsCounter.java
	 * 
	 * 
	 * @param filepath
	 * @throws FileNotFoundException
	 * @override
	 */
	public Map<String, Symptom> getMapSymptoms() {
		Map<String, Symptom> results = new TreeMap<String, Symptom>();
		if (filepath == null) {
			return results;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String symptomDescriptionFromReader = reader.readLine();

			while (symptomDescriptionFromReader != null) {
				// check if the map results has already the value of the
				// symptomDescriptionFromReader
				if (results.containsKey(symptomDescriptionFromReader)) {
					Symptom currentSymptom = results.get(symptomDescriptionFromReader);
					currentSymptom.count++;
				} else {
					results.put(symptomDescriptionFromReader, new Symptom(symptomDescriptionFromReader, 1));
				}
				symptomDescriptionFromReader = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
}
