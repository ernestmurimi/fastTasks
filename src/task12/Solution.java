package task12;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {9, 3, 9, 3, 9, 7, 9};
		try {
			System.out.println(obj.solution(arr));
		} catch (NoUnpairedElement e) {
			System.out.println(e.getMessage());
		}
	}

	public Solution() {
	}

	public int solution(int[] A) throws NoUnpairedElement {
		sort(A, 0, A.length - 1);
		int number = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (count == 0) {
				number = A[i];
				count = 1;
			} else if (A[i] == number) {
				count++;
			} else if (count % 2 == 1) {
				return number;
			} else {
				number = A[i];
				count = 1;
			}
			if (i == A.length - 1 && count % 2 == 1) {
				return number;
			}
		}
		throw new NoUnpairedElement("There is no unpaired element!");
	}

	private void sort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	private int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
