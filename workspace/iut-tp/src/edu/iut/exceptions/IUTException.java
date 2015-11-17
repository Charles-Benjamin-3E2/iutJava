package edu.iut.exceptions;

import edu.iut.app.ApplicationSession;

// Exercice 2 
public class IUTException extends Exception /* étendre les exceptio, */{
	public IUTException() {
		super();
		ApplicationSession.instance().getExceptionLogger().warning("Erreur");

	}
	public IUTException(IUTException e) {
		super (e);
		ApplicationSession.instance().getExceptionLogger().warning(getMessage());
	}
	public IUTException(String message) {
		super(message);
		ApplicationSession.instance().getExceptionLogger().warning(getMessage());
	}
	
}
