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
	private static KeyPoint[][] board;
	private static KeyPoint[][] solutionBoard;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while(true) {
			
			System.out.print("Enter a filename that contains a maze (0 to exit): ");
			String input = in.nextLine();
			if(input.equals("0")) {
				System.out.println("Exiting...");
				System.exit(0);
			}
			else {
				System.out.println();
				instructions(input);
			}	
		}
		
		
		// ****** Maze 1 ******
		//instructions("testMaze.txt");

		// ****** Maze 2 ******
		//instructions("testMaze2.txt");

		// ****** Maze 3 ******
		//instructions("testMaze3.txt");

		// ****** Maze 4 ******
		//instructions("testMaze4.txt");

		// Modify these four lines with getX and getY to test the board "coordination"
		// - it may seem confusing, but it makes sense once you play around with it
		// System.out.println("\n" + mouse.getX());
		// System.out.println(mouse.getY() + "\n---------");
		// System.out.println(board[mouse.getY()-2][mouse.getX()].getVal());
		// System.out.println(board[mouse.getY()-2][mouse.getX()].getVal() == '1');

	}

	// ****** I/O Methods ******
	public static void instructions(String fileName) {

		// Create the file object and read the data into the arrays
		File file = new File(fileName);
		if(!file.exists()) {
			System.out.println("The file does not exist...\n");
			return;
		}
		
		readFile(file);
		printInfo(board);
		printBoard(board);

		if (solveBoard(board, mouse, exit)) {
			System.out.println("\nThe mouse found the exit.\n");
			printBoard(solutionBoard);
		} else {
			System.out.println("\nAn exit cannot be found.");
		}

		System.out.println("\n-----------------------------\n");

	}

	public static void readFile(File file) {
		// Attempt scanner connection to the file
		try {
			
			Scanner input = new Scanner(file);

			try {

				// Get the board dimensions and create it based on those
				int numRow = input.nextInt();
				int numCol = input.nextInt();
				board = new KeyPoint[numRow][numCol];
				solutionBoard = new KeyPoint[numRow][numCol];

				// For every element in the text file, add it to the board
				// -If the element is a mouse or exit, create the keypoint for it
				for (int i = 0; i < numRow; i++) {
					for (int j = 0; j < numCol; j++) {

						String curr = input.next();
						if (curr.equals("m"))
							mouse = new KeyPoint(j, i, 'm');
						else if (curr.equals("e"))
							exit = new KeyPoint(j, i, 'e');
						board[i][j] = new KeyPoint(j, i, curr.charAt(0));
						solutionBoard[i][j] = new KeyPoint(j, i, curr.charAt(0));
					}
				}

			} catch (Exception e) {
				System.out.println("Error with data order!");
				System.exit(0);
			}
			input.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	// ****** Puzzle Related Methods ******
	public static boolean solveBoard(KeyPoint[][] board, KeyPoint mouse, KeyPoint exit) {

		// Stack creation and duplicate the board to show the path
		Stack<KeyPoint> cellStack = new Stack<KeyPoint>();

		// Starting cell is initialized to the mouse's location
		KeyPoint curCell = new KeyPoint(mouse.getX(), mouse.getY());

		while (!curCell.equals(exit)) {
			// Mark the current cell as visited
			curCell.setVisited(true);

			// Push unvisited open neighbours of currentCell onto the stack
			// -12'oclock, 3'oclock, 6'oclock, 9'oclock cell check order
			try {
				if ((board[curCell.getY() - 1][curCell.getX()].getVal() == '0'
						|| board[curCell.getY() - 1][curCell.getX()].getVal() == 'e')
						&& (board[curCell.getY() - 1][curCell.getX()].getVisited() == false)) {
					solutionBoard[curCell.getY() - 1][curCell.getX()].setVal('.');
					cellStack.push(board[curCell.getY() - 1][curCell.getX()]);
				}

				if ((board[curCell.getY()][curCell.getX() + 1].getVal() == '0'
						|| board[curCell.getY()][curCell.getX() + 1].getVal() == 'e')
						&& (board[curCell.getY()][curCell.getX() + 1].getVisited() == false)) {
					solutionBoard[curCell.getY()][curCell.getX() + 1].setVal('.');
					cellStack.push(board[curCell.getY()][curCell.getX() + 1]);
				}

				if ((board[curCell.getY() + 1][curCell.getX()].getVal() == '0'
						|| board[curCell.getY() + 1][curCell.getX()].getVal() == 'e')
						&& (board[curCell.getY() + 1][curCell.getX()].getVisited() == false)) {
					solutionBoard[curCell.getY() + 1][curCell.getX()].setVal('.');
					cellStack.push(board[curCell.getY() + 1][curCell.getX()]);
				}

				if ((board[curCell.getY()][curCell.getX() - 1].getVal() == '0'
						|| board[curCell.getY()][curCell.getX() - 1].getVal() == 'e')
						&& (board[curCell.getY()][curCell.getX() - 1].getVisited() == false)) {
					solutionBoard[curCell.getY()][curCell.getX() - 1].setVal('.');
					cellStack.push(board[curCell.getY()][curCell.getX() - 1]);
				}
			} catch (Exception e) {
				System.out.println("Issue with the board boundaries detected @ " + curCell);
			}

			//cellStack.print("Cells");

			// Check if the stack is empty - if it is a solution cannot be found
			if (cellStack.isEmpty())
				return false;
			else {
				try {

					curCell = cellStack.pop();
					
				} catch (Exception e) {
					System.out.println("Error popping the cell stack!");
				}
			}
		}
		if (curCell.getVal() == 'e') {
			solutionBoard[curCell.getY()][curCell.getX()].setVal('e');
			return true;
		} else
			return false;
	}

	public static void printBoard(KeyPoint[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j].getVal() + " ");
			}
			System.out.println();
		}
	}

	public static void printInfo(KeyPoint[][] board) {
		System.out.println("Mouse location: " + mouse);
		System.out.println("Exit location:  " + exit);
		System.out.println("Row amount: " + board.length + ", Column amount: " + board[0].length);
	}

}