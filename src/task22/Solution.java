package task22;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int A = 6, B = 11, K = 2;
		System.out.println(obj.solution(A, B, K));
	}

	public int solution(int A, int B, int K) {
		for (int i = A; i <= B; i++) {
			if (i % K == 0) {
				return (B - i) / K + 1;
			}
		}
		return 0;
	}
}
