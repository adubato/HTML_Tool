/** A class used to represent html table elements in Java. 
 ** @author Michael Adubato **/
public class table extends element {
	private int rows_;
	private int columns_;
	private element [][] content_;
	private int id_;
	private static int count;
	
	/** Constructs a new empty table. Default constructor. Rows and columns = -1 **/
	public table() {
		this.setElementType(htmlElement.TABLE);
		rows_ = -1;
		columns_ = -1;
		content_ = null;
		count++;
		id_ = count;
	}
	
	/** Constructs a new table with row and column parameters
	 ** @param rows A number of rows
	 ** @param columns A number of columns **/
	public table(int rows, int columns) {
		this.setElementType(htmlElement.TABLE);
		rows_ = rows;
		columns_ = columns;
		content_ = new element [rows][columns];
		count++;
		id_ = count;
	}
	
	/** Constructs a new table with a 2D String array parameter
	 ** @param content A 2D String array **/
	public table(element [][] content) {
		this.setElementType(htmlElement.TABLE);
		content_ = content;
		rows_ = content.length;
		columns_ = content[0].length;
		count++;
		id_ = count;
	}
	
	/** @return The number of rows in the table **/
	public int getRows() {
		return rows_;
	}
	
	/** @return The number of columns in the table **/
	public int getColumns() {
		return columns_;
	}
	
	/** @return The 2D String array of the table's contents **/
	public element [][] getContent() {
		return content_;
	}
	
	/** @return The String within the specified table coordinates **/
	public element getContentAtIndex(int row, int column) {
		return content_[row][column];
	}
	
	/** @return The assigned ID number of the table. Representative of index in which object was created relative to other tables. **/
	public int getIdNum() {
		return id_;
	}

	/** @return The total number of table objects created **/
	public static int getCount() {
		return count;
	}
}
