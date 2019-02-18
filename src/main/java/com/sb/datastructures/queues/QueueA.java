/**
 * 
 */
package com.sb.datastructures.queues;

/**
 * @author ankur.mahajan
 * @written 12-Feb-2019
 * 
 *          The queue is a data structure based on FIFO (FIRST IN FIRST OUT)
 */
public class QueueA<E> {

	private E[] arr;

	private int head;

	private int tail;

	private int size;

	private int nItems;

	@SuppressWarnings("unchecked")
	public QueueA(int size) {
		this.size = size;
		arr = (E[]) new Object[size];
		head = 0;
		tail = -1;
		nItems = 0;
	}

	public void enqueue(E element) {
		if (isFull()) {
			throw new RuntimeException("Queue is full.");
		}
		arr[++tail] = element;
		nItems++;
	}

	public E dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty.");
		}
		nItems--;
		return arr[head++];
	}

	public E peek() {
		return arr[head];
	}

	public boolean isEmpty() {
		return (nItems == 0);
		// return (rear + 1 - front == 0);
	}

	public boolean isFull() {
		return (nItems == size);
	}

	public int size() {
		return nItems;
	}

	public int head() {
		return head;
	}

	public int tail() {
		return tail;
	}
}
