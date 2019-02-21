package task23;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = {4, 2, 2, 5, 1, 5, 8};
		System.out.println(obj.solution(array));
	}

	public int solution(int[] A) {
		float minAvg = Float.MAX_VALUE;
		float twoSliceAvg, threeSliceAvg;
		int idx = Integer.MIN_VALUE;
		for (int i = 0; i < A.length - 2; i++) {
			twoSliceAvg = (float) ((A[i] + A[i + 1]) / 2.0);
			threeSliceAvg = (float) ((A[i] + A[i + 1] + A[i + 2]) / 3.0);
			float avg = Math.min(twoSliceAvg, threeSliceAvg);
			if (avg < minAvg) {
				minAvg = avg;
				idx = i;
			}
		}
		twoSliceAvg = (float) ((A[A.length - 2] + A[A.length - 1]) / 2.0);
		if (twoSliceAvg < minAvg) {
			idx = A.length - 2;
		}
		return idx;
	}
}
