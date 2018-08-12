package task3;

class LocationForVacation {
	private int location;
	private boolean visited;

	LocationForVacation() {
	}

	LocationForVacation(int location) {
		this.location = location;
		this.visited = false;
	}

	int getLocation() {
		return location;
	}

	void setLocation(int location) {
		this.location = location;
	}

	boolean isVisited() {
		return visited;
	}

	void setVisited(boolean visited) {
		this.visited = visited;
	}
}