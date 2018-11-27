package task2;

import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.solution(4, 17));
	}

	public Solution() {
	}

	public int solution(int A, int B) {
		int counter = 0;
		for (double i = A; i <= B; i++) {
			if ((sqrt(i) % 1) == 0) {
				counter++;
			}
		}
		return counter;
	}
}