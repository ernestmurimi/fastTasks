package task9;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {10, 15, 3, 7};
		System.out.println(obj.solution(arr));
	}

	public Solution() {
	}

	public boolean solution(int[] A) {
		Integer[] A_desc = Arrays.stream(A).boxed().toArray(Integer[]::new);
		Arrays.sort(A_desc, Collections.reverseOrder());
		for (int i = 0; i < A_desc.length; i++) {
			for (int j = i + 1; j < A_desc.length; j++) {
				if (j + 1 < A_desc.length && A[j] + A[j + 1] < A[i]) {
					break;
				}
				for (int k = j + 1; k < A_desc.length; k++) {
					if (A[j] + A[k] == A[i]) {
						return true;
					} else if (A[j] + A[k] < A[i]) {
						break;
					}
				}
			}
		}
		return false;
	}
}
