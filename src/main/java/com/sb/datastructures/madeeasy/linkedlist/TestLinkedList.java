/**
 * 
 */
package com.sb.datastructures.madeeasy.linkedlist;

import com.sb.datastructures.List;

/**
 * @author ankur.mahajan
 * @written 01-May-2019
 */
public class TestLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testSinglyList();
		// testDoublyList();
		// circularLinkedListBySinglyLinkedList();
		circularLinkedList();
	}

	private static void circularLinkedList() {
		List<Integer> list = new CircularLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		System.out.println(list);
	}

	private static void circularLinkedListBySinglyLinkedList() {
		List<Integer> list = new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

	}

	private static void testDoublyList() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list.get(0));
		System.out.println(list.get(3));

		System.out.println(list.remove(5));
		// System.out.println(list.get(5));
		System.out.println(list.get(4));
		System.out.println(list.size());

	}

	private static void testSinglyList() {
		List<Integer> list = new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list.get(0));
		System.out.println(list.get(3));

		System.out.println(list.remove(5));
		System.out.println(list.get(5));
		System.out.println(list.get(4));
		System.out.println(list.size());
		// 1 -> 2 -> 3 ....->6 -> null

	}

}
