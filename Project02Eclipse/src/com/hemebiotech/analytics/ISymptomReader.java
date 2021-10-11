package com.hemebiotech.analytics;

import java.util.List;

/**
 * Name : ISymptomReader
 * Called by : ReadSymptomDataFromFile.java
 * This Interface will be usefull in case of code enlargement.
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	public List<String> GetSymptoms ();
}