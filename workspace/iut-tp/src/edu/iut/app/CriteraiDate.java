package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CriteraiDate implements Criteria{
	private Date critere;
	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> lesExam) throws NullPointerException{
		// TODO Auto-generated method stub
		if(critere==null){
			NullPointerException ex=new NullPointerException();
			throw ex;
		}
		List<ExamEvent> ok = new ArrayList<ExamEvent>(); 
		for (ExamEvent exam : lesExam) {
	         if(exam.getExamDate().equals(critere)){
	            ok.add(exam);
	         }
	      }
		return ok;
	}
	public Date getCritere() {
		return critere;
	}
	public void setCritere(Date critere) {
		this.critere = critere;
	}
}
