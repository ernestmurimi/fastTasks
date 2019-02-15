package task18;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = {3, 4, 4, 6, 1, 4, 4};
		int N = 5;
		System.out.println(Arrays.toString(obj.solution(N, array)));
	}

	public int[] solution(int N, int[] A) {
		Counters counters = new Counters(N);
		int numberOfCounters = counters.getNumberOfCounters();
		for (int arrayElement : A) {
			if (arrayElement >= 1 && arrayElement <= numberOfCounters) {
				counters.increaseSingleCounter(arrayElement - 1);
			} else if (arrayElement == numberOfCounters + 1) {
				counters.setAllCountersToMax();
			}
		}
		return counters.getCounters();
	}
}