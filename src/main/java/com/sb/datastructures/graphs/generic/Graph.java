/**
 * 
 */
package com.sb.datastructures.graphs.generic;

/**
 * @author ankur
 * @crated 21-Sep-2021
 */
public interface Graph<T> {
	void addNode(T node);

	void addEdge(T source, T dest, boolean biDirect);

	String dfs();

	String bfs();

	int countNodes();

	int countEdges();
	
}
