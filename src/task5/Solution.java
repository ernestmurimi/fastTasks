package task5;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {1, 5, 3, 3, 7};
		System.out.println(obj.solution(arr));
	}

	public Solution() {
	}

	private int array[];
	private int swapCount;

	private void sort(int[] inputArr) {

		swapCount = 0;
		int length;
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			// Stop unnecessary executing the function quickSort() if count of swapping is greater than 1...
			if (i <= j && array[i] > array[j] && ++swapCount > 1) {
				return;
			}
			// ...otherwise, continue executing quicksort() function
			else if (i <= j) {
				exchangeNumbers(i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex);
		}
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public boolean solution(int[] A) {
		sort(A);
		return swapCount <= 1;
	}
}