package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
 * Class which renders what AnalyticsCounter generates.
 */
public class RenderOfAnalyticsCounter {
	/**
	 * methode writeSymptomsToFiles for each object symptom of the list, write a line in the file result.out
	 * 1 parameters = List of Symptom
	 * Used in AnalyticsCounter.java file in the Main Methode
	 */
  public static void writeSymptomsToFiles(List<Symptom> resultedList) throws IOException {
		FileWriter writer = new FileWriter("result.out");
		for (Symptom current : resultedList) {
			writer.write(current.description+" : " + current.count + "\n");
		}
		writer.close();
	}

}
