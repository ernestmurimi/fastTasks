package task10;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.solution(1041));
	}

	public Solution() {
	}

	public int solution(int N) {
		int max = 0, tmp = 0; // Binary gaps lengths
		String bin = dec2bin(N);
		for (char c : bin.toCharArray()) {
			if (c == '0') {
				tmp++;
			} else {
				if (tmp > max) {
					max = tmp;
				}
				tmp = 0;
			}
		}
		return max;
	}

	private String dec2bin(int dec) {
		StringBuilder binSb = new StringBuilder();
		while (dec > 0) {
			binSb.insert(0, Integer.toString(dec % 2));
			dec /= 2;
		}
		return binSb.toString();
	}
}
