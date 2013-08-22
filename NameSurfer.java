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
		JButton button1 = new JButton ("Graph");
		add(button1, NORTH);
		JButton button2 = new JButton ("Clear");
		add(button2, NORTH);
		addActionListeners();
		
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		String cmd = e.getActionCommand();
		if (cmd.equals("Graph"))
			println("graph");
		if (cmd.equals("Clear"))
			println("clear");
	}
}
