package task24;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		String S = "CAGCCTA";
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		System.out.println(Arrays.toString(obj.solution(S, P, Q)));
	}

	public int[] solution(String S, int[] P, int[] Q) {
		int[][] nucleotides = new int[3][S.length() + 1];
		int a, c, g;
		for (int i = 0; i < S.length(); i++) {
			a = 0;
			c = 0;
			g = 0;
			if (S.charAt(i) == 'A') {
				a = 1;
			} else if (S.charAt(i) == 'C') {
				c = 1;
			} else if (S.charAt(i) == 'G') {
				g = 1;
			}
			nucleotides[0][i + 1] = nucleotides[0][i] + a;
			nucleotides[1][i + 1] = nucleotides[1][i] + c;
			nucleotides[2][i + 1] = nucleotides[2][i] + g;
		}
		int[] result = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			int indexFrom = P[i];
			int indexTo = Q[i] + 1;
			if (nucleotides[0][indexTo] - nucleotides[0][indexFrom] > 0) {
				result[i] = 1;
			} else if (nucleotides[1][indexTo] - nucleotides[1][indexFrom] > 0) {
				result[i] = 2;
			} else if (nucleotides[2][indexTo] - nucleotides[2][indexFrom] > 0) {
				result[i] = 3;
			} else {
				result[i] = 4;
			}
		}
		return result;
	}
}
