package task6;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = obj.solution(5);
		System.out.println(Arrays.toString(arr));
	}

	public Solution() {
	}

	private boolean isPalindrome(double number) {
		double originalNumber = number;
		double reverseNumber = 0;
		while (number > 0) {
			reverseNumber = reverseNumber * 10 + number % 10;
			number = Math.floor(number / 10);
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

	private int getMaxNumber(int numberOfDigits) {
		return (int) Math.pow(10, numberOfDigits) - 1;
	}

	public int[] solution(int numberOfDigits) {
		int[] multipliers = new int[2];
		double largestPalindrome = 0;
		int maxNumber = getMaxNumber(numberOfDigits);
		int minNumber = getMaxNumber(numberOfDigits - 1);

		for (int p = maxNumber; p > minNumber; p -= 2) {
			if (!isPrime(p)) {
				continue;
			}
			for (int q = p; q > minNumber; q -= 2) {
				double product = (double) p * (double) q;
				if (product < largestPalindrome) {
					break;
				} else if (isPrime(q) && product > largestPalindrome && isPalindrome(product)) {
					largestPalindrome = product;
					multipliers[0] = p;
					multipliers[1] = q;
					break;
				}
			}
		}
		return multipliers;
	}
}