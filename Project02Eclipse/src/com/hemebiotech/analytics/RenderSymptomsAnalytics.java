package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Class which renders what AnalyticsCounter generates.
 */
public class RenderSymptomsAnalytics {
	/**
	 * methode writeSymptomsToFiles for each object symptom of the list, write a line in the file result.out
	 * 1 parameters = List of Symptoms
	 * Used in AnalyticsCounter.java file in the Main Methode
	 */
  public static void writeSymptomsToFiles(List<Symptom> resultedList) throws IOException {
		FileWriter writer = new FileWriter("result.out");
		for (Symptom current : resultedList) {
			writer.write(current.description+" : " + current.count + "\n");
		}
		writer.close();
	}

	/**
	 * methode writeMapedSymptomsToFiles for each object symptom of the list, write a line in the file resultMaped.out
	 * 1 parameters = Map of Symptoms
	 * Used in AnalyticsCounter.java file in the Main Methode
	 */
	public static void writeMapedSymptomsToFiles(Map<String, Symptom> resultedMap) throws IOException {
		FileWriter writer = new FileWriter("resultMaped.out");
		for (Entry<String, Symptom> entry : resultedMap.entrySet()) {
			System.out.println(entry.getValue());
			writer.write(entry.getValue().description+", "+ entry.getValue().count+".\n");
		}
		writer.close();
	}
}
//AFAIRE implement variable with name of the file So that name of the file can be changed