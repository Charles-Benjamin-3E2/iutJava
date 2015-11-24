package edu.iut.app;

import java.util.ArrayList;
import java.util.List;

public class CriteriaStudent implements Criteria{
	private Person critere;
	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> lesExam) throws NullPointerException{
		// TODO Auto-generated method stub
		if(critere==null){
			NullPointerException ex=new NullPointerException();
			throw ex;
		}
		List<ExamEvent> ok = new ArrayList<ExamEvent>();
		for (ExamEvent exam : lesExam) {
	         if(exam.getStudent().equals(critere)){
	            ok.add(exam);
	         }
	      }
		return ok;
	}
	public Person getCritere() {
		return critere;
	}
	public void setCritere(Person critere) {
		this.critere = critere;
	}
}
