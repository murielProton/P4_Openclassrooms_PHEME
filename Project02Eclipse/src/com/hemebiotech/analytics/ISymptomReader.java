package com.hemebiotech.analytics;

import java.util.Map;

/**
 * 
 * Name : ISymptomReader
 * Interface to SymptomReader
 */
public interface ISymptomReader {
	/**
	 * @return 
	 * @throws
	 */
	public Map<String, Symptom> getMapSymptoms();
}