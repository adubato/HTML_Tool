import java.util.*;
/** A class used to represent html table elements in Java. 
 ** @author Michael Adubato **/
public class list extends element {
	private String type_;
	private List<element> content_ = new ArrayList<>();
	private int id_;
	private static int count;
	
	public list() {
		this.setElementType(htmlElement.LIST);
		type_ = null;
		count++;
		id_ = count;
	}
	
	public list(String type) {
		this.setElementType(htmlElement.LIST);
		type_ = type;
		count++;
		id_ = count;
	}
	
	public list(String type, ArrayList<element> content) {
		this.setElementType(htmlElement.LIST);
		type_ = type;
		content_ = content;
		count++;
		id_ = count;
	}
	
	public void add(element e) {
		content_.add(e);
	}
	
	public void remove(element e) {
		content_.remove(e);
	}
	
	public element get(int index) {
		return content_.get(index);
	}
	
	public int getLength() {
		return content_.size();
	}

	public void setType(String s) {
		type_ = s;
	}
	
	public String getType() {
		return type_;
	}
	
	/** @return The assigned ID number of the list. Representative of index in which object was created relative to other lists. **/
	public int getIdNum() {
		return id_;
	}

	/** @return The total number of list objects created **/
	public static int getCount() {
		return count;
	}
}
