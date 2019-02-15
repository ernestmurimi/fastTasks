package task18;

import java.util.Arrays;

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
		Arrays.fill(counters, maxCounter);
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
