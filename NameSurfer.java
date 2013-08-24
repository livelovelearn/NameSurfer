/*
 * File: NameSurfer.java

 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the top of the window.
 */
	
	public void init() {
	    // You fill this in, along with any helper methods //
		
		//NSD = new NameSurferDataBase("names-data.txt");
		add(new JLabel("Name"), NORTH);
		add(nameField, NORTH);
		add(new JButton ("Graph"), NORTH);
		add(new JButton ("Clear"), NORTH);
		NameSurferEntry NSE1 = new NameSurferEntry ("AA 1 2 3 4 5 5 7 8 9 10 11");
		System.out.println(NSE1.toString());
		addActionListeners();
		
		
		//NSE = NSD.findEntry(nameField.getText());
		
		
		
		
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		
		
		String cmd = e.getActionCommand();
		String name = nameField.getText();
		
		
		if (cmd.equals("Graph"))
			println("Name you entered " + name);// + NSE.getRank(0));
		if (cmd.equals("Clear"))
			println("clear");
	}
	private JTextField nameField = new JTextField(20);
	private NameSurferDataBase NSD;
	private NameSurferEntry NSE;


}
