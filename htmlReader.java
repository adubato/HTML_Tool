import java.io.*;
import java.util.Scanner;

public class htmlReader {
	
	private File htmlFile;
	public String [] lines;
	Scanner scanner;
	
	public void readHtml(String filename) throws IOException{	
			htmlFile = new File(filename + ".htm");
			scanner = new Scanner(htmlFile);
			lines = new String[];
					
			String strLine;
			
			int i = 0;
			//Read File Line By Line
			while(scanner.hasNextLine()) {
				lines[i++] = scanner.nextLine();
				//System.out.println(scanner.nextLine());
			}
			
			scanner.close();
	}

	public static void main(String[] args) throws IOException {
		
		htmlReader r = new htmlReader();
		
		r.readHtml("ExampleDomain");
		
		for(String s : r.lines) {
			System.out.println(s);
		}
	}

}
