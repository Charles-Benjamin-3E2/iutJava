package edu.iut.tools;

import java.util.Locale;

import edu.iut.app.CommandLineOption;
import edu.iut.app.CommandLineParser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class IUTScheduler {
	public static void main(String[] args) {
		Locale.setDefault(Locale.FRANCE);
		CommandLineParser commandLineParser = new CommandLineParser();
		CommandLineOption<java.io.File> configOption = new CommandLineOption<java.io.File>(CommandLineOption.OptionType.FILE, "config","configuration file",new java.io.File("/tmp"));
		commandLineParser.addOption(configOption);
		commandLineParser.parse(args);
		System.err.println("Option:"+commandLineParser.getOption("config").getValue());
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        JFrame mainFrame = new edu.iut.gui.frames.SchedulerFrame("IUT Scheduler");
		        mainFrame.setVisible(true);		        
		    }
		});
	}
	
}
