package com.hemebiotech.analytics;

import java.util.Map;

//import jdk.nashorn.internal.objects.SetIterator;

/**
 * Class that counts the number of occurence of a symptom
 *
 */
public class AnalyticsCounter {
	/**
	 * methode MAIN 
	 * NEEDS a .txt file in folder Project02Eclipse
	 * Uses class RenderSymptomsAnalytics and ReadSymptomDataFromFile
	 * Process NO DATA
	 * Calls : ReadSymptomDataFromFile("file.txt").getMapSymptoms() and RenderSymptomsAnalytics.writeMapedSymptomsToFiles(Type Map)
	 */
	public static void main(String args[]) throws Exception {
		//Second part getting a Map sorted an rendering it by calling RenderSymptomsAnalytics.writeMapedSymptomsToFiles(resultedMap)
		Map<String, Symptom> resultedMap = new ReadSymptomDataFromFile("symptoms.txt").getMapSymptoms();
		RenderSymptomsAnalytics.writeMapedSymptomsToFiles(resultedMap);
	}
}