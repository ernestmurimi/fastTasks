package task11;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {3, 8, 9, 7, 6};
		System.out.println(Arrays.toString(obj.solution(arr, 3)));
	}

	public Solution() {
	}

	public int[] solution(int[] A, int K) {
		if (A.length == 0 || A.length == K || isArrayUniform(A)) {
			return A;
		}
		for (int i = 0; i < K; i++) {
			int lastElement = A[A.length - 1];
			for (int j = A.length - 1; j > 0; j--) {
				A[j] = A[j - 1];
			}
			A[0] = lastElement;
		}
		return A;
	}

	private boolean isArrayUniform(int[] arr) {
		if (arr.length == 0) {
			return true;
		}
		int firstElement = arr[0];
		for (int curr : arr) {
			if (curr != firstElement) {
				return false;
			}
		}
		return true;
	}
}
