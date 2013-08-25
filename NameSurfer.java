/*
 * File: NameSurfer.java

 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base and
	 * initializing the interactors at the top of the window.
	 */

	public void init() {
		// You fill this in, along with any helper methods //

		NSD = new NameSurferDataBase(NAMES_DATA_FILE);
		add(new JLabel("Name"), NORTH);
		nameField = new JTextField(20);
		add(nameField, NORTH);
		add(new JButton("Graph"), NORTH);
		add(new JButton("Clear"), NORTH);
		graph = new NameSurferGraph();
		add(graph);
		// graph.update();
		addActionListeners();

	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are clicked, so
	 * you will have to define a method to respond to button actions.
	 */
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		if (e.getSource()==nameField){
			//println(nameField.getText());
			NSE = NSD.findEntry(nameField.getText());
			if (NSE != null)
				graph.addEntry(NSE);
		}
		if (cmd.equals("Graph")) {
			NSE = NSD.findEntry(nameField.getText());
			if (NSE != null)
				graph.addEntry(NSE);
		}
		if (cmd.equals("Clear"))
			graph.clear();
	}

	private JTextField nameField;
	private NameSurferDataBase NSD;
	private NameSurferEntry NSE;
	private NameSurferGraph graph;

}
