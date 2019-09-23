/**
 * @author Marina Moreno Villagrana
 */
public class IntNodeTest 
{
	public static void main(String[] args)  
	{
		System.out.println("Create Head node and initialize it with null value (empty list)");
		IntNode Head = null;
		System.out.println("List Lenght = " + IntNode.listLength(Head) + "\n");
		
		System.out.println("Initialize List1_head using the no-argument constructor (One Node in the Linked List)");
		Head = new IntNode();
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Head Link = "+Head.getLink());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12)+"\n");		
		
		System.out.println("Set data to first node with 12 using set Method");
		Head.setData(12);
		System.out.println("Head Data = "+Head.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12)+"\n");
		
		System.out.println("Try to Remove the unique node using removeNodeAfterThis Method");
		Head.removeNodeAfterThis();
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Head Link = "+Head.getLink());
		System.out.println("(Starting from Head) " + Head.toString()+"\n");
		
		System.out.println("Create add node after the first node (Head) with data = 34 using AddNodeAterThis method. Assign this node to Node_4");
		Head.addNodeAfterThis(34);
		IntNode Node_4 = Head.getLink();
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
		
		System.out.println("Remove the last (tail) node from the linked list");
		Head.removeNodeAfterThis();
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Head Link = "+Head.getLink());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("Node_4 Link = "+Node_4.getLink());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
		
		System.out.println("Link again Head Node and Node_4 (Tail) using the setLink Method");
		Head.setLink(Node_4);
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
		
		System.out.println("Add a Node after the current Tail Node with data = 15. Create Node_5 to point to this new node");
		Node_4.addNodeAfterThis(15);
		IntNode Node_5 = Node_4.getLink();
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("Node_5 Data = "+Node_5.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("(Starting from Node_5) " + Node_5.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 15 in the linked list? = " + Head.search(Head, 15));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
		
		System.out.println("Create Node_2 using the constructor with data = 28 and link = null. Link the new node the Head and Node_4 using the Set Method");
		IntNode Node_2 = new IntNode(28,null);
		Head.setLink(Node_2);
		Node_2.setLink(Node_4);
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Node_2 Data = "+Node_2.getData());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("Node_5 Data = "+Node_5.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_2) " + Node_2.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("(Starting from Node_5) " + Node_5.toString());
		System.out.println("Is data 28 in the linked list? = " + Head.search(Head, 28));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 15 in the linked list? = " + Head.search(Head, 15));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
		
		System.out.println("Create a new node after Node_2 using addNodeAfterThis with data = 0. Make a reference to this new node by creating Node_3");
		Node_2.addNodeAfterThis(0);
		IntNode Node_3 = Node_2.getLink();
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Node_2 Data = "+Node_2.getData());
		System.out.println("Node_3 Data = "+Node_3.getData());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("Node_5 Data = "+Node_5.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_2) " + Node_2.toString());
		System.out.println("(Starting from Node_3) " + Node_3.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("(Starting from Node_5) " + Node_5.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 28 in the linked list? = " + Head.search(Head, 28));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 15 in the linked list? = " + Head.search(Head, 15));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
		
		System.out.println("Remove Node_4 using removeNodeAfterThis Method");
		Node_3.removeNodeAfterThis();
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Node_2 Data = "+Node_2.getData());
		System.out.println("Node_3 Data = "+Node_3.getData());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("Node_5 Data = "+Node_5.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_2) " + Node_2.toString());
		System.out.println("(Starting from Node_3) " + Node_3.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("(Starting from Node_5) " + Node_5.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 28 in the linked list? = " + Head.search(Head, 28));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 15 in the linked list? = " + Head.search(Head, 15));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
		
		System.out.println("Remove Node_2 using removeNodeAfterThis Method");
		Head.removeNodeAfterThis();		
		System.out.println("List Lenght = " + IntNode.listLength(Head));
		System.out.println("Head Data = "+Head.getData());
		System.out.println("Node_2 Data = "+Node_2.getData());
		System.out.println("Node_3 Data = "+Node_3.getData());
		System.out.println("Node_4 Data = "+Node_4.getData());
		System.out.println("Node_5 Data = "+Node_5.getData());
		System.out.println("(Starting from Head) " + Head.toString());
		System.out.println("(Starting from Node_2) " + Node_2.toString());
		System.out.println("(Starting from Node_3) " + Node_3.toString());
		System.out.println("(Starting from Node_4) " + Node_4.toString());
		System.out.println("(Starting from Node_5) " + Node_5.toString());
		System.out.println("Is data 0 in the linked list? = " + Head.search(Head, 0));
		System.out.println("Is data 28 in the linked list? = " + Head.search(Head, 28));
		System.out.println("Is data 12 in the linked list? = " + Head.search(Head, 12));
		System.out.println("Is data 15 in the linked list? = " + Head.search(Head, 15));
		System.out.println("Is data 34 in the linked list? = " + Head.search(Head, 34)+"\n");
	}
}
