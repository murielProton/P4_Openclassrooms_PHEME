package com.hemebiotech.analytics;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
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
		//First Part getting a list and sorting throught to count number of occurence of a string
		ReadSymptomDataFromFile rowListOfSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listOfSymptoms = rowListOfSymptoms.GetSymptoms();
		Set<String> setOfSymptoms = new TreeSet<String>(listOfSymptoms);
		List<Symptom> resultedList = new ArrayList<>();
		for (String symptom : setOfSymptoms) {
			String description = symptom;
			Integer count = getCountFromListForSymptom(listOfSymptoms, symptom);
			Symptom current = new Symptom(description, count);
			resultedList.add(current);
		}
		RenderSymptomsAnalytics.writeSymptomsToFiles(resultedList);
		//Second part getting a Map sorted an rendering it by calling RenderSymptomsAnalytics.writeMapedSymptomsToFiles(resultedMap)
		Map<String, Symptom> resultedMap = new ReadSymptomDataFromFile("symptoms.txt").getMapSymptoms();
		for (Entry<String, Symptom> entry : resultedMap.entrySet()) {
			System.out.println(entry.getValue());
		}
		RenderSymptomsAnalytics.writeMapedSymptomsToFiles(resultedMap);
	}
	/**
	 * methode getCountFromListForSymptom counts the number of times a symptom is in a list
	 * 2 parameters = List of string and a string
	 * Used in this file by main
	 */
	private static Integer getCountFromListForSymptom(List<String> listOfSymptoms, String symptom) {
		Integer toReturn = 0;
		for (String description : listOfSymptoms) {
			if (symptom.equals(description)) {
				toReturn++;
			}
		}
		return toReturn;
	}
}