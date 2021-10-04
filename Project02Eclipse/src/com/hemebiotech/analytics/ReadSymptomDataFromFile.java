package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

/**
 * Class that read the data from file and returns it's data as a list of String
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * CONSTRUCTOR of the object ReadSymptomDataFromFile
	 * tacke one parametre only : path to the file
	 * is called in AnalyticsCounter
	 * @param filepath
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	/**
	 * methode of the class ReadSymptomDataFromFile
	 * must be used after having instanciate the object ReadSymptomDataFromFile
	 * is called in ISymptomReader.java
	 * @param filepath
	 */
	@Override
	public List<String> GetSymptoms() {
		List<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
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
//TODO MAPING OF THE FILE

/*public Map<String,Symptom> getMapSymptoms() {
	Map<String,Symptom> results =  new HashMap<>();
	String line = null;
	while (line != null) {


		// Solution 1
		if(results.get(line) != null){
			Symptom currentSymptom = results.get(line);
			currentSymptom.count++;
			//Set la valeur
		}else{
			results.put(line, new Symptom(line, 1));
		}

		//Solution 2
		if(results.get(line) == null){
			results.put(line, new Symptom(line, 0));
		}
		Symptom currentSymptom = results.get(line);
		currentSymptom.count++;
	}
	return results;
}*/
}
