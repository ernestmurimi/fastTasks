package task9;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {10, 15, 3, 7};
		System.out.println(obj.solution(arr));
	}

	public Solution() {
	}

	public boolean solution(int[] A) {
		quickSortInDescendingOrder(A, 0, A.length - 1);
		int idx1;
		int idx2;
		int sumToSearch;
		int currSum;

		for (int i = 0; i < A.length - 2; i++) {
			if (A[i + 1] + A[i + 2] < A[i]) {
				break;
			}
			sumToSearch = A[i];
			idx1 = i + 1;
			idx2 = A.length - 1;
			while (idx1 < idx2) {
				currSum = A[idx1] + A[idx2];
				if (currSum < sumToSearch) {
					idx2--;
				} else if (currSum > sumToSearch) {
					idx1++;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	private static void quickSortInDescendingOrder(int[] numbers, int low, int high) {
		int i = low;
		int j = high;
		int temp;
		int middle = numbers[(low + high) / 2];

		while (i < j) {
			while (numbers[i] > middle) {
				i++;
			}
			while (numbers[j] < middle) {
				j--;
			}
			if (j >= i) {
				temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j) {
			quickSortInDescendingOrder(numbers, low, j);
		}
		if (i < high) {
			quickSortInDescendingOrder(numbers, i, high);
		}
	}
}
