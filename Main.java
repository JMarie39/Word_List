import java.util.Scanner;
/**	This is the main/ driver of the program.
 * 	
 * 	@author Juliana Agulto
 * 	@author Fritz Duriman
 * 	@author Eliana Misa		*/
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		BinarySearchTree tree = new BinarySearchTree();
		
		System.out.print("Input file name: ");
		String filename = scan.nextLine();
		
		if(new TextFiles().readInput(tree, filename)) {		// Reads the text file if it exists
			tree.inorder();		//	Performs the inorder traversal of the BST
			new TextFiles().createOutput(tree);		// Creates the WORD.TXT
			tree.destroy(); 	// Empties the BST
		}
		scan.close();
	}
}