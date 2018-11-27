package task4;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {2, 2, 2, 2, 1, 2, -1, 2, 1, 3};
		System.out.println(obj.solution(arr));
	}

	public Solution() {
	}

	public int solution(int[] A) {
		Integer currIndex = null;
		Integer currCount = 0;

		int maxCount = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			if (currIndex == null) {
				currIndex = i;
				currCount++;
			} else if (A[i] > A[currIndex]) {
				currCount++;
			}
			if (i + 1 >= A.length || A[i + 1] <= A[i]) {
				if (currCount == maxCount) {
					map.put(currIndex, currCount);
				} else if (currCount > maxCount) {
					map.clear();
					map.put(currIndex, currCount);
					maxCount = currCount;
				}
				currIndex = null;
				currCount = 0;
			}
		}

		List<Integer> keysAsArray = new ArrayList<>(map.keySet());
		return keysAsArray.get(new Random().nextInt(keysAsArray.size()));
	}
}