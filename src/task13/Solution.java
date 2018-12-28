package task13;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int X = 10, Y = 85, D = 30;
		System.out.println(obj.solution(X, Y, D));
	}

	public int solution(int X, int Y, int D) {
		float resultFloat = (float) (Y - X) / D;
		int resultInt = (int) resultFloat;
		float fraction = resultFloat - resultInt;
		return (fraction > 0 ? resultInt + 1 : resultInt);
	}
}
