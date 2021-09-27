package com.hemebiotech.analytics;

/*
* Object Symptoms 
* parametter : String, Integer
*/
public class Symptom {
    //propriétés
    String description;
    Integer count;

    /** 
    * CONSTRUCTOR
    * @param description 
    * @param descriptionCount
    */
   
    public Symptom(String description, Integer count) {
		this.description = description;
        this.count = count;
	}
    
}
