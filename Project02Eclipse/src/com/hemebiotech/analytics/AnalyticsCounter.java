package com.hemebiotech.analytics;

import java.util.Map.Entry;
import java.util.Map;

//import jdk.nashorn.internal.objects.SetIterator;

/**
 * Class that counts the number of occurence of a symptom
 *
 */
public class AnalyticsCounter {
	/**
	 * methode MAIN 
	 * first part of MAIN counts the number of occurences within a list of strings, in the case of a list approche of the matter
	 * second part of MAIN uses getMapSymptoms which is a quicker way to implement what is going on in the first part. folow the technique of Map-Reduce => the file is only gone through once
	 * To simplify the second part does nothing but calling the methodes that doese the job.
	 */
	public static void main(String args[]) throws Exception {
		//Second part getting a Map sorted an rendering it by calling RenderSymptomsAnalytics.writeMapedSymptomsToFiles(resultedMap)
		Map<String, Symptom> resultedMap = new ReadSymptomDataFromFile("symptoms.txt").getMapSymptoms();
		for (Entry<String, Symptom> entry : resultedMap.entrySet()) {
			System.out.println(entry.getValue());
		}
		RenderSymptomsAnalytics.writeMapedSymptomsToFiles(resultedMap);
	}
}