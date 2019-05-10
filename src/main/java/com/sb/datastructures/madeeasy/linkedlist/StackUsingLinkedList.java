/**
 * 
 */
package com.sb.datastructures.madeeasy.linkedlist;

/**
 * @author ankur.mahajan
 * @written 02-May-2019
 */
public class StackUsingLinkedList<T> {

	private SinglyLinkedList<T> list;

	public StackUsingLinkedList() {
		list = new SinglyLinkedList<T>();
	}

	public boolean push(T e) {
		list.addFirst(e);
		return true;
	}

	public T pop() {
		return list.removeFirst();
	}

	public T peek() {
		return list.getFirst();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackUsingLinkedList<Integer> s = new StackUsingLinkedList<Integer>();
		s.push(10);
		s.push(0);
		s.push(7);
		s.push(56);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		s.push(99);
		System.out.println(s.peek());
	}

}
