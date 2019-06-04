/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//Initial Template for Java
import java.util.ArrayList;
import java.util.List;
/**
 * @author ankur.mahajan
 * @written 10-May-2019
 */

public class LinkedList1 {

	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	Node head; // head of lisl
	Node lastNode;
	static PrintWriter out;
	/* Linked list Node */
	/* Utility functions */
	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			lastNode = node;
		} else {
			Node temp = head;
			lastNode.next = node;
			lastNode = node;
		}
	}
	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			out.print(temp.data + " ");
			temp = temp.next;
		}
		out.println();
	}
	/* Drier program to test above functions */
	public static void main(String args[]) throws IOException {
		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			LinkedList1 llist = new LinkedList1();
			String nums[] = br.readLine().split(" ");
			if (n > 0) {
				int a1 = Integer.parseInt(nums[0]);
				Node head = new Node(a1);
				llist.addToTheLast(head);
			}
			for (int i = 1; i < n; i++) {
				int a = Integer.parseInt(nums[i]);
				llist.addToTheLast(new Node(a));
			}
			llist.head = new LinkedList1().reverse(llist.head);

			llist.printList();

			t--;
		}
		out.close();
	}

	Node reverse(Node head) {
		List<Node> list = new ArrayList<>();
		Node current = head;
		while (null != current) {
			list.add(current);
			current = current.next;
		}
		Node newHead = list.get(list.size() - 1);
		Node curr = newHead;
		for (int i = list.size() - 2; i >= 0; i--) {
			curr.next = list.get(i);
			curr = curr.next;
		}
		curr.next = null;
		return newHead;

	}
}
