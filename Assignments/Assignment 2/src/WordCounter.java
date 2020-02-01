
/*
 * Assignment 2
 * Michael Buffone
 * February 1st, 2020
 * 
 * This class will create a binary search tree and count the amount of each word
 * in an input file
 */

import java.io.*;
import java.util.Scanner;

public class WordCounter {

	// Data members for the board

	public static void main(String[] args) {

		/*
		 * Scanner in = new Scanner(System.in); while(true) {
		 * 
		 * System.out.print("Enter a filename that contains a maze (0 to exit): ");
		 * String input = in.nextLine(); if(input.equals("0")) {
		 * System.out.println("Exiting..."); System.exit(0); } else {
		 * System.out.println(); instructions(input); } }
		 */

		// ****** File 1 ******
		//instructions("a2data.txt");

		// ****** File 2 ******
		instructions("a2data2.txt");

	}

	// ****** I/O Methods ******
	public static void instructions(String fileName) {

		// Create the file object and read the data into the arrays
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("The file does not exist...\n");
			return;
		}

		String wordsToAdd = parseFile(file);
		System.out.println(wordsToAdd);

		System.out.println("\n-----------------------------\n");

	}

	public static String parseFile(File file) {
		// Attempt scanner connection to the file
		try {

			Scanner input = new Scanner(file);
			String wordsToAdd = "";
			
			while (input.hasNext()) {

				// *** Collect the current word, lower-case it, and add it to "wordsToAdd" String ***
				String curr = input.next();
				
				// If curr doesn't have a single letter, go to the next word
				if(!containsLetters(curr)) continue;
				
				curr = curr.toLowerCase();
				// Remove all unnecessary chars in the word
				curr = curr.replaceAll("[^a-z^'^-]", "");

				// Separate the word by the dash and add both halves to the String
				if (curr.contains("-")) {
					wordsToAdd += (curr.substring(0, curr.indexOf("-")) + " ");
					wordsToAdd += (curr.substring(curr.indexOf("-") + 1, curr.length()) + " ");
				} else {
					wordsToAdd += (curr + " ");
				}

			}
			
			// Remove all unnecessary spaces to clean up the String
			input.close();
			return wordsToAdd;

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return null;
	}

	// ****** Word Related Methods ******
	public static boolean containsLetters(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i)))
				return true;
		}
		return false;
	}

	public static void printTree() {

	}

}