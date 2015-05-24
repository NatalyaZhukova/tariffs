package by.zhukova.tariffs.exception;

public class TechnicalException extends Exception {
	
	public TechnicalException() {
		
	}
	
	public TechnicalException(String message) {
		
		super(message);
	}
	
	public TechnicalException(Throwable cause) {
		
		super(cause);
	}
	
	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}


}
