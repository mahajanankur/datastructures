/**
 * 
 */
package com.sb.datastructures.graphs.weighted;

/**
 * @author ankur.mahajan
 * @written 01-Apr-2019
 */
public class TestNonDirectedGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstTest();

	}

	private static void firstTest() {
		// Heap heap = new Heap(10);
		// heap.insert(82);
		// heap.insert(70);
		// heap.insert(51);
		// heap.insert(63);
		// heap.insert(55);
		// heap.insert(37);
		// heap.insert(10);
		// heap.insert(97);
		// heap.insert(197);
		// heap.insert(907);
		// System.out.println(heap.remove());
		// System.out.println(heap.remove());
		// System.out.println(heap.remove());
		// PriorityQueue queue = new PriorityQueue(10);
		// queue.enqueue(82);
		// queue.enqueue(70);
		// queue.enqueue(51);
		// queue.enqueue(63);
		// queue.enqueue(55);
		// queue.enqueue(37);
		// queue.enqueue(10);
		// queue.enqueue(97);
		// queue.enqueue(197);
		// queue.enqueue(907);
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());
		// System.out.println(queue.dequeue());

		NonDirectionalGraph<Character> graph = new NonDirectionalGraph<>();
		graph.insertVertex('A');
		graph.insertVertex('B');
		graph.insertVertex('C');
		graph.insertVertex('D');
		graph.insertVertex('E');
		graph.insertVertex('F');

		graph.addEdge(0, 1, 6);
		graph.addEdge(0, 3, 4);
		graph.addEdge(1, 2, 10);
		graph.addEdge(1, 3, 7);
		graph.addEdge(1, 4, 7);
		graph.addEdge(3, 2, 8);
		graph.addEdge(3, 4, 12);
		graph.addEdge(2, 4, 5);
		graph.addEdge(2, 5, 6);
		graph.addEdge(4, 5, 7);

		graph.minimumSpanningTree();
	}

}
