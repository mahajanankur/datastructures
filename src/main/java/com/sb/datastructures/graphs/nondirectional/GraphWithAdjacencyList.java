/**
 * 
 */
package com.sb.datastructures.graphs.nondirectional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ankur
 * @crated 21-Sep-2021
 */
public class GraphWithAdjacencyList {

	private Map<Integer, List<Integer>> adj;

	public GraphWithAdjacencyList() {
		adj = new HashMap<>();
	}

	public void addNode(int val) {
		// Check if node already exist.
		adj.put(val, new ArrayList<Integer>());
	}

	public void addEdge(int src, int dest, boolean biDirect) {
		// check if source not exist.
		if (null == adj.get(src)) {
			addNode(src);
		}
		// check if destination not exist.
		if (null == adj.get(dest)) {
			addNode(dest);
		}
		adj.get(src).add(dest);
		// Add dest to src link if the graph is bi-directional.
		if (biDirect) {
			adj.get(dest).add(src);
		}
	}

	@Override
	public String toString() {
		adj.forEach((key, value) -> {
			System.out.println(key + " - " + value);
		});
		return null;
	}

	public static void main(String[] args) {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
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

		graph.toString();
	}

}
