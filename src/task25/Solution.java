package task25;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		String str = "   cccCb?;:baaa$AA   ";
		System.out.println(obj.solution(str));
	}

	public String solution(String S) {
		int[] occurrences = new int[26];
		for (char ch : S.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray()) {
			occurrences[ch - 'a']++;
		}
		char best_char = '\u0000';
		int best_res = 0;
		for (int i = 0; i < 26; i++) {
			if (occurrences[i] > best_res) {
				best_char = (char) ((int) 'a' + i);
				best_res = occurrences[i];
			}
		}
		return Character.toString(best_char);
	}
}