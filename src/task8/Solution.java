package task8;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {10, 15, 3, 7};
		int number = 17;
		System.out.println(obj.solution(arr, number));
	}

	public Solution() {
	}

	public boolean solution(int[] A, int k) {
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] + A[j] == k) {
					return true;
				}
			}
		}
		return false;
	}
}
