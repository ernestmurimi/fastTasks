class Task6 {
	Task6() {
	}

	private boolean isPalindrome(int number) {
		int originalNumber = number;
		int reverseNumber = 0;
		while (number > 0) {
			reverseNumber = reverseNumber * 10 + number % 10;
			number = number / 10;
		}
		return reverseNumber == originalNumber;
	}

	boolean isPrime(int number) {
		if (number == 2) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= number; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	int[] solution() {
		int[] multipliers = new int[2];
		int largestPalindrome = 0;
		for (int p = 99990; p > 9999; p -= 11) {    // Is "p" never prime???
			for (int q = 99999; q > 9999; q--) {
				if (isPrime(p) && isPrime(q)) {    // We can't check it in every loop - correct it!
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
		}
		return multipliers;
	}
}