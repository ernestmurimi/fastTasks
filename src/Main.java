import java.util.Arrays;

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
				System.out.println(task3.solution(arr));
				break;
			}
			case "4": {
				Task4 task4 = new Task4();
				int[] arr = {2, 2, 2, 2, 1, 2, -1, 2, 1, 3};
				System.out.println(task4.solution(arr));
				break;
			}
			case "5": {
				Task5 task5 = new Task5();
				int[] arr = {1, 5, 3, 3, 7};
				System.out.println(task5.solution(arr));
				break;
			}
			case "6": {
				Task6 task6 = new Task6();
				int[] arr = task6.solution(5);
				System.out.println(Arrays.toString(arr));
				break;
			}
			case "7": {
				Task7 task7 = new Task7();
				System.out.println(task7.compressing("abbccc"));
				break;
			}
		}
	}
}