import java.util.ArrayList;

/**	The BinarySearchTree class performs the BST Algorithm.	*/
public class BinarySearchTree {
	
	/**	The function produces an empty BST.	*/
	public void create() {
		root = null;
	}
	
	/** The function determines if a search key exists in the BST.
	 * 	@param root note
	 * 	@param key word	*/
	public  Node search(Node root, String key) {
		if (root.getKey().equalsIgnoreCase(key) || root.getKey() == null) 
			return root;
		else {
			if (key.compareTo(root.getKey()) < 0) 
				return search(root.getLeft(), key);
			else if (key.compareTo(root.getKey()) > 0)
				return search(root.getRight(), key);
		}
		
		return root;
	}
	
	/**	The function calls inserts the word into the insertNode() function.
	 *
	 *	@param key word	*/
	void insert(String key) {
		root = insertNode(root, key);
	}
	
	/**	The function adds a new node in the BST.
	 * 
	 * 	@param root node
	 * 	@param key word	*/
	public Node insertNode(Node root, String key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		
		if (key.compareTo(root.getKey()) < 0) {				// If key < root.key
			root.setLeft(insertNode(root.getLeft(), key));
		} else if (key.compareTo(root.getKey()) > 0) {		// If key > root.key
			root.setRight(insertNode(root.getRight(), key));
		} else if (key.compareTo(root.getKey()) == 0) {		// If key and root.key are equal
			root.addCount();
		}	
		
		return root;
	}
	
	/** The function calls the inorderRec function.	*/
	public void inorder() {
		inorderTrav(root);
	}
	
	/** The function performs inorder traversal of the BST.
	 * 
	 *	@param root node	*/
	public void inorderTrav(Node root) {	
		if (root != null) {
			inorderTrav(root.getLeft());
			list.add(root.toString());
			inorderTrav(root.getRight());
		}
	}
	
	/**	The function is a a clean-up operation before the program actually terminates.
	 * 	The BST will become empty after calling destroy().	*/
	public void destroy() {
		root = null;
	}
	
	/**	This function returns the ArrayList.	*/
	public ArrayList<String> getList() {
		return list;
	}
	
	/**	Root of the Binary Search Tree.	*/
	private Node root;
	/**	List of key words in ascending format	*/
	private ArrayList <String> list = new ArrayList<String> ();
}