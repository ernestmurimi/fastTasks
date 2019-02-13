package task16;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] array = {2, 3, 1, 5};
		try {
			System.out.println(obj.solution(array));
		} catch (ThereIsNoMissingElement e) {
			System.out.println(e.getMessage());
		}
	}

	public int solution(int[] A) throws ThereIsNoMissingElement {
		// https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
		int[] sumAndMax = getArraySumAndMaxElement(A);
		int expectedSum = sumAndMax[1] * (sumAndMax[1] + 1) / 2;
		int realSum = sumAndMax[0];
		if (expectedSum == realSum) {
			throw new ThereIsNoMissingElement("There is no missing element in given array!");
		}
		return expectedSum - realSum;

	}

	private int[] getArraySumAndMaxElement(int[] array) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int currElement : array) {
			sum += currElement;
			if (currElement > max) {
				max = currElement;
			}
		}
		return new int[]{sum, max};
	}
}
