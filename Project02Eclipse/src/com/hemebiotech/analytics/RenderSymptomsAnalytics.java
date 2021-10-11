package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Class which renders what MainSymptomsAnalytics.java generates.
 * Two Methodes one with a list that creates a file the other with a map that creates a file
 */
public class RenderSymptomsAnalytics {
	static String fileName = "result.out";
	static String otherFileName = "mappedResults.out";
	/**
	 * methode writeSymptomsToFiles for each object symptom of the list, write a line in the file result.out
	 * 1 parameters = List of Symptoms
	 * Used in MainSymptomsAnalytics.java file in the Main Methode
	 */
  public static void writeSymptomsToFiles(List<Symptom> resultedList) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		for (Symptom current : resultedList) {
			writer.write(current.description+" : " + current.count + "\n");
		}
		writer.close();
	}

	/**
	 * methode writeMapedSymptomsToFiles for each object symptom of the list, write a line in the file resultMaped.out
	 * 1 parameters = Map of Symptoms
	 * Used in MainSymptomsAnalytics.java file in the Main Methode
	 */
	public static void writeMapedSymptomsToFiles(Map<String, Symptom> resultedMap) throws IOException {
		FileWriter writer = new FileWriter(otherFileName);
		for (Entry<String, Symptom> entry : resultedMap.entrySet()) {
			System.out.println(entry.getValue());
			writer.write(entry.getValue().description+", "+ entry.getValue().count+".\n");
		}
		writer.close();
	}
}