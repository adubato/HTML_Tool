/** A class used to read html files elements in Java. 
 ** @author Michael Adubato **/
import java.io.*;
import java.util.*;

public class htmlReader {
	
	private Scanner scanner_;
	private List<String []> lines_;
	
	private List<element> elements_;
	
	public htmlReader(String filename) {
		
		File file = new File(filename);
		
		try { scanner_ = new Scanner(file); }
		catch(FileNotFoundException e) {
			System.out.println("File Not Found!");
			System.exit(0);
		}
		lines_ = new ArrayList<String[]>();	
		elements_ = new ArrayList<element>();
		
		while(scanner_.hasNextLine()) {
			if(scanner_.nextLine().contains("</head>")) {
				while(scanner_.hasNextLine()){
					lines_.add(scanner_.nextLine().trim().split("<|>"));
				}
			}
		}
	
		scanner_.close();
		
		/* print html code arrays
		for(String [] a : lines_)
			System.out.println(Arrays.toString(a));
		*/
		
		parseElements(lines_);
	}
	
	private void parseElements(List<String []> lines) {		
		
		int length;
		int header;
		String htmlID = null;
		String htmlClass = null;
		String text;
		String [] hold;
		
		for(String [] line : lines) {
			
			length = line.length;
			if(length > 1) {
				// paragraph
				if(line[length - (length - 1)].equals("p") || line[length - (length - 1)].contains("p class=") || line[length - (length - 1)].contains("p id=")) {
					text = "";
					htmlClass = null;
					htmlID = null;
					paragraph p = new paragraph();
					for(String s : line) {
						hold = s.split("\"");
						if(s.contains("class=")) {
							htmlClass = hold[hold.length - 3];
						}
						if(s.contains("id=")) {
							htmlID = hold[hold.length - 1];
						}
						text = text + s + " ";
					}
					p.setHTMLClass(htmlClass);
					p.setHTMLId(htmlID);
					p.setInnerHtml(text);
					elements_.add(p);
				}
				// header
				if(line[length - (length - 1)].matches("h\\d")) {
					text = "";
					header = Integer.parseInt((line[length - (length - 1)].charAt(1) + ""));
					for(String s : line)
						text = text + s + " ";
										
					elements_.add(new header(header, text));
				}
				
				if(line[1].equals("ul")) {
					text = "";
					list l = new list();
					l.setType(line[length - (length - 1)]);
					for(String s : line)
						text = text + s + " ";
										
					elements_.add(l);
				}
				
				if(line[1].equals("tr")) {
					text = "";
					table t = new table();
					for(String s : line)
						text = text + s + " ";
										
					elements_.add(t);
				}
				
				// anchor
				for(String s : line) {
					if(s.contains("a href=")) {
						if(s.indexOf('"') == -1 || s.lastIndexOf('"') == -1)
							continue;
						else
							elements_.add(new anchor(s.substring(s.indexOf('"') + 1, s.lastIndexOf('"'))));
					}
				}
			}
		}
	}
	
	private void diplayElements() {
		System.out.println("Headers:\t" + header.getCount());
		System.out.println("Paragraphs:\t" + paragraph.getCount());
		System.out.println("Anchors:\t" + anchor.getCount());
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		for(element e : elements_) {
			if(e.getElementType() == htmlElement.ANCHOR) {
				anchor a = (anchor) e;
				System.out.println(a.toString());
			}
			if(e.getElementType() == htmlElement.PARAGRAPH) {
				paragraph a = (paragraph) e;
				System.out.println(a.toString());
			}
			if(e.getElementType() == htmlElement.HEADER) {
				header a = (header) e;
				System.out.println(a.toString());
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
		Scanner input = new Scanner(System.in);
		
		String htmlFileName;
		System.out.println("Enter the name of an HTM or HTML file, with the extension: ");
		htmlFileName = input.next( );

		input.close();
		htmlReader r = new htmlReader(htmlFileName);
		System.out.println();
		r.diplayElements();
	}
}
