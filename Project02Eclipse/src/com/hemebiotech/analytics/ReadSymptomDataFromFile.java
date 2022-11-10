package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
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

	@Override
	public List<String> GetSymptoms() {
		//changement de ArrayList to List
		ArrayList<String> result = new ArrayList<String>();
		List <String> list = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = null;
				while ((line = reader.readLine()) != null) {
					result.add(line);
					//System.out.println(line);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	//Methode pour calculer le nombre d'occurence
	public Map<String, Integer> CountOccurences(List<String> list){
		//list des symptom à chercher
		//List<String> list = new ArrayList<String>();
		//les symptoms du fichier symptoms.txt
		ArrayList<String> symptoms = (ArrayList<String>) GetSymptoms();
		//list hasmap pour le fichier de sortie
		Map<String, Integer> occurences = new HashMap<>();

		for (int j=0; j<symptoms.size(); j++){
			int count=0;
			for (String word : list ){
				if(word.equals(symptoms.get(j))) {
					count++;
				}
			}

			if (count>=1) {
				//remplissage de la liste occurence avec le mot et le nombre de fois qu'il apparait
				occurences.put(symptoms.get(j), count);
				System.out.println(symptoms.get(j) + ":" + count + "\n");
			}
		}

		return occurences;
	}
	// Methode pour le fichier de sortie
	public void FichierSortie(Map<String, Integer> wordOccurence) {
		//recuperation de la liste des occurence
		List<String> list = new ArrayList<String>();
		wordOccurence = CountOccurences(list);
		FileWriter writer = null;
		try {
			writer = new FileWriter("result2.out");
			for (Map.Entry mapentry : wordOccurence.entrySet()) {
				writer.write(mapentry.getKey() + ":" + mapentry.getValue() + "\n");
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}






}
