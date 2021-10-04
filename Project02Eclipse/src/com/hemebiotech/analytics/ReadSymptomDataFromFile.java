package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Class that read the data from file and returns it's data as a list of String
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private String lineOfResults;

	/**
	 * CONSTRUCTOR of the object ReadSymptomDataFromFile tacke one parametre only :
	 * path to the file is called in AnalyticsCounter
	 * 
	 * @param filepath
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * methode of the class ReadSymptomDataFromFile must be used after having
	 * instanciate the object ReadSymptomDataFromFile is called in
	 * ISymptomReader.java
	 * 
	 * @param filepath
	 */
	@Override
	public List<String> GetSymptoms() {
		List<String> result = new ArrayList<>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * methode of the class ReadSymptomDataFromFile must be used after having
	 * instanciate the object ReadSymptomDataFromFile is called in
	 * ISymptomReader.java
	 * 
	 * @param filepath
	 * @throws FileNotFoundException
	 */
	public Map<String, Symptom> getMapSymptoms() throws FileNotFoundException {
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
	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Symptom> resultedMap = new ReadSymptomDataFromFile("symptoms.txt").getMapSymptoms();
		for (Entry<String, Symptom> entry : resultedMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}
