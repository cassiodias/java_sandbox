package br.com.hoepers.webtest.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Classe responsável em especializar as exceções lançadas para a aplicação FIERGS.
 * @author IMMEDIATE - Cássio Dias
 *
 */
public class WebTestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Throwable cause;

	public WebTestException() {
		super();
	}

	public String getMessage() {
		String msg = super.getMessage();
		if (msg == null)
			msg = "";
		if (msg.indexOf(':') >= 0)
			msg = msg.substring(msg.lastIndexOf(':'));
		return msg.trim();
	}

	public WebTestException(String message) {
		super(message);
	}

	public WebTestException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
		if (cause != null)
			cause.printStackTrace();
	}

	public WebTestException(Throwable cause) {
		super(cause != null ? cause.getMessage() : "");
		this.cause = cause;
		if (cause != null)
			cause.printStackTrace();
	}

	public void printStackTrace() {
		if (cause != null && cause != this)
			cause.printStackTrace();
		super.printStackTrace();
	}

	public void printStackTrace(PrintStream s) {
		if (cause != null && cause != this)
			cause.printStackTrace(s);
		super.printStackTrace(s);
	}

	public void printStackTrace(PrintWriter s) {
		if (cause != null && cause != this)
			cause.printStackTrace(s);
		super.printStackTrace(s);
	}
}