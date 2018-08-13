import task3.Task3;

public class Main {

	public static void main(String[] args) {
		switch (args[0]) {
			case "1": {
				Task1 task1 = new Task1();
				System.out.println(task1.solution("Forget CVs..Save time . x x"));
				break;
			}
			case "2": {
				Task2 task2 = new Task2();
				System.out.println(task2.solution(4, 17));
				break;
			}
			case "3": {
				Task3 task3 = new Task3();
				int[] arr = {7, 3, 7, 3, 1, 3, 4, 1};

				int numberOfSamples = 100000;
				long startTime, stopTime;
				long sum1 = 0L;
				long sum2 = 0L;

				for (int i = 0; i < numberOfSamples; i++) {
					startTime = System.nanoTime();
					task3.solution(arr);
					stopTime = System.nanoTime();
					sum1 += stopTime - startTime;

					startTime = System.nanoTime();
					task3.solution2(arr);
					stopTime = System.nanoTime();
					sum2 += stopTime - startTime;
				}
				System.out.println("Implementation #1: " + sum1 / (float) numberOfSamples + " nanoseconds");
				System.out.println("Implementation #2: " + sum2 / (float) numberOfSamples + " nanoseconds");

				break;
			}
		}
	}
}