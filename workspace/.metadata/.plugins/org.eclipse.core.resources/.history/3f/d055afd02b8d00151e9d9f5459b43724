package edu.iut.gui.widget.agenda;

import java.awt.GridLayout;
import javax.swing.JPanel;


import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.app.ApplicationSession;

public class WeekPanel extends EventPanel {

	// Exercice 4
	public enum WeekDayNames {
		EMPTYDAY("",""),
		MONDAY(/* Internationalisation */),
		TUESDAY(/* Internationalisation */),
		WEDNESDAY(/* Internationalisation */),
		THURSDAY(/* Internationalisation */),
		FRIDAY(/* Internationalisation */),
		SATURDAY(/* Internationalisation */),
		SUNDAY(/* Internationalisation */);
		
		private String name;
		private String shortName;
		
		WeekDayNames(String name,String shortName) {
			this.name = name;
			this.shortName = shortName;
		}
		
		public String getShortName() {
			return shortName;
		}
		
		public String toString() {
			return name;
		}
	}
	
	public WeekPanel() {
		super(ActiveView.WEEK_VIEW);
		GridLayout daysOfWeekLayout = new GridLayout(1,7);		
		this.setLayout(daysOfWeekLayout);
		for (int di = 0;di<8;di++)	{
			this.add(new DayPanel(ActiveView.WEEK_VIEW,WeekDayNames.values()[di+1]));
		}
	}
}
