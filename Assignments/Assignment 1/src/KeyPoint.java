/*
 * Assignment 1
 * Michael Buffone
 * January 10th, 2020
 * 
 * This class will be used to make the "mouse" and "exit" location objects
 */

public class KeyPoint {
	private int x = 0;
	private int y = 0;
	private boolean visited = false;
	private char val = '-';
	
	public KeyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public KeyPoint(int x, int y, char val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	// Getters and setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean getVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public char getVal() {
		return val;
	}
	public void setVal(char val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return "x = " + this.x + ", y = " + this.y + ", value = " + this.getVal();
	}
	
	public boolean equals(KeyPoint o) {
		if(this.getX() == o.getX()) {
			if(this.getY() == o.getY()) {
				return true;
			}
		}
		return false;
	}
}