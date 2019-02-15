package task17;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = {3, 1, 2, 4, 3};
		try {
			System.out.println(obj.solution(array));
		} catch (ArrayIsTooSmallToSplitIt e) {
			System.out.println(e.getMessage());
		}
	}

	public int solution(int[] A) throws ArrayIsTooSmallToSplitIt {
		if (A.length < 2) {
			throw new ArrayIsTooSmallToSplitIt("Array is too small to split it!");
		} else if (A.length == 2) {
			return Math.abs(A[0] - A[1]);
		} else {
			int sum1 = A[0];
			int sum2 = 0;
			int minDifference;
			int currDifference;

			for (int i = 1; i < A.length; i++) {
				sum2 += A[i];
			}
			minDifference = Math.abs(sum1 - sum2);
			for (int i = 2; i < A.length; i++) {
				sum1 += A[i - 1];
				sum2 -= A[i - 1];
				currDifference = Math.abs(sum1 - sum2);
				if (currDifference < minDifference) {
					minDifference = currDifference;
				}
			}
			return minDifference;
		}
	}
}
