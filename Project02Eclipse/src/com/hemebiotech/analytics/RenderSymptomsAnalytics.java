package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Class which renders what AnalyticsCounter.java generates.
 * Two Methodes one with a list that creates a file the other with a map that creates a file
 */
public class RenderSymptomsAnalytics {
	static String fileName = "result.out";

	/**
	 * methode writeMapedSymptomsToFiles for each object symptom of the list, write a line in the file resultMaped.out
	 * 1 parameters = Map of Symptoms
	 * Used in AnalyticsCounter.java file in the Main Methode
	 */
	public static void writeMapedSymptomsToFiles(Map<String, Symptom> resultedMap) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		for (Entry<String, Symptom> entry : resultedMap.entrySet()) {
			System.out.println(entry.getValue());
			writer.write(entry.getValue().description+", "+ entry.getValue().count+".\n");
		}
		writer.close();
	}
}