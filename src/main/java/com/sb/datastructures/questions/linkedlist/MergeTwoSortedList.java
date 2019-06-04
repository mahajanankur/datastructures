/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

import java.util.Scanner;

/**
 * @author ankur.mahajan
 * @written 29-May-2019
 */

class MergeTwoSortedList {

	Node1 head;
	public void addToTheLast(Node1 node) {
		if (head == null) {
			head = node;
		} else {
			Node1 temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}
	/* Function to print linked list */
	void printList() {
		Node1 temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			MergeTwoSortedList llist1 = new MergeTwoSortedList();
			MergeTwoSortedList llist2 = new MergeTwoSortedList();

			int a1 = sc.nextInt();
			Node1 head1 = new Node1(a1);
			llist1.addToTheLast(head1);
			if (sc.hasNextInt())
				for (int i = 1; i < n1; i++) {
					// int a;

					int a = sc.nextInt();
					llist1.addToTheLast(new Node1(a));
				}

			int b1 = sc.nextInt();
			Node1 head2 = new Node1(b1);
			llist2.addToTheLast(head2);
			if (sc.hasNextInt())
				for (int i = 1; i < n2; i++) {
					// int b;

					int b = sc.nextInt();
					llist2.addToTheLast(new Node1(b));
				}
			llist1.head = new LinkedList().sortedMerge(llist1.head, llist2.head);
			llist1.printList();

			t--;

		}
	}
}

class Node1 {
	int data;
	Node1 next;
	Node1(int d) {
		data = d;
		next = null;
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Merge two linked lists head pointer input could be NULL as well for empty
 * list Node is defined as class Node { int data; Node next; Node(int d) {data =
 * d; next = null; } }
 */
class LinkedList {
	Node1 sortedMerge1(Node1 headA, Node1 headB) {
		Node1 first = null;
		Node1 current = null;
		Node1 merged = null;
		while (null != headA && null != headB) {
			if (headA.data > headB.data) {
				if (first == null) {
					first = headB;
					current = headB;
					merged = headB;
				} else {
					merged.next = headB;
					// current.next = headB;
					current = headB;
				}

				headB = headB.next;

			} else {
				if (first == null) {
					first = headA;
					current = headA;
					merged = headA;
				} else {
					merged.next = headA;
					current = headA;
					// current.next = headA;
				}
				headA = headA.next;
			}
			merged = merged.next;
			current = current.next;
		}

		// List 1 is not empty
		while (null != headA) {
			if (first == null) {
				first = headA;
			}
			current = headA;
			headA = headA.next;
			current = current.next;
		}

		// List 2 is not empty
		while (null != headB) {
			if (first == null) {
				first = headB;
			}
			current = headB;
			headB = headB.next;
			current = current.next;
		}

		return first;
		// This is a "method-only" submission.
		// You only need to complete this method
	}

	Node1 sortedMerge(Node1 headA, Node1 headB) {
		Node1 current = null;
		Node1 merged = null;
		while (null != headA && null != headB) {
			if (headA.data > headB.data) {
				if (merged == null) {
					merged = headB;
				} else {
					current.next = headB;
				}
				current = headB;
				headB = headB.next;

			} else {
				if (merged == null) {
					merged = headA;
				} else {
					current.next = headA;

				}
				current = headA;
				headA = headA.next;
			}

		}

		// List 1 is not empty
		while (null != headA) {
			current.next = headA;
			current = headA;
			headA = headA.next;
		}

		// List 2 is not empty
		while (null != headB) {
			current.next = headB;
			current = headB;
			headB = headB.next;
		}

		return merged;
	}
}
