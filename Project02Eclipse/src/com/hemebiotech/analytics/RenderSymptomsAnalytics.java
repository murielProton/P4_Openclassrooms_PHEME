package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Class which renders a Map into a file .out<br>
 * Used by : AnalyticsCounter.java<br>
 * Interface : IRenderSymptomsAnalytics.java
 */
public class RenderSymptomsAnalytics implements IRenderSymptomsAnalytics {
	static String fileName = "result.out";

	/*
	 * methode writeMapedSymptomsToFiles for each object symptom of the list, write a line in the file result.out<br>
	 * The fil result.out is saved in Project_Da8Java_En_Come_to_the_Rescue_of_a_Java_Application<br>
	 * 1 parameters = Map of Symptoms<br>
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