import java.io.*;

public class htmlReader {
	
	private BufferedReader reader_;
	public String [] lines_;
	private int numLines_ = -1;
	
	public htmlReader(String filename) throws IOException {	
		reader_ = new BufferedReader(new FileReader(filename + ".htm")); // open file

		numLines_ = 0; // initialize numLines_ to 0
		while (reader_.readLine() != null) numLines_++; // count lines
		
		lines_ = new String[numLines_]; // allocate lines_ array using numLines_
		
		reader_ = new BufferedReader(new FileReader(filename + ".htm")); // re-open file to reset reader_
				
		for(int i = 0; i < lines_.length; i++) lines_[i] = reader_.readLine(); // assign each line to position in array using reader_
		
		reader_.close();
	}
	
	public String[] getLines() {
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

	}

}
