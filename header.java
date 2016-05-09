
public class header extends element {
	private int type_;
	private String innerHtml_;
	private int id_;
	private static int count;
	
	public header() {
		this.setElementType(htmlElement.HEADER);
		type_ = -1;
		innerHtml_ = null;
		count++;
		id_ = count;
	}
	
	public header(String innerHtml) {
		this.setElementType(htmlElement.HEADER);
		type_ = -1;
		innerHtml_ = innerHtml;
		count++;
		id_ = count;
	}
	
	public header(int type, String innerHtml) {
		this.setElementType(htmlElement.HEADER);
		type_ = type;
		innerHtml_ = innerHtml;
		count++;
		id_ = count;
	}
	
	public void setType(int type) {
		type_ = type;
	}
	
	public int getType() {
		return type_;
	}
	
	public void setInnerHtml(String s) {
		innerHtml_ = s;
	}
	
	public String getInnerHtml() {
		return innerHtml_;
	}
	
	/** @return The assigned ID number of the header. Representative of index in which object was created relative to other headers. **/
	public int getIdNum() {
		return id_;
	}

	/** @return The total number of header objects created **/
	public static int getCount() {
		return count;
	}
	
	public String toString() {
		String s = "[HEADER,\t IdNum: " + this.getIdNum() + " | HTMLClass: " + this.getHTMLClass() + " | HTMLId: " + this.getHTMLId() + " | Header Type: " + this.getType() + " | innerHtml: " + this.getInnerHtml() + "]";
		return s;
	}
}
