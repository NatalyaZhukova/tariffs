package by.zhukova.tariffs.exception;

public class LogicalException extends Exception {
	
	

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
