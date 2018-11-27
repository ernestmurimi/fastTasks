package task3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] arr = {7, 3, 7, 3, 1, 3, 4, 1};
		System.out.println(obj.solution(arr));
	}

	public Solution() {
		allDiffLocations = new HashMap<>();
	}

	private Map<Integer, Boolean> allDiffLocations;

	private void excludeDifferentLocations(int[] locations) {
		for (int curr : locations) {
			if (!allDiffLocations.containsKey(curr)) {
				allDiffLocations.put(curr, false);
			}
		}
	}

	private void markLocationAsVisited(int location) {
		allDiffLocations.put(location, true);
	}

	private boolean isLocationVisited(int location) {
		if (allDiffLocations.containsKey(location)) {
			return allDiffLocations.get(location);
		}
		return false;
	}

	private boolean isAllLocationsVisited() {
		for (Map.Entry<Integer, Boolean> curr : allDiffLocations.entrySet()) {
			if (!curr.getValue()) {
				return false;
			}
		}
		return true;
	}

	private void rollbackAllVisitingMarks() {
		for (Map.Entry<Integer, Boolean> curr : allDiffLocations.entrySet()) {
			curr.setValue(false);
		}
	}

	public int solution(int[] A) {
		excludeDifferentLocations(A);
		int shortestRoad = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				if (!isLocationVisited(A[j])) {
					markLocationAsVisited(A[j]);
					if (isAllLocationsVisited()) {
						if (j - i + 1 < shortestRoad) {
							shortestRoad = j - i + 1;
						}
						rollbackAllVisitingMarks();
						break;
					}
				}
			}
		}
		return shortestRoad;
	}
}