package edu.iut.app;

import java.util.LinkedList;

public class Agenda extends LinkedList<ExamEvent> {
	public Agenda() {		
	}
	
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
}
