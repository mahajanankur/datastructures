/**
 * 
 */
package com.sb.datastructures.queues;

/**
 * @author ankur.mahajan
 * @written 13-Feb-2019
 */
public class PriorityQueueA<E> {

	private PriorityQueueData<E>[] arr;

	private int arrSize;

	private int nItems;

	@SuppressWarnings("unchecked")
	public PriorityQueueA(int size) {
		arrSize = size;
		arr = new PriorityQueueData[size];
		nItems = 0;
	}

	/**
	 * @param element
	 * @param priority,
	 *            Larger number has high priority.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void enqueue(E element, int priority) {
		int i;
		if (isFull())
			throw new RuntimeException("Queue is full.");
		if (nItems == 0) {
			arr[nItems++] = new PriorityQueueA.PriorityQueueData(priority, element);
		}
		else {
			for (i = nItems - 1; i >= 0; i--) {
				if (arr[i].getPriority() > priority) {
					arr[i + 1] = arr[i];
				}
				else {
					break;
				}

			}
			arr[i + 1] = new PriorityQueueA.PriorityQueueData(priority, element);
			nItems++;
		}
	}

	public E dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty.");
		return arr[--nItems].getValue();
	}

	public E peek() {
		return arr[nItems - 1].getValue();
	}

	public boolean isFull() {
		return (nItems == arrSize);
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public int size() {
		return nItems;
	}

	class PriorityQueueData<E> {

		private Integer priority;

		private E value;

		public PriorityQueueData(Integer p, E element) {
			this.priority = p;
			value = element;
		}

		/**
		 * @return the priority
		 */
		public Integer getPriority() {
			return priority;
		}

		/**
		 * @param priority
		 *            the priority to set
		 */
		public void setPriority(Integer priority) {
			this.priority = priority;
		}

		/**
		 * @return the value
		 */
		public E getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(E value) {
			this.value = value;
		}

	}
}
