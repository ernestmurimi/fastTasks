package task11;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {3, 8, 9, 7, 6};
		int rotations = 3;
		System.out.println("Solution #1: " + Arrays.toString(obj.solution1(arr, rotations)));
		System.out.println("Solution #2: " + Arrays.toString(obj.solution2(arr, rotations)));
	}

	public Solution() {
	}

	// A iterative solution - faster but with worst space complexity
	public int[] solution1(int[] A, int K) {
		if (A.length == 0 || K % A.length == 0 || isArrayUniform(A)) {
			return A;
		}
		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			B[(i + K) % A.length] = A[i];
		}
		return B;
	}

	// A recursive solution - slower but "in-place"
	public int[] solution2(int[] A, int K) {
		if (A.length == 0 || K % A.length == 0 || isArrayUniform(A)) {
			return A;
		}
		moveItemToNewLocation(A, K, 0);
		return A;
	}

	private void moveItemToNewLocation(int[] A, int K, int idx) {
		int tmp = A[idx];
		if (idx + 1 < A.length) {
			moveItemToNewLocation(A, K, idx + 1);
		}
		A[(idx + K) % A.length] = tmp;
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
