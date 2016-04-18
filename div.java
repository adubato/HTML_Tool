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
	 ** @param elements A list of html elements **/
	public div(List<element> elements) {
		innerHtml_ = elements;
		count++;
		id_ = count;
	}
	
	/**	Constructs a new div object with a single element parameter
	 ** @param e An html element **/
	public div(element e) {
		innerHtml_ = new ArrayList<element>();
		innerHtml_.add(e);
		count++;
		id_ = count;
	}
	
	/** @param elements A list of html elements **/
	public void setInnerHtml(List<element> elements) {
		innerHtml_ = elements;
	}
	
	/** @return The list of elements contained in the div **/
	public List<element> getInnerHtml() {
		return innerHtml_;
	}
	
	/** @return An element contained in the div at the specified index **/
	public element getInnerHtmlAtIndex(int index) {
		return innerHtml_.get(index);
	}
	
	/** @return The assigned ID number of the div. Representative of index in which object was created relative to other divs. **/
	public int getIdNum() {
		return id_;
	}

	/** @return The total number of div objects created **/
	public static int getCount() {
		return count;
	}
	
	/** @param e An element to be added to the div's innerHtml **/
	public void addElement(element e) {
		innerHtml_.add(e);
	}
	
	/** @param index The intended index 
	 ** @param e An element to be added to the div's innerHtml at the specified index **/
	public void addElementAtIndex(int index, element e) {
		innerHtml_.add(index, e);
	}
	
	/** @param e An element to be removed from the div's innerHtml **/
	public void removeElement(element e) {
		innerHtml_.remove(e);
	}
	
	/** @param index The index of an element to be removed from the div's innerHtml **/
	public void removeElementAtIndex(int index) {
		innerHtml_.remove(index);
	}
}