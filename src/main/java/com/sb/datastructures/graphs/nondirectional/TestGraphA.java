/**
 * 
 */
package com.sb.datastructures.graphs.nondirectional;

/**
 * @author ankur.mahajan
 * @written 26-Mar-2019
 */
public class TestGraphA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testNonDirectedGraphA();

	}

	private static void testNonDirectedGraphA() {
		GraphA<Character> graphA = new GraphA<>();
		// Add vertices.
		graphA.addVertex('A');// 0
		graphA.addVertex('B');// 1
		graphA.addVertex('C');// 2
		graphA.addVertex('D');// 3
		graphA.addVertex('E');// 4
		graphA.addVertex('F');// 5
		graphA.addVertex('G');// 6
		graphA.addVertex('H');// 7
		graphA.addVertex('I');// 8
		graphA.addVertex('J');// 9
		// Add edges
		graphA.addEdge(0, 1);
		graphA.addEdge(1, 2);
		graphA.addEdge(1, 3);
		graphA.addEdge(3, 4);
		graphA.addEdge(0, 5);
		graphA.addEdge(5, 6);
		graphA.addEdge(6, 7);
		graphA.addEdge(6, 8);
		graphA.addEdge(8, 9);

		// Depth First Search
		System.out.println("Depth First Search");
		graphA.depthFirstSearch();
		System.out.println("Breadth First Search");
		graphA.breadthFirstSearch();
	}

}
