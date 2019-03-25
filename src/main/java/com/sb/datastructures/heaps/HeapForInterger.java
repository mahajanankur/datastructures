/**
 * 
 */
package com.sb.datastructures.heaps;

/**
 * @author ankur.mahajan
 * @written 18-Mar-2019
 * 
 *          Maximum Heap for integers, parent key should have greater than it's
 *          child.
 */
public class HeapForInterger {

	class Node {
		int key;

		public Node(int key) {
			this.key = key;
		}
	}

	private Node[] array;

	private int arraySize;

	private int currentIndex;

	public HeapForInterger(int size) {
		arraySize = size;
		currentIndex = 0;
		array = new Node[size];

	}

	/**
	 * @param element
	 * @return
	 */
	public boolean insert(int element) {
		// Check if array is not full.
		if (isFull()) {
			return false;
		}
		Node node = new Node(element);
		array[currentIndex] = node;
		trickleUp(currentIndex++);
		return true;
	}

	public int remove() {
		int element = array[0].key;
		array[0] = array[--currentIndex];
		trickleDown(0);
		return element;
	}

	public boolean changeKey(int index, int value) {
		// If the index is -ve and larger than array size. Return false.
		if (index < 0 || index > currentIndex)
			return false;
		int old = array[index].key;
		array[index].key = value;

		if (old < value) {
			trickleUp(index);
		}
		else {
			trickleDown(index);
		}

		return true;
	}

	/**
	 * @param index
	 */
	private void trickleDown(int index) {
		int top = array[index].key;
		int largerChild = 0;
		while (index < currentIndex / 2) {
			int left = 2 * index + 1;
			int right = left + 1;
			// Break if top element is greater than both child's
			if (top >= array[left].key && top >= array[right].key)
				break;
			if (top < array[left].key && array[left].key > array[right].key) {
				largerChild = array[left].key;
				array[left].key = array[index].key;
				array[index].key = largerChild;
				index = left;
			}
			else if (top < array[right].key && array[left].key < array[right].key) {
				largerChild = array[right].key;
				array[right].key = array[index].key;
				array[index].key = largerChild;
				index = right;
			}
		}

	}

	/**
	 * @param index
	 */
	private void trickleUp(int index) {
		int parentIndex = (index - 1) / 2;
		int bottom = array[index].key;

		while (bottom > array[parentIndex].key && index > 0) {
			int temp = array[parentIndex].key;
			array[parentIndex].key = bottom;
			array[index].key = temp;
			// REMEBER : Don't change the bottom as it should compared with each
			// parent node.
			// bottom = temp;
			index = parentIndex;
			parentIndex = (parentIndex - 1) / 2;

		}

	}

	public boolean isFull() {
		return currentIndex + 1 >= arraySize ? true : false;
	}

}
