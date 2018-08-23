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
		}
	}
}