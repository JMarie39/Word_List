/**	The Node class contains the left and right child, and the key word of the current node.	*/
public class Node {
	
	/**	The constructor initializes the left, right and key of the node,
	 * 	based on the given parameters.	*/
	Node (String data) {
		left = right = null;
		key = data;
		count = 1;
	}
 	
	/** The function sets the key of the node.
	 * 
	 * @param w the String to be set as key	*/
	public void setKey(String w) {
		key = w;
	}
	
	/** The function sets the left node of the node.
	 * 
	 * @param n the node to be set as left	*/
	public void setLeft(Node n) {
		left = n;
	}
	
	/** The function sets the right node of the node.
	 * 
	 * @param n the node to be set as right	*/
	public void setRight(Node n) {
		right = n;
	}
	
	/** The function returns the key of the node.
	 * 
	 * @return key the word string	*/
	public String getKey() {
		return key;
	}
	
	/** The function returns the left node.
	 * 
	 * @return left the node that is less than the current node	*/
	public Node getLeft() {
		return left;
	}
	
	/** The function returns the right node.
	 * 
	 * @return right the node that is more than the current node	*/
	public Node getRight() {
		return right;
	}

	/** The function increments the count of the node.	*/
	public void addCount() {
		count++;
	}
	 
	@Override
	public String toString() {
		return key + " " + count;
	}
	
	/**	Left and right child of the node	*/
	private Node left, right;
	/** The word of the current node */
	private String key;
	/** The frequency of the key in the current node */
	private int count = 0;
}
