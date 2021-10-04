package com.hemebiotech.analytics;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

//import jdk.nashorn.internal.objects.SetIterator;

/**
 * Class that counts the number of occurence of a symptom
 *
 */
public class AnalyticsCounter {
	/**
	 * methode MAIN counts the number of occurences within a list of strings,
	 * instanciated by the object ReadSymptomDataFromFile.
	 */
	public static void main(String args[]) throws Exception {
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
		RenderOfAnalyticsCounter.writeSymptomsToFiles(resultedList);

	}
	/**
	 * methode getCountFromListForSymptom counts counts the number of times a symptom is in a list
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
