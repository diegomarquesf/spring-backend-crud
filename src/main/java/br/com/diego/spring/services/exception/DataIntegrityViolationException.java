package br.com.diego.spring.services.exception;

public class DataIntegrityViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String msg) {
		super(msg); //super classe RuntimeException
	}
	
	public DataIntegrityViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
