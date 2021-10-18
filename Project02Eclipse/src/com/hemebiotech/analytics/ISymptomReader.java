package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface to SymptomReader<br>
 * Name : ISymptomReader<br>
 * 
 */
public interface ISymptomReader {
	/**
	 * @return 
	 * @throws
	 */
	public Map<String, Symptom> getMapSymptoms();
}