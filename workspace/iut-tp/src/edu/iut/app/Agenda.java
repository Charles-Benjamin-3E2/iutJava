package edu.iut.app;

import java.util.ArrayList;

public class Agenda extends ArrayList<ExamEvent>/* EX2: COLLECTION d'ExamEvent */ {
	public Agenda() {		
	}
	
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
}
