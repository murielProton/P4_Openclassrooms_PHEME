package com.hemebiotech.analytics;

import java.util.Map;


/**
 * Class Main that counts the number of occurence of a symptom<br>
 * Uses class RenderSymptomsAnalytics and ReadSymptomDataFromFile<br>
 * Process NO DATA<br>
 */
public class AnalyticsCounter {
	/**
	 * methode MAIN <br>
	 * NEEDS a .txt file in folder Project02Eclipse<br>
	 * Uses class RenderSymptomsAnalytics and ReadSymptomDataFromFile<br>
	 * Process NO DATA<br>
	 * Calls : ReadSymptomDataFromFile("file.txt").getMapSymptoms() and RenderSymptomsAnalytics.writeMapedSymptomsToFiles(Type Map)
	 */
	public static void main(String args[]) throws Exception {
		//getting a Map sorted an rendering it
		Map<String, Symptom> resultedMap = new ReadSymptomDataFromFile("symptoms.txt").getMapSymptoms();
		RenderSymptomsAnalytics.writeMapedSymptomsToFiles(resultedMap);
	}
}