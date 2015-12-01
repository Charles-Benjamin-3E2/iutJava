package edu.iut.app;

import java.util.ArrayList;
import java.util.List;

public class CriteriaClassroom implements Criteria{
	private Classroom critere;
	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> lesExam) throws NullPointerException{
		// TODO Auto-generated method stub
		if(critere==null){
			NullPointerException ex=new NullPointerException();
			throw ex;
		}
		List<ExamEvent> ok = new ArrayList<ExamEvent>(); 
		for (ExamEvent exam : lesExam) {
	         if(exam.getClassroom().equals(critere)){
	            ok.add(exam);
	         }
	      }
		return ok;
	}
	public Classroom getCritere() {
		return critere;
	}
	public void setCritere(Classroom critere) {
		this.critere = critere;
	}
}