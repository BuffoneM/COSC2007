
/*
 * Assignment 1
 * Michael Buffone
 * January 10th, 2020
 * 
 * This class will use a backtracking algorithm to determine if the mouse can
 * escape the maze
 */
import java.io.*;
import java.util.Scanner;

public class EscapingMice {

	public static void main(String[] args) {

		// Create the file object and read the data into the arrays
		File file = new File("testMaze.txt");
		readFile(file);

	}

	public static void readFile(File file) {
		// Attempt scanner connection to the file
		try {
			Scanner input = new Scanner(file);

			int i = 0;
			while (input.hasNext()) {
				try {
					accountNum[i] = input.nextInt();
					accountType[i] = input.next().charAt(0);
					accountBal[i] = input.nextDouble();
					i++;
				} catch (Exception e) {
					System.out.println("Error with data order!");
					System.exit(0);
				}
			}
			numAccounts = i;
			input.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error reading the data file!");
		}
	}

}
