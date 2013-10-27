/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. 
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

		Color color = Color.black;
		
		/* multiple entries will have different colors */
		switch (colorCount++ % 4) {
		case 0:
			color = Color.black;
			break;
		case 1:
			color = Color.RED;
			break;
		case 2:
			color = Color.blue;
			break;
		case 3:
			color = Color.magenta;

		}
		/*
		based on the ranks, calculated a series of position where name and plot should be placed
		*/

		for (int i = 0; i < NDECADES; i++) {
			int rank = entry.getRank(1900 + i * 10);
			GLabel name;
			if (rank != 0) {
				name = new GLabel(entry.getName() + Integer.toString(rank),
						getWidth() / NDECADES * i + 2, rank / 1000.0
								* (getHeight() - 2 * GRAPH_MARGIN_SIZE)
								+ GRAPH_MARGIN_SIZE);
			}
			/*
			if the input of name is not present in the most popular 1000 names, placed it as 1000th and marked with '*'
			*/
			else {
				rank = 1000;
				name = new GLabel(entry.getName() + "*", getWidth() / NDECADES * i
						+ 2, getHeight() - GRAPH_MARGIN_SIZE);
			}
			name.setColor(color);
			add(name);
			
			/* add curve for the plot*/
			
			if (i < 10) {
				int nextRank = entry.getRank(START_DECADE+ (i + 1) * 10);
				if (nextRank == 0) {
					nextRank = 1000;
				}
				GLine line = new GLine(getWidth() / NDECADES * i + 2, rank / 1000.0
						* (getHeight() - 2 * GRAPH_MARGIN_SIZE)
						+ GRAPH_MARGIN_SIZE, getWidth() / NDECADES * (i + 1) + 2,
						nextRank / 1000.0
								* (getHeight() - 2 * GRAPH_MARGIN_SIZE)
								+ GRAPH_MARGIN_SIZE);
				line.setColor(color);
				add(line);
			}
		}
	}

	/**
	 * Updates the display image by deleting all the graphical objects from the
	 * canvas and then reassembling the display according to the list of
	 * entries. Your application must call update after calling either clear or
	 * addEntry; 
	 */
	public void update() {
		removeAll();
		addLines();
		}
		
	/* initiation by adding all scaffolding elements*/

	private void addLines() {
		GLine[] line = new GLine[NDECADES+2];
		for (int i = 0; i < NDECADES; i++) {

			line[i] = new GLine(getWidth() / NDECADES * i, 0, getWidth() / NDECADES * i,
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
		for (int i = 0; i < NDECADES; i++) {
			String year = Integer.toString(START_DECADE+ i * 10);
			label[i] = new GLabel(year, getWidth() / NDECADES * i + 2,
					getHeight() - 5);
			add(label[i]);
		}
	}

	private int colorCount;
	private NameSurferEntry entry;

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
