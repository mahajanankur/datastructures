/**
 * 
 */
package com.sb.datastructures.graphs.directional;

/**
 * @author ankur.mahajan
 * @written 27-Mar-2019
 * 
 *          Directed Graphs are whose edges have direction and traversal can
 *          happen in one direction only.
 */
public class DirectionalGraph<T> {

	private int MAX_GRAPH_SIZE = 20;

	private Vertex<?>[] vertexArray;

	private boolean[][] adjancencyMatrix;

	private int nVertices;

	public DirectionalGraph() {
		nVertices = 0;
		vertexArray = new Vertex<?>[MAX_GRAPH_SIZE];
		adjancencyMatrix = new boolean[MAX_GRAPH_SIZE][MAX_GRAPH_SIZE];
	}

	/**
	 * @param element
	 * @return
	 */
	public boolean addVertex(T element) {
		if (isFull())
			return false;
		Vertex<T> newVertex = new Vertex<T>(element);
		vertexArray[nVertices++] = newVertex;
		return true;
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean addEdge(int start, int end) {
		// Mark only one (actual) pattern true for directional graph.
		adjancencyMatrix[start][end] = true;
		return true;
	}

	/**
	 * For a directed acyclic graph DAG, Topological sorting is a linear
	 * ordering of the vertices such that for every directed edge e between
	 * vertices a, b, vertex a comes before b in ordering.
	 */
	public void topologicalSorting() {
		int arrayLength = nVertices;
		Vertex<?>[] successorArray = new Vertex<?>[arrayLength];
		while (arrayLength > 0) {
			int vertexWithoutNeighbor = getVertexWithoutAnyNeighbor();
			if (vertexWithoutNeighbor == -1) {
				System.out.println("ERROR : Graph is cyclic.");
				return;
			} else {
				successorArray[--arrayLength] = vertexArray[vertexWithoutNeighbor];
				// Make this vertex visited as this should not be considered as
				// successor again.
				vertexArray[vertexWithoutNeighbor].setVisited(true);
				// Delete all the edges linked to the above by changing the
				// adjancency matrix.
				deleteEdgeLinkedToVertex(vertexWithoutNeighbor);
			}
		}
		// Remember to set the visited flag to default after operation.
		for (int i = 0; i < nVertices; i++) {
			vertexArray[i].setVisited(false);
		}

		// Print the successor array.
		for (int i = 0; i < successorArray.length; i++) {
			System.out.print(successorArray[i].getContent().toString());
		}
	}

	/**
	 * @param index
	 */
	private void deleteEdgeLinkedToVertex(int index) {
		for (int i = 0; i < nVertices; i++) {
			boolean present = adjancencyMatrix[i][index];
			if (present) {
				adjancencyMatrix[i][index] = false;
			}
		}

	}

	/**
	 * @return
	 */
	private int getVertexWithoutAnyNeighbor() {
		for (int row = 0; row < nVertices; row++) {
			boolean isVertexWithNeighbor = false;
			// Check whole row if any edge found break the sequence and this
			// means the vertex has neighbor.
			// Also make sure that this vertex should not visited before. In
			// book there this successor should be deleted after use.
			for (int col = 0; col < nVertices; col++) {
				if (adjancencyMatrix[row][col] || vertexArray[row].isVisited()) {
					isVertexWithNeighbor = true;
					break;
				}
			}
			if (!isVertexWithNeighbor) {
				return row;
			}
		}
		return -1;
	}

	/**
	 * @param index
	 */
	private void displayVertex(int index) {
		System.out.print(vertexArray[index].getContent().toString());
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		return nVertices >= vertexArray.length ? true : false;
	}

	// Utility Classes
	static class Vertex<T> {
		T content;

		boolean visited;

		public Vertex(T content) {
			this.content = content;
		}

		public T getContent() {
			return content;
		}

		public void setContent(T content) {
			this.content = content;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

	}
}
