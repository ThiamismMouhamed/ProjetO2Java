package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		// try with resources

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"))){
			String line;
			//tester si la ligne lue est non vide

			int i = 0;	// compteur pour recuperer le nombre de ligne lu
			while ((line = bufferedReader.readLine()) != null){
			  System.out.println(line);
			  i++;
			  if(line.equals("headache")){
				  headacheCount ++;
				  System.out.println("number of headaches: " + headacheCount);

			} else if (line.equals("rush")) {
				  rashCount++;
				  System.out.println("number of rush: " + rashCount);

			  } else if (line.equals("pupils")) {
				  pupilCount ++;
				  System.out.println("number of pupils: " + pupilCount);

			  }
			}
			System.out.println("nombre de ligne lu :"+ i +"\n");
		}catch (java.lang.Exception e) {
			System.err.println("le fichier %s n'a pas ete trouve.");

		}

		// next generate output
		FileWriter writer = null;
		try {
			writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");

		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			if(writer !=null){
				writer.close();
			}
		}

	}
}
