import exceptions.ThereIsNoPrimeNumbers;

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

	private boolean isPrime(int number) {
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

	int[] solution() throws ThereIsNoPrimeNumbers {
		int[] multipliers = new int[2];
		int largestPalindrome = 0;
		boolean palindromeFound = false;

		// We check only odd numbers (even numbers are not prime)
		for (int p = 99979; p > 9999; p -= 2 * 11) {
			for (int q = 99999; q > 9999; q -= 2) {
				if (isPrime(p) && isPrime(q)) {
					int product = p * q;
					if (product > largestPalindrome && isPalindrome(product)) {
						palindromeFound = true;
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
		if (!palindromeFound) {
			throw new ThereIsNoPrimeNumbers("There is no palindrome number which is the product of two prime five-digit numbers!");
		}
		return multipliers;
	}
}