package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;

public class ExamEvent {
	public ExamEvent() {		
	}
	
	public ExamEvent(Date date, Person person, ArrayList<Person> jury,
					Classroom classRoom, ArrayList<Document> document) {
		
	}
	
	public void setDate(Date date) {
		this.examDate = date;
	}
	
	public Date getDate() {
		return examDate;
	}
	
	public void setStudent(Person student) {
		this.student = student;
	}
	public Person getStudent() {
		return student;
	}
	
	public void setJury(ArrayList<Person> jury) {
		this.jury = jury;
	}
	public ArrayList<Person> getJury() {
		return jury;
	}
	
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	
	
	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	

	protected Date examDate;
	protected Person student;
	protected ArrayList<Person> jury;
	protected Classroom classroom;
	protected ArrayList<Document> documents;
	 
}
