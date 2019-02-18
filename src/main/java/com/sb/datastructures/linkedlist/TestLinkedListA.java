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
		// testDoubleEndedLinkedList();
		// testSortedLinkedList();
		testDoublyLinkedList();
	}

	private static void testDoublyLinkedList() {
		DoublyLinkedList<Integer> dd = new DoublyLinkedList<>();
		System.out.println("First to last : " + dd.toStringFromFirst());
		// dd.deleteFirst();
		System.out.println("Last to first : " + dd.toStringFromLast());
		dd.addFirst(1);
		System.out.println("First to last : " + dd.toStringFromFirst());
		// dd.deleteFirst();
		System.out.println("Last to first : " + dd.toStringFromLast());
		dd.addFirst(2);
		dd.addFirst(3);
		dd.addLast(0);
		dd.addLast(100);
		System.out.println("First to last : " + dd.toStringFromFirst());
		// dd.deleteFirst();
		System.out.println("Last to first : " + dd.toStringFromLast());
		// System.out.println("FIND : " + dd.find(13));
		dd.addAfter(0, 99);
		System.out.println("First to last : " + dd.toStringFromFirst());
		dd.addAfter(100, 43);
		System.out.println("First to last : " + dd.toStringFromFirst());
		System.out.println("Last to first : " + dd.toStringFromLast());
		dd.deleteFirst();
		System.out.println("Delete First, F2L : " + dd.toStringFromFirst());
		System.out.println("Delete First, L2F : " + dd.toStringFromLast());
		dd.deleteLast();
		System.out.println("Delete Last, F2L : " + dd.toStringFromFirst());
		System.out.println("Delete Last, L2F : " + dd.toStringFromLast());

		dd.deleteAfter(0);
		System.out.println("Delete After, F2L : " + dd.toStringFromFirst());
		System.out.println("Delete After, L2F : " + dd.toStringFromLast());

		ListIterator<Integer> listIterator = dd.getListIterator();

		int loop = 0;
		while (listIterator.hasNext()) {
			if (loop++ == 1)
				listIterator.addAfter(700);
			System.out.print(listIterator.next() + " -> ");
		}
		System.out.println("\nAfter Insert, F2L : " + dd.toStringFromFirst());
	}

	private static void testSortedLinkedList() {
		SortedLinkedList<Integer> dd = new SortedLinkedList<>();
		dd.add(10);
		dd.add(2);
		dd.add(13);
		dd.add(0);
		dd.add(100);
		System.out.println(dd.toString());
		dd.deleteFirst();
		System.out.println(dd.toString());
		System.out.println("FIND : " + dd.find(13));

	}

	private static void testDoubleEndedLinkedList() {
		DoubleEndedLinkedList<Integer> dd = new DoubleEndedLinkedList<>();
		dd.addFirst(1);
		dd.addFirst(2);
		dd.addFirst(3);
		dd.addLast(0);
		dd.addLast(100);
		dd.displayAll();
		System.out.println(dd.toString());
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
