package by.zhukova.tariffs.exception;

public class LogicalException extends Exception {
	
	public static final String CANNOT_BE_NEGATIVE = "Value can't be negative";

	public LogicalException() {
		
	}
	
	public LogicalException(String message) {
		
		super(message);
	}
	
	public LogicalException(Throwable exception) {
		
		super(exception);
	}
	
	public LogicalException(String message, Throwable exception) {
		super(message, exception);
	}

}
