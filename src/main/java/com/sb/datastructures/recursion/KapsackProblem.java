/**
 * 
 */
package com.sb.datastructures.recursion;

/**
 * @author ankur.mahajan
 * @written 20-Feb-2019
 */
public class KapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int target = 20;
		int[] weights = { 10, 40, 20 };
		int[] profits = { 100, 280, 120 };

		// normalKapsack(weights, target);
		knapsack01Problem(weights, profits, target);

		// knapsack01FractionalProblem(weights, profits, target);

	}

	private static void knapsack01FractionalProblem(int[] weights, int[] profits, int target) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given weights and values of n items, put these items in a knapsack of
	 * capacity W to get the maximum total value in the knapsack. In other
	 * words, given two integer arrays val[0..n-1] and wt[0..n-1] which
	 * represent values and weights associated with n items respectively. Also
	 * given an integer W which represents knapsack capacity, find out the
	 * maximum value subset of val[] such that sum of the weights of this subset
	 * is smaller than or equal to W. You cannot break an item, either pick the
	 * complete item, or don’t pick it (0-1 property).
	 * 
	 * This problem can not be solved by greedy algo as it will break when
	 * int[] weights = { 10, 40, 20 };
	 * int[] profits = { 100, 280, 120 };
	 * 
	 * @param target
	 * @param profits
	 * @param weights
	 */
	private static void knapsack01Problem(int[] weights, int[] profits, int target) {
		StringBuilder builder = new StringBuilder();
		builder.append("Selected weights and profits are : ");
		// Get profits/weight on this we will prefer the object.
		double[] profitsByWeights = new double[weights.length];
		int minimumWeight = weights[0];
		for (int i = 0; i < profits.length; i++) {
			// Get Minimum weight of the objects.
			if (minimumWeight > weights[i]) {
				minimumWeight = weights[i];
			}
			profitsByWeights[i] = (double) profits[i] / weights[i];
		}

		while (target >= minimumWeight) {
			double maxProfit = profitsByWeights[0];
			int maxIndex = 0;
			for (int i = 1; i < profitsByWeights.length; i++) {
				if (maxProfit < profitsByWeights[i]) {
					maxProfit = profitsByWeights[i];
					maxIndex = i;
				}
			}

			if (target - weights[maxIndex] >= 0) {
				target -= weights[maxIndex];
				builder.append("Weight [" + weights[maxIndex] + "] and Profit [" + profits[maxIndex] + "] ## ");

			}
			profitsByWeights[maxIndex] = 0;
		}
		System.out.println(builder.toString());
	}

	private static void normalKapsack(int[] weights, int target) {
		boolean found = false;
		for (int i = 0; i < weights.length; i++) {
			StringBuilder str = new StringBuilder();
			int outer = weights[i];
			int total = outer;
			str.append(outer);
			for (int j = i + 1; j < weights.length; j++) {
				if (total + weights[j] < target) {
					total = outer + weights[j];
					str.append(" + " + weights[j]);
				}
				else if (total + weights[j] == target) {
					str.append(" + " + weights[j]);
					found = true;
					break;

				}
			}
			if (found) {
				System.out.println("Target Matched with weights : " + str.toString());
				break;
			}
		}

	}

}
