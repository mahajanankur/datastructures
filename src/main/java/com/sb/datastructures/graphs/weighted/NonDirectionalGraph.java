/**
 * 
 */
package com.sb.datastructures.graphs.weighted;

/**
 * @author ankur.mahajan
 * @written 29-Mar-2019
 */
public class NonDirectionalGraph<T> {

	private int MAX_SIZE = 20;

	private Vertex<?>[] verticesArray;

	// change this to actual weight of the edges.
	private int[][] adjancencyMatrix;

	private int nVertices;

	private int nTrees;

	private PriorityQueue queue;

	public NonDirectionalGraph() {
		super();
		nVertices = 0;
		nTrees = 0;
		verticesArray = new Vertex[MAX_SIZE];
		adjancencyMatrix = new int[MAX_SIZE][MAX_SIZE];
		queue = new PriorityQueue(MAX_SIZE);
	}

	/**
	 * @param content
	 * @return
	 */
	public boolean insertVertex(T content) {
		if (isFull())
			return false;
		Vertex<T> newVertex = new Vertex<T>(content);
		verticesArray[nVertices++] = newVertex;
		return true;
	}

	/**
	 * @param start
	 * @param end
	 * @param weight
	 * @return
	 */
	public boolean addEdge(int start, int end, int weight) {
		adjancencyMatrix[start][end] = weight;
		adjancencyMatrix[end][start] = weight;
		return true;
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		return nVertices >= MAX_SIZE ? true : false;
	}

	/**
	 * 
	 */
	public void minimumSpanningTree() {
		int current = 0;
		while (nVertices - 1 > nTrees) {
			// Mark the current vertex as visited.
			verticesArray[current].setVisited(true);
			nTrees++;
			for (int i = 0; i < nVertices; i++) {
				// Ignore as there wouldn't be any edge b/w a vertex.
				if (current == i)
					continue;
				int weight = adjancencyMatrix[current][i];
				// Ignore the if there is no edge between vertices.
				if (weight == 0)
					continue;
				// Ignore the if the vertex is already considered.
				if (verticesArray[i].isVisited())
					continue;
				// Put in PQ
				putInPriorityQueue(current, i, weight);
			}
			// Queue is empty that means there are no edges present in the
			// graph.
			if (queue.isEmpty()) {
				System.out.println("Graph doesn't connect.");
				return;
			}
			// Remove from PQ
			Edge minimumEdge = queue.dequeue();
			System.out.print(verticesArray[minimumEdge.srcVertex].getContent());
			System.out.print(verticesArray[minimumEdge.destVertex].getContent());
			System.out.print(" ");
			// Now the current would be the minimum edge's destination vertex.
			current = minimumEdge.destVertex;

		}
		// Remember to mark the flag to default after use.
		for (int i = 0; i < nVertices; i++) {
			verticesArray[i].setVisited(false);
		}

	}

	/**
	 * @param source
	 * @param destination
	 * @param weight
	 */
	private void putInPriorityQueue(int source, int destination, int weight) {
		int oldEdgeIndex = queue.findByDestination(destination);
		if (oldEdgeIndex == -1) {
			Edge edge = new Edge(source, destination, weight);
			queue.enqueue(edge);
		} else {
			// Compare the entries and consider the edge with smaller weight.
			Edge oldEdge = queue.peekN(oldEdgeIndex);
			if (weight < oldEdge.weight) {
				queue.removeN(oldEdgeIndex);
				Edge edge = new Edge(source, destination, weight);
				queue.enqueue(edge);
			}
		}
	}

	/**
	 * @author ankur.mahajan
	 * @written 01-Apr-2019
	 */
	static class Edge {

		int srcVertex;

		int destVertex;

		int weight;

		public Edge(int srcVertex, int destVertex, int weight) {
			super();
			this.srcVertex = srcVertex;
			this.destVertex = destVertex;
			this.weight = weight;
		}

	}

	/**
	 * @author ankur.mahajan
	 * @written 01-Apr-2019
	 * @param <T>
	 */
	static class Vertex<T> {
		T content;

		boolean visited;

		public Vertex(T content) {
			super();
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

	/**
	 * @author ankur.mahajan
	 * @written 01-Apr-2019
	 */
	static class PriorityQueue {

		private Heap heap;

		private int size;

		private int nElements;

		public PriorityQueue(int size) {
			nElements = 0;
			this.size = size;
			heap = new Heap(size);
		}

		/**
		 * @param element
		 * @return
		 */
		public boolean enqueue(Edge element) {
			if (isFull())
				return false;
			heap.insert(element);
			nElements++;
			return true;
		}

		/**
		 * @return
		 */
		public Edge dequeue() {
			if (isEmpty())
				throw new RuntimeException("Queue is empty.");
			nElements--;
			Edge element = heap.remove();
			return element;
		}

		/**
		 * @return
		 */
		public boolean isFull() {
			return nElements >= size ? true : false;
		}

		/**
		 * @return
		 */
		public boolean isEmpty() {
			return nElements == 0 ? true : false;
		}

		/**
		 * @param destination
		 * @return
		 */
		public int findByDestination(int destination) {
			return heap.findByDestination(destination);
		}

		/**
		 * @param index
		 * @return
		 */
		public Edge removeN(int index) {
			return heap.removeN(index);
		}

		/**
		 * @param index
		 * @return
		 */
		public Edge peekN(int index) {
			return heap.getByIndex(index);
		}
	}

	/**
	 * @author ankur.mahajan
	 * @written 29-Mar-2019
	 * 
	 *          Minimum Heap, root node is the minimum in all.
	 */
	static class Heap {

		private Edge[] heapArray;

		private int currentIndex;

		private int arraySize;

		public Heap(int size) {
			arraySize = size;
			heapArray = new Edge[size];
			currentIndex = 0;
		}

		public boolean insert(Edge element) {
			if (isFull())
				return false;
			heapArray[currentIndex] = element;
			trickleUp(currentIndex++);
			return true;
		}

		public Edge remove() {
			Edge element = heapArray[0];
			heapArray[0] = heapArray[--currentIndex];
			trickleDown(0);
			return element;
		}

		private void trickleUp(int index) {
			int parent = (index - 1) / 2;
			int bottom = heapArray[index].weight;

			while (bottom < heapArray[parent].weight && index > 0) {
				Edge temp = heapArray[index];
				heapArray[index] = heapArray[parent];
				heapArray[parent] = temp;
				index = parent;
				parent = (index - 1) / 2;
			}

		}

		private void trickleDown(int index) {
			int top = heapArray[index].weight;
			Edge temp = null;
			while (index < currentIndex / 2) {
				int left = 2 * index + 1;
				int right = left + 1;
				if (heapArray[left].weight >= top && heapArray[right].weight >= top) {
					return;
				}
				if (heapArray[left].weight < top
						&& heapArray[right].weight > heapArray[left].weight) {
					temp = heapArray[left];
					heapArray[left] = heapArray[index];
					heapArray[index] = temp;
					index = left;
				} else if (heapArray[right].weight < top
						&& heapArray[left].weight > heapArray[right].weight) {
					temp = heapArray[right];
					heapArray[right] = heapArray[index];
					heapArray[index] = temp;
					index = right;
				}

			}

		}

		public boolean isFull() {
			return currentIndex >= arraySize ? true : false;
		}

		/**
		 * @param destination
		 * @return
		 */
		public int findByDestination(int destination) {
			for (int i = 0; i < currentIndex; i++) {
				if (heapArray[i].destVertex == destination) {
					return i;
				}
			}
			return -1;
		}

		/**
		 * @param index
		 * @return
		 */
		public Edge removeN(int index) {
			Edge temp = heapArray[index];
			for (int i = index; i < heapArray.length - 1; i++) {
				heapArray[i] = heapArray[i + 1];
			}
			currentIndex--;
			return temp;
		}

		/**
		 * @param index
		 * @return
		 */
		public Edge getByIndex(int index) {
			return heapArray[index];
		}

	}
}
