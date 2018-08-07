import static java.lang.Math.*;

class Task2 {
	Task2() {
	}

	int solution(int A, int B) {
		int counter = 0;
		for (double i = A; i <= B; i++) {
			if ((sqrt(i) % 1) == 0) {
				counter++;
			}
		}
		return counter;
	}
}