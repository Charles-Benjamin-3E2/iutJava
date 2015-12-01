package edu.iut.gui.frames;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;


public class SchedulerFrame extends JFrame implements ActionListener {
    JPanel contentPane;
    CardLayout layerLayout;
    AgendaPanelFactory agendaPanelFactory;    
    JPanel dayView;
    JPanel weekView;
    JPanel monthView;
    
    protected void setupUI() {
        
        contentPane = new JPanel();
        layerLayout = new CardLayout();
        contentPane.setLayout(layerLayout);
        ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
        agendaPanelFactory = new AgendaPanelFactory();
        dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
        weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
        monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);
        
        contentPane.add(dayView,ActiveView.DAY_VIEW.name());
        contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
        contentPane.add(monthView,ActiveView.MONTH_VIEW.name());
    
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
        this.setContentPane(splitPane);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;        
        JMenuItem file,edit,view,jour,semaine,mois,load,save,newMenu,help,display,about;
        
        /* File Menu */
        /** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP**/
        

        file = new JMenu("File");
        edit = new JMenu("Edit");
        help=new JMenu("Help");
    
        view = new JMenu("View");
        
        edit.add(view);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

       
        jour = new JMenuItem("Days");
        semaine = new JMenuItem("Weeks");
        mois = new JMenuItem("Months");
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        newMenu = new JMenuItem("New");
        display =new JMenuItem("Display");
        about=new JMenuItem("About");
        
        view.add(jour);
        view.add(semaine);        
        view.add(mois);
        
        file.add(newMenu);
        file.add(load);
        file.add(save);
        
        help.add(display);
        help.add(about);
    
        jour.addActionListener(this);
        semaine.addActionListener(this);
        mois.addActionListener(this);
        load.addActionListener(this);
        save.addActionListener(this);
        newMenu.addActionListener(this);
        
        this.setJMenuBar(menuBar);
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
        contentPane = null;
        dayView = null;
        weekView = null;
        monthView = null;
        agendaPanelFactory = null;
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        switch(e.getActionCommand())
        {
        case "Days" :      layerLayout.show(contentPane, ActiveView.DAY_VIEW.name()); break;
        case "Weeks" :     layerLayout.show(contentPane, ActiveView.WEEK_VIEW.name()); break;
        case "Months" :  layerLayout.show(contentPane, ActiveView.MONTH_VIEW.name()); break;
        default :  JOptionPane.showMessageDialog(this, "Fonctionnalité à venir", "Warning message", JOptionPane.WARNING_MESSAGE);break;
            
        
        }
    }
}

