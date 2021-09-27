package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;

/**
 * Class that counts the number of occurence of a symptom
 *
 */
public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
/**
 * methode MAIN counts the number of occurences within a list of strings, instanciated by the object ReadSymptomDataFromFile.
 *
 */
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile rowListOfSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listOfSymptoms = rowListOfSymptoms.GetSymptoms();
		for (String line : listOfSymptoms) {
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}
		}
		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
