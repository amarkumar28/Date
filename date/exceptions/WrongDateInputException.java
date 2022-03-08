package date.exceptions;

public class WrongDateInputException extends RuntimeException {
	private static final long serialVersionUID = 8332019537196371281L;

	public WrongDateInputException(String message) {
		System.out.println("Please enter correct " + message);
	}
	
}
