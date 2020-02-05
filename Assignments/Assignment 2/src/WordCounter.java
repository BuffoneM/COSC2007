
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

	public static void main(String[] args) throws TreeException {

		// ****** File 1 ******
		// instructions("a2data.txt");

		// ****** File 2 ******
		//instructions("a2data2.txt");

		BinaryTree bt = new BinaryTree();
		bt.add("1");
		bt.add("2");
		bt.add("3");
		bt.add("4");
		bt.printTree();
		//System.out.println("2".compareTo("2"));

	}

	// ****** I/O Methods ******
	public static void instructions(String fileName) {

		// Create the file object and read the data into the arrays
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("The file does not exist...\n");
			return;
		}

		BinaryTree wordsToAdd = parseFile(file);
		wordsToAdd.printTree();

		System.out.println("\n-----------------------------\n");

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