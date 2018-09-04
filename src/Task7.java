class Task7 {
	Task7() {
	}

	String compressing(String toCompress) {
		StringBuilder compressedTxtAsBuilder = new StringBuilder();
		char currentChar = '\0';
		int counter = 0;
		for (int i = 0; i < toCompress.length(); i++) {
			if (toCompress.charAt(i) != currentChar) {
				currentChar = toCompress.charAt(i);
				counter = 1;
			} else {
				counter++;
			}
			if (i + 1 < toCompress.length() && toCompress.charAt(i + 1) != currentChar || i + 1 >= toCompress.length()) {
				compressedTxtAsBuilder.append(Integer.toString(counter)).append(currentChar);
			}
		}
		return compressedTxtAsBuilder.toString();
	}
}