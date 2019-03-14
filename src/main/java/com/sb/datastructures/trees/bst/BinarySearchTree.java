/**
 * 
 */
package com.sb.datastructures.trees.bst;

/**
 * @author ankur.mahajan
 * @written 01-Mar-2019
 * 
 *          Currently for {@link Integer} only.
 */
public class BinarySearchTree<T extends Number> {

	class Node {

		T key;

		Node leftChild;

		Node rightChild;

		public Node(T key) {
			this.key = key;
		}
	}

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(T key) {
		Node newNode = new Node(key);
		if (null == root) {
			root = newNode;
		}
		else {
			Node current = root;
			while (true) {
				Node parent = current;
				// newNode key is less than root's key then it should be it's
				// left child.
				if ((Integer) current.key > (Integer) newNode.key) {
					current = current.leftChild;
					if (null == current) {
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					current = current.rightChild;
					if (null == current) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public T find(T key) {
		Node current = root;
		while (current.key != key) {
			if ((Integer) current.key < (Integer) key) {
				current = current.rightChild;
			}
			else {
				current = current.leftChild;
			}

			if (null == current) {
				return null;
			}
		}
		return current.key;
	}

	public T findMaximum() {
		Node current = root;
		Node last = null;
		while (null != current) {
			last = current;
			current = current.rightChild;

		}
		return last.key;
	}

	public T findMinimum() {
		Node current = root;
		Node last = null;

		while (null != current) {
			last = current;
			current = current.leftChild;
		}
		return last.key;
	}

	public void traverse(int order) {
		switch (order) {
		case 1:
			preOrder(root);
			break;
		case 2:
			inOrder(root);
			break;

		default:
			postOrder(root);
			break;
		}
	}

	private void postOrder(BinarySearchTree<T>.Node node) {
		if (null != node) {
			inOrder(node.leftChild);
			inOrder(node.rightChild);
			System.out.print(node.key + " -> ");
		}
	}

	private void inOrder(BinarySearchTree<T>.Node node) {
		if (null != node) {
			inOrder(node.leftChild);
			System.out.print(node.key + " -> ");
			inOrder(node.rightChild);
		}
	}

	private void preOrder(BinarySearchTree<T>.Node node) {
		if (null != node) {
			System.out.print(node.key + " -> ");
			inOrder(node.leftChild);
			inOrder(node.rightChild);
		}
	}

	public T delete(T key) {
		Node current = root;
		Node parent = root;
		boolean isleftNode = false;
		while (current.key != key) {
			parent = current;
			if ((Integer) current.key > (Integer) key) {
				isleftNode = true;
				current = current.leftChild;
			}
			else {
				isleftNode = false;
				current = current.rightChild;
			}

			// Break if current is null it solve the null pointer.
			if (null == current) {
				return null;
			}
		}
		// Current is the node we want to delete.
		// Check if It's a leaf node.
		if (null == current.leftChild && null == current.rightChild) {
			// Check if user wants to delete root node.
			if (current == root) {
				root = null;
				return current.key;
			}
			if (isleftNode) {
				parent.leftChild = null;
			}
			else {
				parent.rightChild = null;
			}
		}
		// Check if only right child exist.
		else if (null == current.leftChild) {
			// Check if user wants to delete root node.
			if (current == root) {
				root = current.rightChild;
			}
			if (isleftNode) {
				parent.leftChild = current.rightChild;
			}
			else {
				parent.rightChild = current.rightChild;
			}
		}
		// Check if only left child exist.
		else if (null == current.rightChild) {
			// Check if user wants to delete root node.
			if (current == root) {
				root = current.leftChild;
			}
			if (isleftNode) {
				parent.leftChild = current.leftChild;
			}
			else {
				parent.rightChild = current.leftChild;
			}
		}
		// Check if two child's exist.
		else {
			Node successor = getSuccessor(current);
			if (isleftNode) {
				parent.leftChild = successor;
			}
			else {
				parent.rightChild = successor;
			}
			// Attach left node of deleted with selector
			successor.leftChild = current.leftChild;
		}

		return current.key;

	}

	private BinarySearchTree<T>.Node getSuccessor(Node deletedNode) {
		// First right node of the deleted node.
		Node firstRight = deletedNode.rightChild;
		Node successor = firstRight;
		Node successorParent = firstRight;
		while (null != firstRight) {
			successorParent = successor;
			successor = firstRight;
			firstRight = firstRight.leftChild;
		}

		// Extra logic if successor node is left child of deleted node's right
		// child.
		if (deletedNode.rightChild != successor) {
			// successor's right child always be less than successor's parent so
			// it will a successor parent's left child.
			successorParent.leftChild = successor.rightChild;
			// deleted node right child now become right child of successor
			// node.
			successor.rightChild = deletedNode.rightChild;
		}
		successorParent.leftChild = null;
		return successor;
	}

}
