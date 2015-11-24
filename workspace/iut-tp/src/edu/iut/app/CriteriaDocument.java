package edu.iut.app;

import java.util.ArrayList;
import java.util.List;

public class CriteriaDocument implements Criteria{
	private Document critere;
	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> lesExam) throws NullPointerException{
		// TODO Auto-generated method stub
		if(critere==null){
			NullPointerException ex=new NullPointerException();
			throw ex;
		}
		List<ExamEvent> ok = new ArrayList<ExamEvent>();
		for (ExamEvent exam : lesExam) {
	         if(exam.getDocuments().equals(critere)){
	            ok.add(exam);
	         }
	      }
		return ok;
	}
	public Document getCritere() {
		return critere;
	}
	public void setCritere(Document critere) {
		this.critere = critere;
	}
}
