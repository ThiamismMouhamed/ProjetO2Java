package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Utilitaire class
 */
public class AnalyticsCounter {
	private static CountOccurences countOccurences;
	private static  ReadSymptomDataFromFile readSymptomDataFromFile;
	private static  WriteSymptomWithOccurenceFromFile writeSymptomWithOccurenceFromFile;
	
	public static void main(String args[]) throws Exception {

		String pathFileIn = "Project02Eclipse/symptoms.txt";
		String pathfileExit = "result2.out";

		// intaciation class ReadSymptomDataFromFile
		readSymptomDataFromFile = new ReadSymptomDataFromFile(pathFileIn);
		// read file symptom.txt with the method getSymptoms()
		List<String> symptoms = readSymptomDataFromFile.getSymptoms();

		//create liste symptom for counter occurence
		List<String> listForOccurences = new ArrayList<>(Arrays.asList("headache","tremor","pupils"));
		//instanciation class CountOccurences
		countOccurences = new CountOccurences(listForOccurences);
		// count occurences with symptoms
		Map<String, Integer> occurence = countOccurences.listSymptomWithOccurence(symptoms);

		//Intaciation to class WriteSymptomWithOccurenceFromFile

		writeSymptomWithOccurenceFromFile = new WriteSymptomWithOccurenceFromFile(pathfileExit);
		// write result count occurence to file result.out

		writeSymptomWithOccurenceFromFile.getFileSymptomsExit(occurence);

		// afficher le resultat
		System.out.println(occurence);




	}
}
