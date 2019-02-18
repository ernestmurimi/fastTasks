package task19;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = {1, 3, 6, 4, 1, 2};
		try {
			System.out.println(obj.solution(array));
		} catch (ThereIsNoMinimumInteger e) {
			System.out.println(e.getMessage());
		}
	}

	public int solution(int[] A) throws ThereIsNoMinimumInteger {
		Set<Integer> set = new HashSet<>();
		for (int curr : A) {
			if (curr > 0) {
				set.add(curr);
			}
		}
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		throw new ThereIsNoMinimumInteger("There is no minimum positive integer!");
	}
}
