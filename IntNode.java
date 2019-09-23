/**
 * @author Marina Moreno
 */
public class IntNode 
{
	private int data;
	private IntNode link;
	
	/** Set the node value to be 0 and the link to be null reference
	 */
	public IntNode()
	{
		data = 0;
		link = null; // link is no pointing to a node
	}
	
	/** Initialize a node with specified initial data and a link to the next node.
	 * @param _data Initial data of this new node
	 * @param _node Reference to node after this new node. The reference may be null
	 */
	public IntNode(int _data, IntNode _node)
	{
		data = _data;
		link = _node;
	}
	
	/**Get the data from the node accesing this method
	 * @return The data from the node calling this method
	 */
	public int getData() {return data;}
	
	/** Gets a reference to the next node after this node
	 * @return A reference to the node after this node (or null reference if there is nothing after this node)
	 */
	public IntNode getLink() {return link;}
	
	/** Modification method to set the data in the accesing node.
	 * @param newdata The new data to place in this node
	 */
	public void setData(int newdata) {data = newdata;}
	
	/** Sets the reference to the next node after this node.
	 * @param newLink Reference to the node that should appear after this node in the linked list (or null reference if there should be no node after this node
	 */
	public void setLink(IntNode newLink) {link = newLink;}
	
	/** Displays the linked list in the format 12-28-0-34
	 * @return A String for the linked list starting from the node that activates this method.
	 */
	public String toString()
	{
		String Text="";
		IntNode current_link = link;
		
		Text = Text + Integer.toString(data);
		while(current_link != null)
		{
			//System.out.println("Data = "+current_link.data);
			Text = Text + "->" + Integer.toString(current_link.data);
			current_link = current_link.getLink(); // to move to the next reference			
		}		
		return "Linked List: "+Text;
	}
	
	/** This method should create a new node after the node calling this method. The current node links to this new node.
	 * @param newdata Data to place in the new node
	 * @throws OutOfMemoryError Indicates that there is insufficient memory for a new IntNode
	 */
	public void addNodeAfterThis(int newdata)
	{
		try
		{
			link = new IntNode(newdata,link);
		}
		catch(OutOfMemoryError e)
		{
			System.out.println("Out of Memory Error");
		}
	}
	
	/** Removes the node that is after the node that activates this method.
	 * @throws NullPointerException Indicates Tail Node activated this method. Method will try to remove a node after the tail node.
	 */
	public void removeNodeAfterThis()
	{
		try
		{
			link = link.link;
		}
		catch(NullPointerException e)
		{
			System.out.println("Cannot remove Node");
		}
	}
	
	/** Provides the number of nodes in the list starting from a given node head
	 * @param head The head reference for a linked list
	 * @return The number of nodes in the list
	 */
	public static int listLength(IntNode head)
	{ 
		int list_size = 0;
		IntNode cursor = head;

		while (cursor != null)
		{
			list_size++;
			cursor = cursor.link;
		}			
		return list_size;
	}
	
	/** Search for a particular piece of data in a linked list
	 * @param head Head reference for a linked list
	 * @param e Int value to search for
	 * @return True if data exist in the linked list starting with the head. Returns False otherwise.
	 */
	public static boolean search(IntNode head, int e)
	{
		IntNode cursor = head;
	    boolean result = false;
		while(cursor != null)
		{
			if(cursor.getData() == e)
				result = true;
			cursor = cursor.getLink();
		}
		return result;
	}
}
