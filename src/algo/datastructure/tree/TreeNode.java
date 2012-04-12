/**
 * 
 */
package algo.datastructure.tree;

/**
 * @author erotkur
 * 
 */
public class TreeNode<T> {
	private int data;

	private T left;

	private T right;

	/**
	 * 
	 */
	public TreeNode() {
		data = -1;
		left = null;
		right = null;

	}

	public TreeNode(int data, T left, T right) {
		this.data = data;
		this.left = left;
		this.right = right;

	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public T getLeft() {
		return left;
	}

	public void setLeft(T left) {
		this.left = left;
	}

	public T getRight() {
		return right;
	}

	public void setRight(T right) {
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("inside equals function");
		boolean returnValue = false;
		if (obj != null && obj instanceof TreeNode) {
			TreeNode objTreeNode = (TreeNode) obj;
			if (objTreeNode.getData() == data) {
				returnValue = true;
			}
		}

		return returnValue;
	}
}
