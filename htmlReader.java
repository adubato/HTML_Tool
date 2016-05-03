/** A class used to read html files elements in Java. 
 ** @author Michael Adubato **/
import java.io.*;
import java.util.*;

public class htmlReader {
	
	private Scanner scanner_;
	private List<String []> lines_;
	
	private List<element> elements_;
	
	public htmlReader(String filename) throws IOException {
		
		File file = new File(filename + ".htm");
		
		scanner_ = new Scanner(file); // open file
		
		lines_ = new ArrayList<String[]>();	
		
		
		while(scanner_.hasNextLine()) {
			if(scanner_.nextLine().contains("</head>")) {
				while(scanner_.hasNextLine()){
					lines_.add(scanner_.nextLine().trim().split("<|>"));
				}
			}
		}
	
		
		scanner_.close();
		
		parseElements(lines_);
	}
	
	private void parseElements(List<String []> lines) {		
		for(String [] line : lines) {
			if(line.length > 1) {
				
			}
		}
	}
	
	public List<String []> getLines() {
		return lines_;
	}
	
	public String [] getLineAtIndex(int index) {
		try { return lines_.get(index); }
		catch(ArrayIndexOutOfBoundsException e) { return null; }
	}

	public static void main(String[] args) throws IOException {
		
		htmlReader r = new htmlReader("ExampleDomain");
		List<String []> lines = r.getLines();
		
		for(String [] s : lines)
			System.out.println(Arrays.toString(s));
	}

}
