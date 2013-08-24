/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas implements NameSurferConstants,
		ComponentListener {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {
		addComponentListener(this);
		// You fill in the rest //
	}

	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		

		// You fill this in //
	}

	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display. Note
	 * that this method does not actually draw the graph, but simply stores the
	 * entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		
	}

	/**
	 * Updates the display image by deleting all the graphical objects from the
	 * canvas and then reassembling the display according to the list of
	 * entries. Your application must call update after calling either clear or
	 * addEntry; update is also called whenever the size of the canvas changes.
	 */
	public void update() {
		removeAll();

		addLines();

	}

	private void addLines() {
		GLine[] line = new GLine[13];
		for (int i = 0; i < 11; i++) {

			line[i] = new GLine(getWidth()/ 11 * i, 0,
					APPLICATION_WIDTH / 11 * i, APPLICATION_HEIGHT);
			add(line[i]);
		}
		line[11] = new GLine(0, GRAPH_MARGIN_SIZE, APPLICATION_WIDTH,
				GRAPH_MARGIN_SIZE);
		add(line[11]);
		line[12] = new GLine(0, APPLICATION_HEIGHT - GRAPH_MARGIN_SIZE, APPLICATION_WIDTH, APPLICATION_HEIGHT - GRAPH_MARGIN_SIZE);
		add(line[12]);
		
		GLabel[] label = new GLabel[11];
		for (int i = 0; i < 11; i++) {
			String year = Integer.toString(1900+i*10);
			label[i] = new GLabel(year, APPLICATION_WIDTH / 11 * i+2, APPLICATION_HEIGHT-5);
			add(label[i]);
		}
	}

	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) {
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentResized(ComponentEvent e) {
		update();
	}

	public void componentShown(ComponentEvent e) {
	}
}
