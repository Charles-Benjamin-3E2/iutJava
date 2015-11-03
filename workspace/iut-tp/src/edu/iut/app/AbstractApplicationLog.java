package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	/** TP1 : Tableau au sens des collections **/
	protected /*TYPE TABLEAU*/ listeners;
	
	public AbstractApplicationLog() {
		message = null;
		listeners = new /*TYPE TABLEAU*/();
	}
	
    /** TP1 : Fonction venant de l'interface par héritage */


	/** Listener action */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}
