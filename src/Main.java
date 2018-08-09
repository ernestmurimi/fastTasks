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
			/*
			Algorithm:
			foreach(dzień z wycieczką)
				- pobieram pierwszą liczbę i zapisuję jej indeks
				while(istnieje następna liczba)
					- pobieram następną liczbę
					- sprawdzam odhaczenie liczby
						- jeśli odhaczona, to wykonuję kolejny obieg pętli
						- jeśli nie, to odhaczam i przechodzę do kolejnego kroku
					- sprawdzam czy wszystkie liczby są odhaczone
						- jeśli tak
							- zapisuję indeks ostatniej liczby
							- wyliczam i zapisuję długość drogi
							- cofam odhaczenie wszystkich liczb
						- jeśli nie, to wykonuję kolejny obieg pętli
				- jeśli nie wyliczono żadnej długości drogi, to przerywamy pętlę foreach
			- przechodzimy przez wszystkie długości dróg, jakie zapisaliśmy i wybieramy tą najkrótszą*/
			case "3": {

			}
		}
	}
}