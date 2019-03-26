/**
 * 
 */
package com.sb.datastructures.recursion;

/**
 * @author ankur.mahajan
 * @written 18-Feb-2019
 */
public class TowerOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int disks = 5;
		char from = 'A';
		char aux = 'B';
		char to = 'C';
		firstApproachByRecursion(disks, from, aux, to);

	}

	/**
	 * For n disks, total 2n – 1 moves are required.
	 * 
	 * STEPS:
	 * 
	 * Shift 'n-1' disks from 'A' to 'B'. - Line - 42
	 * Shift last disk from 'A' to 'C'. - Line - 43
	 * Shift 'n-1' disks from 'B' to 'C'. - Line - 45
	 * 
	 * @param disks
	 * @param from
	 * @param aux
	 * @param to
	 */
	private static void firstApproachByRecursion(int disks, char from, char aux, char to) {
		// Base Condition to stop recursion.
		if (disks > 0) {
			// Move n-1 disks from -> aux
			firstApproachByRecursion(disks - 1, from, to, aux);
			System.out.println("Disk [" + disks + "] Moved from tower [" + from + "] to [" + to + "]");
			// Move that n-1 disks aux -> to
			firstApproachByRecursion(disks - 1, aux, from, to);
		}

	}

}
