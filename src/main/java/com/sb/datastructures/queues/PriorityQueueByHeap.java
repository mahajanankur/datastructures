/**
 * 
 */
package com.sb.datastructures.queues;

/**
 * @author ankur.mahajan
 * @written 02-Apr-2019
 */
public class PriorityQueueByHeap {

	private Heap heap;

	private int size;

	private int nElements;

	public PriorityQueueByHeap(int size) {
		nElements = 0;
		this.size = size;
		heap = new Heap(size);
	}

	public boolean enqueue(int element) {
		if (isFull())
			return false;
		heap.insert(element);
		nElements++;
		return true;
	}

	public int dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty.");
		nElements--;
		int element = heap.remove();
		return element;
	}

	public boolean isFull() {
		return nElements >= size ? true : false;
	}

	public boolean isEmpty() {
		return nElements == 0 ? true : false;
	}

	/**
	 * @author ankur.mahajan
	 * @written 29-Mar-2019
	 * 
	 *          Minimum Heap, root node is the minimum in all.
	 */
	static class Heap {

		private int[] heapArray;

		private int currentIndex;

		private int arraySize;

		public Heap(int size) {
			arraySize = size;
			heapArray = new int[size];
			currentIndex = 0;
		}

		public boolean insert(int element) {
			if (isFull())
				return false;
			heapArray[currentIndex] = element;
			trickleUp(currentIndex++);
			return true;
		}

		public int remove() {
			int element = heapArray[0];
			heapArray[0] = heapArray[--currentIndex];
			trickleDown(0);
			return element;
		}

		private void trickleUp(int index) {
			int parent = (index - 1) / 2;
			int bottom = heapArray[index];

			while (bottom < heapArray[parent] && index > 0) {
				int temp = heapArray[index];
				heapArray[index] = heapArray[parent];
				heapArray[parent] = temp;
				index = parent;
				parent = (index - 1) / 2;
			}

		}

		private void trickleDown(int index) {
			int top = heapArray[index];
			int temp = 0;
			while (index < currentIndex / 2) {
				int left = 2 * index + 1;
				int right = left + 1;
				if (heapArray[left] >= top && heapArray[right] >= top) {
					return;
				}
				if (heapArray[left] < top && heapArray[right] > heapArray[left]) {
					temp = heapArray[left];
					heapArray[left] = heapArray[index];
					heapArray[index] = temp;
					index = left;
				} else if (heapArray[right] < top && heapArray[left] > heapArray[right]) {
					temp = heapArray[right];
					heapArray[right] = heapArray[index];
					heapArray[index] = temp;
					index = right;
				}

			}

		}

		public boolean isFull() {
			return currentIndex >= arraySize ? true : false;
		}

	}

}
