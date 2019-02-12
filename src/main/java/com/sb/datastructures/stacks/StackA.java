/**
 * 
 */
package com.sb.datastructures.stacks;

/**
 * @author ankur.mahajan
 * @param <T>
 * @written 11-Feb-2019
 * 
 *          The stack is a data structure based on LIFO (LAST IN FIRST OUT)
 */
public class StackA<T> {

	private T[] arr;

	private int top;

	private int maxSize;

	@SuppressWarnings("unchecked")
	public StackA(int size) {
		this.top = -1;
		this.maxSize = size;
		arr = (T[]) new Object[maxSize];
	}

	public void push(T element) {
		if (isFull()) {
			throw new RuntimeException("Stack is full.");
		}
		else {
			arr[++top] = element;
		}
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty.");
		}
		else {
			return arr[top--];
		}

	}

	public T peek() {
		return arr[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
}
