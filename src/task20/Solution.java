package task20;

public class Solution {
	private static final int PERMUTATION = 1;
	private static final int NOT_PERMUTATION = 0;

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = {4, 1, 3};
		System.out.println(obj.solution(array));
	}

	public int solution(int[] A) {
		boolean[] flags = new boolean[A.length];
		int counter = 0;
		for (int curr : A) {
			int value = curr - 1;
			if (value < 0 || value > flags.length - 1 || flags[value]) {
				return NOT_PERMUTATION;
			} else {
				flags[value] = true;
				counter++;
			}
		}
		return counter == flags.length ? PERMUTATION : NOT_PERMUTATION;
	}
}
