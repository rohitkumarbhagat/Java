/**
 * 
 */
package algo.datastructure.tree;

/**
 * @author erotkur
 * 
 */
public class AvlTreeNode extends TreeNode<AvlTreeNode>
{
	private int height;

	/**
 * 
 */
	public AvlTreeNode()
	{
		super();

		height = 0;
	}

	public AvlTreeNode(int height, int data, AvlTreeNode left, AvlTreeNode right)
	{
		super(data, left, right);

		this.height = height;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public void refreshHeight()
	{
		// 
		int leftTreeHeight = this.getLeft() != null ? getLeft().getHeight() : -1;
		int rightTreeHeight = this.getRight() != null ? getRight().getHeight() : -1;

		height = Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}

	public boolean isAVLTreeNode()
	{
		int leftTreeHeight = this.getLeft() != null ? getLeft().getHeight() : -1;
		int rightTreeHeight = this.getRight() != null ? getRight().getHeight() : -1;
		if (Math.abs(leftTreeHeight - rightTreeHeight) > 1)
			return false;
		return true;

	}
}
