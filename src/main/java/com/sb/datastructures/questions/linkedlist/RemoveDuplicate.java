/**
 * 
 */
package com.sb.datastructures.questions.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ankur.mahajan
 * @written 15-Apr-2019
 */
public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>();
		l.addFirst("a");
		l.addFirst("b");
		l.addFirst("e");
		l.addFirst("c");
		l.addFirst("d");
		l.addFirst("a");
		l.addFirst("e");
		System.out.println(l.toString());
		LinkedList<String> list = l.removeDuplicateByHashMap();
		System.out.println(list.toString());

	}

	/**
	 * @author ankur.mahajan
	 * @written 15-Apr-2019
	 * @param <T>
	 */
	static class LinkedList<T> {

		/**
		 * @author ankur.mahajan
		 * @written 15-Apr-2019
		 * @param <T>
		 */
		static class Link<T> {
			T content;

			Link<T> next;

			public Link(T t) {
				content = t;
			}
		}

		Link<T> first;

		Link<T> last;

		int size;

		public LinkedList() {
			first = null;
			last = null;
			size = 0;
		}

		public boolean isEmpty() {
			return size == 0 ? true : false;
		}

		/**
		 * @param t
		 * @return
		 */
		public boolean addFirst(T t) {
			Link<T> l = new Link<T>(t);
			if (isEmpty())
				last = l;
			l.next = first;
			first = l;
			size++;
			return true;
		}

		/**
		 * @param t
		 * @return
		 */
		public boolean addLast(T t) {
			Link<T> l = new Link<T>(t);
			if (isEmpty())
				first = l;
			else
				last.next = l;
			last = l;
			size++;
			return true;
		}

		/**
		 * 
		 */
		public LinkedList<T> removeDuplicateByHashMap() {
			Link<T> current = first;
			LinkedList<T> uniqueList = new LinkedList<T>();
			Map<T, Boolean> map = new HashMap<>();
			while (null != current) {
				if (!map.containsKey(current.content)) {
					map.put(current.content, true);
					uniqueList.addLast(current.content);
				}
				current = current.next;
			}
			return uniqueList;
		}

		/**
		 * @toString
		 */
		public String toString() {
			StringBuilder builder = new StringBuilder();
			Link<T> current = first;
			while (null != current) {
				if (current.next != null)
					builder.append(current.content).append(" -> ");
				else
					builder.append(current.content).append(" -> null");
				current = current.next;
			}
			return builder.toString();
		}
	}

}
