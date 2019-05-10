/**
 * 
 */
package com.sb.datastructures.graphs.weighted;

/**
 * @author ankur.mahajan
 * @written 03-Apr-2019
 */
public class DirectionalGraph<T> {

	Vertex<?>[] verticesArray;

	int[][] adjancencyMatrix;

	int MAX_GRAPH_SIZE = 20;

	int nVertices;

	PriorityQueue queue;

	public DirectionalGraph() {
		verticesArray = new Vertex[MAX_GRAPH_SIZE];
		adjancencyMatrix = new int[MAX_GRAPH_SIZE][MAX_GRAPH_SIZE];
		nVertices = 0;
		queue = new PriorityQueue(MAX_GRAPH_SIZE);
	}

	public boolean isFull() {
		return nVertices >= MAX_GRAPH_SIZE ? true : false;
	}

	/**
	 * @param t
	 * @return
	 */
	public boolean addVertex(T t) {
		if (isFull())
			return false;
		Vertex<T> ver = new Vertex<>(t);
		verticesArray[nVertices++] = ver;
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
		return true;
	}

	/**
	 * 
	 */
	public void minimumSpanningTree() {
		int current = 0;
		int nTrees = 0;

		while (nVertices - 1 > nTrees) {
			verticesArray[current].setVisited(true);
			nTrees++;

			for (int i = 0; i < nVertices; i++) {
				if (current == i)
					continue;
				int weight = adjancencyMatrix[current][i];
				if (weight == 0)
					continue;
				if (verticesArray[i].isVisited())
					continue;
				putInPQ(current, i, weight);
			}
			if (queue.isEmpty()) {
				System.out.println("Graph doesn't connect.");
				return;
			}

			Edge edge = queue.remove();
			System.out.print(edge.sourceVertex);
			System.out.print(edge.destinationVertex);
			System.out.print(" ");
			current = edge.destinationVertex;

		}
	}

	private void putInPQ(int current, int i, int weight) {
		int dest = queue.findEdgeByDestination(i);
		Edge e = new Edge(weight, current, i);
		if (dest == -1) {
			queue.add(e);
		} else {
			Edge old = queue.findN(dest);
			if (old.weight > weight) {
				queue.removeN(dest);
				queue.add(e);
			}
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @author ankur.mahajan
	 * @written 03-Apr-2019
	 * @param <T>
	 */
	static class Vertex<T> {

		T content;

		boolean visited;

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
		 * @param content
		 *            the content to set
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
		 * @param visited
		 *            the visited to set
		 */
		public void setVisited(boolean visited) {
			this.visited = visited;
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @author ankur.mahajan
	 * @written 03-Apr-2019
	 */
	static class Edge {

		int weight;

		int sourceVertex;

		int destinationVertex;

		public Edge(int weight, int sourceVertex, int destinationVertex) {
			super();
			this.weight = weight;
			this.sourceVertex = sourceVertex;
			this.destinationVertex = destinationVertex;
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @author ankur.mahajan
	 * @written 03-Apr-2019
	 */
	static class Heap {

		Edge[] heapArray;

		int maxSize;

		int currentIndex;

		public Heap(int size) {
			maxSize = size;
			currentIndex = 0;
			heapArray = new Edge[size];
		}

		/**
		 * @return
		 */
		public boolean isFull() {
			return currentIndex >= maxSize ? true : false;
		}

		/**
		 * @return
		 */
		public boolean isEmpty() {
			return currentIndex == 0 ? true : false;
		}

		/**
		 * @param e
		 * @return
		 */
		public boolean insert(Edge e) {
			if (isFull())
				return false;
			heapArray[currentIndex] = e;
			trickleUp(currentIndex++);
			return true;
		}

		/**
		 * @return
		 */
		public Edge remove() {
			Edge e = heapArray[0];
			heapArray[0] = heapArray[--currentIndex];
			trickleDown(0);
			return e;
		}

		/**
		 * @param index
		 */
		private void trickleDown(int index) {
			while (currentIndex / 2 > index) {
				int left = 2 * index + 1;
				int right = left + 1;
				if (heapArray[index].weight <= heapArray[left].weight
						&& heapArray[index].weight <= heapArray[right].weight)
					return;
				Edge temp = heapArray[index];
				if (heapArray[index].weight > heapArray[left].weight
						&& heapArray[right].weight > heapArray[left].weight) {
					heapArray[index] = heapArray[left];
					heapArray[left] = temp;
					index = left;

				} else if (heapArray[index].weight > heapArray[right].weight
						&& heapArray[left].weight > heapArray[right].weight) {
					heapArray[index] = heapArray[right];
					heapArray[right] = temp;
					index = right;
				}
			}

		}

		/**
		 * @param index
		 */
		private void trickleUp(int index) {
			Edge bottom = heapArray[index];
			int parentIndx = (index - 1) / 2;
			while (bottom.weight < heapArray[parentIndx].weight && parentIndx > 0) {
				Edge temp = heapArray[index];
				heapArray[index] = heapArray[parentIndx];
				heapArray[parentIndx] = temp;
				index = parentIndx;
				parentIndx = (parentIndx - 1) / 2;
			}

		}

		/**
		 * @param i
		 * @return
		 */
		public int EdgeByDestination(int i) {
			for (int j = 0; j < currentIndex; j++) {
				if (heapArray[j].destinationVertex == i) {
					return j;
				}
			}
			return -1;
		}

		public Edge find(int index) {
			return heapArray[index];
		}

		public void removeN(int i) {
			for (int j = i; j < currentIndex; j++) {
				heapArray[j] = heapArray[j + 1];
			}
			currentIndex--;

		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @author ankur.mahajan
	 * @written 03-Apr-2019
	 */
	static class PriorityQueue {
		Heap heap;

		int queueSize;

		int maxSize;

		public PriorityQueue(int size) {
			queueSize = 0;
			maxSize = size;
			heap = new Heap(size);
		}

		public void removeN(int i) {
			heap.removeN(i);

		}

		public Edge findN(int index) {
			return heap.find(index);
		}

		public int findEdgeByDestination(int i) {
			return heap.EdgeByDestination(i);
		}

		/**
		 * @return
		 */
		public boolean isFull() {
			return queueSize >= maxSize ? true : false;
		}

		/**
		 * @return
		 */
		public boolean isEmpty() {
			return queueSize == 0 ? true : false;
		}

		/**
		 * @param e
		 * @return
		 */
		public boolean add(Edge e) {
			if (isFull())
				return false;
			heap.insert(e);
			queueSize++;
			return true;
		}

		/**
		 * @return
		 */
		public Edge remove() {
			if (isEmpty())
				return null;
			return heap.remove();
		}
	}
}
