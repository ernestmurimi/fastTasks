package task7;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.solution("abbccc"));
	}

	public Solution() {
	}

	public String solution(String stringToCompress) {
		StringBuilder compressedText = new StringBuilder();
		int index = 0;
		int counter = 0;
		for (char character : stringToCompress.toCharArray()) {
			counter++;
			if (isLastSameChar(stringToCompress, index)) {
				compressedText.append(counter).append(character);
				counter = 0;
			}
			index++;
		}
		return compressedText.toString();
	}

	private boolean isLastSameChar(String string, int charIndex) {
		return isLastChar(string, charIndex) || !isNextCharSame(string, charIndex);
	}

	private boolean isLastChar(String string, int charIndex) {
		return charIndex + 1 == string.length();
	}

	private boolean isNextCharSame(String string, int charIndex) {
		return string.charAt(charIndex + 1) == string.charAt(charIndex);
	}
}