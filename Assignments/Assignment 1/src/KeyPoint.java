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
	
	public KeyPoint(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	@Override
	public String toString() {
		return "x = " + this.x + ", y = " + this.y;
	}
}