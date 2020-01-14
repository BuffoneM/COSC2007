/*
 * Assignment 1
 * Michael Buffone
 * January 10th, 2020
 * 
 * Interface implemented by stack
 */

public interface StackInterface<T> {
	
	public T peek() throws StackException;
	public T pop() throws StackException;
	public void push(T item);
	public void popAll();
	public boolean isEmpty();
	public int size();
	
}