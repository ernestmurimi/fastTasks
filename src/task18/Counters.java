package task18;

class Counters {
	private int[] counters;
	private int maxCounter = 0;

	Counters(int numberOfCounters) {
		counters = new int[numberOfCounters];
	}

	void increaseSingleCounter(int index) {
		if (index < counters.length) {
			int increasedCounter = ++counters[index];
			if (increasedCounter > maxCounter) {
				maxCounter = increasedCounter;
			}
		}
	}

	void setAllCountersToMax() {
		for (int i = 0; i < counters.length; i++) {
			counters[i] = maxCounter;
		}
	}

	int[] getCounters() {
		int[] countersCopy = new int[counters.length];
		System.arraycopy(counters, 0, countersCopy, 0, countersCopy.length);
		return countersCopy;
	}

	int getNumberOfCounters() {
		return counters.length;
	}
}
