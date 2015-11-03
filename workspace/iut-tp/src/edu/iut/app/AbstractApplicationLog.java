package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {
	
	protected ArrayList<IApplicationLogListener> listeners;
	protected String message;
	/** TP1 : Tableau au sens des collections **/
	protected /*TYPE TABLEAU*/ listeners;
	
	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList();
	}
	
    /** TP1 : Fonction venant de l'interface par héritage */
	abstract void setMessage(String message);
	public void addIApplicationLogListener(IApplicationLogListener appli){
		listeners.add(appli);
	}
	public getIApplicationLogListener(){
		return listeners;
	}
	/** Listener action */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}
