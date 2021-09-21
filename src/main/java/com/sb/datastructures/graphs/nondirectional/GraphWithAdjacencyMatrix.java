/**
 * 
 */
package com.sb.datastructures.graphs.nondirectional;

/**
 * @author ankur.mahajan
 * @written 25-Mar-2019
 */
public class GraphWithAdjacencyMatrix<T> {

	private int MAX_GRAPH_SIZE = 20;

	private Vertex<?>[] verticesArray;

	private boolean[][] adjacencyMatrix;

	private Stack<Integer> stack;

	private Queue<Integer> queue;

	private int nVertices;

	public GraphWithAdjacencyMatrix() {
		nVertices = 0;
		verticesArray = new Vertex<?>[MAX_GRAPH_SIZE];
		adjacencyMatrix = new boolean[MAX_GRAPH_SIZE][MAX_GRAPH_SIZE];
		stack = new Stack<>(MAX_GRAPH_SIZE);
		queue = new Queue<>(MAX_GRAPH_SIZE);

	}

	/**
	 * @param content
	 * @return
	 */
	public boolean addVertex(T content) {
		if (isFull())
			return false;
		Vertex<T> newVertex = new Vertex<T>(content);
		verticesArray[nVertices++] = newVertex;
		return true;
	}

	/**
	 * @param from
	 * @param to
	 * @return boolean
	 */
	public boolean addEdge(int from, int to) {
		// TODO - VALIDATION? from and to should be less than MAX_GRAPH_SIZE
		adjacencyMatrix[from][to] = true;
		adjacencyMatrix[to][from] = true;
		return true;
	}

	/**
	 * The depth-first search uses a stack to remember where it should go when it
	 * reaches a dead end. This algorithm acts as though it wants to get as far away
	 * from the starting point as quickly as possible.
	 */
	public void depthFirstSearch() {
		Vertex<?> firstVertex = verticesArray[0];
		// Mark the visited flag true.
		firstVertex.setVisited(true);
		// Push this to stack
		stack.push(0);
		displayVertex(0);
		// Traverse until the stack has elements. Implementation of Rule 3.
		while (!stack.isEmpty()) {
			// Rule 1 - Visit the adjacent unvisited vertex, if found push it to
			// stack.
			// Rule 2 - If adjacent unvisited vertex is not found pop the
			// element from stack.
			// Rule 3 - If we can't follow rule 1 and 2 then we are done.
			int adjVertexIndex = findAdjacentUnvisitedVertex(stack.peek());
			if (adjVertexIndex == -1) {
				stack.pop();
			} else {
				// Mark the vertex as visited.
				verticesArray[adjVertexIndex].setVisited(true);
				displayVertex(adjVertexIndex);
				stack.push(adjVertexIndex);

			}
		}

		// Mark the vertices visited flag to false again.
		for (int i = 0; i < verticesArray.length; i++) {
			if (null != verticesArray[i]) {
				verticesArray[i].setVisited(false);
			}
		}

	}

	/**
	 * The breadth-first search has an interesting property: It first finds all the
	 * vertices that are one edge away from the starting point, then all the
	 * vertices that are two edges away, and so on. This is useful if you’re trying
	 * to find the shortest path from the starting vertex to a given vertex.
	 */
	public void breadthFirstSearch() {
		Vertex<?> firstVertex = verticesArray[0];
		// Mark the visited flag
		firstVertex.setVisited(true);
		// Add this to queue.
		queue.add(0);
		displayVertex(0);
		// Traverse until the queue has elements. Rule 3.
		while (!queue.isEmpty()) {
			// Rule 1 - Visit the adjacent unvisited vertex, if found add it to
			// queue.
			// Rule 2 - If adjacent unvisited vertex is not found remove the
			// element from queue.
			// Rule 3 - If we can't follow rule 1 and 2 then we are done.
			int adjacentUnvisitedVertex = findAdjacentUnvisitedVertex(queue.peek());

			if (adjacentUnvisitedVertex == -1) {
				queue.remove();
			} else {
				// Mark it visited
				verticesArray[adjacentUnvisitedVertex].setVisited(true);
				displayVertex(adjacentUnvisitedVertex);
				queue.add(adjacentUnvisitedVertex);
			}
		}
		// Mark the vertices visited flag to false again.
		for (int i = 0; i < verticesArray.length; i++) {
			if (null != verticesArray[i]) {
				verticesArray[i].setVisited(false);
			}
		}
	}

	/**
	 * 
	 */
	public void minimalSpanningTree() {
		// Start from the first vertex and mark it visited
		verticesArray[0].setVisited(true);
		stack.push(0);

		while (!stack.isEmpty()) {
			int current = stack.peek();
			int adjacentUnvisitedVertex = findAdjacentUnvisitedVertex(current);
			// If not unvisited adjacent element found pop from stack. Else push.
			if (adjacentUnvisitedVertex == -1) {
				stack.pop();
			} else {
				verticesArray[adjacentUnvisitedVertex].setVisited(true);
				stack.push(adjacentUnvisitedVertex);
				displayVertex(current);
				displayVertex(adjacentUnvisitedVertex);
				System.out.print(" ");
			}
		}
		// Mark the vertices visited flag to false again after use.
		for (int i = 0; i < verticesArray.length; i++) {
			if (null != verticesArray[i]) {
				verticesArray[i].setVisited(false);
			}
		}

	}

	/**
	 * @param index
	 * @return
	 */
	private int findAdjacentUnvisitedVertex(int index) {
		for (int j = 0; j < nVertices; j++) {
			// Check for the adjacent vertex and it should be not visited in
			// past.
			if (adjacencyMatrix[index][j] && !verticesArray[j].isVisited()) {
				return j;
			}
		}
		return -1;

	}

	/**
	 * @param index
	 */
	private void displayVertex(int index) {
		System.out.print(verticesArray[index].content.toString());
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		return nVertices >= MAX_GRAPH_SIZE ? true : false;
	}

	// OTHER UTILITY CLASSES. STACK AND VERTEX.

	/**
	 * @author ankur.mahajan
	 * @written 25-Mar-2019
	 * @param <T>
	 */
	static class Vertex<T> {
		private T content;

		private boolean visited;

		public Vertex(T content) {
			this.content = content;
		}

		/**
		 * @return the content
		 */
		public T getContent() {
			return content;
		}

		/**
		 * @param content the content to set
		 */
		public void setContent(T content) {
			this.content = content;
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

	/**
	 * @author ankur.mahajan
	 * @written 25-Mar-2019
	 * @param <T>
	 */
	static class Stack<T> {

		private T[] array;

		private int nElements;

		private int top;

		@SuppressWarnings("unchecked")
		public Stack(int size) {
			nElements = 0;
			top = -1;
			array = (T[]) new Object[size];

		}

		/**
		 * @param element
		 * @return boolean
		 */
		public boolean push(T element) {
			if (isFull())
				return false;
			array[++top] = element;
			nElements++;
			return true;
		}

		/**
		 * @return T
		 */
		public T peek() {
			if (isEmpty())
				return null;
			return array[top];
		}

		/**
		 * @return T
		 */
		public T pop() {
			if (isEmpty())
				return null;
			nElements--;
			return array[top--];
		}

		/**
		 * @return boolean
		 */
		public boolean isFull() {
			return nElements >= array.length ? true : false;
		}

		/**
		 * @return boolean
		 */
		public boolean isEmpty() {
			return nElements == 0 ? true : false;
		}

	}

	/**
	 * @author ankur.mahajan
	 * @written 26-Mar-2019
	 * @param <T>
	 */
	static class Queue<T> {

		private T[] queueArray;

		private int front;

		private int rear;

		private int arraySize;

		private int nElements;

		@SuppressWarnings("unchecked")
		public Queue(int size) {
			arraySize = size;
			nElements = 0;
			rear = -1;
			front = 0;
			queueArray = (T[]) new Object[size];
		}

		/**
		 * @return boolean
		 */
		public boolean isEmpty() {
			return nElements == 0 ? true : false;
		}

		/**
		 * @return boolean
		 */
		public boolean isFull() {
			return nElements >= arraySize ? true : false;
		}

		/**
		 * @param element
		 * @return boolean
		 */
		public boolean add(T element) {
			if (isFull())
				return false;
			nElements++;
			queueArray[++rear] = element;
			return true;
		}

		/**
		 * @return
		 */
		public T remove() {
			if (isEmpty())
				return null;
			nElements--;
			return queueArray[front++];

		}

		/**
		 * @return
		 */
		public T peek() {
			return queueArray[front];
		}
	}

}
