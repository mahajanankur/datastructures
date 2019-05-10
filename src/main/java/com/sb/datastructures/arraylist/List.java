/**
 * 
 */
package com.sb.datastructures.arraylist;

/**
 * @author ankur.mahajan
 * @written 01-May-2019
 */
public interface List<T> {

	boolean add(T e);

	T get(int index);

	T remove(int index);
}
