import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import acm.util.ErrorException;
import java.io.FileReader;
import acm.util.*;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {

	/* Constructor: NameSurferDataBase(filename) */
	/**
	 * Creates a new NameSurferDataBase and initializes it using the data in the
	 * specified file. The constructor throws an error exception if the
	 * requested file does not exist or if an error occurs as the file is being
	 * read.
	 */
	public NameSurferDataBase(String filename) {
				
		try {
			BufferedReader rd = getFileToRead(filename);

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				System.out.println(line);
				NameSurferEntry entry = new NameSurferEntry(line);
				pool.add(entry);
			}
			
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	/* Method: findEntry(name) */
	/**
	 * Returns the NameSurferEntry associated with this name, if one exists. If
	 * the name does not appear in the database, this method returns null.
	 */
	public NameSurferEntry findEntry(String name) {
	
		for (int i=0; i< pool.size();i++){
			if (pool.get(i).getName().toUpperCase().equals(name.toUpperCase()))
				return pool.get(i);
		}
		return null;
	}

	private BufferedReader getFileToRead(String filename) {

		BufferedReader rd = null;
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				System.out.println("Can't open that file.");
				break;
			}
		}
		return rd;
	}
	ArrayList<NameSurferEntry> pool = new ArrayList<NameSurferEntry>();
	
}
