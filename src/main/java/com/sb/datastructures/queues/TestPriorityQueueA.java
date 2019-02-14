/**
 * 
 */
package com.sb.datastructures.queues;

/**
 * @author ankur.mahajan
 * @written 12-Feb-2019
 */
public class TestPriorityQueueA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstTest();

	}

	private static void firstTest() {
		PriorityQueueA<String> cir = new PriorityQueueA<>(10);
		cir.enqueue("sec", 10);
		cir.enqueue("last", 0);
		cir.enqueue("mid", 6);
		cir.enqueue("first", 18);
		cir.enqueue("seclast", 2);
		System.out.println("De : " + cir.dequeue());
		// System.out.println("Rear : " + cir.rear());
		// System.out.println("Front : " + cir.front());
		System.out.println(cir.size());
		cir.enqueue("deqFirs", 11);
		System.out.println(cir.size());
		System.out.println("De : " + cir.dequeue());
		// System.out.println("Rear : " + cir.rear());
		// System.out.println("Front : " + cir.front());
		System.out.println(cir.size());
		System.out.println("De : " + cir.dequeue());
	}

}
