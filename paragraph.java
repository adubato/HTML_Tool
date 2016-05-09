/** A class used to represent html paragraph elements in Java. 
 ** @author Michael Adubato **/
public class paragraph extends element {
	
	private String innerHtml_;
	private int id_;
	private static int count = 0;
	
	/** Constructs a new paragraph with nothing in the paragraph body. Default constructor **/
	public paragraph() {
		this.setElementType(htmlElement.PARAGRAPH);
		innerHtml_ = null;
		count++;
		id_ = count;
	}
	
	/** Constructs a new paragraph with an innerHtml parameter
	 ** @param innerHtml A String to be contained in the paragraph **/
	public paragraph(String innerHtml) {
		this.setElementType(htmlElement.PARAGRAPH);
		innerHtml_ = innerHtml;
		count++;
		id_ = count;		
	}
	
	/** @param innerHtml The innerHtml of the paragraph. **/
	public void setInnerHtml(String innerHtml) {
		innerHtml_ = innerHtml;
	}
	
	/** @return The innerHtml of the paragraph. **/
	public String getInnerHtml() {
		return innerHtml_;
	}
	
	/** @return The assigned ID number of the paragraph. Representative of index in which object was created relative to other paragraphs. **/
	public int getIdNum() {
		return id_;
	}

	/** @return The total number of paragraph objects created **/
	public static int getCount() {
		return count;
	}
	
	public String toString() {
		String s = "[PARAGRAPH,\t IdNum: " + this.getIdNum() + " | HTMLClass: " + this.getHTMLClass() + " | HTMLId: " + this.getHTMLId() + " | innerHtml: " + this.getInnerHtml() + "]";
		return s;
	}
}
