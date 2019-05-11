package task26;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		String str = "011100";
		System.out.println(obj.solution(str));
	}

	public int solution(String S) {
		int V = Integer.parseInt(S, 2);
		int counter = 0;
		while (V > 0) {
			counter++;
			V = V % 2 == 0 ? V / 2 : V - 1;
		}
		return counter;
	}
}