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
		final int A_IMPACT_FACTOR = 1;
		final int C_IMPACT_FACTOR = 2;
		final int G_IMPACT_FACTOR = 3;
		final int T_IMPACT_FACTOR = 4;
		int[] impactFactors = new int[S.length()];
		int[] result = new int[P.length];

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'A') {
				impactFactors[i] = A_IMPACT_FACTOR;
			} else if (S.charAt(i) == 'C') {
				impactFactors[i] = C_IMPACT_FACTOR;
			} else if (S.charAt(i) == 'G') {
				impactFactors[i] = G_IMPACT_FACTOR;
			} else {
				impactFactors[i] = T_IMPACT_FACTOR;
			}
		}
		for (int i = 0; i < P.length; i++) {
			int indexFrom = P[i];
			int indexTo = Q[i];
			int minImpactFactor = Integer.MAX_VALUE;
			for (int j = indexFrom; j <= indexTo; j++) {
				if (impactFactors[j] < minImpactFactor) {
					minImpactFactor = impactFactors[j];
				}
			}
			result[i] = minImpactFactor;
		}
		return result;
	}
}
