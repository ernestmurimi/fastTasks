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

	private int getMaxNumberDivisibleByEleven(int numberOfDigits) {
		for (int i = getMaxNumber(numberOfDigits); ; i--) {
			if ((i % 10) % 2 != 0 && i % 11 == 0) {
				return i;
			} else if (i % 11 == 0) {
				return i - 11;
			}
		}
	}

	private int getMaxNumber(int numberOfDigits) {
		return (int) Math.pow(10, numberOfDigits) - 1;
	}

	int[] solution(int numberOfDigits) throws ThereIsNoPrimeNumbers {
		int[] multipliers = new int[2];
		int largestPalindrome = 0;
		boolean palindromeFound = false;
		int maxOddNumberDivisibleByEleven = getMaxNumberDivisibleByEleven(numberOfDigits);
		int maxNumberWithDefinedDigits = getMaxNumber(numberOfDigits);
		int maxNumberWithOneLessDigit = getMaxNumber(numberOfDigits - 1);

		for (int p = maxOddNumberDivisibleByEleven; p > maxNumberWithOneLessDigit; p -= 2 * 11) {
			if (!isPrime(p)) {
				continue;
			}
			for (int q = maxNumberWithDefinedDigits; q > maxNumberWithOneLessDigit; q -= 2) {
				if (isPrime(q)) {
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
			throw new ThereIsNoPrimeNumbers("There is no palindrome number which is the product of two prime " + numberOfDigits + "-digit numbers!");
		}
		return multipliers;
	}
}