package task21;

public class Solution {
	private static final int PAIRS_LIMIT = 1000000000;

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = {0, 1, 0, 1, 1};
		System.out.println(obj.solution(array));
	}

	public int solution(int[] A) {
		int zeros = 0;
		int pairs = 0;
		for (int curr : A) {
			if (curr == 0) {
				zeros++;
			} else {
				pairs += zeros;
			}
			if (pairs > PAIRS_LIMIT) {
				return -1;
			}
		}
		return pairs;
	}
}
