package edu.iut.app;

import java.util.List;

public interface Criteria {
	public List<ExamEvent> meetCriteria(List<ExamEvent> persons);
}
