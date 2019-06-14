/**
 * 
 */
package com.sb.datastructures.revision.stack;

/**
 * @author ankur.mahajan
 * @written 10-Jun-2019
 */
public class Stack<T> {

	T[] arr;

	int size;

	int arraySize;

	int top;

	public Stack(int size) {
		size = 0;
		arraySize = size;
		arr = (T[]) new Object[arraySize];
		top = -1;
	}

	public boolean push(T element) {
		if (isFull()) {
			throw new RuntimeException("Stack is full.");
		}
		arr[++top] = element;
		size++;
		return true;

	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty.");
		}
		size--;
		return arr[top--];
	}

	public boolean isFull() {
		return arraySize <= size ? true : false;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

}
