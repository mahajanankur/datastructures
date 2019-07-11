/**
 * 
 */
package com.sb.datastructures.revision.bst;

/**
 * @author ankur.mahajan
 * @written 16-Jun-2019
 */
public class BinarySearchTree<T> {

	static class Node<T> {
		T content;

		Node<T> left;

		Node<T> right;

		public Node(T content) {
			this.content = content;
		}

		public int compareTo(Node<T> node) {
			T fst = this.content;
			T sec = node.content;
			if (sec instanceof Number) {
				return compareTwoNumbers(fst, sec);
			} else if (sec instanceof String) {
				String a = (String) fst;
				String b = (String) sec;
				return a.compareTo(b);
			}

			return 1;
		}

		private int compareTwoNumbers(T fst, T sec) {
			if (sec instanceof Byte) {
				if ((Byte) fst > (Byte) sec) {
					return 1;
				} else if ((Byte) fst == (Byte) sec) {
					return 0;
				} else {
					return -1;
				}
			} else if (sec instanceof Float) {
				if ((Float) fst > (Float) sec) {
					return 1;
				} else if ((Float) fst == (Float) sec) {
					return 0;
				} else {
					return -1;
				}
			} else if (sec instanceof Integer) {
				if ((Integer) fst > (Integer) sec) {
					return 1;
				} else if ((Integer) fst == (Integer) sec) {
					return 0;
				} else {
					return -1;
				}
			} else if (sec instanceof Long) {
				if ((Long) fst > (Long) sec) {
					return 1;
				} else if ((Long) fst == (Long) sec) {
					return 0;
				} else {
					return -1;
				}
			} else if (sec instanceof Double) {
				if ((Double) fst > (Double) sec) {
					return 1;
				} else if ((Double) fst == (Double) sec) {
					return 0;
				} else {
					return -1;
				}
			}
			// Check other
			return -2;
		}
	}

	private Node<T> root;

	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public boolean insert(T content) {
		Node<T> nodeNew = new Node<T>(content);
		if (null == root) {
			root = nodeNew;
		} else {
			Node<T> current = root;
			while (true) {
				Node<T> parent = current;
				// If new node is smaller then current than it should be left
				// child of current.
				if (current.compareTo(nodeNew) <= 0) {
					current = current.right;
					if (null == current) {
						parent.right = nodeNew;
						break;
					}
				} else {
					current = current.left;
					if (null == current) {
						parent.left = nodeNew;
						break;
					}
				}

			}

		}

		size++;
		return true;
	}

}
