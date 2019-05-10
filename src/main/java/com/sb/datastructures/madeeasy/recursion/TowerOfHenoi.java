/**
 * 
 */
package com.sb.datastructures.madeeasy.recursion;

/**
 * @author ankur.mahajan
 * @written 30-Apr-2019
 */
public class TowerOfHenoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int disk = 4;
		tohByRecursion(disk, 1, 3, 2);

	}

	private static void tohByRecursion(int disk, int sourceTower, int destinationTower, int auxTower) {
		if (disk < 1)
			return;
		// first move n-1 discs to T1 to T2
		tohByRecursion(disk - 1, 1, 2, 3);
		// Move nth disc to T1 to T3
		System.out.println("Disk " + disk + " is moved from tower" + sourceTower + " to tower" + destinationTower);
		// Move n-1 discs to T2 to T3
		tohByRecursion(disk - 1, 2, 3, 1);
	}

}
