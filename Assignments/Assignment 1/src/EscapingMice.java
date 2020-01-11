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
	
	// Data members for the board
	private static KeyPoint mouse;
	private static KeyPoint exit;
	private static char[][] board;
	
	public static void main(String[] args) {

		// Create the file object and read the data into the arrays
		File file = new File("testMaze.txt");
		readFile(file);
		printBoard(board);
		
		

	}

	// ****** I/O Methods ******
	public static void readFile(File file) {
		// Attempt scanner connection to the file
		try {
			Scanner input = new Scanner(file);
			
			try {
				
				// Get the board dimensions and create it based on those
				int numRow = input.nextInt();
				int numCol = input.nextInt();
				board = new char[numRow][numCol];
				
				// For every element in the text file, add it to the board
				// -If the element is a mouse or exit, create the keypoint for it
				for(int i = 0; i < numRow; i++) {
					for(int j = 0; j < numCol; j++) {
						
						String curr = input.next();
						if(curr.equals("m")) mouse = new KeyPoint(i, j);
						else if(curr.equals("e")) exit = new KeyPoint(i, j);
						board[i][j] = curr.charAt(0);				
					}
				}

			} catch (Exception e) {
				System.out.println("Error with data order!");
				System.exit(0);
			}
			input.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error reading the data file!");
		}
	}
	
	// ****** Puzzle Related Methods ******
	public static void solveBoard(char[][] board) {
		
	}
	
	public static void printBoard(char[][] board) {
		
		System.out.println("Mouse location: " + mouse.toString());
		System.out.println("Exit location: " + exit.toString());
		System.out.println("Row amount: " + board.length + " Column amount: " + board[0].length);
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
