import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task1 {
	Task1() {
	}

	int solution(String S) {
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
