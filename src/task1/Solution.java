package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.solution("Forget CVs..Save time . x x"));
	}

	public Solution() {
	}

	public int solution(String S) {
		List<String> sentences = new ArrayList<>(Arrays.asList(S.split("[.?!]", -2)));
		sentences.removeAll(Arrays.asList("", null));
		int maxWords = 0;
		for (String curr : sentences) {
			List<String> words = new ArrayList<>(Arrays.asList(curr.split("\\s+", 0)));
			words.removeAll(Arrays.asList("", null));
			if (words.size() > maxWords) {
				maxWords = words.size();
			}
		}
		return maxWords;
	}
}
