package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;


public class SchedulerFrame extends JFrame {
	
	protected void setupUI() {
		JPanel contentPane = new JPanel();
		CardLayout layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		AgendaPanelFactory agendaPanelFactory = new AgendaPanelFactory();
		contentPane.add(agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW),ActiveView.DAY_VIEW.name());
		contentPane.add(agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW),ActiveView.WEEK_VIEW.name());
		contentPane.add(agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW),ActiveView.MONTH_VIEW.name());		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
		this.setContentPane(splitPane);
		
		this.pack();
		layerLayout.next(contentPane);
	}
	
	public SchedulerFrame() {
		super();
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();

	}
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();
	}
	
}
