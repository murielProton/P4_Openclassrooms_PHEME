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
    // this methode returns an Integer of the variable count wich composes this Object Symptom
    public Integer getCount(){
      return count;
    }
    // this methode defines the Integer of the variable count wich composes this Object Symptom
    public void setCount(Integer numberOfOccurences) {
      count=numberOfOccurences;
    }
    // this methode returns a String of the variable description wich composes this Object Symptom
    public String getDescription(){
      return description;
    }
    // this methode defines a String of the variable description wich composes this Object Symptom
    public void setDescription(String nameOfSymptom) {
      description = nameOfSymptom;
    }
    // this methode returns a string of the two variables which compose this Object Symptom
    @Override
    public String toString() {
        return description+", "+count;
    }
    
}
