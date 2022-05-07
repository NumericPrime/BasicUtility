package ProcessingUtils.error;

public class PException {
	public PException() {
		// TODO Auto-generated constructor stub
	}
	public static void customException(String message) {
		throw new CustomException(message);
	}
	public static void customException() {
		throw new CustomException();
	}
}
