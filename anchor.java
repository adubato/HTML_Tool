/** A class used to represent html anchor elements in Java. 
 ** @author Michael Adubato **/
public class anchor extends element {

	private String href_;
	private String target_;
	private String innerHtml_;
	private int id_;
	private static int count = 0;
	
	/**	Constructs a new empty anchor object. Default constructor **/
	public anchor() {
		this.setElementType(htmlElement.ANCHOR);
		href_ = null;
		target_ = null;
		innerHtml_ = null;
		count++;
		id_ = count;
	}
	
	/**	Constructs a new anchor object with href parameter
	 ** @param href ex: http://www.google.com **/
	public anchor(String href) {
		this.setElementType(htmlElement.ANCHOR);
		href_ = href;
		target_ = null;
		innerHtml_ = null;
		count++;
		id_ = count;
	}

	/**	Constructs a new anchor object with href & target parameters
	 ** @param href ex: "http://www.google.com"
	 ** @param target ex: "_blank" **/
	public anchor(String href, String target) {
		this.setElementType(htmlElement.ANCHOR);
		href_ = href;
		target_ = target;
		innerHtml_ = null;
		count++;
		id_ = count;
	}
	
	public void setHref(String href) {
		href_ = href;
	}
	
	/** @return The href of the anchor. ex: "http://www.google.com" or "#top" **/
	public String getHref() {
		return href_;
	}
	
	public void setTarget(String target) {
		target_ = target;
	}
	
	/** @return The target of the anchor. ex: "_blank" **/
	public String getTarget() {
		return target_;
	}
	
	public void setInnerHtml(String innerHtml) {
		innerHtml_ = innerHtml;
	}
	
	/** @return The contents of the anchor. **/
	public String getInnerHtml() {
		return innerHtml_;
	}
	
	/** @return The assigned ID number of the anchor. Representative of index in which object was created relative to other anchors. **/
	public int getIdNum() {
		return id_;
	}
	
	/** @return The total number of anchor objects created **/
	public static int getCount() {
		return count;
	}
	
	/** @return [Anchor IdNum: {@link #getIdNum()} | HTMLClass: {@link #getHTMLId()} | HTMLId: {@link #getHTMLClass()} | href: {@link #getHref()} | target: {@link #getTarget()}] **/
	public String toString() {
		String s = "[ANCHOR, IdNum: " + this.getIdNum() + " | HTMLClass: " + this.getHTMLClass() + " | HTMLId: " + this.getHTMLId() + " | href: " + this.getHref() + " | target: " + this.getTarget() + "]";
		return s;
	}
}