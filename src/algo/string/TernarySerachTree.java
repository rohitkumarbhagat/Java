package algo.string;

public class TernarySerachTree {
	private Node root;

	public TernarySerachTree(String str) {
		// create a new tree with given string

	}

	/**
	 * @param str
	 *            : to be added
	 * @return
	 */
	public void add(String str) {
		if (root == null) {

		}
	}

	/**
	 * @param str
	 *            : to be added starting at specified root position
	 * @param index
	 *            : starting index of string to be added
	 * @return root node
	 */
	private Node add(String str, int index, Node root) {
		// completed addition
		if (index == str.length()) {
			return null;
		}
		// root node is null
		if (root == null) {
			root = new Node();
			root.key = str.charAt(index);

		}
		if(root.key==str.charAt(index)){
			// move to mid element;
			root.mid=add(str,index+1,root.mid);
		}else if(root.key < str.charAt(index)) {
			// add to left tree
		}
		return null;
	}

	// represents node of a ternary tree
	private class Node {
		Node left;
		Node right;
		Node mid;

		String data = "";
		boolean endFlag = false;
		char key;

	}

}
