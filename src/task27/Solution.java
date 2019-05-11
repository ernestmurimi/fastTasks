package task27;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = new int[]{2, -2, 3, 0, 4, -7};
		System.out.println(obj.solution(array));
	}

	public int solution(int[] A) {
		int numberOfFragmentsWithZeroSum = 0;
		Set<Integer> sumSet = new HashSet<>();
		int currSum = 0;
		for (int arrayElement : A) {
			currSum += arrayElement;
			if (currSum == 0) {
				numberOfFragmentsWithZeroSum++;
			}
			if (sumSet.contains(currSum)) {
				numberOfFragmentsWithZeroSum++;
			} else {
				sumSet.add(currSum);
			}
			if (numberOfFragmentsWithZeroSum == 1000000000) {
				return -1;
			}
		}
		return numberOfFragmentsWithZeroSum;
	}
}
