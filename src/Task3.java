import java.util.ArrayList;
import java.util.List;

class Task3 {
	private List<LocationForVacation> allDiffLocations;
	private List<Integer> allRoadsLengths;

	Task3() {
		allDiffLocations = new ArrayList<>();
		allRoadsLengths = new ArrayList<>();
	}

	private boolean isLocationInListOfLocations(List<LocationForVacation> locations, int singleLocation) {
		for (LocationForVacation curr : locations) {
			if (curr.getLocation() == singleLocation) {
				return true;
			}
		}
		return false;
	}

	private void excludeDifferentLocations(int[] locations) {
		for (int curr : locations) {
			if (!isLocationInListOfLocations(allDiffLocations, curr)) {
				allDiffLocations.add(new LocationForVacation(curr));
			}
		}
	}

	private void markLocationAsVisited(int location) {
		for (LocationForVacation curr : allDiffLocations) {
			if (curr.getLocation() == location && !curr.isVisited()) {
				curr.setVisited(true);
			}
		}
	}

	private boolean isLocationVisited(int location) {
		for (LocationForVacation curr : allDiffLocations) {
			if (curr.getLocation() == location) {
				return curr.isVisited();
			}
		}
		return false;
	}

	private boolean isAllLocationsVisited() {
		for (LocationForVacation curr : allDiffLocations) {
			if (!curr.isVisited()) {
				return false;
			}
		}
		return true;
	}

	private void rollbackAllVisitingMarks() {
		for (LocationForVacation curr : allDiffLocations) {
			curr.setVisited(false);
		}
	}

	private int theShortestRoad() {
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
	}

	/*
	Algorithm:
		foreach(dzień z wycieczką)
			- pobieram pierwszą liczbę i zapisuję jej indeks
			while(istnieje następna liczba)
				- pobieram następną liczbę
				- sprawdzam odhaczenie liczby
					- jeśli odhaczona, to wykonuję kolejny obieg pętli while
					- jeśli nie, to odhaczam i przechodzę do kolejnego kroku
				- sprawdzam czy wszystkie liczby są odhaczone
					- jeśli tak
						- zapisuję indeks ostatniej liczby
						- wyliczam i zapisuję długość drogi
						- cofam odhaczenie wszystkich liczb
					- jeśli nie, to wykonuję kolejny obieg pętli while
			- jeśli nie wyliczono żadnej długości drogi, to przerywamy pętlę foreach
		- przechodzimy przez wszystkie długości dróg, jakie zapisaliśmy i wybieramy tą najkrótszą
	*/

	int solution(int[] A) {
		excludeDifferentLocations(A);
		for (int i = 0; i < A.length; i++) {
			Integer currRoadLength = null;
			markLocationAsVisited(A[i]);
			if (isAllLocationsVisited()) {
				currRoadLength = i + 1;
				allRoadsLengths.add(currRoadLength);
				rollbackAllVisitingMarks();
				break;
			}
			for (int j = i + 1; j < A.length; j++) {
				if (!isLocationVisited(A[j])) {
					markLocationAsVisited(A[j]);
					if (isAllLocationsVisited()) {
						currRoadLength = j - i + 1;
						allRoadsLengths.add(currRoadLength);
						rollbackAllVisitingMarks();
						break;
					}
				}
			}
			if (currRoadLength == null) {
				break;
			}
		}
		return theShortestRoad();
	}
}