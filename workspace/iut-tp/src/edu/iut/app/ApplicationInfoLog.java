package edu.iut.app;

public class ApplicationInfoLog extends AbstractApplicationLog {
	protected ArrayList<IApplicationLogListener> listeners;
	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationInfoLog() {
		super();
	}
	
	@Override
	public void setMessage(String message) {
		for(int cpt=0;cpt<listeners.size();cpt++){
			listeners.get(cpt).newMessage("level",message)
		}
		this.message = message;
        super.fireMessage("[INFO]", this.message);
	}

}
