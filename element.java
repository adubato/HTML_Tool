/** An abstract class used to represent html elements in Java. 
 ** @author Michael Adubato **/
public abstract class element {
	private String htmlId_ = null;
	private String htmlClass_ = null;
	private htmlElement htmlType_ = htmlElement.NULL;
	
	public void setHTMLId(String id) {
		htmlId_ = id;
	}
	
	public void setHTMLClass(String htmlClass) {
		htmlClass_ = htmlClass;
	}
	
	protected void setElementType(htmlElement type) {
		htmlType_ = type;
	}
	
	/**	@return The html specific ID of an element/object. **/
	public String getHTMLId() {
		return htmlId_;
	}
	
	/**	@return The html specific class of an element/object. **/
	public String getHTMLClass() {
		return htmlClass_;
	}
	
	/**	@return The type of html element. **/
	public htmlElement getElementType() {
		return htmlType_;
	}
}