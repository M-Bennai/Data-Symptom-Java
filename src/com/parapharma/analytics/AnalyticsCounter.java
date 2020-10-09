package com.parapharma.analytics;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	/*private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0*/

	public static void main(String args[]) throws Exception {
		// first get input

		ReadSymptomDataFromFile reader1 = new ReadSymptomDataFromFile("symptoms.txt");
		reader1.GetSymptoms();
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));

		Map<String, Integer> frequency = new TreeMap<>();
		String line = reader.readLine();

		while (line != null) {


			if (!line.trim().equals("")) {
				String[] symptoms = line.split(" ");

				for (String symptom : symptoms) {
					if (symptom == null || symptom.trim().equals("")) {
						continue;
					}

					String processed = symptom.toLowerCase();
					if (frequency.containsKey(processed)) {
						frequency.put(processed, frequency.get(processed) + 1);
					} else {
						frequency.put(processed, 1);
					}

				}
			}
			line = reader.readLine();
		}
		System.out.println(reader + "\n");
		FileWriter writer = new FileWriter ("result.out.");
		writer.write(String.valueOf(frequency + "\n"));
		writer.close();
	}
}


		/*
		int i = 0;	// test branch
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// read line
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close(); */

