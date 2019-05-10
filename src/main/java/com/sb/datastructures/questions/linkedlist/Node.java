/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

/**
 * @author ankur.mahajan
 * @written 10-Apr-2019
 */
public class Node<T> {

	private T content;

	private Node<T> next;

	public Node(T content) {
		this.content = content;
	}
	/**
	 * @return the content
	 */
	public T getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(T content) {
		this.content = content;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
