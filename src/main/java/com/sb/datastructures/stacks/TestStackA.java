/**
 * 
 */
package com.sb.datastructures.stacks;

/**
 * @author ankur.mahajan
 * @written 11-Feb-2019
 */
public class TestStackA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testStackImplementedByArrays();
		testStackImplementedByLinkedList();
	}

	private static void testStackImplementedByLinkedList() {
		StackByLinkedList<Integer> stackA = new StackByLinkedList<>();
		stackA.push(1);
		stackA.push(2);
		stackA.push(3);
		stackA.push(4);
		stackA.push(6);
		stackA.push(7);
		stackA.push(8);
		stackA.push(9);
		stackA.push(10);
		stackA.push(11);
		// stackA.push(12);
		// stackA.push(13);
		System.out.println("Size : " + stackA.size());
		System.out.println("Peek : " + stackA.peek());
		System.out.println("Pop : " + stackA.pop());
		System.out.println("Peek : " + stackA.peek());
		System.out.println("Pop : " + stackA.pop());
		System.out.println("Pop : " + stackA.pop());
		System.out.println("Peek : " + stackA.peek());
		System.out.println("Size : " + stackA.size());

	}

	private static void testStackImplementedByArrays() {
		StackA<Integer> stackA = new StackA<>(10);
		stackA.push(1);
		stackA.push(2);
		stackA.push(3);
		stackA.push(4);
		stackA.push(6);
		stackA.push(7);
		stackA.push(8);
		stackA.push(9);
		stackA.push(10);
		stackA.push(11);
		// stackA.push(12);
		// stackA.push(13);

		System.out.println(stackA.peek());
		System.out.println(stackA.pop());
		System.out.println(stackA.peek());
		System.out.println(stackA.pop());
		System.out.println(stackA.pop());
		System.out.println(stackA.peek());

	}

}
