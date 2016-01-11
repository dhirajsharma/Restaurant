package system.restaurant.exception;

public class AppException extends Exception {
	
	private static final long serialVersionUID = -549896870397689366L;

	public AppException(String msg) {
		super(msg);
	}
	
	public AppException (String msg, Throwable cause) {
		super(msg, cause);
	}
}
