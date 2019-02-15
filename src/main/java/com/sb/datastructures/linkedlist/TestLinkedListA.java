/**
 * 
 */
package com.sb.datastructures.linkedlist;

/**
 * @author ankur.mahajan
 * @written 14-Feb-2019
 */
public class TestLinkedListA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testLinkedList();
		testDoubleEndedLinkedList();
	}

	private static void testDoubleEndedLinkedList() {
		DoubleEndedLinkedList<Integer> dd = new DoubleEndedLinkedList<>();
		dd.addFirst(1);
		dd.addFirst(2);
		dd.addFirst(3);
		dd.addLast(0);
		dd.addLast(100);
		dd.displayAll();
	}

	private static void testLinkedList() {
		LinkedListA<Integer> ll = new LinkedListA<>();
		ll.insertFirst(1);
		ll.insertFirst(2);
		ll.insertFirst(3);
		ll.insertFirst(4);
		ll.insertFirst(5);
		// System.out.println(ll.deleteFirst());
		ll.displayAll();
		System.out.println(ll.find(5));
		System.out.println(ll.find(4));
		System.out.println(ll.delete(4));
		System.out.println(ll.delete(5));
		System.out.println("deleted");
		ll.displayAll();

	}

}
