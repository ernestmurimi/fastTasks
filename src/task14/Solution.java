package task14;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int K = 3, M = 5;
		int[] A = {2, 1, 5, 1, 2, 2, 2};
		System.out.println(obj.solution(K, M, A));
	}

	public int solution(int K, int M, int[] A) {
		int min = 0;
		int max = 0;
		for (int arrElem : A) {
			max += arrElem; // Maximum sum is the sum of all elements of the array
			min = Math.max(min, arrElem); // Minimum sum is the largest element of the array
		}
		int possibleResult = max; // Maximum sum is the first possible result (but the worst)
		while (min <= max) {
			int mid = (min + max) / 2; // Binary searching
			if (isDivisible(mid, K, A)) { // Divisibility checking
				possibleResult = mid; // Mid is the next possible result (better than maximum sum)
				max = mid - 1; // We can search in a set in which there are smaller elements
			} else {
				min = mid + 1; // We have to search in a set in which there are greater elements
			}
		}
		return possibleResult;
	}

	// Checking if we can divide array into numBlocksAllowed blocks and with maxSum maximum sum
	private boolean isDivisible(int maxSum, int numBlocksAllowed, int[] array) {
		int currentBlockSum = 0;
		for (int arrElem : array) {
			currentBlockSum += arrElem;
			if (currentBlockSum > maxSum) { // Means: we need new block from numBlocksAllowed
				numBlocksAllowed--;
				currentBlockSum = arrElem; // We count the next elements of the array for the new block from numBlocksAllowed
			}
			if (numBlocksAllowed == 0) { // We don't have enough blocks, so divisible is impossible
				return false;
			}
		}
		return true; // Divisible is possible
	}
}
