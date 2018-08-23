package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
	//private List<LocationForVacation> allDiffLocations;
	private Map<Integer, Boolean> allDiffLocations;
	//private List<Integer> allRoadsLengths;

	public Task3() {
		allDiffLocations = new HashMap<>();
		//allRoadsLengths = new ArrayList<>();
	}

	/*private boolean isLocationInListOfLocations(List<LocationForVacation> locations, int singleLocation) {
		for (LocationForVacation curr : locations) {
			if (curr.getLocation() == singleLocation) {
				return true;
			}
		}
		return false;
	}*/

	private void excludeDifferentLocations(int[] locations) {
		/*for (int curr : locations) {
			if (!isLocationInListOfLocations(allDiffLocations, curr)) {
				allDiffLocations.add(new LocationForVacation(curr));
			}
		}*/
		for (int curr : locations) {
			if (!allDiffLocations.containsKey(curr)) {
				allDiffLocations.put(curr, false);
			}
		}
	}

	private void markLocationAsVisited(int location) {
		allDiffLocations.put(location, true);
		/*for (LocationForVacation curr : allDiffLocations) {
			if (curr.getLocation() == location && !curr.isVisited()) {
				curr.setVisited(true);
			}
		}*/
	}

	private boolean isLocationVisited(int location) {
		if (allDiffLocations.containsKey(location)) {
			return allDiffLocations.get(location);
		}
		return false;
		/*for (LocationForVacation curr : allDiffLocations) {
			if (curr.getLocation() == location) {
				return curr.isVisited();
			}
		}
		return false;*/
	}

	private boolean isAllLocationsVisited() {
		for (Map.Entry<Integer, Boolean> curr : allDiffLocations.entrySet()) {
			if (!curr.getValue()) {
				return false;
			}
		}
		return true;
		/*for (LocationForVacation curr : allDiffLocations) {
			if (!curr.isVisited()) {
				return false;
			}
		}
		return true;*/
	}

	private void rollbackAllVisitingMarks() {
		for (Map.Entry<Integer, Boolean> curr : allDiffLocations.entrySet()) {
			curr.setValue(false);
		}
		/*for (LocationForVacation curr : allDiffLocations) {
			curr.setVisited(false);
		}*/
	}

	/*private int theShortestRoad() {
		if (allRoadsLengths.size() == 0) {
			return 0;
		}
		int shortestRoad = allRoadsLengths.get(0);
		for (int i = 1; i < allRoadsLengths.size(); i++) {
			if (allRoadsLengths.get(i) < shortestRoad) {
				shortestRoad = allRoadsLengths.get(i);
			}
		}
		return shortestRoad;
	}*/

	public int solution(int[] A) {
		excludeDifferentLocations(A);
		Integer shortestRoad = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			//Integer currRoadLength = null;
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

	public int solution2(int[] A) {
		return 0;
	}
}