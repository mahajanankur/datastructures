/**
 * 
 */
package com.sb.datastructures.queues;

/**
 * @author ankur.mahajan
 * @written 12-Feb-2019
 */
public class TestQueueA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testSimpleQueueImplemetedByArray();
		testQueueImplemetedByDoubleEndedLinkedList();

	}

	private static void testQueueImplemetedByDoubleEndedLinkedList() {
		QueueUsingDoubleEndedLinkedList<Integer> que = new QueueUsingDoubleEndedLinkedList<>();
		que.enqueue(10);
		que.enqueue(11);
		que.enqueue(12);
		que.enqueue(13);
		que.enqueue(14);
		System.out.println("Size : " + que.size());
		System.out.println("Peek : " + que.peek());
		System.out.println("Dequeue : " + que.dequeue());
		System.out.println("Peek : " + que.peek());
		System.out.println("Size : " + que.size());

	}

	private static void testSimpleQueueImplemetedByArray() {
		QueueA<Integer> que = new QueueA<>(10);
		que.enqueue(10);
		que.enqueue(11);
		que.enqueue(12);
		que.enqueue(13);

		// System.out.println(que.peek());
		// System.out.println(que.dequeue());
		// System.out.println(que.peek());

		CircularQueueA<Integer> cir = new CircularQueueA<>(5);
		cir.enqueue(10);
		cir.enqueue(11);
		cir.enqueue(12);
		cir.enqueue(13);
		cir.enqueue(14);
		System.out.println("De : " + cir.dequeue());
		System.out.println("Rear : " + cir.rear());
		System.out.println("Front : " + cir.front());
		System.out.println(cir.size());
		cir.enqueue(15);
		System.out.println("Rear : " + cir.rear());
		System.out.println("Front : " + cir.front());
		System.out.println(cir.size());
	}

}
