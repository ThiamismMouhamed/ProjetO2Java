package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class which allows to read a symptom file and which implements the interface IsymptomReader
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {

		this.filepath = filepath;
	}


	/**
	 * method to return symptoms
	 * @return result  list of file symptoms symptoms.txt
	 */
	@Override
	public List<String> getSymptoms() {
		//changement de ArrayList to List
		List<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try( BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					result.add(line);
					//System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}








}
