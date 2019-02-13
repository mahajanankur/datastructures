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
public class CircularQueueA<E> {

	private E[] arr;

	private int front;

	private int rear;

	private int size;

	private int nItems;

	@SuppressWarnings("unchecked")
	public CircularQueueA(int size) {
		this.size = size;
		arr = (E[]) new Object[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void enqueue(E element) {
		if (isFull()) {
			throw new RuntimeException("Queue is full.");
		}
		// To make it circular if rear is at max index of array wrapper should
		// be taken place. Now rear is lesser than front this is called BROKEN
		// SEQUENCE.
		if (rear == size - 1)
			rear = -1;
		arr[++rear] = element;
		nItems++;
	}

	public E dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty.");
		}
		// To make it circular, if front is at max index of array wrapper should
		// be taken place. Now rear is greater than front this is called
		// CONTIGOUS (NORMAL) SEQUENCE.
		if (front == size)
			front = 0;
		nItems--;
		return arr[front++];
	}

	public E peek() {
		return arr[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
		// return (rear + 1 - front == 0);
		// TODO - HOW without nItems.
		// return ( rear + 1 == front || (front + size - 1 == rear));
	}

	public boolean isFull() {
		return (nItems == size);
		// TODO - HOW without nItems.
		// return ( rear + 2 == front || (front + size -2 == rear) );
	}

	public int size() {
		return nItems;
	}

	public int front() {
		return front;
	}

	public int rear() {
		return rear;
	}
}
