/**
 * 
 */
package com.sb.datastructures.trees.bst;

/**
 * @author ankur.mahajan
 * @written 01-Mar-2019
 */
public class TestBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {

		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		// for (int i = 0; i < 100; i++) {
		// tree.insert((int) (Math.random() * 101));
		// }
		tree.insert(35);
		tree.insert(25);
		tree.insert(45);
		tree.insert(15);
		tree.insert(30);
		tree.insert(40);
		tree.insert(60);
		tree.insert(10);
		tree.insert(20);
		tree.insert(37);
		tree.insert(65);
		// down left successor
		tree.insert(55);
		tree.insert(50);
		tree.insert(57);
		tree.insert(52);

		// System.out.println(tree.find(99));
		// System.out.println(tree.findMaximum());
		// System.out.println(tree.findMinimum());
		System.out.println(tree.delete(45));
		System.out.println("\n PREORDER");
		tree.traverse(1);
		System.out.println("\n INORDER");
		tree.traverse(2);
		System.out.println("\n POSTORDER");
		tree.traverse(3);
	}

}
