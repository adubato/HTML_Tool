import java.util.*;

/** A class used to represent html div elements in Java. 
 ** @author Michael Adubato **/
public class div extends element {
	
	private List<element> innerHtml_;
	private int id_;
	private static int count = 0;
	
	/**	Constructs a new empty div object. Default constructor **/
	public div() {
		innerHtml_ = null;
		count++;
		id_ = count;
	}
	
	/**	Constructs a new div object with elements parameter
	 ** @param A list of html elements **/
	public div(List<element> elements) {
		innerHtml_ = elements;
		count++;
		id_ = count;
	}
	
	/**	Constructs a new div object with a single element parameter
	 ** @param An html element **/
	public div(element e) {
		innerHtml_ = new ArrayList<element>();
		innerHtml_.add(e);
		count++;
		id_ = count;
	}
	
	public void setInnerHtml(List<element> elements) {
		innerHtml_ = elements;
	}
	
	/** @return A list of elements contained in the div **/
	public List<element> getInnerHtml() {
		return innerHtml_;
	}
	
	public int getIdNum() {
		return id_;
	}
	
	public static int getCount() {
		return count;
	}
}
