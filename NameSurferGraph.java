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
		// update();
	}

	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		update();
	}

	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display. Note
	 * that this method does not actually draw the graph, but simply stores the
	 * entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		
		/*switch (color++%4){
					case 0: rect.setFillColor(Color.RED);
					break;
					case 1: rect.setFillColor(Color.RED);
					break;
					case 2: rect.setFillColor(Color.ORANGE);
					break;
					case 3: rect.setFillColor(Color.ORANGE);
					break;
					}*/

		for (int i = 0; i < 11; i++) {
			int rank = entry.getRank(1900+i*10);
			GLabel name = new GLabel(entry.getName()+Integer.toString(rank), getWidth() / 11 * i + 2, rank/1000*getHeight());
			add(name);
		}
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

			line[i] = new GLine(getWidth() / 11 * i, 0, getWidth() / 11 * i,
					getHeight());
			add(line[i]);
		}
		line[11] = new GLine(0, GRAPH_MARGIN_SIZE, getWidth(),
				GRAPH_MARGIN_SIZE);
		add(line[11]);
		line[12] = new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(),
				getHeight() - GRAPH_MARGIN_SIZE);
		add(line[12]);

		GLabel[] label = new GLabel[11];
		for (int i = 0; i < 11; i++) {
			String year = Integer.toString(1900 + i * 10);
			label[i] = new GLabel(year, getWidth() / 11 * i + 2,
					getHeight() - 5);
			add(label[i]);
		}
	}

	private int color;/* Implementation of the ComponentListener interface */
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
