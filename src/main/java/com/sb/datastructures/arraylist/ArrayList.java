/**
 * 
 */
package com.sb.datastructures.arraylist;

/**
 * @author ankur.mahajan
 * @written 01-May-2019
 */
public class ArrayList<T> implements List<T> {

	private Object[] listArray;

	private int size;

	private int arraySize;

	public ArrayList() {
		size = 0;
		arraySize = 10;
		listArray = new Object[arraySize];
	}

	@Override
	public boolean add(T e) {
		listArray[size++] = e;
		growArrayToDouble();
		return true;
	}

	private void growArrayToDouble() {
		Object[] newArray;
		if (size >= arraySize / 2) {
			int newSize = arraySize * 2;
			newArray = new Object[newSize];
			for (int i = 0; i < listArray.length; i++) {
				newArray[i] = listArray[i];
			}
			listArray = newArray;
			arraySize = newSize;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		rangeCheck(index);
		T element = (T) listArray[index];
		return element;
	}

	/**
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index >= size)
			throw new RuntimeException("Index out of bound.");

	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		T temp = (T) listArray[index];
		for (int i = index; i < size; i++) {
			listArray[i] = listArray[i + 1];
		}
		size--;
		return temp;
	}

}
