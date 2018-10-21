package exceptions;

public class ThereIsNoPrimeNumbers extends Exception {
	public ThereIsNoPrimeNumbers() {
	}

	public ThereIsNoPrimeNumbers(String message) {
		super(message);
	}
}
