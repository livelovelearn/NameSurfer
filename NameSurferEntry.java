/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears in the data
	 * file. Each line begins with the name, which is followed by integers
	 * giving the rank of that name for each decade.
	 * 
	 */
	public NameSurferEntry(String line) {
		int current = 0;
		rank = new int[NDECADES];

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ') {
				current = i;
				name = line.substring(0, i);
				break;
			}
		}

		for (int i = 0; i < NDECADES-1; i++) {
			String srank = "";
			for (int j = current + 1; j < line.length(); j++) {
				if (line.charAt(j) != ' ') {
					srank += line.charAt(j);
				} else {
					current = j;
					rank[i] = Integer.parseInt(srank);
					break;
				}
			}
		}
		rank[NDECADES-1] = Integer.parseInt(line.substring(current+1));
	}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular decade. The
	 * decade value is an integer indicating how many decades have passed since
	 * the first year in the database, which is given by the constant
	 * START_DECADE. If a name does not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		int a = (decade - START_DECADE) / 10;
		return rank[a];
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */

	public String toString() {
		String a = name + " [" ;
		for (int i =0; i< NDECADES; i++){
			a = a + " " + rank[i];}
		
			//	+ rank[3] + " " + rank[4] + " " + rank[5] + " " + rank[6] + " "
			//	+ rank[7] + " " + rank[8] + " " + rank[9] + " " + rank[10] + "]");
			 return (a + "]");
			 }

	private String name;
	private int[] rank;

}
