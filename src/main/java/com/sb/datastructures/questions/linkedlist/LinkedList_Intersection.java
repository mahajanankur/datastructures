/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ankur.mahajan
 * @written 30-May-2019
 */

class Node2 {
	int data;
	Node2 next;
	Node2(int d) {
		data = d;
		next = null;
	}
}

public class LinkedList_Intersection {

	Node2 head = null;
	Node2 tail = null;
	public void addToTheLast(Node2 node) {
		if (head == null) {
			head = node;
			tail = head;
		} else {
			// Node temp = head;
			// while (temp.next != null)
			// temp = temp.next;
			// temp.next = node;
			tail.next = node;
			tail = node;
		}
	}
	/* Function to print linked list */
	void printList() {
		Node2 temp = head;
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
			int n3 = sc.nextInt();
			LinkedList_Intersection llist1 = new LinkedList_Intersection();
			LinkedList_Intersection llist2 = new LinkedList_Intersection();
			LinkedList_Intersection llist3 = new LinkedList_Intersection();

			int a1 = sc.nextInt();
			Node2 head1 = new Node2(a1);
			Node2 tail1 = head1;
			llist1.addToTheLast(head1);
			for (int i = 1; i < n1; i++) {
				int a = sc.nextInt();
				llist1.addToTheLast(new Node2(a));
			}

			int b1 = sc.nextInt();
			Node2 head2 = new Node2(b1);
			Node2 tail2 = head2;
			llist2.addToTheLast(head2);
			for (int i = 1; i < n2; i++) {
				int b = sc.nextInt();
				llist2.addToTheLast(new Node2(b));
			}

			int c1 = sc.nextInt();
			Node2 head3 = new Node2(c1);
			Node2 tail3 = head3;
			llist3.addToTheLast(head3);
			for (int i = 1; i < n3; i++) {
				int c = sc.nextInt();
				llist3.addToTheLast(new Node2(c));
			}

			if (tail1 != null)
				tail1.next = head3;
			if (tail2 != null)
				tail2.next = head3;

			Intersect obj = new Intersect();
			System.out.println(obj.intersectPoint(llist1.head, llist2.head));
			t--;
		}
	}

}
class Intersect {

	int intersectPoint(Node2 headA, Node2 headB) {
		Node2 curA = headA;
		Node2 curB = headB;
		int one = 0;
		int two = 0;
		while (null != curA && null != curB) {
			one++;
			two++;
			curA = curA.next;
			curB = curB.next;
		}

		while (null != curA) {
			one++;
			curA = curA.next;
		}

		while (null != curB) {
			two++;
			curB = curB.next;
		}

		int delta = Math.abs(one - two);
		boolean oneBigger = one - two >= 0 ? true : false;
		int loop = 0;
		while (loop++ < delta) {
			if (oneBigger) {
				headA = headA.next;
			} else {
				headB = headB.next;
			}
		}

		while (null != headA && null != headB) {
			if (headA.equals(headB)) {
				return headA.data;
			}
			headA = headA.next;
			headB = headB.next;

		}
		return -1;
	}

	int intersectPoint1(Node2 headA, Node2 headB) {
		List<Integer> one = new ArrayList<>();
		List<Integer> two = new ArrayList<>();
		while (null != headA && null != headB) {
			one.add(headA.data);
			two.add(headB.data);
			headA = headA.next;
			headB = headB.next;
		}

		while (null != headA) {
			one.add(headA.data);
			headA = headA.next;
		}

		while (null != headB) {
			two.add(headB.data);
			headB = headB.next;
		}
		int prev = 0;
		boolean intersecting = false;
		for (int i = 0; i < one.size(); i++) {
			if (one.get(one.size() - 1 - i) == two.get(two.size() - 1 - i)) {
				intersecting = true;
				prev = one.get(one.size() - 1 - i);
			} else {
				if (!intersecting) {
					return -1;
				}
				break;
			}
		}
		return prev;
	}
}
