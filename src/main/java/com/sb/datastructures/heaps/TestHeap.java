/**
 * 
 */
package com.sb.datastructures.heaps;

/**
 * @author ankur.mahajan
 * @written 19-Mar-2019
 */
public class TestHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testHeap1();

	}

	private static void testHeap1() {
		HeapForInterger heap = new HeapForInterger(10);
		heap.insert(82);
		heap.insert(70);
		heap.insert(51);
		heap.insert(63);
		heap.insert(55);
		heap.insert(37);
		heap.insert(10);
		heap.insert(97);

		// heap.remove();
		heap.changeKey(4, 88);

	}

}
