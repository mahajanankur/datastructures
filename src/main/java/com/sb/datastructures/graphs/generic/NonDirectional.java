/**
 * 
 */
package com.sb.datastructures.graphs.generic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ankur
 * @crated 21-Sep-2021
 */
public class NonDirectional<T> implements Graph<T> {
	// Adjacency list based approach.
	private Map<T, List<T>> adjMap;

	public NonDirectional() {
		adjMap = new LinkedHashMap<>();
	}

	@Override
	public void addNode(T node) {
		adjMap.put(node, new ArrayList<T>());
	}

	@Override
	public void addEdge(T source, T dest, boolean biDirect) {
		if (null == adjMap.get(source)) {
			addNode(source);
		}
		if (null == adjMap.get(dest)) {
			addNode(dest);
		}
		// create edge link
		adjMap.get(source).add(dest);
		if (biDirect) {
			adjMap.get(dest).add(source);
		}
	}

	@Override
	public String dfs() {
		return null;
	}

	@Override
	public String bfs() {
		int index = 0;
		List<T> nodes = new ArrayList<>(adjMap.keySet());
		// Create a visited arrays same as the nodes size.
		boolean[] visited = new boolean[adjMap.size()];
		Queue<T> queue = new Queue<>();
		// Mark the initial node visited.
		visited[index] = true;
		// Add this in the queue.
		queue.push(nodes.get(index));
		while (queue.size() != 0) {
			// Pop the element from queue.
			T pop = queue.pop();
			System.out.println(pop + ", ");
			// Get all adjacent nodes and mark them visited and push to the queue.
			List<T> adjNodes = adjMap.get(pop);
			for (T node : adjNodes) {

			}

		}
		return null;
	}

	@Override
	public int countNodes() {
		return adjMap.size();
	}

	@Override
	public int countEdges() {
		int count = 0;
		for (Map.Entry<T, List<T>> entry : adjMap.entrySet()) {
			count += entry.getValue().size();
		}
		return count;
	}

	@Override
	public String toString() {
		String res = "";
		Set<T> keySet = adjMap.keySet();
		for (T key : keySet) {
			res = res + key + " - " + adjMap.get(key) + '\n';
		}
		return res;
	}

	public static void main(String[] args) {
		Graph<Integer> graph = new NonDirectional<>();
		graph.addNode(5);
		graph.addEdge(5, 1, true);
		graph.addNode(2);
		graph.addNode(6);
		graph.addEdge(2, 6, true);
		graph.addNode(0);
		graph.addEdge(4, 0, true);
		graph.addEdge(2, 1, true);
		graph.addNode(10);
		graph.addEdge(10, 4, false);

		System.out.println(graph);

		Queue<Integer> queue = new Queue<>();
		queue.push(10);
		queue.push(11);
		queue.push(12);
		queue.push(13);
		System.out.println(queue.peek());
		queue.push(14);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.peek());
		System.out.println(queue);
	}

	/**
	 * The queue can be implemented by array list and linked list but linked list
	 * will be the optimized approach as only two references needs to be changes
	 * while popping any element.
	 * 
	 * @author ankur
	 * @crated 22-Sep-2021
	 * @param <T>
	 */
	static class Queue<T> {

		private List<T> list;

		public Queue() {
			// list = new ArrayList<>();
			list = new LinkedList<>();
		}

		public void push(T element) {
			list.add(element);
		}

		public T peek() {
			return list.get(0);
		}

		public T pop() {
			return list.remove(0);
		}

		public int size() {
			return list.size();
		}

		@Override
		public String toString() {
			return list.toString();
		}

	}

	/**
	 * @author ankur
	 * @crated 23-Sep-2021
	 * @param <T>
	 */
	static class Node<T> {

		private T value;

		private boolean visited;

		/**
		 * @return the value
		 */
		public T getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(T value) {
			this.value = value;
		}

		/**
		 * @return the visited
		 */
		public boolean isVisited() {
			return visited;
		}

		/**
		 * @param visited the visited to set
		 */
		public void setVisited(boolean visited) {
			this.visited = visited;
		}

	}

}
