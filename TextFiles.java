import java.util.Scanner;
import java.io.*;
import java.util.regex.*;


/**	The TextFiles class is for reading and creating text files	*/
public class TextFiles {
	
	/**	The function reads the INPUT.TXT. It also inserts the words if the text file is found.
	 * 	
	 * 	@param tree is the binary search tree
	 * 	@param filename that the user inputed	
	 * 	@return true if text file is found, otherwise false	*/
	public boolean readInput(BinarySearchTree tree, String filename) {
		File tempFile = new File(filename);
		
		if(tempFile.exists() && tempFile.isDirectory()) {		// If file name entered is not found
			System.out.println(filename + " not found.");
			return false;
		} else {
			try (FileReader myObj1 = new FileReader(filename);
					Scanner myReader1 = new Scanner(myObj1)) {
				
				tree.create();		// Creates an empty BST
				
				while (myReader1.hasNextLine()) {			// This reads the text file
					String words = myReader1.nextLine();	
				    String[] arrWord = words.split("\\s+");	// Splits the whitespace and new line
				       
				    for (String word : arrWord) {			// Loops the array of Strings
				    	word = new TextFiles().removeChar(word);	// Checks the special characters
				    	if(word.length() >= 3) {			// Only words with a length of at least 3 would be added to the tree
				    		tree.insert(word.toLowerCase());	// Inserts the word to the BST	
				    	}    		   
				    }
				}
				return true;
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
			} catch (IOException e) {
				
			}
			return false;
		}
	}
	
	/**	The function checks whether the word contains a special character or not.
	 * 
	 * 	@param word to be checked	
	 * 	@return word string	*/
	public String removeChar(String word) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");	// Special characters
		Matcher matcher1, matcher2, matcher;
		matcher = pattern.matcher(word);
		if (!matcher.matches()) {
			do {
				String first = Character.toString(word.charAt(0));			// Gets the first character of the word
				String last = Character.toString(word.charAt(word.length()-1));		// Gets the last character of the word
				
				matcher1 = pattern.matcher(first.toString());	// Checks the character at the first index
				matcher2 = pattern.matcher(last.toString());	// Checks the character at the last index
				
				if (!matcher1.matches())
					word = word.substring(1, word.length());	// Will remove the first character of the word
				else if (!matcher2.matches())
					word = word.substring(0, word.length()-1);	// Will remove the last character of the word
							
			} while (word.length() >= 3 && (!matcher1.matches() || !matcher2.matches()));
		}
		return word;
	}
	
	/**	The function creates a text file named WORD.TXT which output the words in ascending order and the number of times it was mentioned.	
	 * 
	 * 	@param tree is the binary search tree	*/
	public void createOutput(BinarySearchTree tree) {
		try(FileWriter myWriter = new FileWriter("WORDS.TXT")) {
			for (String list : tree.getList())		// Loops the ArrayList
				myWriter.write(list.toString() + "\n");		
		} catch(IOException e) {
			System.out.println("An error occurred.");
		}
	}
}