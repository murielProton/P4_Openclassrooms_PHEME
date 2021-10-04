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
    public Integer getCount(){
      return count;
    }
    public void setCount(Integer numberOfOccurences) {
      count=numberOfOccurences;
    }
    public String getDescription(){
      return description;
    }
    public void setDescription(String nameOfSymptom) {
      description = nameOfSymptom;
    }
    @Override
    public String toString() {
        return "Symptom : "+description +" => "+count;
    }
    
}
