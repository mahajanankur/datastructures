/**
 * 
 */
package com.sb.datastructures.stacks.questions;

/**
 * @author ankur.mahajan
 * @written 04-Jun-2019
 */
public class GetMinimumFormStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(6);
		stack.pushMinimum(3);
		stack.pushMinimum(5);
		stack.pushMinimum(2);
		stack.pushMinimum(1);
		stack.pushMinimum(1);
		stack.pushMinimum(-1);
		// stack.push(1);
		// stack.push(1);
		// stack.push(1);
		// stack.push(1);
		// stack.push(1);
		// stack.push(1);

	}

	static class Stack<T> {

		private T[] stackArray;

		private int top;

		private int arraySize;

		private int size;

		private int minimum;

		public Stack(int size) {
			arraySize = size;
			stackArray = (T[]) new Object[size];
			top = -1;
			this.size = 0;
		}

		boolean push(T element) {
			if (isFull()) {
				throw new RuntimeException("Stack is full.");
			}
			stackArray[++top] = element;
			size++;
			return true;
		}

		// While push (2*element – minimum)
		boolean pushMinimum(int element) {
			Integer inserted = null;
			if (isFull()) {
				throw new RuntimeException("Stack is full.");
			}
			if (isEmpty()) {
				minimum = element;
				inserted = element;
			} else {
				if (minimum <= element) {
					inserted = element;
				} else {
					inserted = 2 * element - minimum;
					minimum = element;
				}
			}
			stackArray[++top] = (T) inserted;
			size++;
			return true;
		}

		// While push (2*minimum – peek)
		int popMinimum() {
			if (isEmpty()) {
				throw new RuntimeException("Stack is empty, there is nothing to remove.");
			}
			int returned = 0;
			int peek = (int) stackArray[top];
			if (peek >= minimum) {

				returned = (int) stackArray[top--];
			} else {
				minimum = 2 * minimum - peek;
				returned = peek;
			}
			size--;
			return returned;
		}

		T pop() {
			if (isEmpty()) {
				throw new RuntimeException("Stack is empty, there is nothing to remove.");
			}
			size--;
			return stackArray[top--];
		}

		T peek() {
			return stackArray[top];
		}

		boolean isEmpty() {
			return size == 0 ? true : false;
		}

		boolean isFull() {
			return size >= arraySize ? true : false;
		}

		int minimum() {
			return minimum;
		}
	}
}
