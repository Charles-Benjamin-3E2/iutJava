package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

import edu.iut.app.ApplicationSession;

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	protected JSpinner annee;
	protected JComboBox mois, jour;
	
	
	
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {
		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		
		/** EX3: REMPLACEMENT DU BOUTON NEXT */
		
		String[] months = ApplicationSession.instance().getMonths();
		String[] jours = ApplicationSession.instance().getDays();
		 
		annee= new JSpinner(new SpinnerNumberModel(2015,2010 ,2020,1)); 
		mois = new JComboBox(ApplicationSession.instance().getMonths());
		jour = new JComboBox(ApplicationSession.instance().getDays());
		
		Calendar calendar = Calendar.getInstance();
		selectedYear = calendar.get(Calendar.YEAR); 
		selectedMonth = calendar.get(Calendar.MONTH); 
		selectedDay = calendar.get(Calendar.DAY_OF_MONTH); 
		
		mois.setSelectedItem(months[selectedMonth]);
		jour.setSelectedItem(jours[selectedDay]);
		
		this.add(jour);
		this.add(mois);
		this.add(annee);
	}
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
