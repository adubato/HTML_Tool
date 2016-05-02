/** A class used to read html files elements in Java. 
 ** @author Michael Adubato **/
import java.io.*;
import java.util.*;

public class htmlReader {
	
	private BufferedReader reader_;
	private String [] lines_;
	private int numLines_ = -1;
	
	private List<element> elements_;
	
	public htmlReader(String filename) throws IOException {	
		try { reader_ = new BufferedReader(new FileReader(filename + ".htm")); } // open file
		catch(FileNotFoundException e) { reader_ = new BufferedReader(new FileReader(filename + ".html")); }

		numLines_ = 0; // initialize numLines_ to 0
		while (reader_.readLine() != null) numLines_++; // count lines
		
		lines_ = new String[numLines_]; // allocate lines_ array using numLines_
		
		try { reader_ = new BufferedReader(new FileReader(filename + ".htm")); } // re-open file to reset reader_
		catch(FileNotFoundException e) { reader_ = new BufferedReader(new FileReader(filename + ".html")); }
		
		for(int i = 0; i < lines_.length; i++) lines_[i] = reader_.readLine(); // assign each line to position in array using reader_
		
		reader_.close();
		
		parseElements(lines_);
	}
	
	private void parseElements(String [] lines) {		
		for(String line : lines) {

		}
	}
	
	public String [] getLines() {
		return lines_;
	}
	
	public String getLineAtIndex(int index) {
		try { return lines_[index]; }
		catch(ArrayIndexOutOfBoundsException e) { return e.toString(); }
	}
	
	public int getNumLines() {
		return numLines_;
	}

	public static void main(String[] args) throws IOException {
		
		htmlReader r = new htmlReader("ExampleDomain");
		String [] lines = r.getLines();
		
		for(String s : lines)
			System.out.println(s);
		
		System.out.println(r.getNumLines());
		System.out.println(r.getLineAtIndex(50));
		
		htmlReader r2 = new htmlReader("ExampleDomain_COPY");
		lines = r.getLines();
		
		for(String s : lines)
			System.out.println(s);
		
		System.out.println("r2 " + r2.getNumLines());
		System.out.println("r2 " + r2.getLineAtIndex(12));

	}

}
