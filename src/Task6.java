class Task6 {
	Task6() {
	}

	private boolean isPalindrome(int number) {
		return true;
	}

	int[] solution() {
		int[] multipliers = new int[2];
		int largestPalindrome = 0;
		for (int p = 99990; p > 9999; p -= 11) {
			for (int q = 99999; q > 9999; q--) {
				int product = p * q;
				if (product > largestPalindrome && isPalindrome(product)) {
					largestPalindrome = product;
					multipliers[0] = p;
					multipliers[1] = q;
					break;
				} else if (product < largestPalindrome) {
					break;
				}
			}
		}
		return multipliers;
	}
}