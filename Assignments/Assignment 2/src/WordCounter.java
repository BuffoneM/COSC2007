/*
 * Assignment 2
 * Michael Buffone
 * February 1st, 2020
 * 
 * This class will create a binary tree and print, count, and filter
 * each word in an input file
 */

import java.io.*;
import java.util.Scanner;

public class WordCounter {

	public static void main(String[] args) throws TreeException {
		
		
		Scanner in = new Scanner(System.in);
		while (true) {

			System.out.print("Enter a filename (0 to exit): ");
			String input = in.nextLine();
			if (input.equals("0")) {
				System.out.println("Exiting...");
				System.exit(0);
			} else {
				System.out.println();
				instructions(input);
			}
		}
		

		// ****** File 1 ******
		//instructions("a2data.txt");

		// ****** File 2 ******
		//instructions("a2data2.txt");
		
		// ****** File 3 ******
		//instructions("a2data3.txt");

	}

	// ****** I/O Methods ******
	public static void instructions(String fileName) {

		// Create the file object and read the data into the arrays
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("The file does not exist...\n");
			System.out.println("Complete...\n-----------------------------");
			return;
		}

		// Create the binary tree from the file
		BinaryTree wordsToAdd = parseFile(file);
		System.out.println("There are " + wordsToAdd.countNodes() + " words in the file.");
		int num4l = wordsToAdd.countFourLetters();
		System.out.println(
				"There " + (num4l == 1 ? "is " + num4l + " four letter word" : "are " + num4l + " four letter words")
						+ " in the file.");

		System.out.println("\n----------In Order----------");
		wordsToAdd.printInTree();
		/*
		System.out.println("\n----------Pre Order----------");
		wordsToAdd.printPreTree();
		
		System.out.println("\n----------Post Order----------");
		wordsToAdd.printPostTree();
		*/
		System.out.println("\nComplete...\n-----------------------------");
	}

	public static BinaryTree parseFile(File file) {

		// Attempt scanner connection to the file
		try {
			Scanner input = new Scanner(file);
			BinaryTree wordTree = new BinaryTree();

			while (input.hasNext()) {
				String curr = input.next();

				// If curr doesn't have a letter, go to the next word
				if (!containsLetters(curr))
					continue;

				// Remove everything but hyphens and apostrophes from curr
				curr = curr.toLowerCase();
				curr = curr.replaceAll("[^a-z^'^-]", "");

				// Separate the word by the dash and add both halves to the tree
				if (curr.contains("-")) {
					wordTree.add(curr.substring(0, curr.indexOf("-")));
					wordTree.add(curr.substring(curr.indexOf("-") + 1, curr.length()));

				} else
					wordTree.add(curr);
			}
			input.close();
			return wordTree;

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

}